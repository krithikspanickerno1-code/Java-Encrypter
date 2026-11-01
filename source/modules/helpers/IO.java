package modules.helpers;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
public class IO{
    ArrayList<String> lines;
    public void read(String path){
        String line;
        lines = new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(path))){
            while((line=reader.readLine())!=null){
                lines.add(line);
            }
        }
        catch(FileNotFoundException e){
            if(!Files.isReadable(Paths.get(path))){
                System.out.println("The File Does not or no longer exist");
            }
            else{
                System.out.println("The File is unreadable");
            }
        }
        catch(IOException e){
            System.out.println("The Program can't do anything to read(Unexpected Error)");
        }
    }
    public ArrayList<String> getLines(){
        return lines;
    }
    public void write(String path){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path), 200_000)){
            for(int i=0 ; i<lines.size() ; i++){
                writer.write(lines.get(i)+"\n");
            }
        }
        catch(FileNotFoundException e){
            Path pAth = Paths.get(path);
            if(!Files.exists(pAth.getParent())){
                System.out.println("Location Doesn't exist");
            }
            else if(Files.isDirectory(pAth)){
                System.out.println("The Path is A folder");
            }
            else if(!Files.isWritable(pAth.getParent())){
                System.out.println("File Is Unwritable");
            }
            else{
                System.out.println("The File is Busy");
            }
        }
        catch(IOException e){
            System.out.println("The Program can't do anything to write(Unexpected Error)");
        }
    }
    public void setLines(ArrayList<String> lines){
        this.lines=lines;
    }
}
