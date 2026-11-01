package modules.boxes;
import java.util.ArrayList;
import java.util.Random;

import modules.helpers.assign;
public class EBox{
    int securityLevel=1000;
    String password="";
    ArrayList<ArrayList<String>> box=new ArrayList<>();
    ArrayList<ArrayList<String>> original=new ArrayList<>();
    public EBox(int securityLevel){
        this.securityLevel=securityLevel;
        reset();
    }
    public void reset(){
        assign Assign = new assign();
        box=Assign.Assign();
        original=Assign.Assign();
    }
    public void jumble(){
        password="";
        Random random=new Random();
        int[] target = {0,0,0,0};
        String tmp1;
        String tmp2;
        for(int i=0 ; i<securityLevel ; i++){
            target[0]=random.nextInt(0, 3);
            target[2]=random.nextInt(0, 3);

            target[1]=(target[0]==0) ? random.nextInt(0, 10):target[1];
            target[1]=(target[0]==1) ? random.nextInt(0, 26):target[1];
            target[1]=(target[0]==2) ? random.nextInt(0, 33):target[1];

            target[3]=(target[2]==0) ? random.nextInt(0, 10):target[3];
            target[3]=(target[2]==1) ? random.nextInt(0, 26):target[3];
            target[3]=(target[2]==2) ? random.nextInt(0, 33):target[3];

            tmp1=box.get(target[0]).get(target[1]);
            tmp2=box.get(target[2]).get(target[3]);

            box.get(target[0]).set(target[1], tmp2);
            box.get(target[2]).set(target[3], tmp1);
            password+=(String.valueOf(target[0])+" "+String.valueOf(target[1])+" "+String.valueOf(target[2])+" "+String.valueOf(target[3])+" ");
        }
    }
    public String search(String Char){
        int[] indexList = new int[3];
        String returnable;
        String addable="";
        if(!Char.isEmpty() && Character.isUpperCase(Char.charAt(0))){
            Char=Char.toLowerCase();
            addable="\u0000";
        }
        indexList[0]=original.get(0).indexOf(Char);
        indexList[1]=original.get(1).indexOf(Char);
        indexList[2]=original.get(2).indexOf(Char);
        if(indexList[0]!=-1){returnable=box.get(0).get(indexList[0]);}
        else if(indexList[1]!=-1){returnable=box.get(1).get(indexList[1]);}
        else if(indexList[2]!=-1){returnable=box.get(2).get(indexList[2]);}
        else{return Char;}
        return addable+returnable;
    }
    public String getPass(){
        return password;
    }
}
