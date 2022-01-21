public class Monster extends Fighter {

    public Monster(int x, int y) {
        super(x, y);
        icon = "M";
        HP = (int)(Math.random() * ((100 - 50) + 1)) + 50;
        Atk = (int)(Math.random() * ((100 - 50) + 1)) + 50;
        Str = (int)(Math.random() * ((2 - 1) + 1));
        Def = (int)(Math.random() * ((100 - 50) + 1)) + 50;
        Spd = (int)(Math.random() * ((50 - 25) + 1)) + 25;
    }

    public void attack(Fighter opponent) {
      int damage = (int)(Atk * Str) - opponent.getDef();
      opponent.lowerHP(damage);
      System.out.println("The Monster attacks for " + damage + " damage");
    }

    public void specialAttack(Fighter opponent) {

    }

}
