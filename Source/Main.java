import wrapper.Default;
public class Main{
    public static void main(String[] args){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\uD83D\uDC4B");
        }));
        try{
            Default.display();
        }
        catch(Exception e){
            System.err.println("Something happened I don't care");
        }
    }
}
