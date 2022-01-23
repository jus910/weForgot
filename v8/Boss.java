public class Boss extends Monster {

    private boolean specialized;

    public Boss(int x, int y) {
        super(x, y);
        icon = "B";
        specialized = false;
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

        if(Math.random() < .3) {
            specialize();
        }
 
        int damage = (int)(Atk * Str) - opponent.getDef();

        if (specialized) {
            int[] playerStats = {opponent.getAtk(), opponent.getDef(), (int)(opponent.getStr() * 100), opponent.getSpd()};

            for(int i = 3; i > 0; i--) {
                if (playerStats[i] < playerStats[i - 1]) {
                    int currentVal = playerStats[i];
  	                int previousVal = playerStats[i - 1];

                    playerStats[i] = previousVal;
                    playerStats[i - 1] = currentVal;
                }
            }
            damage = (int)( (Atk * Str * 1.2) - playerStats[0]);
            specialized = false;
        }


        if (damage < 0) {
            damage = 0;
        }
        opponent.lowerHP(damage);
        System.out.println("The mighty Foo attacks for " +  damage + " damage");
    }

    public void specialize() {
        specialized = true;
        System.out.println("The mighty Foo performs a special attack");
    }

}
