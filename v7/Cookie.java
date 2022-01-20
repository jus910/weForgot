public class Cookie implements Item {
    boolean itemActive = false;
    int turnCtr = 0;
    int turnLimit = 4;

    public void effect(Fighter target) {
        int i = 0;
        int baseSpd = target.getSpd();

        System.out.println("you feel faster");

        if (i < turnLimit) {
            target.setSpd(baseSpd + 10);
        } 

        System.out.println("current speed: " + target.getSpd());
    }

    public String getName() {
        String name = "cookie";
        return name;
    }

    public void advanceCtr() {
        turnCtr++;
    }

}
