/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBLayers;

import java.time.LocalDateTime;

/**
 *
 * @author Admin
 */
public class GameMatchDTO {

    int id;
    int playerID1;
    int playerID2;
    int winnerID;
    int playTime;
    int totalMove;
    LocalDateTime startedTime;
    String chat = "";

    public GameMatchDTO(int id, int playerID1, int playerID2, int winnerID, int playTime, int totalMove, LocalDateTime startedTime, String chat) {
        this.id = id;
        this.playerID1 = playerID1;
        this.playerID2 = playerID2;
        this.winnerID = winnerID;
        this.playTime = playTime;
        this.totalMove = totalMove;
        this.startedTime = startedTime;
        this.chat = chat;
    }

    public GameMatchDTO(int playerID1, int playerID2, int winnerID, int playTime, int totalMove, LocalDateTime startedTime) {
        this.playerID1 = playerID1;
        this.playerID2 = playerID2;
        this.winnerID = winnerID;
        this.playTime = playTime;
        this.totalMove = totalMove;
        this.startedTime = startedTime;
    }

    public GameMatchDTO(GameMatchDTO g) {
        this.id = g.id;
        this.playerID1 = g.playerID1;
        this.playerID2 = g.playerID2;
        this.winnerID = g.winnerID;
        this.playTime = g.playTime;
        this.totalMove = g.totalMove;
        this.startedTime = g.startedTime;
        this.chat = g.chat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerID1() {
        return playerID1;
    }

    public void setPlayerID1(int playerID1) {
        this.playerID1 = playerID1;
    }

    public int getPlayerID2() {
        return playerID2;
    }

    public void setPlayerID2(int playerID2) {
        this.playerID2 = playerID2;
    }

    public int getWinnerID() {
        return winnerID;
    }

    public void setWinnerID(int winnerID) {
        this.winnerID = winnerID;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public int getTotalMove() {
        return totalMove;
    }

    public void setTotalMove(int totalMove) {
        this.totalMove = totalMove;
    }

    public LocalDateTime getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(LocalDateTime startedTime) {
        this.startedTime = startedTime;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

}
