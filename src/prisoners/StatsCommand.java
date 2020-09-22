/********************************
 * Created by Gabriel Tenocelotl
 * Started: 4/13
 * Finished: 4/14
 * Debugged and completed: 4/15
 * IMPORTANT* The stats command is overrides because the Prison stats JOptionPanel needs to include prisoner stats
 *******************************/
package prisoners;

import mvc.Command;
import mvc.Model;
import simstation.Simulation;

public class StatsCommand extends Command
{
    public StatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Simulation prison = (Simulation) model;
        prison.stats();
    }
}
