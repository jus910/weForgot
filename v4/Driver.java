import java.io.*;
import java.util.*;

public class Driver {
    private Scanner scanner;
    private Grid grid;
    private boolean inBattle;
    private boolean bossDefeated;
    private int monstersDestroyed;
    private Protagonist player;
    private Boss boss;

    public Driver() {
        scanner = new Scanner(System.in);
        grid = new Grid(10, 5);
        inBattle = false;
        player = grid.getPlayer();
        boss = grid.getBoss();
        monstersDestroyed=0;
    }

    public void startGame() {
        enableGrid();
// New change, check if player isAlive
        if(player.isAlive()){
          System.out.println("The beast has been slain");
        } else {
          System.out.println("You have perished in battle");
        }
    }

    // enables the grid and starts fight
    public void enableGrid() {
        System.out.println("grid enabled");
        System.out.println("inBattle: " + inBattle);
        while (!inBattle && player.isAlive()) {
            for(Monster monster : Grid.monsters){
              	if(grid.sameCoords(player, monster) ){
                   inBattle=true;
                   startBattle(monster);
                   // Checks if player is alive, returns if they are not
                   if(!player.isAlive()){
                     return;
                   }
               }
                inBattle=false;
             	}
            // new change, must kill all monsters for boss to appear
            if (monstersDestroyed==Grid.monsterSize){
              System.out.println("You have angered a great foe");
              Grid.bossActive = true;
              if(grid.sameCoords(player, boss) ){
                System.out.println("You are now in the court of the Foo King");
                inBattle=true;
                startBossBattle();
                return;
              }
            }
               System.out.println(grid);
               grid.move(scanner.nextLine());
            }

        }

    public void startBattle(Monster monster) {
        System.out.println("battle started");
        inBattle = true;

        while(inBattle) {

            System.out.println("\n" + "What will you do?");
            System.out.println("1: attack");
            System.out.println("2: View Inventory");
            battleOptions(scanner.nextLine(), monster);

            if(!monster.isAlive()) {
                System.out.println("\n" + "You won!");
                monstersDestroyed++;
                inBattle = false;
                break;
            } else
            if(!player.isAlive()) {
              System.out.println("\n" + "You lost...");
              inBattle = false;
              break;
            }
        }
        System.out.println("battle ended");
    }

    public void battleOptions(String i,Monster monster) {
      int option = Integer.parseInt(i);

      if (option == 1) {
        player.attack(monster);
        monster.attack(player);
        System.out.println("You attacked!");
      } else
      if (option == 2 ){
        System.out.println(player.getInventory());
      }
    }

// Boss will have special methods for its fight
    public void startBossBattle() {
        System.out.println("battle started");
        inBattle = true;

        while(inBattle) {

            System.out.println("\n" + "What will you do?");
            System.out.println("1: attack");
            System.out.println("2: View Inventory");
            bossBattleOptions(scanner.nextLine());

            if(!boss.isAlive()) {
                System.out.println("\n" + "You won!");
                monstersDestroyed++;
                inBattle = false;
                break;
            } else
            if(!player.isAlive()) {
              System.out.println("\n" + "You lost...");
              inBattle = false;
              break;
            }
        }
        System.out.println("battle ended");
    }

    public void bossBattleOptions(String i) {
      int option = Integer.parseInt(i);

      if (option == 1) {
        player.attack(boss);
        boss.attack(player);
        System.out.println("You attacked!");
      } else
      if (option == 2 ){
        System.out.println(player.getInventory());
      }
    }

    public static void main(String[] args) {
        Driver game = new Driver();
        game.startGame();
    }
}
