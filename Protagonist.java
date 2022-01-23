public class Protagonist extends Fighter {

    protected Item[] inventory;
    protected int inventorySize = 10;
    protected int itemCount;
    protected int gold;
    protected boolean specialized;

    public Protagonist(int x, int y) {
        super(x, y);
        inventory = new Item[inventorySize];
        gold = 0;
        specialized = false;

        icon = "p";
        HP = 250;
        Atk = 125;
        Str = 1;
        Def = 40;
        Spd = 40;
    }

    public void attack(Fighter opponent) {

        if (!isAlive()) {
            return;
        }

        int atk = Atk + atkBuff;
        double str = Str + strBuff;
        
        int damage = (int)( (atk * str) - opponent.getDef());

        if (specialized) {
            damage = damage * 3;
            specialized = false;
        }

        if (damage < 0) {
            damage = 0;
        }
        
        opponent.lowerHP(damage);
        System.out.println("You attack for " + damage + " damage");
    }

    public void specialize() {
        specialized = true;
        System.out.println("You prepare a special move");
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
                s+="___, ";
            }
        }
        s=s.substring(0,s.length()-2);
        s+="]";
        return s;
    }
      
    public void obtainItem(Item item) {
    	int i=0;
    	while (inventory[i] instanceof Item){
    		i++;
    	}
    	inventory[i]=item;
        itemCount++;
    }

    public void removeItem(int i) {
        inventory[i] = null;
        itemCount--;
    }

    public void addGold(int g) {
        gold += g;
    }

    public int getGold() {
        return gold;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getInvSize() {
        return inventorySize;
    }

    public boolean isSpecialized() {
        return specialized;
    }

}
