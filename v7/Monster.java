public class Monster extends Fighter {

    public Monster(int x, int y) {
        super(x, y);
        icon = "M";
        HP = 10;
        Atk = 10;
        Str = 1.0;
        Def = 10;
        Spd = 25;
    }

    public void attack(Fighter opponent) {
      int damage = (int)(Atk * Str) - opponent.getDef();
      opponent.lowerHP(damage);
      System.out.println("The Monster attacks for " + damage + " damage");
    }

    public void specialAttack(Fighter opponent) {

    }

}
