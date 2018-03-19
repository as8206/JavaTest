package typesContinued;

import java.util.Comparator;

public class HumanComparator implements Comparator<Human>
{
	public int compare(Human h1, Human h2)
	{
		if(h1.getRunningSpeed() == h2.getRunningSpeed())
			return 0;
		else if (h1.getRunningSpeed() < h2.getRunningSpeed())
			return -1;
		else if(h1.getRunningSpeed() > h2.getRunningSpeed())
			return 1;
		else
			return 0;
	}
}
