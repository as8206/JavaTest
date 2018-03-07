package Java_Types;

public class runner {
	public static void main(String[] args)
	{
		Apple[] aa = new Apple[] {new Apple()};
		Fruit[] fa = aa;
		fa[0] = new Orange();
	}
}
