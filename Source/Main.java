import wrapper.Default;
public class Main{
    public static void main(String[] args){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\uD83D\uDC4B");
        }));
        Default.display();
    }
}
