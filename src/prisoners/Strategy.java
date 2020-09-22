/********************************
 * Created by Gabriel Tenocelotl
 * Started: 4/13
 * Finished: 4/14
 * Debugged and completed: 4/15
 * IMPORANT* the equals method does not override the Object equals method!!
 * its purpose is to compare extended versions of Strategy..
 *******************************/
package prisoners;

import java.io.Serializable;

public abstract class Strategy implements Serializable
{
	protected int toCompare;								//used to compare the different extended strategy Objects
	abstract boolean executeStrategy(Boolean ... previous);
	abstract boolean equals(Strategy that);
}
