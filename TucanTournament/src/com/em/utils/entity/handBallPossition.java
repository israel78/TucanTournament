package com.em.utils.entity;

public class handBallPossition extends positionsDefinition {

    int initialRatingPoints;
    int goalMade;
    int goalReceived;

    public handBallPossition(String sportBallname, String possition, int initialRatingPoints, int goalMade, int goalReceived) {
        super(sportBallname, possition);
        this.initialRatingPoints = initialRatingPoints;
        this.goalMade = goalMade;
        this.goalReceived = goalReceived;
    }

    public int getInitialRatingPoints() {
        return initialRatingPoints;
    }

    public void setInitialRatingPoints(int initialRatingPoints) {
        this.initialRatingPoints = initialRatingPoints;
    }

    public int getGoalMade() {
        return goalMade;
    }

    public void setGoalMade(int goalMade) {
        this.goalMade = goalMade;
    }

    public int getGoalReceived() {
        return goalReceived;
    }

    public void setGoalReceived(int goalReceived) {
        this.goalReceived = goalReceived;
    }

}
