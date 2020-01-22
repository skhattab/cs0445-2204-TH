import java.util.Arrays;
public class Main{
  public static void main(String[] args){
    BagInterface<Integer> aBag = new ArrayBag<>(10);
    aBag.add(1);
    aBag.add(2);
    aBag.add(3);
    Object[] items = aBag.toArray();
    // for(Object item: items){
    //   Integer i = (Integer)item;
    // }
    System.out.println(Arrays.toString(items));

    testSetOperations(new Integer[]{2, 1}, new Integer[]{1});
    testSetOperations(new Integer[]{2, 2, 1}, new Integer[]{2});
    testSetOperations(new Integer[]{2, 2, 1}, new Integer[]{2, 2, 2, 1, 1, 1});
    testSetOperations(new Integer[]{2, 2, 2, 2, 1}, new Integer[]{2, 2, 2, 1, 1, 1});

  }

  private static void testSetOperations(Integer[] A, Integer[] B){
    System.out.println(Arrays.toString(A) + " and " + Arrays.toString(B));
    ArrayBag<Integer> BagA = new ArrayBag<>(A.length);
    ArrayBag<Integer> BagB = new ArrayBag<>(B.length);
    for(Integer a : A){
      BagA.add(a);
    }
    for(Integer b : B){
      BagB.add(b);
    }
    System.out.println("Intersection: " +
      Arrays.toString(BagA.intersection(BagB).toArray()));
    System.out.println("Union: " +
        Arrays.toString(BagA.union(BagB).toArray()));
    System.out.println("Difference: " +
          Arrays.toString(BagA.difference(BagB).toArray()));
  }
}
