public class Fighter extends Character{
    protected int HP;
    protected int Atk;
    protected double Str;
    protected int Def;
    protected int Spd;

    public Fighter(int x, int y) {
        super(x, y);
    }

    public boolean isAlive() {
        return HP > 0;
    }
    
    public String getStats() {
        return ( "\n" +
            "Fighter Stats" + "\n" +
            "============" + "\n" +
            "HP: " + getHP() + "\n" +
            "Atk: " + getAtk() + "\n" +
            "Str: " + getStr() + "\n" +
            "Def: " + getDef() + "\n" +
            "Spd: " + getSpd() + "\n" +
            "============"
        );
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

    public void attack(Fighter opponent) {
        int damage = (int)(Atk * Str) - opponent.getDef();
        opponent.lowerHP(damage);
        System.out.println("The Fighter attacks for " + damage + " damage");
    }

    public void lowerHP(int damage) {
        HP -= damage;
    }

    public void useItem(Item a, Fighter target) {
        a.effect(target);
    }

    public void translateBuffs(int[] a) {
        HP += a[0];
        Atk += a[1];
        Str += a[2];
        Def += a[3];
        Spd += a[4];
    }
}
