public class Grid {
    Tile[][] _tiles;
    Tile _player;
    int _length;
    int _height;

    public Grid(int length, int height, PlayerTile player) {
        _tiles =  new Tile[height][length];
        _player = player;
        _length = length;
        _height = height;
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                _tiles[y][x] = new Tile(x, y);
            }
        }
        setTile(player);
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

        if (wasd.equals("w")) {
            _player.setY(_player.getY() + 1);
        } else
        if (wasd.equals("a")) {
            _player.setX(_player.getX() - 1);
        } else
        if (wasd.equals("s")) {
            _player.setY(_player.getY() - 1);
        } else
        if (wasd.equals("d")) {
            _player.setX(_player.getX() + 1);
        }

        setTile(_player);
        setTile(explored, x, y);
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
