package textproc;

import java.util.*;


public class GeneralWordCounter implements TextProcessor {
    private Map<String,Integer> map;
    private Set<String> undantagsord;

    
    public GeneralWordCounter(Set<String> s){
        undantagsord = s;
        map = new TreeMap<>();
    }


    public void process(String w) { //Anropas när ett ord lästs in. Metoden ska uppdatera statistiken därefter.
        boolean undantagsordfinns = false;
        if(undantagsord.contains(w)){
            undantagsordfinns = true;
        }
        // for(String s : undantagsord){
        //     if(s.equals(w)){
        //         undantagsordfinns = true;
        //         break;
        //     }
        //  }

        if(map.containsKey(w) & !undantagsordfinns){
            map.put(w , map.get(w)+1); 
        }else{
            map.put(w , 1); 
        }
	}
	
	 /* Anropas när samtliga ord i sekvensen lästs in. Metoden ska skriva ut
	  en sammanställning av statistiken.*/
	public void report() {
        Set<Map.Entry<String, Integer>> wordSet = map.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);

        wordList.sort((v1,v2) -> {
            if(v1.getValue().equals(v2.getValue())){ //autoboxing då det är ett integer objekt och autoboxas till int och drf kan == funka
                return v1.getKey().compareTo(v2.getKey()); //return v1.getKey().charAt(0) - v2.getKey().charAt(0); funkar oxå
            }
            return v2.getValue() - v1.getValue();
        });

        for(int i = 0; i<15; i++){
            System.out.println(wordList.get(i));
        }
    }
        public List<Map.Entry<String, Integer>> getWordList() {
            List<Map.Entry<String, Integer>> list = new ArrayList<>();

            // Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();

            // while(itr.hasNext()){
            //     list.add(itr.next());
            // }
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                list.add(entry);
                
            }
            return list;
        }
    
}

        // for(String key : map.keySet()){
        //     if(map.get(key) >=200){
        //     System.out.println(key + ": " + map.get(key));
        //     }
        // }
	