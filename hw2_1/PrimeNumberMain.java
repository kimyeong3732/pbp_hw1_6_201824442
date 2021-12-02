import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumberMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a number: ");
        int num = scanner.nextInt();

        for ( int i=2; i<=num; i++) {
            System.out.println("Prime Numbers less than or equal to " + i + " = " + Arrays.toString(getPrimeNumber(i)));
        }
    }

    private static Integer[] getPrimeNumber(final int n) {
        Integer temp[] = new Integer[n-1];
        int index = 0;
        for ( int i=2; i<=n; i++) {
            int notprime = 0;

            for ( int j=2; j<=(i/2); j++) {
                if((i%j) == 0) {
                    notprime = 1;
                }
            }

            if(notprime == 0) {
                temp[index++] = i;
            }
        }
        Integer result[] = new Integer[index];
        for ( int i=0; i<index; i++) {
            result[i] = temp[i];
        }

        return result;
    }
}
