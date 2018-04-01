package conditionalsAndLoops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedList
{
	public static void main(String[] args)
	{
		List nestedLst = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5,6), Arrays.asList(7,8,9));
		System.out.println(nestedLst);
		
		List unnestedLst = flatten(nestedLst);
		System.out.println(unnestedLst);
	}

	public static List<Integer> flatten(List<List<Integer>> lst)
	{
		List<Integer> res = new ArrayList<>();
		for(List<Integer> li: lst)
		{
			res.addAll(li);
		}
		return res;
	}
}
