public class Boss extends Character implements Fighter {

    public Boss(int x, int y) {
        super(x, y, "Boss");
        icon = "B";
        HP = 100;
        Atk = 10;
        Str = 10;
        Def = 10;
        Spd = 10;
    }

    public void useItem(Item a) {
        translateBuffs(a.effect());
    }

    public void translateBuffs(int[] a) {
        HP -= a[0];
        Atk -= a[1];
        Str -= a[2];
        Def -= a[3];
        Spd -= a[4];
    }

    public void attack(Fighter opponent) {
      int damage = (int)(Atk * Str) - opponent.getDef();
      opponent.lowerHP(damage);
    }

    public void lowerHP(int damage) {
        HP -= damage;
    }
    public void specialAttack(Fighter opponent) {

    }
    public boolean isAlive() {
        return (HP > 0);
    }

}
