// Chris:
// 4/11 finished drunks factory
// 4/14 removed cleaned up, remove unneeded Override for about
// 4/15 added in code to work with SimFactory
// 4/15 clean up
// 4/15 Removed unneeded getView, added DrunksFactory constuctor so makeModel grabs the right sim

package randomWalks;

import simstation.*;
import mvc.*;

public class DrunksFactory extends SimulationFactory{

    //So that makeModel can grab the correct simulation
    public DrunksFactory() {
        setSim(new DrunksSimulation());
    }

    @Override
    public Model makeModel() {
        return getSim();
    }

    @Override
    public String getTitle() { return "Random Walks (Drunks) Simulation"; }

    @Override
    public String[] getHelp() {
        // put something later
        String[] cmmds = new String[3];
        cmmds[0] = "#agents: # of dots";
        cmmds[1] = "clock: start timer when you start the simulation and pause when you press suspend";
        cmmds[2] = "Agents move randomly with random speed";

        return cmmds;
    }

}