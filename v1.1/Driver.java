import java.io.*;
import java.text.NumberFormat.Style;
import java.util.*;

public class Driver {
    private Scanner scanner;
    private Grid grid;
    private boolean inBattle;
    private boolean bossDefeated;
    private Protagonist player;
    private Monster monster;

    public Driver() {
        scanner = new Scanner(System.in);
        grid = new Grid(10, 5);
        inBattle = false;
        player = grid.getPlayer();
        monster = grid.getMonster();
    }

    public void startGame() {
        while (!bossDefeated) {
            enableGrid();

        }
    }

    // enables the grid and starts fight
    public void enableGrid() {
        System.out.println("grid enabled");
        System.out.println("inBattle: " + inBattle);
        while (!inBattle) {
            if( grid.sameCoords(player, monster) ) {
                inBattle = true;
                break;
            }

            System.out.println(grid);
            grid.move(scanner.nextLine());
        }
        startBattle();
    }
    
    public void startBattle() {
        System.out.println("battle started");
        inBattle = true;

        while(inBattle) {

            System.out.println("\n" + "What will you do?");
            System.out.println("1: attack");
            battleOptions(scanner.nextLine());

            if(!monster.isAlive()) {
                System.out.println("\n" + "You won!");
                inBattle = false;
                break;
            }
        }
        System.out.println("battle ended");
    }

    public void battleOptions(String i) {
      int option = Integer.parseInt(i);

      if (option == 1) {
        player.attack(monster);
        System.out.println("You attacked!");
      } else {
        battleOptions(scanner.nextLine());
      }
    }

    public static void main(String[] args) {
        Driver game = new Driver();
        game.startGame();
    }
}
