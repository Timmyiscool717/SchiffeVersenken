import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
/**
 * Beschreiben Sie hier die Klasse SpielGUI.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class SpielGUI extends JFrame
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private JFrame fenster = new JFrame();
    private JPanel hauptPanel = new JPanel();
    private JLabel spielbrettAnzeige;
    
    private BufferedImage spielbrettBild;
    /**
     * Konstruktor für Objekte der Klasse SpielGUI
     */
    public SpielGUI()
    {
        fenster.add(hauptPanel);
        fenster.setTitle("Schiffe versenken");
        fenster.setVisible(true);
        fenster.setSize(1000, 900);
        fenster.setMinimumSize(new Dimension(900, 700));
        fenster.setBackground(Color.BLUE);
        try{
            spielbrettBild = ImageIO.read(this.getClass().getResource("warrior.png"));
        }
        catch(IOException ex)
        {
            System.out.println ("Bilddatei nicht gefunden");
        }
        spielbrettAnzeige = new JLabel(new ImageIcon(spielbrettBild));
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void beispielMethode()
    {
        // tragen Sie hier den Code ein
        
    }
}
