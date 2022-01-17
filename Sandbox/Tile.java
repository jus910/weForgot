public class Tile {
    protected int _x;
    protected int _y;
    protected String _icon;

    public Tile(int xcor, int ycor) {
        _x = xcor;
        _y = ycor;
        _icon = "-";
    }

    public String getIcon() {
        return _icon;
    }

    public void setIcon(String icon) {
        _icon = icon;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public void setX(int x) {
        _x = x;
    }

    public void setY(int y) {
        _y = y;
    }

    public String toString() {
        String output = "";
        output += _icon + ": ";
        output += "(" + _x + ", ";
        output += _y + ")";
        return output;
    }

}
