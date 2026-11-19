package software.handlers;
import modules.boxes.UBox;
public class Uncrypter{
    String solData;
    UBox box;
    public Uncrypter(String solData, String dataPath, String keyPath){
        box = new UBox(keyPath, dataPath);
        this.solData=solData;
    }
    public void run(){
        String uncrypt="";
        for(int i=0 ; i<box.getSize() ; i++){
            String[] packet=box.getPacket(i);
            box.scramble(packet[0]);
            String[] parsed=packet[1].split("");
            for(int j=0 ; j<parsed.length ; j++){
                try{
                    if(parsed[j].equals("\u0000")){
                        uncrypt+=box.solve(parsed[++j]).toUpperCase();
                    }
                    else{
                        uncrypt+=box.solve(parsed[j]);
                    }
                }
                catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Nice try Buddy");
                }
            }
            box.replace(uncrypt, i);
            box.reset();
            uncrypt="";
        }
        box.flush(solData);
    }
}
