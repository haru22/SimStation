/*
    Haruna:
    4/9 created
    4/11 fix update
    4/13 fix add method
    4/14 fix update againg done

*/

package boids;

import mvc.Utilities;
import simstation.*;


public class Birds extends Agent {
    private int speed;

    public Birds() {
        super();
        //random speed
        speed = Utilities.rng.nextInt(5) + 1;
    }

    @Override
    public void update() {
        Birds neighbor = (Birds) world.getNeighbor(this);
        if (neighbor != null) {
            //System.out.println("original heading" + " " + this.getHeading());
            //System.out.println("original speed" + " " + this.getSpeed());
            heading = neighbor.getHeading();
            speed = neighbor.getSpeed();


            //System.out.println("after copied heading " + heading);
            //System.out.println("after copied heading " + speed);

        }
        move(speed);
    }

    public synchronized int getSpeed() {
        return speed;
    }


}
