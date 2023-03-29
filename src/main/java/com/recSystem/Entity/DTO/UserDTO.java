package com.recSystem.Entity.DTO;

public class UserDTO {
    private String login;
    private String password;
    private int id;
    private String email;
    private Boolean author_verified;
    private String last_login;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO(String login, int id, String email, Boolean authorVerified) {
        this.login = login;
        this.id = id;
        this.email = email;
        this.author_verified = authorVerified;
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

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAuthor_verified() {
        return author_verified;
    }

    public void setAuthor_verified(Boolean author_verified) {
        this.author_verified = author_verified;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }
}
