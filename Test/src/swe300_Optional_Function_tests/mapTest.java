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
	
	public static void main(String[] args)
	{
		Optional<localHuman> oh = Optional.of(new localHuman(new Weapon(new Magazine(15))));
		Optional<localHuman> oh2 = Optional.of(new localHuman(new Weapon(new Magazine(20))));
		
		System.out.println(mapf(localHuman::getWeapon).apply(oh));
		System.out.println(mapf(localHuman::getWeapon).apply(oh2));
	}
}
