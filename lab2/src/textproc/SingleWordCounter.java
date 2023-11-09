package textproc;

public class SingleWordCounter implements TextProcessor {
	private String word;
	private int n;

	public SingleWordCounter(String word) { //Konstruktor
		this.word = word;
		n = 0;
	}

	public void process(String w) { //Anropas när ett ord lästs in. Metoden ska uppdatera statistiken därefter.
		if (w.equals(word)) {
			n++;
		}
	}
	
	 /* Anropas när samtliga ord i sekvensen lästs in. Metoden ska skriva ut
	  en sammanställning av statistiken.*/
	public void report() {
		System.out.println(word + ": " + n);
	}

}
