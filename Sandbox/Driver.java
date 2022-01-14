public class Driver {
    public static void main(String[] args) {
        Protag bob = new Protag();
        Cookie a = new Cookie();
        System.out.println(bob.getStats());
        bob.use(a);
        System.out.println(bob.getStats());
    }
}
