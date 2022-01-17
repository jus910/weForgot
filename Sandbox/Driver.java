import java.io.*;
import java.util.*;

public class Driver {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        Protag bob = new Protag();
        Cookie a = new Cookie();
        System.out.println(bob.getStats());
        bob.use(a);
        System.out.println(bob.getStats());
        */

        Grid grid = new Grid(10, 5);

        System.out.println(grid);
        while (true) {
            grid.move(scanner.next());
            System.out.println(grid);
        }
    }
}
