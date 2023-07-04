package com.book.bookprac.member;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String nickname;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getImage() {
        return image;
    }

    @Column
    private String image;

    @Builder
    public Member(String email, String password, String nickname, String image ){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.image = image;
    }
}
