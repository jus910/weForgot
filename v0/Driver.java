import java.io.*;
import java.util.*;

public class Driver {
    private Scanner scanner;
    private Grid grid;
    private boolean inBattle;

    public Driver() {
        scanner = new Scanner(System.in);
        grid = new Grid(10, 5);
        inBattle = false;

    }

    public void startGame() {
        enableGrid();
    }

    public void enableGrid() {
        while (!inBattle) {
            System.out.println(grid);
            grid.move(scanner.nextLine());
        }
    }
    public static void main(String[] args) {
        Driver game = new Driver();
        game.startGame();
    }
}
