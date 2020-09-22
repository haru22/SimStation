/********************************
 * Created by Gabriel Tenocelotl
 * Started: 4/13
 * Finished: 4/14
 * Debugged and completed: 4/15
 *******************************/
package prisoners;

import simstation.*;
import mvc.*;

public class PrisonerFactory extends SimulationFactory
{
    public PrisonerFactory() {setSim(new Prison());}
	public Model makeModel()
	{
		return getSim();
	}
	
	@Override
    public String[] getEditCommands() {
        return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type) {
        if(type == "Start")
            return new StartCommand(model);
        else if(type == "Stop")
            return new StopCommand(model);
        else if (type == "Suspend")
            return new SuspendCommand(model);
        else if (type == "Resume")
            return new ResumeCommand(model);
        else if (type == "Stats")
            return new StatsCommand(model);
        return null;
    }

    @Override
    public String[] getHelp() {
        // put something later
        String[] cmmds = new String[5];
        cmmds[0] = "#agents: # of dots";
        cmmds[1] = "clock: start timer when you start the simulation and pause when you press suspend";
        cmmds[2] = "cheat vs cooperate: fitness of cheat is incremented by 5pts";
        cmmds[3] = "cheat vs cheat: fitness is incremented by 1pts for both";
        cmmds[4] = "cooperate vs cooperate: fitness is incremented by 3pts for both";

        return cmmds;
    }
}
