package modules.helpers;
import java.util.Arrays;
import java.util.ArrayList;
public class assign{
    public ArrayList<ArrayList<String>> Assign(){
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        data.add(new assigners().numbers());
        data.add(new assigners().letters());
        data.add(new assigners().symbols());
        return data;
    }
    private class assigners{
        public ArrayList<String> numbers(){
            String[] numberList={"4","7","1","9","3","0","6","2","8","5"};
            ArrayList<String> numbers=new ArrayList<>(Arrays.asList(numberList));
            return numbers;
        }
        public ArrayList<String> letters(){
            String[] letterList={"y","p","m","f","w","v","z","b","l","o","j","a","x","r","d","s","c","t","e","g","k","h","q","n","u","i"};
            ArrayList<String> letters=new ArrayList<>(Arrays.asList(letterList));
            return letters;
        }
        public ArrayList<String> symbols(){
            String[] symbolsList = {"[",")","\"","\\",";","$","]","!","?","\t","@","~","^","%","-","{",":",",","+","}",".","_","`","=","(","<","/","&","#","|","'",">","*"};
            ArrayList<String> symbols=new ArrayList<>(Arrays.asList(symbolsList));
            return symbols;
        }
    }
}
