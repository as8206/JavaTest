package swe300_Optional_Function_tests;
import java.util.Optional;
import java.util.function.*;

public class OptionalExperiment 
{
	static Optional<Integer> ammoCheck(localHuman h)
	{
		return Optional.ofNullable(h).map(localHuman::getWeapon).map(Weapon::getMagazine).map(Magazine::getCount);
	}
	
	public static void main(String[] args)
	{
		localHuman bob = new localHuman(new Weapon(new Magazine(10)));
		Optional<localHuman> oh = Optional.of(new localHuman(new Weapon(new Magazine(15))));
		System.out.println(ammoCheck(bob));
	//	System.out.println(oh.map(ammoCheck));
		
	}
}




class Magazine {
	private int count;
	public Magazine(int c) {count = c;}
	public int getCount() { return count;}
}

class Weapon {
	private Magazine mag;
	public Weapon(Magazine m) {mag=m;}
	public Magazine getMagazine() { return mag; }
}

class localHuman {
	private Weapon w;
	public localHuman(Weapon ww) {w=ww;}
	public Weapon getWeapon() { return w; }
	public int oneArg(int i) {return i *3;}
}

class demoClass {
	public int oneArg(int i) {
		return i * 3;
	}
}