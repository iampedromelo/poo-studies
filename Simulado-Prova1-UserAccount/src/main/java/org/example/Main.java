package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        UserAccount pedro = new UserAccount("pedro","pedro.melo@unesp.br");
        UserAccount nat = new UserAccount("nat","nat@unesp.br");
        UserAccount amora = new UserAccount("amora","amora@unesp.br");

        System.out.println("Primeiro post do Pedro");
        pedro.publish("Primeiro Post");

        System.out.println("Os Posts do pedro:");
        System.out.println(pedro.showMyPosts());

        System.out.println("Timeline da Nat:");
        System.out.println(nat.showTimeline());

        System.out.println("Timeline da Amora:");
        System.out.println(amora.showTimeline());

        System.out.println("Amora segue Pedro");
        pedro.acceptFollower(amora);

        System.out.println("Nat segue Pedro");
        pedro.acceptFollower(nat);

        System.out.println("Lista de amigos do Pedro");
        System.out.println(pedro.showMyFriends());

        System.out.println("Pedro posta novamente");
        pedro.publish("Segundo post");

        System.out.println("Amora aplaude");
        amora.clapPost(0);

        System.out.println("Nat vaia");
        nat.booPost(0);

        System.out.println("Os Posts do pedro:");
        System.out.println(pedro.showMyPosts());

        System.out.println("Timeline da Nat:");
        System.out.println(nat.showTimeline());

        System.out.println("Timeline da Amora:");
        System.out.println(amora.showTimeline());

        System.out.println("Pedro Bloqueia Nat");
        pedro.blockFollower(nat);

        System.out.println("Lista de amigos do Pedro");
        System.out.println(pedro.showMyFriends());

        System.out.println("Pedro posta a última vez");
        pedro.publish("Nat me vaiou, nao vai ver mais nada");

        System.out.println("Os Posts do pedro:");
        System.out.println(pedro.showMyPosts());

        System.out.println("Timeline da Nat:");
        System.out.println(nat.showTimeline());

        System.out.println("Timeline da Amora:");
        System.out.println(amora.showTimeline());

        System.out.println("Pedro faz 10 publicações");
        for (int i = 0; i < 10; i++) {
            pedro.publish(i + "");
        }

        System.out.println("Timeline da Nat com os mais recentes:");
        System.out.println(nat.showTimeline());

        System.out.println("Timeline da Amora com os mais recentes:");
        System.out.println(amora.showTimeline());

        System.out.println("Pedro deleta um post");
        pedro.delete(3);

        System.out.println("Os Posts do pedro:");
        System.out.println(pedro.showMyPosts());
    }
}

