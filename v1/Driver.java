import java.io.*;
import java.util.*;

public class Driver {
    private Scanner scanner;
    private Grid grid;
    private boolean inBattle;
    private Fighter[] turnOrder;

    public Driver() {
        scanner = new Scanner(System.in);
        grid = new Grid(10, 5);
        inBattle = false;
        turnOrder = new Fighter[10];
    }

    public void startGame() {
        enableGrid();
    }
    // enables the grid and starts fight
    public void enableGrid() {
        while (!inBattle) {
            System.out.println(grid);
            for(Monster monster : Grid.monsters){
              if((Grid.player).getX()==(monster).getX() && (Grid.player).getY()==(monster).getY()){
                inBattle=true;
                if(battleLost(monster)){
                  break;
                }
                inBattle=false;
              }
            }
            grid.move(scanner.nextLine());
        }
      System.out.println("You have become dead");
    }

    public void startBattle() {

      while (inBattle) {

      }
    }
// battle method, will take a monster as input, will return if the battle is lost
    public boolean battleLost(Monster monster){
      System.out.println("Oh noes a monster");
      while ((Grid.player).isAlive() && (monster).isAlive()){
        System.out.println("Do you want the sauce");
        if ((scanner.nextLine())=="yes"){
          (Grid.player).attack((monster));
          (monster).attack((Grid.player));
          System.out.println("Monster hit you, you hit monster");
        } else {
          (Grid.player).attack((monster));
          (monster).attack((Grid.player));
          System.out.println("Monster hit you, you hit monster");
        }
      }
      if((Grid.player).isAlive()){
        System.out.println("you win, now move off");
        return false;
      }
      return true;
    }

    public static void main(String[] args) {
        Driver game = new Driver();
        game.startGame();
    }
}
