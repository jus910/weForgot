public class Spinach implements Item {
    boolean itemActive = false;

    public void effect(Fighter target) {
        target.setStrBuff(target.getStrBuff() + .25);
        System.out.println("You ate the spinach and felt invigorated.");
        System.out.println("Str +0.25");
        System.out.println("current strength: " + target.getStr());
    }

    public String getName() {
        String name = "spinach";
        return name;
    }

}
