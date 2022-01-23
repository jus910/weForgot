public class Character {

    protected int xcor;
    protected int ycor;
    protected String icon;

    public Character(int x, int y) {
        xcor = x;
        ycor = y;
        icon = "c";
    }

    public boolean isAlive() {
        return true;
    }

    public int getX() {
        return xcor;
    }

    public int getY() {
        return ycor;
    }

    public String getIcon() {
        return icon;
    }

    public void setX(int x) {
        xcor = x;
    }

    public void setY(int y) {
        ycor = y;
    }

}
