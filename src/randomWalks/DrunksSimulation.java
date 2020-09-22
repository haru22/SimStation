// Chris:
// 4/11 mostly done, just gotta figure out the timer
// 4/14 timer solved outside of package, done

package randomWalks;

import simstation.*;
import mvc.*;

public class DrunksSimulation extends Simulation {

    public DrunksSimulation() {
        super();
    }

    public void populate() {
        for (int i = 0; i < NUM_OF_AGENTS; i++) {
            this.add(new Drunks());
        }
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new DrunksFactory());
        panel.display();
    }
}