public class Shopkeeper extends Character {
    
    public Shopkeeper(int x, int y) {
        super(x, y);
        icon = "$";
    }

    public void showShop() {
        String inventory = "";
        inventory += "====================" + "\n";
        inventory += "cookie       10 gold" + "\n";
        inventory += "pie          20 gold" + "\n";
        inventory += "crab         20 gold" + "\n";
        inventory += "steak        20 gold" + "\n";
        inventory += "spinach      30 gold" + "\n";
        System.out.println(inventory);
    }

    public void sell(Protagonist a, String input) {
        Item item;

        if (a.getItemCount() == a.getInvSize()) {
            System.out.println("Your inventory is full");
            return;
        }

        if (input.equals("cookie")) {
            if (a.getGold() >= 10) {
                item = new Cookie();
                a.obtainItem(item);
                a.addGold(-10);
                System.out.println("You bought a cookie" + "\n");
            } else {
                System.out.println("You don't have enough money" + "\n");
            }
        }

        if (input.equals("pie")) {
            if (a.getGold() >= 20) {
                item = new Pie();
                a.obtainItem(item);
                a.addGold(-20);
                System.out.println("You bought a pie" + "\n");
            } else {
                System.out.println("You don't have enough money" + "\n");
            }
        }

        if (input.equals("crab")) {
            if (a.getGold() >= 20) {
                item = new Crab();
                a.obtainItem(item);
                a.addGold(-20);
                System.out.println("You bought a cooked crab" + "\n");
            } else {
                System.out.println("You don't have enough money" + "\n");
            }
        }
        
        if (input.equals("steak")) {
            if (a.getGold() >= 20) {
                item = new Steak();
                a.obtainItem(item);
                a.addGold(-20);
                System.out.println("You bought a steak" + "\n");
            } else {
                System.out.println("You don't have enough money" + "\n");
            }
        }
        
        if (input.equals("spinach")) {
            if (a.getGold() >= 30) {
                item = new Spinach();
                a.obtainItem(item);
                a.addGold(-30);
                System.out.println("You bought a can of spinach" + "\n");
            } else {
                System.out.println("You don't have enough money" + "\n");
            }
        }
    }
}
