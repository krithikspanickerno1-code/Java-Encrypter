package modules.boxes;
import java.util.ArrayList;

import modules.helpers.IO;
import modules.helpers.assign;
public class UBox{
    ArrayList<String> keys = new ArrayList<>();
    ArrayList<String> data = new ArrayList<>();
    ArrayList<ArrayList<String>> box = new ArrayList<>();
    ArrayList<ArrayList<String>> original = new ArrayList<>();
    IO helper1 = new IO();
    IO helper2 = new IO();
    public void reset(){
        assign Assign = new assign();
        box=Assign.Assign();
        original=Assign.Assign();
    }
    public UBox(String keyPath, String dataPath){
        helper1.read(keyPath);
        helper2.read(dataPath);
        keys=helper1.getLines();
        data=helper2.getLines();
        reset();
    }
    public String[] getPacket(int i){
        String[] packet={keys.get(i), data.get(i)};
        return packet;
    }
    public void scramble(String args){
        String[] pins=args.split(" ");
        String tmp1;
        String tmp2;
        int j=0;
        int[] locs = new int[4];
        for(int i=0 ; i<pins.length/4 ; i++){
            locs[0]=Integer.parseInt(pins[j++]);
            locs[1]=Integer.parseInt(pins[j++]);
            locs[2]=Integer.parseInt(pins[j++]);
            locs[3]=Integer.parseInt(pins[j++]);

            tmp1=box.get(locs[0]).get(locs[1]);
            tmp2=box.get(locs[2]).get(locs[3]);

            box.get(locs[0]).set(locs[1], tmp2);
            box.get(locs[2]).set(locs[3], tmp1);
        }
    }
    public String solve(String Char){
        int[] indexList = new int[3];
        String returnable;
        indexList[0]=box.get(0).indexOf(Char);
        indexList[1]=box.get(1).indexOf(Char);
        indexList[2]=box.get(2).indexOf(Char);
        if(indexList[0]!=-1){returnable=original.get(0).get(indexList[0]);}
        else if(indexList[1]!=-1){returnable=original.get(1).get(indexList[1]);}
        else if(indexList[2]!=-1){returnable=original.get(2).get(indexList[2]);}
        else{return Char;}
        return returnable;
    }
    public int getSize(){
        return data.size();
    }
    public void flush(String path){
        helper1.setLines(data);
        helper1.write(path);
    }
    public void replace(String dataString, int dataLoc){
        data.set(dataLoc, dataString);
    }
}
