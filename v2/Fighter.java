public interface Fighter {

    public void attack(Fighter opponent);

    public void lowerHP(int damage);

    public void specialAttack(Fighter opponent);

    public boolean isAlive();

    public void useItem(Item item);

    public void translateBuffs(int[] a);

    public String getStats();

    public int getHP();

    public int getAtk();

    public double getStr();

    public int getDef();

    public int getSpd();

}
