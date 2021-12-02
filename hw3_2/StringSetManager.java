import java.util.Locale;
import java.util.Scanner;

enum StringCommand {ADD, SORT, REMOVE, CLEAN, QUIT, INVALID};

public class StringSetManager {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] stringSet = new String[100];
        while(true) {
            final StringCommand command = getCommand(scanner);
            if(command == StringCommand.QUIT) {
                System.out.println("BYE!");
                break;
            }
            switch (command) {
                case ADD: {
                    final String str = getString(scanner);
                    add(stringSet, str);
                    break;
                }
                case SORT: {
                    final String order = getString(scanner);
                    sort(stringSet, order);
                    break;
                }
                case REMOVE: {
                    final String str = getString(scanner);
                    remove(stringSet,str);
                    break;
                }
                case CLEAN: {
                    clean(stringSet);
                    break;
                }
                case INVALID: {
                    System.out.println("Invalid Command");
                    break;
                }
                default:
            }
            print(stringSet);
        }
        scanner.close();
    }

    private static StringCommand getCommand(Scanner scanner) {
        final String command = scanner.next();
        StringCommand result;
        try {
            result = StringCommand.valueOf(command.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            result = StringCommand.INVALID;
        }
        return result;
    }

    private static String getString(Scanner scanner) {
        String result = scanner.next();
        return result;
    }

    private static void add(String[] arrays, String str) {
        int i;
        for(i=0; arrays[i] != null; i++)
            if(arrays[i].equals(str))
                break;

        arrays[i] = str;
    }

    private static void sort(String[] arrays, String order) {
        if(order.toUpperCase().equalsIgnoreCase("DESC")) {
            for(int i=0; arrays[i] != null; i++) {
                int index = i;
                String temp = arrays[i];

                for(int j=i; arrays[j] != null; j++) {
                    if(temp.compareTo(arrays[j]) < 0) {
                        temp = arrays[j];
                        index = j;
                    }
                }
                if(index != i) {
                    arrays[index] = arrays[i];
                    arrays[i] = temp;
                }
            }
        }
        else {
            for (int i = 0; arrays[i] != null; i++) {
                int index = i;
                String temp = arrays[i];

                for (int j = i; arrays[j] != null; j++) {
                    if (temp.compareTo(arrays[j]) > 0) {
                        temp = arrays[j];
                        index = j;
                    }
                }
                if (index != i) {
                    arrays[index] = arrays[i];
                    arrays[i] = temp;
                }
            }
        }
    }

    private static void remove(String[] arrays, String str) {
        int find_str = 0;
        for(int i=0; arrays[i] != null; i++) {
            if(arrays[i].equals(str))
                find_str = 1;
            if(find_str == 1) {
                if(i==100)
                    arrays[i] = null;
                else
                    arrays[i] = arrays[i + 1];
            }
        }
    }

    private static void clean(String[] arrays) {
        for(int i=0; arrays[i] != null; i++)
            arrays[i] = null;
    }

    private static void print(String[] arrays) {
        int index;
        for(index=0 ; arrays[index] != null; index++);

        System.out.printf("Element Size: %d, Values = [", index);

        for(int i=0; i<index; i++) {
            System.out.print(arrays[i]);

            if(i != (index-1))
                System.out.print(", ");
        }

        System.out.println("]");
    }
}
