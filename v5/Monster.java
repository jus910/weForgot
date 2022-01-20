public class Monster extends Character implements Fighter {

    public Monster(int x, int y) {
        super(x, y);
        icon = "M";
        HP = 10;
        Atk = 10;
        Str = 1.0;
        Def = 10;
        Spd = 25;
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
      System.out.println("The Monster attacks for " + damage + " damage");
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
