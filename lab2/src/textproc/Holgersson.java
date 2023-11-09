package textproc;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		//D12
		long t0 = System.nanoTime();

		//D7
		Scanner scan = new Scanner(new File("/Users/hassanhussin/Documents/lth/experimental_vscode_workspace_v1/lab2/undantagsord.txt"));
		Set<String> stopWords = new HashSet<>();

		while(scan.hasNext()){
			String word = scan.next().toLowerCase();
			stopWords.add(word);
		}
		scan.close();

		ArrayList<TextProcessor> txtProccessList = new ArrayList<TextProcessor>();
		txtProccessList.add(new SingleWordCounter("nils"));
		txtProccessList.add(new SingleWordCounter("norge"));
		//txtProccessList.add(new MultiWordCounter(REGIONS));
		TextProcessor g = new GeneralWordCounter(stopWords);
        txtProccessList.add(g);  

		for (int i = 0; i < txtProccessList.size(); i++) { //iterera genom alla object i listan som ska anropa sina metoder
            Scanner s = new Scanner(new File("/Users/hassanhussin/Documents/lth/experimental_vscode_workspace_v1/lab2/nilsholg.txt"));
            s.findWithinHorizon("\uFEFF", 1);
            s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
            
            while (s.hasNext()) {
                String word = s.next().toLowerCase(); //scannar nästa ord och gör om till gemener

                txtProccessList.get(i).process(word); //iterera genom objekten för att processa vardera ord
            }
            s.close();
        }
		//System.out.println(g.getWordList().size());
		for (TextProcessor tp : txtProccessList) { //for each där varje textprocessor object ska reporta
            tp.report();
        }
		
		 // kod vars exekveringstid vi vill mäta
        long t1 = System.nanoTime();
        System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms"); //Median värde 1838.432329 ms HASHMAP
	} 																//Median värde 1909.08632 ms TREEMAP
}

		//TextProcessor nils = new SingleWordCounter("nils");
		//TextProcessor norge = new SingleWordCounter("Norge");

	/*Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning*/

		/*while (s.hasNext()) {
			String word = s.next().toLowerCase();

			nils.process(word);
			norge.process(word);
		}

		s.close();*/

		//nils.report();
		//norge.report();
	