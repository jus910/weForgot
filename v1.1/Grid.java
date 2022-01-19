public class Grid {
    private Character[][] tiles;
    private int length;
    private int height;
    private Protagonist player;
    private Monster monster;

    public Grid(int x, int y) {
        length = x;
        height = y;
        tiles =  new Character[height][length];
        setupGrid();
    }

    public void setupGrid() {
        int spawnX = (int)(Math.random() * length);
        int spawnY = (int)(Math.random() * height);

        int mobX = (int)(Math.random() * length);
        int mobY = (int)(Math.random() * height);

        player = new Protagonist(spawnX, spawnY);
        monster = new Monster(mobX, mobY);
        
        setTile(player);
        setTile(monster);
    }

    public void setTile(Character c) {
        if (c.isAlive()) {
            int x = c.getX();
            int y = c.getY();
            tiles[y][x] = c;
        }
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
            setTile(monster);
            setTile(player);
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

    public Protagonist getPlayer() {
        return player;
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean sameCoords(Character a, Character b) {
        boolean sameX = (a.getX() == b.getX());
        boolean sameY = (a.getY() == b.getY());
        boolean bothAlive = (a.isAlive() && b.isAlive());

        if (sameX && sameY && bothAlive) {
            return true;
        } else return false;
    }

}
