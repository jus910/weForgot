public class Cookie implements Item {
    boolean itemActive = false;

    public void effect(Fighter target) {
        target.setSpdBuff(target.getSpdBuff() + 10);
        System.out.println("You feel faster");
        System.out.println("Spd +10");
        System.out.println("current speed: " + target.getSpd());
    }

    public String getName() {
        String name = "cookie";
        return name;
    }

}
