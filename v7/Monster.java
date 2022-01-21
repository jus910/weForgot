public class Monster extends Fighter {

    public Monster(int x, int y) {
        super(x, y);
        icon = "M";
        HP = (int)(Math.random() * 50) + 50;
        Atk = (int)(Math.random() * 50) + 50;
        Str = Math.random() + .5;
        Def = (int)(Math.random() * 50) + 50;
        Spd = (int)(Math.random() * 25) + 25;
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
        System.out.println("The Monster attacks for " + damage + " damage");
    }

    public void specialAttack(Fighter opponent) {

    }

}
