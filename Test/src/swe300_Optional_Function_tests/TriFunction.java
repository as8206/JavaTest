package swe300_Optional_Function_tests;

/**
 * Implements the TriFunction interface to be used as a function.
 * @author as8206
 *
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <R>
 */

@FunctionalInterface
public interface TriFunction<T1,T2, T3, R>
{
	R apply(T1 t1, T2 t2, T3 t3);
}
