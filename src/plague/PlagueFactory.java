// Chris:
// 4/11: Plague factory done
// 4/14: added a get view so that we a PlagueView can be created since it's different from the SimulationView
// 4/14: Modified plague factory to allow for PlagueView to work properly

package plague;

import mvc.*;
import simstation.*;

public class PlagueFactory extends SimulationFactory{

    //So that makeModel can grab the correct simulation
    public PlagueFactory() { setSim(new PlagueSimulation()); }

    @Override
    public Model makeModel() { return getSim(); }

    @Override
    public String getTitle() { return "Plague Simulation"; }

    @Override
    public View getView(Model m) { return new PlagueView((PlagueSimulation)getSim()); }

    @Override
    public String[] getHelp() {
        // put something later
        String[] cmmds = new String[4];
        cmmds[0] = "#agents: # of dots";
        cmmds[1] = "clock: start timer when you start the simulation and pause when you press suspend";
        cmmds[2] = "Red agent: infected by a virus";
        cmmds[3] = "Green: not infected by a virus";

        return cmmds;
    }
}
