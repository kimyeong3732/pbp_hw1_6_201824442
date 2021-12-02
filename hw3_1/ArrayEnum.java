import java.util.Scanner;

enum Command {ADD, LIST, SRTA, SRTD, SUM, QUIT, INVALID};

public class ArrayEnum {
    public static void main(String[] args) {
        int[] values = new int[100];
        int index = 0;
        final Scanner scanner = new Scanner(System.in);

        while(true) {
            final Command command = getCommand(scanner);
            if( command == Command.QUIT ) {
                System.out.println("Bye!");
                break;
            }
            switch (command) {
                case ADD:
                    final int newValue = getValue(scanner);
                    values[index] = newValue;
                    index++;
                    break;
                case LIST:
                    printList(values, index);
                    break;
                case SRTA:
                    printList(sort(values, index, 'a'), index);
                    break;
                case SRTD:
                    printList(sort(values, index, 'd'), index);
                    break;
                case SUM:
                    int sum_result = 0;
                    for(int i=0; i<index; i++)
                        sum_result += values[i];
                    System.out.println(sum_result);
                    break;
                case INVALID:
                    System.out.println("Invalid Command");
            }
        }
        scanner.close();
    }

    private static Command getCommand(Scanner scanner) {
        final String command = scanner.next();
        Command result;
        try {
            result = Command.valueOf(command.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            result = Command.INVALID;
        }
        return result;
    }

    private static int getValue(Scanner scanner) {
        int result;
        try {
            result = scanner.nextInt();
        }
        catch (Exception e) {
            System.out.println("It's not Integer.");
            result = -1;
        }
        return result;
    }

    private static void printList(int[] arrays, int index){
        for (int i = 0; i < index; i++)
            System.out.print(arrays[i] + " ");

        System.out.println("");
    }

    private static int[] sort(int[] arrays, int index, char aod) {
        int[] result = new int[index];

        for(int i=0; i<index; i++)
            result[i] = arrays[i];

        if(aod == 'd') {
            for (int i = 0; i < index; i++) {
                int max = result[i];
                int index_max = i;

                for (int j = i; j < index; j++)
                    if (max < result[j]) {
                        max = result[j];
                        index_max = j;
                    }

                int temp = result[i];
                result[i] = max;
                result[index_max] = temp;
            }
        }
        else {
            for (int i = 0; i < index; i++) {
                int min = result[i];
                int index_min = i;

                for (int j = i; j < index; j++)
                    if (min > result[j]) {
                        min = result[j];
                        index_min = j;
                    }

                int temp = result[i];
                result[i] = min;
                result[index_min] = temp;
            }
        }

        return result;
    }
}
