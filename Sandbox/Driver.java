import javax.swing.text.PlainDocument;

public class Driver {

    public static void main(String[] args) {
        /*
        Protag bob = new Protag();
        Cookie a = new Cookie();
        System.out.println(bob.getStats());
        bob.use(a);
        System.out.println(bob.getStats());
        */
        PlayerTile player = new PlayerTile(2, 1);
        Grid grid = new Grid(5, 3, player);

        System.out.println(grid);
        grid.move("a");
        System.out.println(grid);
        grid.move("w");
        System.out.println(grid);
    }
}
