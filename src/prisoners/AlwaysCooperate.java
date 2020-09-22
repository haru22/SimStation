/********************************
 * Created by Gabriel Tenocelotl
 * Started: 4/13
 * Finished: 4/14
 * Debugged and completed: 4/15
 *******************************/
package prisoners;

public class AlwaysCooperate extends Strategy
{
	public AlwaysCooperate()
	{
		toCompare = 2;									//How to compare the object of strategy
	}
	
	public boolean executeStrategy(Boolean ...booleans)
	{
		return true;
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
