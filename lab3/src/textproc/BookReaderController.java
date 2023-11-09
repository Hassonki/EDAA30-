package textproc;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Map;
import java.awt.BorderLayout;

import javax.swing.*;

public class BookReaderController {
    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
}
    private void createWindow(GeneralWordCounter counter, String title,
                                                int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();

        // pane är en behållarkomponent till vilken de övriga komponenterna (listvy, knappar etc.) ska läggas till.
        
        frame.setPreferredSize(new Dimension(800, 500)); //Ändra size på frame
        //D4
        SortedListModel<Map.Entry<String,Integer>> list = new SortedListModel<Map.Entry<String,Integer>>(counter.getWordList());
        
        //Skapar listview
        JList<Map.Entry<String,Integer>> listView = new JList<>(list);
        listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //markera endast ett ord
        
        //Scroll
        JScrollPane scroll = new JScrollPane(listView);
        scroll.setPreferredSize(new Dimension(200, 100));
        pane.add(scroll);

        //Button1
        JRadioButton frequency = new JRadioButton("Frequency");

        frequency.addActionListener((e)-> { //Lambda i en lamdba pga actionlistener har bara en abstrakt metod ,funktionellt interface
            list.sort((e1,e2) -> {
                if((e2).getValue().equals((e1).getValue())) { //kollar om antal är lika
                    return (e1).getKey().compareTo((e2).getKey()); //sortera efter bokstav
                }
                return ((e2).getValue() - (e1).getValue()); 
            });});
            //Måste göra om värdena från generisk till MapEntry

        //Button2
        JRadioButton alphabetic = new JRadioButton("Alphabetic");
        alphabetic.addActionListener((e)->{                    
            list.sort((e1,e2) -> (e1).getKey().compareTo((e2).getKey()));});

        //Sätts i en group för att endast kunna trycka på en knapp
        ButtonGroup group = new ButtonGroup();
            group.add(alphabetic);
            group.add(frequency);

        //Sökfält
        JButton find = new JButton("Find");
        JTextField textRuta = new JTextField(15);
        
         textRuta.addActionListener(e -> {
             wordSearch(textRuta,list,listView);
         });
            
        find.addActionListener((e)->{
            wordSearch(textRuta,list,listView);
        });

        JPanel panel = new JPanel();
        panel.add(alphabetic, BorderLayout.WEST);
        panel.add(frequency, BorderLayout.WEST);  
        panel.add(textRuta, BorderLayout.EAST);                             
        panel.add(find, BorderLayout.EAST);
        pane.add(panel,BorderLayout.SOUTH);   
        frame.pack();
        frame.setVisible(true);
       
    }
        private void wordSearch(JTextField textRuta, SortedListModel<Map.Entry<String,Integer>> list, JList<Map.Entry<String,Integer>> listView){
        String searchedWord = textRuta.getText().toLowerCase().replaceAll("\\s+",""); //Vad man vill räkna bort, vad man vill ersätta till
        
        boolean ordetfinns = false; //variabel för att kunna veta om ordet finns elr ej

        for (int i = 0; i < list.getSize(); i++) { //itererar genom orden i listan o kollar om == med sökta ordet
            String possibleWord = list.getElementAt(i).getKey();

            if (possibleWord.equals(searchedWord)) {
                listView.ensureIndexIsVisible(i); //Finns ordet i listan markeras det i vyn 
                listView.setSelectedIndex(i);
                ordetfinns = true;
                break;
                }
            }
            if(!ordetfinns){
            JOptionPane.showMessageDialog(null, "Ordet finns inte med", "ERROR", 1);
            }
    }
}


