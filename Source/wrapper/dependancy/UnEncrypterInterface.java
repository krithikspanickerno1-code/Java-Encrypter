package wrapper.dependancy;
import java.awt.Font;
import wrapper.Caller;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.Timer;
public class UnEncrypterInterface implements MainFrameInterface{
    int limitCounter;
    boolean[] isValid={false, false, false};
    String[] responses=new String[3];
    public void unencrypt(){
        MainFrameInterface.clear();
        keyFileInterface();
        encryptedDataFileInterface();
        outputFileInterface();
        SubmitAllButton();
        frame.repaint();
        frame.setVisible(true);
    }
    public void keyFileInterface(){
        JLabel labelForKeyFile=new JLabel("Enter path to the KEY file:");
        labelForKeyFile.setBounds(0, 0, 500, 20);
        labelForKeyFile.setOpaque(true);
        labelForKeyFile.setBackground(Color.GREEN);
        labelForKeyFile.setForeground(Color.BLUE);
        JTextField keyFile=new JTextField();
        keyFile.setBounds(0, 20, 500, 20);
        keyFile.setForeground(Color.BLUE);
        Font font=keyFile.getFont();
        keyFile.setFont(font.deriveFont(Font.BOLD));
        JButton buttonForKeyFile=new JButton("Submit Key");
        buttonForKeyFile.setBounds(0, 40, 150, 20);
        buttonForKeyFile.setFocusable(false);
        buttonForKeyFile.addActionListener((e) -> {
            Path path=Paths.get(keyFile.getText()).toAbsolutePath();
            if(path==null || !(Files.exists(path) && Files.isRegularFile(path) && Files.isReadable(path))){
                if(path==null){
                    labelForKeyFile.setText("The path isn't towards a file");
                }
                else if(!Files.exists(path)){
                    labelForKeyFile.setText("The file doesn't exist");
                }
                else if(!Files.isRegularFile(path)){
                    labelForKeyFile.setText("The path is not towards a file");
                }
                else if(!Files.isReadable(path)){
                    labelForKeyFile.setText("The file isn't readable");
                }
                labelForKeyFile.setOpaque(false);
                labelForKeyFile.setForeground(Color.RED);
                frame.repaint();
                System.err.println("An error was triggered by section 1");
                isValid[0]=false;
            }
            else{
                labelForKeyFile.setText("Valid File!");
                labelForKeyFile.setOpaque(true);
                labelForKeyFile.setForeground(Color.BLUE);
                isValid[0]=true;
                responses[0]=keyFile.getText();
            }
        });
        frame.add(labelForKeyFile);
        frame.add(keyFile);
        frame.add(buttonForKeyFile);
    }
    public void encryptedDataFileInterface(){
        JLabel labelForEncryptedDataFile=new JLabel("Enter path to the ENCRYPTED DATA file:");
        labelForEncryptedDataFile.setBounds(0, 80, 500, 20);
        labelForEncryptedDataFile.setOpaque(true);
        labelForEncryptedDataFile.setBackground(Color.GREEN);
        labelForEncryptedDataFile.setForeground(Color.BLUE);
        JTextField encryptedDataFile=new JTextField();
        encryptedDataFile.setBounds(0, 100, 500, 20);
        encryptedDataFile.setForeground(Color.BLUE);
        Font font=encryptedDataFile.getFont();
        encryptedDataFile.setFont(font.deriveFont(Font.BOLD));
        JButton buttonForEncryptedDataFile=new JButton("Submit Data");
        buttonForEncryptedDataFile.setBounds(0, 120, 150, 20);
        buttonForEncryptedDataFile.setFocusable(false);
        buttonForEncryptedDataFile.addActionListener((e) -> {
            Path path=Paths.get(encryptedDataFile.getText()).toAbsolutePath();
            if(!(Files.exists(path) && Files.isRegularFile(path) && Files.isReadable(path))){
                if(!Files.exists(path)){
                    labelForEncryptedDataFile.setText("The file doesn't exist");
                }
                else if(!Files.isRegularFile(path)){
                    labelForEncryptedDataFile.setText("The path is not towards a file");
                }
                else if(!Files.isReadable(path)){
                    labelForEncryptedDataFile.setText("The file isn't readable");
                }
                labelForEncryptedDataFile.setOpaque(false);
                labelForEncryptedDataFile.setForeground(Color.RED);
                frame.repaint();
                System.err.println("An error was triggered by section 2");
                isValid[1]=false;
            }
            else{
                labelForEncryptedDataFile.setText("Valid File!");
                labelForEncryptedDataFile.setOpaque(true);
                labelForEncryptedDataFile.setForeground(Color.BLUE);
                isValid[1]=true;
                responses[1]=encryptedDataFile.getText();
            }
        });
        frame.add(labelForEncryptedDataFile);
        frame.add(encryptedDataFile);
        frame.add(buttonForEncryptedDataFile);
    }
    public void outputFileInterface(){
        JTextField outputFile=new JTextField();
        outputFile.setForeground(Color.BLUE);
        outputFile.setBounds(0, 180, 500, 20);
        Font font=outputFile.getFont();
        outputFile.setFont(font.deriveFont(Font.BOLD));
        JLabel labelForOutputFile=new JLabel("new file where UN-ENCRYPTED data file to be stored with full path:");
        labelForOutputFile.setForeground(Color.BLUE);
        labelForOutputFile.setBackground(Color.GREEN);
        labelForOutputFile.setBounds(0, 160, 500, 20);
        labelForOutputFile.setOpaque(true);
        JButton buttonForOutputFile=new JButton("Submit Path");
        buttonForOutputFile.setFocusable(false);
        buttonForOutputFile.setBounds(0, 200, 150, 20);
        buttonForOutputFile.addActionListener((e) -> {
            Path path=Paths.get(outputFile.getText()).toAbsolutePath().getParent();
            Path path1=Paths.get(outputFile.getText()).toAbsolutePath();
            if(path==null || !(Files.isWritable(path) && Files.exists(path) && Files.isDirectory(path) && !Files.isDirectory(path1))){
                if(path==null){
                    labelForOutputFile.setText("Un-Writable Location");
                }
                else if(!Files.exists(path) || !Files.isDirectory(path)){
                    labelForOutputFile.setText("The Location Doesn't Exist");
                }
                else if(Files.isDirectory(path1)){
                    labelForOutputFile.setText("Existing directory with same name detected");
                }
                else if(!Files.isWritable(path)){
                    labelForOutputFile.setText("Un-Writable Location");
                }
                System.err.println("An error was triggered by section 3");
                isValid[2]=false;
                labelForOutputFile.setOpaque(false);
                labelForOutputFile.setForeground(Color.RED);
            }
            else{
                labelForOutputFile.setText("Valid File!");
                labelForOutputFile.setOpaque(true);
                labelForOutputFile.setForeground(Color.BLUE);
                isValid[2]=true;
                responses[2]=outputFile.getText();
            }
            frame.repaint();
        });
        frame.add(outputFile);
        frame.add(buttonForOutputFile);
        frame.add(labelForOutputFile);
    }
    public void SubmitAllButton(){
        JLabel progressText=new JLabel("Click the button below to start Un-Encrypting");
        progressText.setBounds(0, 402, 500, 20);
        progressText.setForeground(Color.BLUE);
        progressText.setBackground(Color.GREEN);
        progressText.setOpaque(true);
        JButton submitAll=new JButton("Start Un-Encrypting");
        submitAll.addActionListener((e) -> {
            boolean Continue=true;
            for(boolean doer : isValid){
                if(doer==false){
                    Continue=false;
                    break;
                }
            }
            if(limitCounter==3){
                progressText.setText("limit reached cannot use 3 Un-encrypters at once");
            }
            if(!Continue){
                progressText.setText("The form isn't complete...");
                frame.add(progressText);
                frame.repaint();
            }
            else{
                String[] args={"-u", "-k"+responses[0], "-i"+responses[1], "-o"+responses[2]};
                limitCounter++;
                Thread thread=new Thread(() ->{
                    progressText.setText("Un-Encrypting might take a while");
                    try{
                        new Caller(args);
                        progressText.setText("Completed!!!");
                    }
                    catch(NumberFormatException e1){
                        progressText.setText("The keys didnt had numbers!!!");
                        System.err.println("The keys didnt had number");
                        isValid[0]=false;
                        isValid[1]=false;
                    }
                    Timer timer=new Timer(5000, (e0) -> progressText.setText("Click the button below to start Un-Encrypting"));
                    timer.start();
                    limitCounter--;
                });
                thread.start();
            }
        });
        frame.add(progressText);
        submitAll.setFocusable(false);
        submitAll.setBounds(0, 422, 500, 50);
        frame.add(submitAll);
    }
}
