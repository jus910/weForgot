public class Protag {
    private int _HP = 10;
    private int _Atk = 10;
    private int _Str = 10;
    private int _Def = 10;
    private int _Spd = 10;

    public void use(Item a) {
        translateBuffs(a.effect());
    }

    public void translateBuffs(String a) {
        int start = 0;
        int stop = 0;
        String read = "";
        int[] statBoosts = new int[5];

        for(int i = 0; i < 5; i++) {
            start = a.indexOf(":", start + 1);
            stop = a.indexOf(".", stop + 1);
            read = a.substring(start + 1, stop);
            statBoosts[i] = Integer.parseInt(read);

            if(stop == a.length()-1) {
                break;
            }
        }
        _HP += statBoosts[0];
        _Atk += statBoosts[1];
        _Str += statBoosts[2];
        _Def += statBoosts[3];
        _Spd += statBoosts[4];
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