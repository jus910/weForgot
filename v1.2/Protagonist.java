public class Protagonist extends Character implements Fighter {

    Item[] inventory;

    public Protagonist(int x, int y) {
        super(x, y, "Traveler");
        inventory = new Item[10];
        super.icon = "p";
        HP = 200;
        Atk = 10;
        Str = 10;
        Def = 10;
        Spd = 10;
    }

    public void useItem(Item a) {
        translateBuffs(a.effect());
    }

    public void translateBuffs(int[] a) {
        HP += a[0];
        Atk += a[1];
        Str += a[2];
        Def += a[3];
        Spd += a[4];
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

}
