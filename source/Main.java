import wrapper.Default;
public static void main(String[] args){
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        System.out.println();
    }));
    Default.display(args);
}
