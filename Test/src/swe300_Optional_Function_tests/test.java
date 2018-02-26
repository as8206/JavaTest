package swe300_Optional_Function_tests;
import java.util.function.Function;

public class test 
{	
	static <A,B> B simplyApply(Function<A,B> f, A a) 
	{
		return f.apply(a);
	}
	
	static Function<String, Integer> count = (String s) -> s.length();
	
	public static void main(String[] args)
	{
		System.out.println(simplyApply(count, "abcd"));
		System.out.println(simplyApply(count2, "abcd"));
	}
	
	static Function<String, Integer> count2 = s -> (s.length() * 2);
	
}