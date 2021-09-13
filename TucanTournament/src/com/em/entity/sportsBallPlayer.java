package com.em.entity;

public class sportsBallPlayer {

   protected String playerName;
   protected String nickname;
   protected int number;
   protected String teamName;
   protected String position;
   protected int finalScore;

   public sportsBallPlayer(String playerName, String nickname, int number, String teamName, String position,int finalScore) {
      this.playerName = playerName;
      this.nickname = nickname;
      this.number = number;
      this.teamName = teamName;
      this.position = position;
      this.finalScore = finalScore;
   }

   public String getPlayerName() {
      return playerName;
   }

   public void setPlayerName(String playerName) {
      this.playerName = playerName;
   }

   public String getNickname() {
      return nickname;
   }

   public void setNickname(String nickname) {
      this.nickname = nickname;
   }

   public int getNumber() {
      return number;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   public String getTeamName() {
      return teamName;
   }

   public void setTeamName(String teamName) {
      this.teamName = teamName;
   }

   public String getPosition() {
      return position;
   }

   public void setPosition(String position) {
      this.position = position;
   }

   public int getFinalScore() {
      return finalScore;
   }

   public void setFinalScore(int finalScore) {
      this.finalScore = finalScore;
   }
}
