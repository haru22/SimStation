/********************************
 * Created by Gabriel Tenocelotl
 * Started: 4/13
 * Finished: 4/14
 * Debugged and completed: 4/15
 *******************************/
package prisoners;

public class AlwaysCheat extends Strategy
{
	public AlwaysCheat()
	{
		toCompare = 1;                                   //How to compare the object of strategy
	}
	public boolean executeStrategy(Boolean ...booleans)
	{
		return false;
	}
	
	public boolean equals(Strategy that)
	{
		if(this.toCompare == that.toCompare)              //compares two different strategies
		{
			return true;
		}
		return false;
	}
}
