package textproc;
import java.util.*;
//import java.util.HashMap;

public class MultiWordCounter implements TextProcessor{
    private Map<String,Integer> map;

    public MultiWordCounter(String[] words){
        map = new TreeMap<String, Integer>();

        for(String s : words){
            map.put(s,0);
        }
    }


    public void process(String w) { //Anropas när ett ord lästs in. Metoden ska uppdatera statistiken därefter.
        if(map.containsKey(w)){
           map.put(w , map.get(w)+1); 
        }
	}
	
	 /* Anropas när samtliga ord i sekvensen lästs in. Metoden ska skriva ut
	  en sammanställning av statistiken.*/
	public void report() {
        for(String key : map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }
	}
    
}
