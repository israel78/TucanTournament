package com.em.utils.entity;

public class basketPosition extends positionsDefinition {

    int scorePoint;
    int rebound;
    int assist;

    public basketPosition(String sportBallname, String possition, int scorePoint, int rebound, int assist) {
        super(sportBallname, possition);
        this.scorePoint = scorePoint;
        this.rebound = rebound;
        this.assist = assist;
    }

    public int getScorePoint() {
        return scorePoint;
    }

    public void setScorePoint(int scorePoint) {
        this.scorePoint = scorePoint;
    }

    public int getRebound() {
        return rebound;
    }

    public void setRebound(int rebound) {
        this.rebound = rebound;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }
}
