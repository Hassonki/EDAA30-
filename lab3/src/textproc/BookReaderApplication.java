package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class BookReaderApplication {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<TextProcessor> txtProccessList = new ArrayList<TextProcessor>();
        Scanner scan = new Scanner(new File("undantagsord.txt"));
        Set<String> stopWords = new TreeSet<>();
        

        while(scan.hasNext()){
			String word = scan.next().toLowerCase();
			stopWords.add(word);
		}
        scan.close();

        GeneralWordCounter wordCount = new GeneralWordCounter(stopWords);

        
        txtProccessList.add(wordCount);
        
        for (int i = 0; i < txtProccessList.size(); i++) { //iterera genom alla object i listan som ska anropa sina metoder
            Scanner s = new Scanner(new File("nilsholg.txt"));
            s.findWithinHorizon("\uFEFF", 1);
            s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
            
            while (s.hasNext()) {
                String word = s.next().toLowerCase(); //scannar nästa ord och gör om till gemener

                txtProccessList.get(i).process(word); //iterera genom objekten för att processa vardera ord
            }

            s.close();
        }
        

     BookReaderController controller = new BookReaderController(wordCount);
    }
}
