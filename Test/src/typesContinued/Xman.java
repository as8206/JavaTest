package typesContinued;

public class Xman extends Human 
{
	int flySpeed;
	
	public Xman(int speed, int fly) 
	{
		super(speed);
		flySpeed = fly;
	}
	
	int getFlyingSpeed()
	{
		return flySpeed;
	}

}
