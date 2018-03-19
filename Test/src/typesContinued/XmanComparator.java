package typesContinued;

import java.util.Comparator;

public class XmanComparator implements Comparator<Xman>
{
	public int compare(Xman h1, Xman h2)
	{
		if(h1.getFlyingSpeed() == h2.getFlyingSpeed())
			return 0;
		else if (h1.getFlyingSpeed() < h2.getFlyingSpeed())
			return -1;
		else if(h1.getFlyingSpeed() > h2.getFlyingSpeed())
			return 1;
		else
			return 0;
	}
}
