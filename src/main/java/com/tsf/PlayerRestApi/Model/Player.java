package com.tsf.PlayerRestApi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player {
    @Id
    @Column(name = "ID")
    private Long ID;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TEAM")
    private String team;

    @Column(name = "SCORE")
    private int score;

    //CONSTRUCTORS
    public Player() {
    }

    public Player(Long ID, String name, String team, int score) {
        this.ID = ID;
        this.name = name;
        this.team = team;
        this.score = score;
    }

    //GETTERS AND SETTERS

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}