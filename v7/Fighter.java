public class Fighter extends Character{
    protected int HP;
    protected int Atk;
    protected double Str;
    protected int Def;
    protected int Spd;

    // New inst vars
    protected int atkBuff;
    protected double strBuff;
    protected int defBuff;
    protected int spdBuff;

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
        return Atk + atkBuff;
    }

    public double getStr() {
        return Str + strBuff;
    }

    public int getDef() {
        return Def + defBuff;
    }

    public int getSpd() {
        return Spd + spdBuff;
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
    
    // New get methods
    public int getAtkBuff() {
        return atkBuff;
    }

    public double getStrBuff() {
        return strBuff;
    }

    public int getDefBuff() {
        return defBuff;
    }

    public int getSpdBuff() {
        return spdBuff;
    }
    // New set methods
    public void setAtkBuff(int Atk) {
        atkBuff = Atk;
    }

    public void setStrBuff(double Str) {
        strBuff = Str;
    }

    public void setDefBuff(int Def) {
        defBuff = Def;
    }

    public void setSpdBuff(int Spd) {
        spdBuff = Spd;
    }

    public void resetBuffs() {
        atkBuff = 0;
        strBuff = 0;
        defBuff = 0;
        spdBuff = 0;
    }
    
}
