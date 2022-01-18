public class Grid {
    private Character[][] tiles;
    private int length;
    private int height;
    public Character player;
    public Character monster;

    public Grid(int x, int y) {
        length = x;
        height = y;
        tiles =  new Character[height][length];
        setupGrid();
    }

    public void setupGrid() {
        int spawnX = (int)(Math.random() * length);
        int spawnY = (int)(Math.random() * height);
        
        int spawnMobx = (int)(Math.random() * length);
        int spawnMoby = (int)(Math.random() * height);

        player = new Protagonist(spawnX, spawnY);
        setTile(player);
        
        monster = new Monster(spawnMobx,spawnMoby);
        setTile(monster);
    }

    public void setTile(Character c) {
        int x = c.getX();
        int y = c.getY();
        tiles[y][x] = c;
    }

    public void move(String wasd) {
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
            setTile(monster);
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

}
