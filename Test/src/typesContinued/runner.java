package typesContinued;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class runner 
{

	public static void main(String[] args) 
	{
		Human bob = new Human(8);
		Human lisa = new Human(6);
		Human matt = new Human(10);
		Xman superBob = new Xman(10, 20);
		Xman superLisa = new Xman(8, 15);
		Xman superMatt = new Xman(15, 40);
		
		List<Human> humanList = Arrays.asList(bob, lisa, matt);
		List<Xman> xmanList = Arrays.asList(superBob, superLisa, superMatt);
		
		Collections.sort(humanList, new HumanComparator());
		//Collections.sort(humanList, new XmanComparator()); //This one doesn't work due to inheritance rules
		
		Collections.sort(xmanList, new HumanComparator());
		Collections.sort(xmanList, new XmanComparator());
	}

}
