package wrapper.dependancy;
import javax.swing.JFrame;
import java.awt.Color;
public interface MainFrameInterface{
    public static JFrame frame=new JFrame();
    public static void close(){
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){}
        frame.dispose();
    }
    public static void initialize(){
        //set frame size
        frame.setSize(500, 500);
        //set color to blue
        frame.getContentPane().setBackground(Color.BLUE);
        //desable layout manager
        frame.setLayout(null);
        //make it un-focusable because it is weird
        frame.setFocusable(false);
        //Make it exit on the tap of a close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //make it un resizable
        frame.setResizable(false);
        //centre it
        frame.setLocationRelativeTo(null);
    }
    public static void clear(){
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
        frame.setVisible(false);
    }
}
