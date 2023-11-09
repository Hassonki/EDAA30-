package game;

import javax.swing.JOptionPane;

public class UserInterface {

    
    /** Visar en dialogruta med texten msg. */
    public static void printMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }


    /**
     * Visar en dialogruta med texten msg och och läser in ett positivt heltal. Om
     * användaren skriver något som inte kan tolkas som ett positivt heltal ska -1
     * returneras. Om användaren klickar på "Avbryt" ska -2 returneras.
     */
    public static int askForInt(String msg) {

        //Input ruta kommer upp och inputet sparas i variabeln input som en sträng
        //Dvs .showInputDialog() metoden returnerar inputet efter att anvädnaren tryckt "OK"
        String input = JOptionPane.showInputDialog(null, msg);

        if (input == null) {
            System.exit(1);
            return -2;
        }

        try {
            return(Integer.parseInt(input));
        }

        catch(NumberFormatException ex) {
            return -1;
        }
    }
}