package software.handlers;
import modules.boxes.DBox;
import modules.boxes.EBox;
public class Encrypter{
    DBox box0;
    EBox box1;
    String dataPath;
    String keyPath;
    public Encrypter(String dataPath, String keyPath, String sourcePath, int level){
        box0 = new DBox(sourcePath);
        box1=new EBox(level);
        this.keyPath=keyPath;
        this.dataPath=dataPath;
    }
    public void run(){
        String encrypt="";
        for(int i=0 ; i<box0.getSize() ; i++){
            String[] parsed;
            box1.jumble();
            parsed=box0.getData(i).split("");
            for(int j=0 ; j<parsed.length ; j++){
                encrypt+=box1.search(parsed[j]);
            }
            box0.replace(encrypt, i);
            box0.addKey(box1.getPass());
            box1.reset();
            encrypt="";
        }
        box0.flush(dataPath, keyPath);
    }
}
