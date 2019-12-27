package com.paga.dao.h2.entity;


import javax.persistence.*;

@Entity
@Table(name = "LOGINCASE")
public class LoginCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqGenerator")
    @SequenceGenerator(name = "SeqGenerator", sequenceName = " SEQ_TEST_ID")
    @Column(name = "ID",nullable = false)
    private int id;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String passWord;
    @Column(name = "EXPECTED")
    private int expected;

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getExpected() {
        return expected;
    }

    public void setExpected(int expected) {
        this.expected = expected;
    }

    @Override
    public String toString() {
        return "LoginCase{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
