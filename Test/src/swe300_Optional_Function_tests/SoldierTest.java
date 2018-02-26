package swe300_Optional_Function_tests;

import java.util.Optional;

public class SoldierTest 
{
	public static void main(String[] args)
	{
		Human h = new Human("regular");
		Optional<Human> oh=Optional.ofNullable(h);
		Optional<Human> oh2=Optional.ofNullable(null);
		Optional<Human> oh3=Optional.ofNullable(h);
		Optional<Human> oh4=Optional.ofNullable(null);
		System.out.println("______________________________________");
		
		/*
		System.out.println(oh.orElseGet(() -> talkingSoldier()).getMood());
		System.out.println(oh2.orElseGet(() -> talkingSoldier()).getMood());
		System.out.println(oh3.orElseGet(() -> silentSoldier()).getMood());
		System.out.println(oh4.orElseGet(() -> silentSoldier()).getMood());
		
		System.out.println(oh.orElse(talkingSoldier()).getMood());
		System.out.println(oh2.orElse(talkingSoldier()).getMood());
		System.out.println(oh3.orElse(silentSoldier()).getMood());
		System.out.println(oh4.orElse(silentSoldier()).getMood());
		
		System.out.println(oh.orElse(new Human("test")).getMood());
		System.out.println("--------------------------------------");
		System.out.println(oh2.orElse(new Human("test")).getMood());
		System.out.println("--------------------------------------");
		System.out.println(oh3.orElse(new Human("test")).getMood());
		System.out.println("--------------------------------------");
		System.out.println(oh4.orElse(new Human("test")).getMood());
		
		System.out.println("______________________________________");
		
		System.out.println(oh.orElseGet(() -> new Human("test")).getMood());
		System.out.println("--------------------------------------");
		System.out.println(oh2.orElseGet(() -> new Human("test")).getMood());
		System.out.println("--------------------------------------");
		System.out.println(oh3.orElseGet(() -> new Human("test")).getMood());
		System.out.println("--------------------------------------");
		System.out.println(oh4.orElseGet(() -> new Human("test")).getMood());
		*/
		oh.ifPresent(System.out::println);
		oh2.ifPresent(System.out::println);
		/*
		oh.ifPresent(h -> System.out.println("Roll Call"));
		oh2.ifPresent(System.out::println);
		*/
	}
	
	public static Human talkingSoldier()
	{
		System.out.println("*Roger that*");
		return new Human("Talkative");
	}

	public static Human silentSoldier()
	{
		return new Human("Quiet");
	}
}
