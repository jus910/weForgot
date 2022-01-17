public class Grid {
    Tile[][] _tiles;
    Tile _player;
    int _length;
    int _height;

    public Grid(int length, int height) {
        _tiles =  new Tile[height][length];
        
        int spawnX = (int)(Math.random() * length);
        int spawnY = (int)(Math.random() * height);
        _player = new PlayerTile(spawnX, spawnY);

        _length = length;
        _height = height;
        
        fillGrid();
        setTile(_player);
    }

    public void fillGrid() {
        for (int y = 0; y < _height; y++) {
            for (int x = 0; x < _length; x++) {
                _tiles[y][x] = new Tile(x, y);
            }
        }
    }

    public void setTile(Tile tile) {
        _tiles[tile.getY()][tile.getX()] = tile;
    }

    public void setTile(Tile tile, int x, int y) {
        _tiles[y][x] = tile;
    }

    public void move(String wasd) {
        int x = _player.getX();
        int y = _player.getY();
        Tile explored = new ExploredTile(x, y);

        if (wasd.equals("w") && (y < _height - 1)) {
            _player.setY(y + 1);
        } else
        if (wasd.equals("a") && (x > 0)) {
            _player.setX(x - 1);
        } else
        if (wasd.equals("s") && (y > 0)) {
            _player.setY(y - 1);
        } else
        if (wasd.equals("d") && (x < _length - 1)) {
            _player.setX(x + 1);
        }

        if ( (_player.getX() != x) || (_player.getY() != y) ) {
            setTile(_player);
            setTile(explored, x, y);
        }
    }

    public String toString() {
        String output = addRow(1);

        for(int y = _height - 1; y >= 0; y--) {
            output += addColumn(y);
            output += addRow(y);
        }
        return output;
    }

    public String addRow(int y) {
        String output = "+";
        
        for(int x = 0; x < _length; x++) {
            output += "---+";
        }
        output += "\n";
        return output;
    }

    public String addColumn(int y) {
        String output = "|";
        
        for(int x = 0; x < _length; x++) {
            if (_tiles[y][x] instanceof Tile) {
                output += " " + _tiles[y][x].getIcon() + " |";
            } else {
                output += "   |";
            }
        }
        output += "\n";
        return output;
    }

}
