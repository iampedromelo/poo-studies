package org.example;

public class UserAccount {
    private final String email;
    private final String userName;
    private final Post[] timeline;
    private int qtdTimeline;
    private final Post[] posts;
    private int qtdTPosts;
    private final UserAccount[] followers;
    private int qtdFollowers;

    public UserAccount(String userName, String email) {
        this.email = email;
        this.userName = userName;
        this.timeline = new Post[10];
        this.posts = new Post[100];
        this.followers = new UserAccount[100];
    }

    public void publish(String quote){
        if(quote == null) return;
        Post newPost = new Post(this,quote);

        posts[qtdTPosts++] = newPost;
        for (int i = 0; i < qtdFollowers; i++) {
            followers[i].updateTimeline(newPost);
        }
    }

//  Eu sei que era só fazer um esquema de fila circular, mas quero usar o timestamp pra descobrir o mais antigo
//  Pela descrição, updateTimeline deveria ser private (não é chamado individualmente).
    public void updateTimeline(Post newPost){
        if (qtdTimeline < 10){
            timeline[qtdTimeline++] = newPost;
            return;
        }

        timeline[searchOldestPostInTimeline()] = newPost;

    }

    private int searchOldestPostInTimeline(){
        int oldestPostIndex = 0;
        for (int i = 0; i < 10; i++) {
            if((timeline[oldestPostIndex].getTimestamp()).isAfter(timeline[i].getTimestamp())){
                oldestPostIndex = i;
            }
        }
        return oldestPostIndex;
    }

    public boolean delete(int postIndex){
        if (postIndex < 0 || postIndex >= qtdTPosts) return false;
        for (int i = postIndex; i < qtdTPosts - 1 ; i++) {
            posts[i] = posts[i+1];
        }
        posts[--qtdTPosts] = null;
        return true;
    }

    public String showTimeline(){
        StringBuilder builder = new StringBuilder();
        builder.append("--- Timeline --- \n");
        for (int i = 0; i < qtdTimeline; i++) {
            builder.append(timeline[i].show()).append(("\n"));
        }
        return builder.toString();
    }

    public String showMyPosts(){
        StringBuilder builder = new StringBuilder();
        builder.append("--- My Posts --- \n");
        for (int i = 0; i < qtdTPosts; i++) {
            builder.append(posts[i].show()).append(("\n"));
        }
        return builder.toString();
    }

    public String showMyFriends(){
        StringBuilder builder = new StringBuilder();
        builder.append("--- Followers --- \n");
        for (int i = 0; i < qtdFollowers; i++) {
            builder.append(followers[i].getUserName()).append("\n");
        }
        return builder.toString();
    }

    public void clapPost(int postIndex){
        if(postIndex<0 || postIndex >= qtdTimeline) return;
        timeline[postIndex].clap();
    }

    public void booPost(int postIndex){
        if(postIndex<0 || postIndex >= qtdTimeline) return;
        timeline[postIndex].boo();
    }


    public void acceptFollower(UserAccount newFollower){
        if(searchFollowerInUser(newFollower) >= 0) return;
        followers[qtdFollowers++] = newFollower;
    }

    public void blockFollower(UserAccount follower){
        int blockFollowerIndex = searchFollowerInUser(follower);
        if(blockFollowerIndex == -1) return;
        for (int i = blockFollowerIndex; i < qtdFollowers - 1; i++) {
            followers[i] = followers[i+1];
        }
        followers[--qtdFollowers] = null;
    }

    private int searchFollowerInUser(UserAccount user){
        for (int i = 0; i < qtdFollowers; i++) {
            if((followers[i].email).equals(user.email) && (followers[i].userName).equals(user.userName)){
                return i;
            }
        }
        return -1;
    }


    public String getUserName() {
        return userName;
    }
}
