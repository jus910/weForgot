public class Steak implements Item {
    boolean itemActive = false;

    public void effect(Fighter target) {
        target.setSpdBuff(target.getAtkBuff() + 10);
        System.out.println("You ate the steak and felt stronger");
        System.out.println("Atk +10");
        System.out.println("current attack: " + target.getAtk());
    }

    public String getName() {
        String name = "steak";
        return name;
    }

}
