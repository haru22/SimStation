/*
    Chris:
    4/11: Majority of class prepared
    4/12: Finished logic for update, created a infect method
    4/14: Completed all methods, simulation moved out of People and stored in Agent
    4/15: Clean up and comment
 */
package plague;

import mvc.*;
import simstation.*;

public class People extends Agent{
    private int speed;          //int to store how much the person moves
    private boolean infected;   //Boolean to flag person as infected or not

    public People() {
        super();
        this.setName("Person");
        this.setHeading(Heading.NORTH); //Default heading is north
        speed = Utilities.rng.nextInt(11) + 1;  //Get a random initial speed
        if(Utilities.rng.nextInt(100) < PlagueSimulation.INITIAL_INFECTION_PERCENT) //(0-99 < 10) 10% infection chance initially
            infected = true;
        else
            infected = false;
    }

    @Override
    public void update() {
        heading = randHeading(getHeading());        //The plagued person moves like a drunk
        speed = Utilities.rng.nextInt(11);
        move(speed);
        infect();       //call the infect method to see if this person can infect a neighbor
    }

    //Method to infect neighboring agents
    public void infect()
    {
        People neighbor = (People)(world.getNeighbor(this));    //Grab a random neighbor to try and infect
        double infection_Chance = (PlagueSimulation.VIRULENCE/100) * ((100 - PlagueSimulation.RESISTANCE)/100); //The chance of infection

        //If statement to check if this user can infect (needs to have a neighbor to infect and also be infected)
        if(this.getInfected() && neighbor != null) {
            if(Utilities.rng.nextInt(101) <= infection_Chance * 100) {   //Test the infection chance based on virulence and resistance
                neighbor.setInfected(true);     //If the agent manages to infect a neighbor, set the neighbor as infected
            }
        }
    }

    //Method to get a random heading
    public Heading randHeading(Heading defaultHeading)
    {
        int randVal = Utilities.rng.nextInt(4); //0 - 3
        switch(randVal) {
            case 0:
                return Heading.NORTH;
            case 1:
                return Heading.SOUTH;
            case 2:
                return Heading.EAST;
            case 3:
                return Heading.WEST;
            default:
                return defaultHeading;
        }
    }

    //Getters, no need for setters
    public boolean getInfected() { return infected; }
    public void setInfected(boolean val) { infected = val; }
    public synchronized int getSpeed() { return speed; }
}
