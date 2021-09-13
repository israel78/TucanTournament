package com.em.utils.entity;

public class positionsDefinition {

    String sportBallname;
    String possition;

    public positionsDefinition(String sportBallname, String possition) {
        this.sportBallname = sportBallname;
        this.possition = possition;
    }

    public String getSportBallname() {
        return sportBallname;
    }

    public void setSportBallname(String sportBallname) {
        this.sportBallname = sportBallname;
    }

    public String getPossition() {
        return possition;
    }

    public void setPossition(String possition) {
        this.possition = possition;
    }
}
