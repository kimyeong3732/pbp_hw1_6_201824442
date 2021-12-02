import java.util.Arrays;
import java.util.Scanner;

public class MathMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N: ");
        int leng = scanner.nextInt();
        int[] inputs = new int[leng];

        for(int i=0; i<leng; i++) {
            inputs[i] = scanner.nextInt();
        }
        scanner.close();

        int max = getMax(inputs);
        System.out.printf("Max element : %d in %s%n", max, Arrays.toString(inputs));

        int min = getMin(inputs);
        System.out.printf("Min element : %d in %s%n", min, Arrays.toString(inputs));
    }

    private static int getMax(int[] array) {
        int result = array[0];

        for(int i=1; i<array.length; i++) {
            if(result < array[i]) {
                result = array[i];
            }
        }

        return result;
    }

    private static int getMin(int[] array) {
        int result = array[0];

        for(int i=1; i<array.length; i++) {
            if(result > array[i]) {
                result = array[i];
            }
        }

        return result;
    }
}
