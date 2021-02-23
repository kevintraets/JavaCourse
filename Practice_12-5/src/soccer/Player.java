/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */

package soccer;

public class Player {
    private String playerName;   
    
    //Constructors
    public Player(String playerName) {
        this.playerName = playerName;
    }
    
    //Getters and Setters
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
