public class Crab implements Item {
    boolean itemActive = false;

    public void effect(Fighter target) {
        target.setDefBuff(target.getDefBuff() + 10);
        System.out.println("You ate the crab and feel sturdier");
        System.out.println("Def +10");
        System.out.println("current def: " + target.getDef());
    }

    public String getName() {
        String name = "crab";
        return name;
    }
}
