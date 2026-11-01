package software;
import software.handlers.*;
public class Manifest{
    Encrypter e;
    Uncrypter un;
    public void en(String dataPath, String keyPath, String sourcePath, int n){
        e=new Encrypter(dataPath, keyPath, sourcePath, n);
        e.run();
    }
    public void eun(String solData, String dataPath, String keyPath){
        un=new Uncrypter(solData, dataPath, keyPath);
        un.run();
    }
}
