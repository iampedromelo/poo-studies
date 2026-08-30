package org.example;

import java.time.LocalDateTime;

public class Post {
    private final String quote;
    private final LocalDateTime timestamp;
    private int claps;
    private int boos;
    private final UserAccount user;

    public Post(UserAccount user, String quote) {
        this.timestamp = LocalDateTime.now();
        this.user = user;
        this.quote = quote;
    }

    public String show(){
        return String.format("[%s] %s says \"%s\" | Claps: %d | Boos: %d", timestamp, user.getUserName(), quote,claps, boos);
    }

    public void clap(){
        claps++;
    }

    public void boo() {
        boos++;
    }

    public String getQuote() {
        return quote;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getClaps() {
        return claps;
    }

    public int getBoos() {
        return boos;
    }

    public UserAccount getUser() {
        return user;
    }
}
