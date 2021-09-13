package com.em.entity;

public class basketPlayer extends sportsBallPlayer{


    private int scoredPoints;
    private int rebounds;
    private int assists;

    public basketPlayer(String playerName, String nickname, int number, String teamName, String position, int finalScore, int scoredPoints, int rebounds, int assists) {
        super(playerName, nickname, number, teamName, position,finalScore);
        this.scoredPoints = scoredPoints;
        this.rebounds = rebounds;
        this.assists = assists;
    }

    public int getScoredPoints() {
        return scoredPoints;
    }

    public void setScoredPoints(int scoredPoints) {
        this.scoredPoints = scoredPoints;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }
}
