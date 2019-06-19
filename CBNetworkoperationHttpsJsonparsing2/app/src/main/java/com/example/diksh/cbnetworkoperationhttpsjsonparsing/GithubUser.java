package com.example.diksh.cbnetworkoperationhttpsjsonparsing;

public class GithubUser {
    String login;
    int id;
    String html_url;
    Double score;
    String avatar_url;

    public GithubUser(String login, int id, String html_url, Double score, String avatar_url) {
        this.login = login;
        this.id = id;
        this.html_url = html_url;
        this.score = score;
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getHtml_url() {
        return html_url;
    }

    public Double getScore() {
        return score;
    }

    public String getAvatar_val() {
        return avatar_url;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setAvatar_val(String avatar_val) {
        this.avatar_url = avatar_val;
    }
}
