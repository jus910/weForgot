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
        player = Grid.player;
        boss = Grid.boss;
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
        while (!inBattle) {
            for(Monster monster : Grid.monsters){
              	if(grid.sameCoords(player, monster) ) {
                    inBattle=true;
                    startBattle(monster);
                    break;
                }
                inBattle=false;
            }

            // new change, must kill all monsters for boss to appear
            if (monstersDestroyed==Grid.monsterSize){
                System.out.println("You have angered a great foe");
                Grid.bossActive = true;
                Grid.setTile(boss);
                if(grid.sameCoords(player, boss) ){
                    System.out.println("You are now in the court of the Foo King");
                    inBattle=true;
                    startBattle(boss);
                    return;
                }
            }
            System.out.println(grid);
            System.out.println(monstersDestroyed);
            grid.move(scanner.nextLine());
        }
    }

    // New Change: startBattle now uses playTurn, which does speed calculations
    public void startBattle(Monster monster) {
        System.out.println("battle started");
        inBattle = true;

        while(inBattle) {
            
            playTurn(player, monster);

            if(!player.isAlive()) {
                inBattle = false;
                break;
            }

            if(!monster.isAlive()) {
                System.out.println("\n" + "You won!");
                inBattle = false;
                monstersDestroyed++;
                break;
            }
        }
        System.out.println("battle ended");
    }

    public void startBossBattle() {
        System.out.println("battle started");
        inBattle = true;

        while(inBattle) {
            
            playTurn(player, boss);

            if(!player.isAlive()) {
                inBattle = false;
                break;
            }

            if(!boss.isAlive()) {
                System.out.println("\n" + "A mighty evil has been vanquished!");
                inBattle = false;
                bossDefeated = true;
                break;
            }
        }
        System.out.println("battle ended");
    }

    // New Change: new method to factor in speed when in battle
    public void playTurn(Protagonist player, Monster monster) {
        int monsterSpd = monster.getSpd();
        int playerSpd = player.getSpd();
        int spdDifference;

        if (monster.getSpd() > playerSpd) {
            while ( (monster.getSpd() > playerSpd) && player.isAlive() ) {
                spdDifference = monster.getSpd() - playerSpd;
                monster.attack(player);
                monster.setSpd(spdDifference);
            }
            battleOptions(monster);

            monster.setSpd(monsterSpd);
        }

        if (player.getSpd() > monsterSpd) {
            while ( (player.getSpd() > monsterSpd) && monster.isAlive() ) {
                spdDifference = player.getSpd() - monsterSpd;
                
            }
            monster.attack(player);

            player.setSpd(playerSpd);
        }
        
    }

    // New Change: Added option to view inventory
    public void battleOptions(Monster monster) {
        System.out.println("\n" + "What will you do?");
        System.out.println("1: attack");
        System.out.println("2: View Inventory");
        
        int option = Integer.parseInt(scanner.nextLine());

        if (option == 1) {
            player.attack(monster);
        } else
        if (option == 2 ){
            System.out.println(player.getInventory());
        } else {
            battleOptions(monster);
        }
    }

    public static void main(String[] args) {
        Driver game = new Driver();
        game.startGame();
    }
}
