public class Protagonist extends Fighter {

    Item[] inventory;

    public Protagonist(int x, int y) {
        super(x, y);
        inventory = new Item[10];

        icon = "p";
        HP = 200;
        Atk = 20;
        Str = 100;
        Def = 10;
        Spd = 10;
    }

    public void attack(Fighter opponent) {
        int damage = (int)(Atk * Str) - opponent.getDef();
        opponent.lowerHP(damage);
        System.out.println("You attack for " + damage + " damage");
    }

    public void specialAttack(Fighter opponent) {

    }

    // New: useItem now removes item from inventory on use
    public void useItem(String a, Fighter target) {
        String input = a.toLowerCase();

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] instanceof Item) {
                String item = inventory[i].getName();

                if (item.equals(input)) {
                    inventory[i].effect(target);
                    removeItem(i);
                    return;
                } 
            }
        }
        System.out.println("You don't have that item");
    }

    // New change Inventory methods
    public String getInventory() {
        String s="[";
        for(Item item: inventory){
            if (item instanceof Item) {
                s+=item.getName()+", ";
            } else {
                s+="   ";
            }
        }
        s=s.substring(0,s.length()-3);
        s+="]";
        return s;
    }
      
    public void obtainItem(Item item) {
    	int i=0;
    	while (inventory[i] instanceof Item){
    		i++;
    	}
    	inventory[i]=item;
    }

    // New: remove item from inventory
    public void removeItem(int i) {
        inventory[i] = null;
    }
}
