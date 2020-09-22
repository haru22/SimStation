// Chris:
// 4/15: Added in getView and separated makeModel into two parts to allow for SimFactory implementation
// 4/15: Reworked implementation so getView is no longer needed

/*
    Haruna:
    4/10 created
*/
package boids;
import mvc.Model;
import simstation.SimulationFactory;

public class FlockingFactory extends SimulationFactory {

    //So that makeModel can grab the correct simulation
    public FlockingFactory() { setSim(new Flocking()); }
    public Model makeModel() {
        return getSim();
    }
    @Override
    public String[] getHelp() {
        // put something later
        String[] cmmds = new String[3];
        cmmds[0] = "#agents: # of dots";
        cmmds[1] = "clock: start timer when you start the simulation and pause when you press suspend";
        cmmds[2] = "Agents randomly copy neighbor's heading and speed and move";

        return cmmds;
    }
}
