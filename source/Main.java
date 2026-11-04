import wrapper.Default;
public static void main(String[] args){
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        System.out.println();
    }));
    Default.display(args);
    System.out.print("\uD83D\uDC4B");
}
