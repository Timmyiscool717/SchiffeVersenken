import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

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
    
    //private BufferedImage spielbrettBild;
    private ImageIcon spielbrettBild = new ImageIcon("beispiel_spielbrett_schiffeversenken.webp");
    /**
     * Konstruktor für Objekte der Klasse SpielGUI
     */
    public SpielGUI()
    {
        fenster.add(hauptPanel);
        fenster.setTitle("Schiffe versenken");
        fenster.setSize(1000, 900);
        fenster.setMinimumSize(new Dimension(900, 700));
        fenster.setBackground(Color.BLUE);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        spielbrettAnzeige = new JLabel(spielbrettBild);
        fenster.add(spielbrettAnzeige);
        fenster.pack();
        fenster.setVisible(true);
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
