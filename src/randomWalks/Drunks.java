// Chris:
// 04/04 - Created the framework for the drunks agent
// 04/11 - Completed everything but still need to account for time
// 04/14 - Finished, timer problem solved outside of this package

package randomWalks;

import simstation.*;
import mvc.*;

//Drunks walk around randomly, first they choose a heading and then a distance to walk
public class Drunks extends Agent {
    private int speed;

    public Drunks() {
        super();
        this.setName("Town Drunk");     //These guys are town drunks
        this.setHeading(Heading.NORTH); //Default heading is north
        speed = Utilities.rng.nextInt(11) + 1;
    }

    //Update method picks a random heading and moves anywhere from 0-10 steps in that direction
    @Override
    public void update() {
        heading = randHeading(getHeading());
        speed = Utilities.rng.nextInt(11);
        move(speed);
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

    public synchronized int getSpeed() {
        return speed;
    }
}