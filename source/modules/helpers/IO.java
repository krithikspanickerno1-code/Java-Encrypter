package modules.helpers;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.AccessDeniedException;
import java.nio.file.NoSuchFileException;
import java.io.IOException;
public class IO{
    ArrayList<String> lines = new ArrayList<>();
    public void read(String path){
        Path p=Paths.get(path);
        try{
            if(Files.isDirectory(p)){
                System.out.println("The file is a directory");
            }
            else{
                lines=new ArrayList<>(Files.readAllLines(p));
            }
        }
        catch(NoSuchFileException e){
            System.out.println("The file does not exist");
        }
        catch(AccessDeniedException e){
            System.out.println("Cannot read the file");
        }
        catch(IOException e){
            System.out.println("An Unexpected Error occured");
        }
    }
    public void write(String path){
        Path p=Paths.get(path);
        try{
            if(Files.isDirectory(p)){
                System.out.println("The file is a directory");
            }
            else{
                Files.write(p, lines);
            }
        }
        catch(NoSuchFileException e){
            System.out.println("File does not exist");
        }
        catch(AccessDeniedException e){
            System.out.println("Cannot read the file to location");
        }
        catch(IOException e){
            System.out.println("An Unexpected Error occured");
        }
    }
    public ArrayList<String> getLines(){
        return lines;
    }
    public void setLines(ArrayList<String> lines){
        this.lines=lines;
    }
}
