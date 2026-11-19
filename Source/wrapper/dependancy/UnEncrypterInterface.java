package wrapper.dependancy;
import wrapper.Caller;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class UnEncrypterInterface implements MainFrameInterface{
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
        JLabel labelForKeyFile=new JLabel("Enter path to the key file:");
        labelForKeyFile.setBounds(0, 0, 500, 20);
        labelForKeyFile.setOpaque(true);
        labelForKeyFile.setBackground(Color.GREEN);
        labelForKeyFile.setForeground(Color.BLUE);
        JTextField keyFile=new JTextField();
        keyFile.setBounds(0, 20, 500, 20);
        keyFile.setForeground(Color.BLUE);
        JButton buttonForKeyFile=new JButton("Submit Key");
        buttonForKeyFile.setBounds(0, 40, 150, 20);
        buttonForKeyFile.setFocusable(false);
        buttonForKeyFile.addActionListener((e) -> {
            Path path=Paths.get(keyFile.getText());
            if(!(Files.exists(path) && Files.isRegularFile(path) && Files.isReadable(path))){
                if(!Files.exists(path) || keyFile.getText().isEmpty()){
                    labelForKeyFile.setText("The file doesn't exist");
                }
                else if(!Files.isRegularFile(path)){
                    labelForKeyFile.setText("The path is not towards a file");
                }
                else if(!Files.isReadable(path)){
                    labelForKeyFile.setText("The file isn't readable");
                }
                labelForKeyFile.setBackground(Color.BLUE);
                labelForKeyFile.setForeground(Color.RED);
                frame.repaint();
                System.err.println("An error was triggered by section 1");
                isValid[0]=false;
            }
            else{
                labelForKeyFile.setText("Valid File!");
                labelForKeyFile.setBackground(Color.GREEN);
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
        JLabel labelForEncryptedDataFile=new JLabel("Enter path to the encrypted data:");
        labelForEncryptedDataFile.setBounds(0, 80, 500, 20);
        labelForEncryptedDataFile.setOpaque(true);
        labelForEncryptedDataFile.setBackground(Color.GREEN);
        labelForEncryptedDataFile.setForeground(Color.BLUE);
        JTextField encryptedDataFile=new JTextField();
        encryptedDataFile.setBounds(0, 100, 500, 20);
        encryptedDataFile.setForeground(Color.BLUE);
        JButton buttonForEncryptedDataFile=new JButton("Submit Data");
        buttonForEncryptedDataFile.setBounds(0, 120, 150, 20);
        buttonForEncryptedDataFile.setFocusable(false);
        buttonForEncryptedDataFile.addActionListener((e) -> {
            Path path=Paths.get(encryptedDataFile.getText());
            if(!(Files.exists(path) && Files.isRegularFile(path) && Files.isReadable(path))){
                if(!Files.exists(path) || encryptedDataFile.getText().isEmpty()){
                    labelForEncryptedDataFile.setText("The file doesn't exist");
                }
                else if(!Files.isRegularFile(path)){
                    labelForEncryptedDataFile.setText("The path is not towards a file");
                }
                else if(!Files.isReadable(path)){
                    labelForEncryptedDataFile.setText("The file isn't readable");
                }
                labelForEncryptedDataFile.setBackground(Color.BLUE);
                labelForEncryptedDataFile.setForeground(Color.RED);
                frame.repaint();
                System.err.println("An error was triggered by section 2");
                isValid[1]=false;
            }
            else{
                labelForEncryptedDataFile.setText("Valid File!");
                labelForEncryptedDataFile.setBackground(Color.GREEN);
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
        JLabel labelForOutputFile=new JLabel("new file where key file to be stored with full path:");
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
            if(!(Files.isWritable(path) && Files.exists(path) && Files.isDirectory(path) && !Files.isDirectory(path1))){
                if(!Files.exists(path) || !Files.isDirectory(path)){
                    labelForOutputFile.setText("The Location Doesn't Exist");
                }
                else if(Files.isDirectory(path1)){
                    labelForOutputFile.setText("Existing directory");
                }
                else if(!Files.isWritable(path)){
                    labelForOutputFile.setText("Un-Writable Location");
                }
                System.err.println("An error was triggered by section 3");
                isValid[2]=false;
                labelForOutputFile.setBackground(Color.BLUE);
                labelForOutputFile.setForeground(Color.RED);
            }
            else{
                labelForOutputFile.setText("Valid File!");
                labelForOutputFile.setBackground(Color.GREEN);
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
                String[] args={"-u", "-k"+responses[0], "-i"+responses[1], "-o"+responses[2]};
                progressText.setText("Un-encrypting Might Take A while...");
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
