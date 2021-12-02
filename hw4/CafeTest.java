import java.util.Locale;
import java.util.Scanner;

enum Command {ADD, FIND, CLEAR, LIST, QUIT, INVALID}

public class CafeTest {
    private static Scanner scanner = new Scanner(System.in);
    public  static void main(String[] args) {
        Cafe starbucks = new Cafe("Starbucks");
        while(true) {
            final Command cmd = getCommand(scanner);
            if(cmd == Command.QUIT) {
                System.out.println("Bye");
                break;
            }
            if(cmd == Command.INVALID) {
                System.out.println("Invalid Operation!");
                continue;
            }
            switch (cmd) {
                case ADD: {
                    Beverage newBeverage = createBeverage();
                    starbucks.addBeverage(newBeverage);
                    break;
                }
                case FIND: {
                    findBeverage(starbucks);
                    break;
                }
                case CLEAR: {
                    starbucks.removeAllBeverage();
                    break;
                }
                case LIST: {
                    System.out.println(starbucks);
                    break;
                }
                default: break;
            }
        }
    }

    private static void findBeverage(final Cafe cs) {
        final String name = scanner.next();
        final String type = scanner.next().toUpperCase();
        final Beverage foundBeverage = cs.findBeverage(name, type);
        if(foundBeverage != null) {
            System.out.println(foundBeverage);
        }
        else {
            System.out.println("Beverage Not Found with nama " + name + " and type " + type);
        }
    }

    private static Beverage createBeverage() {
        final String name = scanner.next();
        final String type = scanner.next().toUpperCase();
        return new Beverage(name, type);
    }

    private static Command getCommand(Scanner scanner) {
        System.out.print("Enter Command String! ");
        String input = scanner.next();
        Command cmd;
        try {
            cmd = Command.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            cmd = Command.INVALID;
        }
        return cmd;
    }
}
