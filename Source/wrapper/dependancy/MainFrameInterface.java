package wrapper.dependancy;
import javax.swing.JFrame;
import java.awt.Color;
public interface MainFrameInterface{
    public static JFrame frame=new JFrame("Encrypter/Decrypter");
    public static void initialize(){
        //set frame size
        frame.setSize(500, 500);
        //centre it
        frame.setLocationRelativeTo(null);
        //make layout manager absolute
        frame.setLayout(null);
        //set color to blue
        frame.getContentPane().setBackground(Color.BLUE);
        //make it un-focusable because it is weird
        frame.setFocusable(false);
        //make it un resizable
        frame.setResizable(false);
        //Make it exit on the tap of a close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void clear(){
        frame.setVisible(false);
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }
}
