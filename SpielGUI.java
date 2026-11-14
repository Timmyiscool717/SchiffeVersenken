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
    //private JLabel spielbrettAnzeige;
    private JPanel eigeneSeite = new JPanel();
    private JPanel gegnerSeite = new JPanel();
    //private BufferedImage spielbrettBild;
    //private ImageIcon spielbrettBild = new ImageIcon("beispiel_spielbrett_schiffeversenken.png");
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
        
        /**spielbrettAnzeige = new JLabel(spielbrettBild);
        fenster.add(spielbrettAnzeige);
        fenster.pack();**/
        fenster.setVisible(true);
        
        hauptPanel.setLayout(new GridLayout(1,2,30,0));
        hauptPanel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        
        eigeneSeite.setLayout(new BorderLayout(30,30));
        JLabel titelEigeneSeite = new JLabel("eigener Spielplan", SwingConstants.CENTER);
        titelEigeneSeite.setFont(new Font("Arial", Font.BOLD, 25));
        Karte eigenerSpielplan = new Karte();
        eigeneSeite.add(eigenerSpielplan,BorderLayout.CENTER);
        eigeneSeite.add(titelEigeneSeite, BorderLayout.NORTH);
        
        gegnerSeite.setLayout(new BorderLayout(30,30));
        JLabel titelGegnerSeite = new JLabel("gegnerischer Spielplan", SwingConstants.CENTER);
        titelGegnerSeite.setFont(new Font("Arial", Font.BOLD, 25));
        Karte gegnerSpielplan = new Karte();
        gegnerSeite.add(gegnerSpielplan,BorderLayout.CENTER);
        gegnerSeite.add(titelGegnerSeite, BorderLayout.NORTH);
        
        hauptPanel.add(eigeneSeite);
        hauptPanel.add(gegnerSeite);
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void beispielMethode()
    {
        Karte spielplan = new Karte();
        hauptPanel.add(spielplan);
    }
}
