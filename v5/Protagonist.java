public class Protagonist extends Character implements Fighter {

    Item[] inventory;

    public Protagonist(int x, int y) {
        super(x, y);
        inventory = new Item[10];
        for(int i=0;i<10;i++){
            inventory[i]=new Item();
        }

        super.icon = "p";
        HP = 200;
        Atk = 20;
        Str = 1.0;
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
        System.out.println("You attack for " + damage + " damage");
    }

    public void lowerHP(int damage) {
        HP -= damage;
    }

    public void specialAttack(Fighter opponent) {

    }

    // New change Inventory methods
    public String getInventory() {
        String s="[";
        for(Item item: inventory){
            s+=item.getName()+" , ";
        }
        s=s.substring(0,s.length()-3);
        s+="]";
        return s;
      }

}
