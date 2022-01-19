public class Grid {
    private static Character[][] tiles;
    private static int length;
    private static int height;
    public static Protagonist player;
    public static int monsterSize = 2;
    public static Monster[] monsters = new Monster[monsterSize];
    public Grid(int x, int y) {
        length = x;
        height = y;
        tiles =  new Character[height][length];
        setupGrid();
    }

    public static void setupGrid() {
        int spawnX;
        int spawnY;
        Monster foo;

// For some reason we cannot use a for each loop to initialize everything
        for(int i = 0; i<monsterSize;i++){
          spawnX = (int)(Math.random() * length);
          spawnY = (int)(Math.random() * height);
          monsters[i] = new Monster(spawnX,spawnY);
          setTile(monsters[i]);
        }
        spawnX = (int)(Math.random() * length);
        spawnY = (int)(Math.random() * height);

        player = new Protagonist(spawnX, spawnY);
        setTile(player);
    }

    public static void setTile(Character c) {
      if (c.isAlive()) {
        int x = c.getX();
        int y = c.getY();
        tiles[y][x] = c;
      }
    }

    public static void move(String wasd) {
        int x = player.getX();
        int y = player.getY();

        if (wasd.equals("w") && (y < height - 1)) {
            player.setY(y + 1);
        } else
        if (wasd.equals("a") && (x > 0)) {
            player.setX(x - 1);
        } else
        if (wasd.equals("s") && (y > 0)) {
            player.setY(y - 1);
        } else
        if (wasd.equals("d") && (x < length - 1)) {
            player.setX(x + 1);
        }

        if ( (player.getX() != x) || (player.getY() != y) ) {
            // if the coordinates of _player are different from what they were before moving, then set its location again
            tiles = new Character[height][length];
            setTile(player);
            for(Monster monster : monsters){
              setTile(monster);
            }
        }
    }

    public String toString() {
        String output = addRow(1);

        for(int y = height - 1; y >= 0; y--) {
            output += addColumn(y);
            output += addRow(y);
        }
        return output;
    }

    public String addRow(int y) {
        String output = "+";

        for(int x = 0; x < length; x++) {
            output += "---+";
        }
        output += "\n";
        return output;
    }

    public String addColumn(int y) {
        String output = "|";

        for(int x = 0; x < length; x++) {
            if (tiles[y][x] instanceof Character) {
                output += " " + tiles[y][x].getIcon() + " |";
            } else {
                output += "   |";
            }
        }
        output += "\n";
        return output;
    }

    public static void remove(Monster monster) {
      tiles[monster.getY()][monster.getX()]=null;
    }

    public Protagonist getPlayer() {
        return player;
    }

}
