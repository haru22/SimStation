/* Edit History
Haruna 4/9 created
Haruna 4/10 continue creating
Haruna 4/11 continue creating

 */

package boids;

import mvc.AppPanel;
import simstation.Simulation;
import simstation.SimulationPanel;


public class Flocking extends Simulation {

    public Flocking() {
        super();
    }

    public void populate() {
        for (int i = 0; i < NUM_OF_AGENTS; i++){
            this.add(new Birds());
        }
    }


    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }

}
