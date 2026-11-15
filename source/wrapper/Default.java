package wrapper;
import java.util.Scanner;
public class Default{
    public static void display(String[] args){
        if(args.length==4 || args.length==5){
            Caller worker = new Caller();
            worker.load(args);
        }
        else{
            Scanner input=new Scanner(System.in);
            System.out.print("Enter (e) to encrypt or (u) to un-encrypt: ");
            String ress=input.nextLine();
            if(ress.isEmpty()){
                System.exit(0);
            }
            else if(ress.charAt(0)=='u'){
                optionU(input);
            }
            else if(ress.charAt(0)=='e'){
                optionE(input);
            }
            else{
                System.exit(0);
            }
        }
    }
    public static void optionU(Scanner input){
        String[] args=new String[4];
        args[0]="-u";
        System.out.print("Enter the file to un-encrypt: ");
        args[1]="-i"+input.nextLine();
        System.out.print("Enter the path to the key: ");
        args[2]="-k"+input.nextLine();
        System.out.print("Enter the file to store un-encrypted data(can be a non-existing file): ");
        args[3]="-o"+input.nextLine();
        try{
            Caller worker = new Caller();
            worker.load(args);
        }
        catch(NumberFormatException e){
            System.err.print("Are you sure your key is not fake");
        }
        catch(Exception e){
            System.err.print("Something Unexpected happened");
        }
        input.close();
    }
    public static void optionE(Scanner input){
        String[] args=new String[5];
        args[0]="-e";
        System.out.print("Enter the file to encrypt: ");
        args[1]="-i"+input.nextLine();
        System.out.print("Enter the path to store the keys (can be a non-existing file): ");
        args[2]="-k"+input.nextLine();
        System.out.print("Enter the path to store the encrypted data (can be a non-existing file): ");
        args[3]="-o"+input.nextLine();
        System.out.print("Enter the strength of the encryption: ");
        args[4]=input.nextLine();
        if(isNumber(args[4])){
            args[4]="-l"+args[4];
        }
        else{
            System.out.println("Using Default Value 1000");
            args[4]="-l1000";
        }
        try{
            Caller worker = new Caller();
            worker.load(args);
        }
        catch(Exception e){
            System.err.print("Something Unexpected happened");
        }
        input.close();
    }
    public static boolean isNumber(String n){
        try{
            Integer.parseInt(n);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
