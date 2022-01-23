public class Pie implements Item {
    boolean itemActive = false;

    public void effect(Fighter target) {
        target.setHP(target.getHP() + 50);
        System.out.println("You ate the pie and felt better");
        System.out.println("HP +50");
        System.out.println("current HP: " + target.getHP());
    }

    public String getName() {
        String name = "pie";
        return name;
    }
}
