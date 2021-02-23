/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */

package soccer;

public class Goal {   
    private Team theTeam;
    private Player thePlayer;
    private double theTime;
    
    //Getters and Setters
    public Team getTheTeam() {
        return theTeam;
    }
    public void setTheTeam(Team theTeam) {
        this.theTeam = theTeam;
    }

    public Player getThePlayer() {
        return thePlayer;
    }
    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public double getTheTime() {
        return theTime;
    }
    public void setTheTime(double theTime) {
        this.theTime = theTime;
    }
}
