package four;

public class ArrayAverage {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;
        try {
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            System.out.println(sum / array.length);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument provided");
        }
    }
}
