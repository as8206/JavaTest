package sum;

//This class uses reference type Long, takes longer but has various methods
public class Sum {
  public static void main(String[] s) {
    Long sum = 0L;
    for (long i = 0; i < Integer.MAX_VALUE; i++) {
      sum += i;
    }

    System.out.println(sum);
  }
}
