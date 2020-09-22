/********************************
 * Created by Gabriel Tenocelotl
 * Started: 4/13
 * Finished: 4/14
 * Debugged and completed: 4/15
 *******************************/
package prisoners;

import mvc.*;
import simstation.*;

public class Prisoner extends Agent
{
	/**************
	 * IMPORTANT* The static variables are used to see which strategy is being used
	 * Its also used to randomize which prisoner gets which strategy.
	 * Used also to compare which strategy in Prison.java
	 **************/
	public static int NUMBER_OF_STRATEGIES = 4;				
	public static Strategy[] strategies = new Strategy[] {new AlwaysCheat(),
														   new AlwaysCooperate(),
														   new RandomlyCooperate(),
														   new CooperateIfLastCooperated()};
	private int fitness;
	private boolean previousCooperate;					//used for a Strategy object
	private Strategy strategy;							//holds current strategy
	
	public Prisoner()
	{
		fitness = 0;
		strategy = strategies[Utilities.rng.nextInt(4)];		//randomize the strategy to use
		previousCooperate = true;
	}
	
	public void update()
	{
		Prison prison = (Prison)world;
		Prisoner player2 = (Prisoner)prison.getNeighbor(this);
		if(player2 != null)
		{
			if(this.cooperate() == true && player2.cooperate() == true)              //player1 and player 2 cooperate
			{
				this.fitness += 3;
				player2.fitness += 3;
			}
			else if(this.cooperate() == true && player2.cooperate() == false)        //player1 cooperates and playeer2 cheats
			{
				player2.fitness += 5;
			}
			else if(this.cooperate() == false && player2.cooperate() == true)        //player1 cheats and player2 cooperate
			{
			this.fitness += 5;
			}
			else if(this.cooperate()== false && player2.cooperate() == false)         //player1 and player 2 cheat
			{
				this.fitness += 1;
				player2.fitness += 1;
			}
			previousCooperate = player2.cooperate();
		}
		heading = Heading.values()[Utilities.rng.nextInt(4)];						//randomizes the next heading
		move(Utilities.rng.nextInt(10));											//randomizes the movement
	}
	
	private boolean cooperate()
	{
		return strategy.executeStrategy(previousCooperate);							//used to get the Strategys boolean (cheat or cooperate)
	}
	
	public Strategy getStrategy()
	{
		return strategy;
	}

	@Override
	public int getSpeed() {    //not sure if this method is required for prisoner
		// TODO Auto-generated method stub
		return 0;
	}

	public int getFitness() 
	{
		return fitness;
	}
}
