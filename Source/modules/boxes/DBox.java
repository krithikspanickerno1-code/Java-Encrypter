package modules.boxes;
import java.util.ArrayList;
import modules.helpers.IO;
public class DBox{
    ArrayList<String> keys = new ArrayList<>();
    ArrayList<String> data = new ArrayList<>();
    IO helper1 = new IO();
    IO helper2 = new IO();
    public DBox(String path){
        helper1.read(path);
        data=helper1.getLines();
    }
    public void addKey(String key){
        keys.add(key);
    }
    public void flush(String dataPath, String keyPath){
        helper1.setLines(data);
        helper2.setLines(keys);
        helper1.write(dataPath);
        helper2.write(keyPath);
    }
    public void replace(String dataString, int dataLoc){
        data.set(dataLoc, dataString);
    }
    public String getData(int dataLoc){
        return data.get(dataLoc);
    }
    public int getSize(){
        return data.size();
    }
}
