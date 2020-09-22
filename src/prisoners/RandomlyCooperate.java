/********************************
 * Created by Gabriel Tenocelotl
 * Started: 4/13
 * Finished: 4/14
 * Debugged and completed: 4/15
 *******************************/
package prisoners;

import mvc.*;

public class RandomlyCooperate extends Strategy
{
	public RandomlyCooperate()
	{
		toCompare = 3;									//How to compare the object of strategy
	}
	
	public boolean executeStrategy(Boolean ...booleans)
	{
		return Utilities.rng.nextBoolean();				//return a random boolean
	}
	
	public boolean equals(Strategy that)
	{
		if(this.toCompare == that.toCompare)
		{
			return true;
		}
		return false;
	}
}
