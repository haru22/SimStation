/********************************
 * Created by Gabriel Tenocelotl
 * Started: 4/13
 * Finished: 4/14
 * Debugged and completed: 4/15
 *******************************/
package prisoners;

import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mvc.*;
import simstation.*;

public class Prison extends Simulation
{

	public void populate()
	{
		for(int i = 0; i < NUM_OF_AGENTS; i++)
		{
			this.add(new Prisoner());
		}
	}
	
	public void stats()							//used to create a new stats panel for Prisoner stats
	{
		JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "#agents = " + NUM_OF_AGENTS
        + "\nclock = " + clock + "\n" + getStats());
	}
	
	private String getStats()					//to get a String of the prisoner stats
	{
		String statsString = "";
		double average1 = 0, average2 = 0, average3 = 0, average4 = 0;
		double strategy1Prisoners = 0, strategy2Prisoners = 0, strategy3Prisoners = 0, strategy4Prisoners = 0;
		DecimalFormat df2 = new DecimalFormat("#.##");						//better formatting 
		
		for(Agent a: agentList)
		{
			Prisoner prisoner = (Prisoner)a;
			if(prisoner.getStrategy().equals(Prisoner.strategies[0]))		//uses equals method to compare the strategy objects
			{
				strategy1Prisoners += 1;
				average1 += prisoner.getFitness();
			}
			else if(prisoner.getStrategy().equals(Prisoner.strategies[1]))
			{
				strategy2Prisoners += 1;
				average2 += prisoner.getFitness();
			}
			else if(prisoner.getStrategy().equals(Prisoner.strategies[2]))
			{
				strategy3Prisoners += 1;
				average3 += prisoner.getFitness();
			}
			else if(prisoner.getStrategy().equals(Prisoner.strategies[3]))
			{
				strategy4Prisoners += 1;
				average4 += prisoner.getFitness();
			}
		}
		
		average1 /= strategy1Prisoners;
		average2 /= strategy2Prisoners;
		average3 /= strategy3Prisoners;
		average4 /= strategy4Prisoners;
		
		statsString = "Always Cheat Average Fitness: " + df2.format(average1) +
					  "\nAlways Cooperate Average Fitness: " + df2.format(average2) + 
					  "\nRandomly Cooperate Average Fitness: " + df2.format(average3) +
					  "\nPrevious Opponent Strategy Average: " + df2.format(average4);
		return statsString;
	}
	public static void main(String [] args)
	{
		AppPanel panel = new SimulationPanel(new PrisonerFactory());
		panel.display();
	}
}
