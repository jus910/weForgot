public class Cookie extends Item{
  public Cookie(){
    super("cookie");
    }
  public int[] effect() {
      int[] i = {10, 0, 0, 0, 0};
      System.out.println("Item was used");
      return i;
  }
}
