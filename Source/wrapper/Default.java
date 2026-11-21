package wrapper;
import wrapper.dependancy.*;
import javax.swing.JButton;
public class Default implements MainFrameInterface{
    public static void display(){
        MainFrameInterface.initialize();
        //button 1
        JButton button=new JButton("Un-Encrypt");
        button.setBounds(205, 190, 105, 40);
        button.setFocusable(false);
        button.addActionListener((e)->{
            UnEncrypterInterface newInterface=new UnEncrypterInterface();
            newInterface.unencrypt();
        });
        //button 2
        JButton button2=new JButton("Encrypt");
        button2.setBounds(205, 225, 105, 40);
        button2.setFocusable(false);
        button2.addActionListener((e)->{
            EncrypterInterface newInterface=new EncrypterInterface();
            newInterface.encrypt();
        });
        //add the buttons
        frame.add(button);
        frame.add(button2);
        //make it visible
        frame.setVisible(true);
    }
}
