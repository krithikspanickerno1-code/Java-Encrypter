package wrapper;
import software.Manifest;
public class Caller{
    public static void main(String[] args){
        Caller a = new Caller();
        if(args.length==0){
            System.out.println("-e for encrypt");
            System.out.println("-i to specify the data to encrypt");
            System.out.println("-k to specify place to store the key");
            System.out.println("-o to specify place to store the encrypted data");
            System.out.println("-u for un-encrypt");
            System.out.println("-i to specify the data to un-encrypt");
            System.out.println("-k to specify place to where the key is located");
            System.out.println("-o to specify place to store the un-encrypted data");
            System.out.println("there should be no spaces in the signifiers like between -k and the path to the key");
        }
        else{
            a.load(args);
        }
    }
    public void load(String[] args){
        if(args[0].equalsIgnoreCase("-u") && args.length==4){
            String[] hold = new String[3];
            if(args[1].startsWith("-i")){
                hold[0]=args[1].replaceFirst("-i", "");
            }
            else if(args[1].startsWith("-o")){
                hold[1]=args[1].replaceFirst("-o", "");
            }
            else if(args[1].startsWith("-k")){
                hold[2]=args[1].replaceFirst("-k", "");
            }
            if(args[2].startsWith("-i")){
                hold[0]=args[2].replaceFirst("-i", "");
            }
            else if(args[2].startsWith("-o")){
                hold[1]=args[2].replaceFirst("-o", "");
            }
            else if(args[2].startsWith("-k")){
                hold[2]=args[2].replaceFirst("-k", "");
            }
            if(args[3].startsWith("-i")){
                hold[0]=args[3].replaceFirst("-i", "");
            }
            else if(args[3].startsWith("-o")){
                hold[1]=args[3].replaceFirst("-o", "");
            }
            else if(args[3].startsWith("-k")){
                hold[2]=args[3].replaceFirst("-k", "");
            }
            for(int i=0 ; i<3 ; i++){
                if(hold[i]==null){
                    System.out.println("Invalid Option");
                    System.exit(1);
                }
            }
            Manifest work = new Manifest();
            work.eun(hold[1], hold[0], hold[2]);
        }
        else if(args[0].equalsIgnoreCase("-e") && args.length==5){
            String[] hold=new String[4];
            if(args[1].startsWith("-k")){
                hold[1]=args[1].replace("-k","");
            }
            else if(args[1].startsWith("-o")){
                hold[0]=args[1].replace("-o","");
            }
            else if(args[1].startsWith("-i")){
                hold[2]=args[1].replace("-i","");
            }
            else if(args[1].startsWith("-l")){
                hold[3]=args[1].replace("-l","");
                try{
                    Integer.parseInt(hold[3]);
                }
                catch(NumberFormatException e){
                    System.out.println("Invalid Argument");
                    System.exit(1);
                }
            }
            if(args[2].startsWith("-k")){
                hold[1]=args[2].replace("-k","");
            }
            else if(args[2].startsWith("-o")){
                hold[0]=args[2].replace("-o","");
            }
            else if(args[2].startsWith("-d")){
                hold[2]=args[2].replace("-d","");
            }
            else if(args[2].startsWith("-l")){
                hold[3]=args[2].replace("-l","");
                try{
                    Integer.parseInt(hold[3]);
                }
                catch(NumberFormatException e){
                    System.out.println("Invalid Argument");
                    System.exit(1);
                }
            }
            if(args[3].startsWith("-k")){
                hold[1]=args[3].replace("-k","");
            }
            else if(args[3].startsWith("-o")){
                hold[0]=args[3].replace("-o","");
            }
            else if(args[3].startsWith("-d")){
                hold[2]=args[3].replace("-d","");
            }
            else if(args[3].startsWith("-l")){
                hold[3]=args[3].replace("-l","");
                try{
                    Integer.parseInt(hold[3]);
                }
                catch(NumberFormatException e){
                    System.out.println("Invalid Argument");
                    System.exit(1);
                }
            }
            if(args[4].startsWith("-k")){
                hold[1]=args[4].replace("-k","");
            }
            else if(args[4].startsWith("-o")){
                hold[0]=args[4].replace("-o","");
            }
            else if(args[4].startsWith("-d")){
                hold[2]=args[4].replace("-d","");
            }
            else if(args[4].startsWith("-l")){
                hold[3]=args[4].replace("-l","");
                try{
                    Integer.parseInt(hold[3]);
                }
                catch(NumberFormatException e){
                    System.out.println("Invalid Argument");
                    System.exit(1);
                }
            }
            for(int i=0 ; i<4 ; i++){
                if(hold[i]==null){
                    System.out.println("Invalid Option");
                    System.exit(1);
                }
            }
            //output at 0 key at 1 data at 2 and level at 3
            Manifest work = new Manifest();
            work.en(hold[0], hold[1], hold[2], Integer.parseInt(hold[3]));
        }
        else{
            System.out.println("Invalid Arguments");
            System.exit(1);
        }
    }
}
