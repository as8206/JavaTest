

package Java_Types;

import java.util.ArrayList;
import java.util.List;

public class runner {
	public static void main(String[] args)
	{
		Apple[] aa = new Apple[] {new Apple()};
		Fruit[] fa = aa;
		fa[0] = new Orange();
		
		List<Apple> a = new ArrayList<Apple>();
		a.add(new Apple());
		List<Fruit> f = a;
		
		
	}
}
