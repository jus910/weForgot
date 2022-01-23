public class Boss extends Monster {

    public Boss(int x, int y) {
        super(x, y);
        icon = "B";
        HP = (int)(Math.random() * 100) + 300;
        Atk = (int)(Math.random() * 25) + 100;
        Str = Math.random() + .5;
        Def = (int)(Math.random() * 25) + 75;
        Spd = (int)(Math.random() * 25) + 50;
    }

    public void attack(Fighter opponent) {

        if (!isAlive()) {
            return;
        }

        int damage = (int)(Atk * Str) - opponent.getDef();

        if (damage < 0) {
            damage = 0;
        }
        opponent.lowerHP(damage);
        System.out.println("The mighty Foo attacks for " +  damage + " damage");
    }

}
