public class Monster extends Character implements Fighter {
    
    public Monster(int x, int y) {
        super(x, y, "Monster");
        icon = "M";
        HP = 10;
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
