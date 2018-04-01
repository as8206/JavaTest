package conditionalsAndLoops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlattenStream
{
	public static void main(String[] args)
	{
		List<List<Integer>> lli = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5,6), Arrays.asList(7,8,9));
		System.out.println(lli);
		Stream<Stream<Integer>> ssi = lli.stream().map(List::stream);
		
		Stream<Integer> si = ssi.flatMap(a -> a);
		//Stream<Integer> si = ssi.flatMap(Function.identity());
		
		List<Integer> li = si.collect(Collectors.toList());
		
		System.out.println(li);
	}
	
}
