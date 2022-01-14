public class Protag {
    private int _HP = 10;
    private int _Atk = 10;
    private int _Str = 10;
    private int _Def = 10;
    private int _Spd = 10;

    public void use(Item a) {
        translateBuffs(a.effect());
    }

    public void translateBuffs(int[] a) {
        _HP += a[0];
        _Atk += a[1];
        _Str += a[2];
        _Def += a[3];
        _Spd += a[4];
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

    public int getHP() {
        return _HP;
    }

    public int getAtk() {
        return _Atk;
    }

    public int getStr() {
        return _Str;
    }

    public int getDef() {
        return _Def;
    }

    public int getSpd() {
        return _Spd;
    }
}