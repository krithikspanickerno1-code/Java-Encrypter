package wrapper.dependancy;
import wrapper.Caller;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class EncrypterInterface implements MainFrameInterface{
    boolean[] isValid={false, false, false};
    String[] responses=new String[4];
    public void encrypt(){
        MainFrameInterface.clear();
        inputFileInterface();
        keyStrengthInterface();
        keyFileInterface();
        EncryptedDataFileInterface();
        SubmitAllButton();
        frame.repaint();
        frame.setVisible(true);
    }
    public void inputFileInterface(){
        JTextField inputFile=new JTextField();
        inputFile.setBounds(0, 20, 500, 20);
        inputFile.setForeground(Color.BLUE);
        JLabel labelForInputFile=new JLabel("Enter the file to encrypt:");
        labelForInputFile.setBounds(0, 0, 500, 20);
        labelForInputFile.setOpaque(true);
        labelForInputFile.setBackground(Color.GREEN);
        labelForInputFile.setForeground(Color.BLUE);
        JButton buttonForInputFile=new JButton("Submit Input File");
        buttonForInputFile.setBounds(0, 40, 150, 20);
        buttonForInputFile.setFocusable(false);
        buttonForInputFile.addActionListener((e) -> {
            Path path=Paths.get(inputFile.getText()).toAbsolutePath();
            if(!(Files.exists(path) && Files.isRegularFile(path) && Files.isReadable(path))){
                if(!Files.exists(path)){
                    labelForInputFile.setText("File Doesn't Exist");
                }
                else if(!Files.isRegularFile(path)){
                    labelForInputFile.setText("It is not a file");
                }
                else if(!Files.isReadable(path)){
                    labelForInputFile.setText("File is un-readable");
                }
                labelForInputFile.setBackground(Color.BLUE);
                labelForInputFile.setForeground(Color.RED);
                System.err.println("An error was triggered by section 1");
                isValid[0]=false;
            }
            else{
                labelForInputFile.setText("Valid File!");
                labelForInputFile.setBackground(Color.GREEN);
                labelForInputFile.setForeground(Color.BLUE);
                isValid[0]=true;
                responses[0]=inputFile.getText();
            }
            frame.repaint();
        });
        frame.add(inputFile);
        frame.add(labelForInputFile);
        frame.add(buttonForInputFile);
    }
    public void keyStrengthInterface(){
        JTextField keyStrength=new JTextField();
        keyStrength.setForeground(Color.BLUE);
        keyStrength.setBounds(0, 100, 500, 20);
        JLabel labelForKeyStrength=new JLabel("Type a number, higher the better encryption but also make it slower");
        labelForKeyStrength.setBounds(0, 80, 500, 20);
        labelForKeyStrength.setBackground(Color.GREEN);
        labelForKeyStrength.setForeground(Color.BLUE);
        labelForKeyStrength.setOpaque(true);
        JButton buttonForKeyStrength=new JButton("Submit Key-Power");
        buttonForKeyStrength.setFocusable(false);
        buttonForKeyStrength.setBounds(0, 120, 150, 20);
        buttonForKeyStrength.addActionListener((e) -> {
            try{
                Integer.parseInt(keyStrength.getText());
                labelForKeyStrength.setText("Valid Option!");
                responses[1]=keyStrength.getText();
            }
            catch(NumberFormatException e1){
                labelForKeyStrength.setText("Default Option 1000 was chosen");
                System.err.println("Default Option Was Chosen");
                responses[1]="1000";
            }
            frame.repaint();
        });
        frame.add(keyStrength);
        frame.add(labelForKeyStrength);
        frame.add(buttonForKeyStrength);
    }
    public void keyFileInterface(){
        JTextField keyFile=new JTextField();
        keyFile.setForeground(Color.BLUE);
        keyFile.setBounds(0, 180, 500, 20);
        JLabel labelForKeyFile=new JLabel("new file where key file to be stored with full path:");
        labelForKeyFile.setForeground(Color.BLUE);
        labelForKeyFile.setBackground(Color.GREEN);
        labelForKeyFile.setBounds(0, 160, 500, 20);
        labelForKeyFile.setOpaque(true);
        JButton buttonForKeyFile=new JButton("Submit Path");
        buttonForKeyFile.setFocusable(false);
        buttonForKeyFile.setBounds(0, 200, 150, 20);
        buttonForKeyFile.addActionListener((e) -> {
            Path path=Paths.get(keyFile.getText()).toAbsolutePath().getParent();
            Path path1=Paths.get(keyFile.getText()).toAbsolutePath();
            if(!(Files.isWritable(path) && Files.exists(path) && Files.isDirectory(path) && !Files.isDirectory(path1))){
                if(!Files.exists(path) || !Files.isDirectory(path)){
                    labelForKeyFile.setText("The Location Doesn't Exist");
                }
                else if(Files.isDirectory(path1)){
                    labelForKeyFile.setText("Existing directory");
                }
                else if(!Files.isWritable(path)){
                    labelForKeyFile.setText("Un-Writable Location");
                }
                System.err.println("An error was triggered by section 3");
                isValid[1]=false;
                labelForKeyFile.setBackground(Color.BLUE);
                labelForKeyFile.setForeground(Color.RED);
            }
            else{
                labelForKeyFile.setText("Valid File!");
                labelForKeyFile.setBackground(Color.GREEN);
                labelForKeyFile.setForeground(Color.BLUE);
                isValid[1]=true;
                responses[2]=keyFile.getText();
            }
            frame.repaint();
        });
        frame.add(keyFile);
        frame.add(buttonForKeyFile);
        frame.add(labelForKeyFile);
    }
    public void EncryptedDataFileInterface(){
        JTextField encryptedDataFile=new JTextField();
        encryptedDataFile.setForeground(Color.BLUE);
        encryptedDataFile.setBounds(0, 260, 500, 20);
        JLabel labelForEncryptedDataFile=new JLabel("Enter the path to store encrypted data:");
        labelForEncryptedDataFile.setForeground(Color.BLUE);
        labelForEncryptedDataFile.setBackground(Color.GREEN);
        labelForEncryptedDataFile.setBounds(0, 240, 500, 20);
        labelForEncryptedDataFile.setOpaque(true);
        JButton buttonForEncryptedDataFile=new JButton("Submit Path");
        buttonForEncryptedDataFile.addActionListener((e) -> {
            Path path=Paths.get(encryptedDataFile.getText()).toAbsolutePath().getParent();
            Path path1=Paths.get(encryptedDataFile.getText()).toAbsolutePath();
            if(!(Files.isWritable(path) && Files.exists(path) && Files.isDirectory(path) && !Files.isDirectory(path1))){
                if(!Files.exists(path) || !Files.isDirectory(path)){
                    labelForEncryptedDataFile.setText("The Location Doesn't Exist");
                }
                else if(Files.isDirectory(path1)){
                    labelForEncryptedDataFile.setText("Existing directory");
                }
                else if(!Files.isWritable(path)){
                    labelForEncryptedDataFile.setText("Un-Writable Location");
                }
                System.err.println("An error was triggered by section 4");
                isValid[2]=false;
                labelForEncryptedDataFile.setOpaque(false);
                labelForEncryptedDataFile.setForeground(Color.RED);
            }
            else{
                labelForEncryptedDataFile.setText("Valid File!");
                labelForEncryptedDataFile.setOpaque(true);
                labelForEncryptedDataFile.setForeground(Color.BLUE);
                isValid[2]=true;
                responses[3]=encryptedDataFile.getText();
            }
            frame.repaint();
        });
        buttonForEncryptedDataFile.setFocusable(false);
        buttonForEncryptedDataFile.setBounds(0, 280, 150, 20);
        frame.add(labelForEncryptedDataFile);
        frame.add(encryptedDataFile);
        frame.add(buttonForEncryptedDataFile);
    }
    public void SubmitAllButton(){
        JLabel progressText=new JLabel("Encrypting Might Take A while...");
        progressText.setBounds(0, 402, 500, 20);
        progressText.setForeground(Color.BLUE);
        progressText.setBackground(Color.GREEN);
        progressText.setOpaque(true);
        JButton submitAll=new JButton("Start Encrypting");
        submitAll.addActionListener((e) -> {
            boolean Continue=true;
            for(boolean doer : isValid){
                if(doer==false){
                    Continue=doer;
                    break;
                }
            }
            if(!Continue){
                progressText.setText("The form isn't complete...");
                frame.add(progressText);
                frame.repaint();
            }
            else{
                String[] args={"-e", "-i"+responses[0], "-l"+responses[1], "-k"+responses[2], "-o"+responses[3]};
                progressText.setText("Encrypting Might Take A while...");
                frame.repaint();
                new Caller(args);
                progressText.setText("Completed!!! Closing in 5 seconds");
                frame.repaint();
                MainFrameInterface.close();
            }
        });
        submitAll.setFocusable(false);
        submitAll.setBounds(0, 422, 500, 50);
        frame.add(submitAll);
    }
}
