import java.io.*;
import java.util.*;

public class Driver {
    private Scanner scanner;
    private Grid grid;
    private boolean inBattle;
    private boolean bossDefeated;
    private Protagonist player;

    public Driver() {
        scanner = new Scanner(System.in);
        grid = new Grid(10, 5);
        inBattle = false;
        player = grid.getPlayer();
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
            for(Monster monster : Grid.monsters){
              	if(grid.sameCoords(player, monster) ){
                   inBattle=true;
                   startBattle(monster);
                   break;
               }
                inBattle=false;
             	}
               System.out.println(grid);
               grid.move(scanner.nextLine());
            }
            
        }
 
    public void startBattle(Monster monster) {
        System.out.println("battle started");
        inBattle = true;

        while(inBattle) {
            
            playTurn(player, monster);

            if(!player.isAlive()) {
                System.out.println("\n" + "You died!");
                inBattle = false;
                break;
            }

            if(!monster.isAlive()) {
                System.out.println("\n" + "You won!");
                inBattle = false;
                break;
            }
        }
        System.out.println("battle ended");
    }

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

    public void battleOptions(Monster monster) {
        System.out.println("\n" + "What will you do?");
        System.out.println("1: attack");
        
        int option = Integer.parseInt(scanner.nextLine());

        if (option == 1) {
            player.attack(monster);
        } else {
            battleOptions(monster);
        }

    }

    public static void main(String[] args) {
        Driver game = new Driver();
        game.startGame();
    }
}
