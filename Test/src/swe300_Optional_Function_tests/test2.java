package swe300_Optional_Function_tests;
import java.util.function.Function;

public class test2 
{
	public static void main(String[] args)
	{
		System.out.println(p3.apply(2.0));
		System.out.println(p3.apply(2.5));
		System.out.println(p3.apply(-4.6));
		System.out.println(p3.apply(3.68));
	}
	
	static String silly(Integer i, Double d)
	{
		return ""+i+d;
	}
	
	static Function<Integer, Function<Double,String>> curriedSilly = i -> d -> silly(i,d);
	
	static Function<Double, String> p3 = curriedSilly.apply(3);
}
