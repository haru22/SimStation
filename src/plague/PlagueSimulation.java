/*
    Chris:
    4/11: Layout of methods required completed, finished some methods
    4/12: Runnable prototype finished, with logic
    4/14: Implemented with Simstation we decided to use as base
    4/15: Cleaned up and commented, done
 */

package plague;

import mvc.*;
import simstation.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class PlagueSimulation extends Simulation{
    public static int VIRULENCE = 50;   //Chance of infection
    public static int RESISTANCE = 2;   //Chance of being resisted
    public static int INITIAL_INFECTION_PERCENT = 10;   //Initial infected rate, set at 10%
    public PlagueSimulation() { super(); }

    public void populate() {
        for (int i = 0; i < NUM_OF_AGENTS; i++) {
            this.add(new People());
        }
    }

    //Stats show # of agents, # Infected, % infected, and running time
    public void stats() {
        DecimalFormat formatter = new DecimalFormat("##.##");   //to format the percentages
        double infections = 0;

        //Checks for all the infected agents, and increments infections based on infected agents
        for(Agent a : this.getAgentList()) {
            if (((People) a).getInfected() == true) {
                infections++;
            }
        }

        //Make the message box
        JFrame frame = new JFrame("Stats");
        JOptionPane.showMessageDialog(frame, "# of People: " +  //# of people
                this.getAgentList().size() +
                "\n# Infected: " + (int)infections +    //# infected
                "\n% infected: " +                      //% infected
                formatter.format((infections/this.getAgentList().size()) * 100) +   //time
                "\nTime: " + this.getClock()
        );
    }

    public static void main(String[] args) {
        PlagueFactory plague = new PlagueFactory();
        AppPanel panel = new SimulationPanel(plague);
        panel.display();

    }
}
