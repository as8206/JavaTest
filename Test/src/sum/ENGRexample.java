package sum;

public class ENGRexample 
{
	public static void main(String[] args)
	{
		int start = 400;
		int end = 600;
		int step = 50;
		
		double l_start = start/1000.0;
		double l_end = end/1000.0;
		double l_step = step/1000.0;
		
		double loop_variable = l_start;
		
		while (loop_variable <= l_end +(.00001))
		{
			System.out.println(loop_variable);
			loop_variable += l_step;
		}
		System.out.println(l_end);
	}
}
