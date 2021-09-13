package com.em.entity;

public class handMadePlayer extends sportsBallPlayer{
    private int goalsMade;
    private int goalsReceived;

    public handMadePlayer(String playerName, String nickname, int number, String teamName, String position, int finalScore, int goalsMade, int goalsReceived) {
        super(playerName, nickname, number, teamName, position, finalScore);
        this.goalsMade = goalsMade;
        this.goalsReceived = goalsReceived;
    }

    public int getGoalsMade() {
        return goalsMade;
    }

    public void setGoalsMade(int goalsMade) {
        this.goalsMade = goalsMade;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }
}
