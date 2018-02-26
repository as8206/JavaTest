package swe300_Optional_Function_tests;

public class Human 
{
	String mood;
	
	public Human(String moodInput)
	{
		System.out.println("*Delay...*");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mood = moodInput;
	}
	
	public String getMood()
	{
		return mood;
	}
}
