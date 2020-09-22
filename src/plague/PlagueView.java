/*
    Chris:
    4/12: Finished plague view based on Simulation View
    4/14: Updated using agreed upon Simstation
    4/15: Removed the need to get color from People, color is determined by if infected
 */
package plague;

import simstation.*;

import java.awt.*;

public class PlagueView extends SimulationView{

    public PlagueView(PlagueSimulation sim) { super(sim); }

    public void paintComponent(Graphics gc)
    {
        PlagueSimulation sim = (PlagueSimulation)model;

        for(Agent a : sim.getAgentList())
        {
            //Check to see if current person is infected
            if(((People)a).getInfected())
            {
                gc.setColor(Color.RED);     //Red is infected
            }
            else
            {
                gc.setColor(Color.GREEN);   //Green is not infected
            }
            gc.fillOval(a.getX_Pos(), a.getY_Pos(), sim.DOT_SIZE, sim.DOT_SIZE); //Prepare to be drawn
        }
    }
}
