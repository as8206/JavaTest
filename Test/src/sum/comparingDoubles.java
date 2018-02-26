package sum;

public class comparingDoubles 
{
	public static void main(String [] args)
	{
		System.out.println(0.1 == 0.1);
		System.out.println(0.1 == 0.2 - 0.1);
		System.out.println(0.1 == 0.3 - 0.1 - 0.1);
		
		int x = 2147483647;
		if (x != x*1000/1000)
			System.out.println("No!");
		
		int term1 = 247483647;;
		int term2 = 1000;
		int product = term1 * term2 / 1000000;
		if (product < 0)
			System.out.println("got it!");
	}
}
