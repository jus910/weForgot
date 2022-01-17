public class Tile {
    protected int _x;
    protected int _y;
    protected String icon = "-";

    public Tile(int xcor, int ycor) {
        _x = xcor;
        _y = ycor;
    }

    public String getIcon() {
        return icon;
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

}
