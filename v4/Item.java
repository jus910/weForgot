public class Item {
    protected String Name;
    public Item(){
      Name="";
    }
    public Item(String name){
      Name=name;
    }
    public int[] effect() {
        int[] i = {0, 0, 0, 0, 0};
        System.out.println("Item was used");
        return i;
    }

    public String getName(){
      return Name;
    }
}
