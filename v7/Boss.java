public class Boss extends Monster {

    public Boss(int x, int y) {
        super(x, y);
        icon = "B";
        HP = 100;
        Atk = 10;
        Str = 10;
        Def = 10;
        Spd = 11;
    }

    public void attack(Fighter opponent) {
      int damage = (int)(Atk * Str) - opponent.getDef();
      opponent.lowerHP(damage);
      System.out.println("The mighty Foo attacks for " +  damage + " damage");
    }

}
