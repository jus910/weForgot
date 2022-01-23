import java.io.*;
import java.util.*;

public class Woo {
    private static final String CLEAR_SCREEN =  "\033[2J";
    private Scanner scanner;
    private Grid grid;
    private boolean inBattle;
    private boolean bossDefeated;
    private int monstersDestroyed;
    private Protagonist player;
    private Boss boss;
    // New instance variables
    private Shopkeeper shopkeeper;
    private boolean inShop;

    public Woo() {
        scanner = new Scanner(System.in);
        grid = new Grid(10, 5);
        inBattle = false;
        inShop = false;
        player = Grid.player;
        boss = Grid.boss;
        shopkeeper = Grid.shopkeeper;
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
        System.out.println("<<grid enabled>>");

        while (!inBattle) {
            for(Monster monster : Grid.monsters){
              	if(grid.sameCoords(player, monster) ) {
                    inBattle=true;
                    startBattle(monster);
                    break;
                }
                inBattle=false;
            }

            // New shopkeeper tile
            if (grid.sameCoords(player, shopkeeper) ) {
                System.out.println("Welcome to my shop");
                inShop = true;
                startShopping();
            }

            // new change, must kill all monsters for boss to appear
            if (monstersDestroyed==Grid.monsterSize) {
                System.out.println("You have angered a great foe");
                if (!Grid.bossActive) {
                    Grid.bossActive = true;
                    Grid.setTile(boss);
                }
            }

            if (grid.sameCoords(player, boss) && Grid.bossActive){
                System.out.println("You are now in the court of the Foo King");
                inBattle=true;
                startBattle(boss);
            }

            if (!player.isAlive() || bossDefeated) {
                return;
            }
            System.out.println(CLEAR_SCREEN);
            System.out.println(grid);
            grid.move(scanner.nextLine());
        }
    }

    // New Change: startBattle now uses playTurn, which does speed calculations
    public void startBattle(Monster monster) {
        System.out.println("<<battle started>>");
        inBattle = true;

        while(inBattle) {

            playTurn(player, monster);

            if(!player.isAlive()) {
                inBattle = false;
                break;
            }

            if( (monster instanceof Boss) && !monster.isAlive() ) {
                bossDefeated = true;
                break;
            }

            if(!monster.isAlive()) {
                System.out.println("\n" + "You won!");
                inBattle = false;
                monstersDestroyed++;
                // Get gold after winning
                int gold = (int)(Math.random() * 25) + 25;
                player.addGold(gold);
                System.out.println("You got " + gold + " gold");
                break;
            }
        }
        player.resetBuffs();
        System.out.println("<<battle ended>>");
        wait(2000);
    }

    // New Change: new method to factor in speed when in battle
    public void playTurn(Protagonist player, Monster monster) {
        int monsterSpd = monster.getSpd();
        int playerSpd = player.getSpd();
        int spdDifference;

        if (monster.getSpd() >= playerSpd) {
            while ( (monster.getSpd() >= playerSpd) && player.isAlive() ) {
                spdDifference = monster.getSpd() - playerSpd;
                monster.attack(player);
                wait(1000);

                System.out.println("\n" + "Your HP: " + player.getHP());
                System.out.println("Enemy HP: " + monster.getHP() + "\n");

                monster.setSpd(spdDifference);
            }
            battleOptions(monster);
            wait(1000);
            monster.setSpd(monsterSpd);
        }

        if (player.getSpd() > monsterSpd) {
            while ( (player.getSpd() > monsterSpd) && monster.isAlive() ) {
                spdDifference = player.getSpd() - monsterSpd;
                battleOptions(monster);
                wait(1000);
                player.setSpd(spdDifference);
            }
            monster.attack(player);

            if (monster.isAlive()) {
                wait(1000);
                System.out.println("\n" + "Your HP: " + player.getHP());
                System.out.println("Enemy HP: " + monster.getHP() + "\n");
            }

            player.setSpd(playerSpd);
        }

    }

    // New Change: Added option to view inventory
    public void battleOptions(Monster monster) {
        if (player.isAlive()) {
            System.out.println("\n" + "What will you do?");
            System.out.println("=================");

            if (player.isSpecialized()) {
                System.out.println("1: special attack");
            } else {
                System.out.println("1: attack");
            }

            System.out.println("2: view inventory");
            System.out.println("3: special move" + "\n");

            int option = Integer.parseInt(scanner.nextLine());

            if (option == 1) {

                player.attack(monster);

            } else
            if (option == 2){
                System.out.println(player.getInventory());
                System.out.println("Which item?");
                player.useItem(scanner.nextLine(), player);
                battleOptions(monster);

            } else
            if (option == 3) {
                player.specialize();

            } else {
                battleOptions(monster);
            }
        }
    }

    public void startShopping() {
        shopkeeper.showShop();
        System.out.println("What would you like to buy?");
        System.out.println("Current balance: " + player.getGold());
        System.out.println("<<type exit to leave>>" + "\n");
        String i = scanner.nextLine();

        if(i.equals("exit")) {
            inShop = false;
        }

        if (inShop) {
            shopkeeper.sell(player, i);
            startShopping();
        }
    }

    private static void wait(int millis) {
    try {
      Thread.sleep(millis);
    	}
    catch (InterruptedException e) {
    	}
    }

    public static void main(String[] args) {
        Woo game = new Woo();
        game.startGame();
    }
}
