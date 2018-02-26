package sum;

//This class uses the primitive type long, it is faster but only a value. Usually use this type.
public class Sum2 {
  public static void main(String[] s) {
    long sum = 0L;
    for (long i = 0; i < Integer.MAX_VALUE; i++) {
      sum += i;
    }

    System.out.println(sum);
  }
}
