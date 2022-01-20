public class Character {
    protected int HP;
    protected int Atk;
    protected double Str;
    protected int Def;
    protected int Spd;

    protected int xcor;
    protected int ycor;
    protected String icon;

    public Character(int x, int y) {
        xcor = x;
        ycor = y;
        icon = "c";
    }

    public String getStats() {
        return ( "\n" +
            "Player Stats" + "\n" +
            "============" + "\n" +
            "HP: " + getHP() + "\n" +
            "Atk: " + getAtk() + "\n" +
            "Str: " + getStr() + "\n" +
            "Def: " + getDef() + "\n" +
            "Spd: " + getSpd() + "\n" +
            "============"
        );
    }

    public boolean isAlive() {
        return HP > 0;
    }

    public int getHP() {
        return HP;
    }

    public int getAtk() {
        return Atk;
    }

    public double getStr() {
        return Str;
    }

    public int getDef() {
        return Def;
    }

    public int getSpd() {
        return Spd;
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

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setAtk(int Atk) {
        this.Atk = Atk;
    }

    public void setStr(double Str) {
        this.Str = Str;
    }

    public void setDef(int Def) {
        this.Def = Def;
    }

    public void setSpd(int Spd) {
        this.Spd = Spd;
    }

}
