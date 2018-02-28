package swe300_Optional_Function_tests;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class mapTest 
{
	static <T,U> Function<Optional<T>, Optional<U>> map (Function<T, U> f)
	{
		return ot -> ot.map(f);
	}
	
	static <T,U> Function<Optional<T>, Optional<U>> mapf (Function<T, U> f)
	{
		return (ot) -> ot.flatMap(t -> Optional.of(f.apply(t)));
	}
	
	static <A,B,C> BiFunction<Optional<A>,Optional<B>,Optional<C>> map2 (BiFunction<A, B, C> f)
	{
		return (oa, ob) -> (oa.flatMap(a -> ob.map(b -> f.apply(a, b))));
	}
	
	static <A,B,C,R> TriFunction<Optional<A>,Optional<B>,Optional<C>,Optional<R>> map3 (TriFunction<A, B, C, R> f)
	{
		return (oa, ob, oc) -> (oa.flatMap(a -> ob.flatMap(b -> oc.map(c -> f.apply(a, b, c)))));
	}
	
	static <A,B,C> BiFunction<Optional<A>, Integer, Optional<C>> repeat(Function<Integer,C> f)
	{
		return (oh, i) -> oh.map(h -> f.apply(i));
	}
	public static void main(String[] args)
	{
		Optional<localHuman> oh = Optional.of(new localHuman(new Weapon(new Magazine(15))));
		Optional<localHuman> oh2 = Optional.of(new localHuman(new Weapon(new Magazine(20))));
		Function<Integer,Integer> c = (i) -> i;
		Optional<Integer> j = Optional.of(1);
		Integer i = 1;
		
		System.out.println(mapf(localHuman::getWeapon).apply(oh));
		System.out.println(map(localHuman::getWeapon).apply(oh2));
		
		
		
		
		//System.out.println(repeat(localHuman::oneArg).apply(oh, i));
		System.out.println(map2(localHuman::oneArg).apply(oh, j));
		System.out.println(map2((localHuman h, Integer x) -> h.oneArg(x)).apply(oh, j));
		
		System.out.println();
		
		
		demoClass regularDemo = new demoClass();
		int regularInteger = 1;
		
		Optional<demoClass> demo = Optional.of(regularDemo);
		Optional<Integer> optionalInteger = Optional.of(regularInteger);
		
		System.out.println(regularDemo.oneArg(regularInteger));
		System.out.println(map2(demoClass::oneArg).apply(demo, optionalInteger));
		
		
	}
}
