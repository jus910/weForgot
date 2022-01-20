public class Cookie implements Item {
    int turnCtr = 0;
    int turnLimit = 4;

    public void effect(Fighter target) {
        int i = 0;
        int baseSpd = target.getSpd();

        System.out.println(target + " feels faster");

        if (i < turnLimit) {
            target.setSpd(baseSpd + 10);
        } 

        System.out.println("current speed: " + target.getSpd());

        target.setSpd(baseSpd);
    }

    public String getName() {
        String name = "Cookie";
        return name;
    }

    public void advanceCtr() {
        turnCtr++;
    }
}
