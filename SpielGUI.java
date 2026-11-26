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
    private JPanel buttons = new JPanel();
    private JButton drehen, schiff2, schiff3, schiff4, schiff5 ;
    private Karte eigenerSpielplan = new Karte(this,false);
    private Karte gegnerSpielplan = new Karte(this,true);
    private JPanel gegnerSeite = new JPanel();
    
    private int anzahlSchiff2 = 4;
    private int anzahlSchiff3 = 3;
    private int anzahlSchiff4 = 2;
    private int anzahlSchiff5 = 1;
    //private BufferedImage spielbrettBild;
    //private ImageIcon spielbrettBild = new ImageIcon("beispiel_spielbrett_schiffeversenken.png");
    /**
     * Konstruktor für Objekte der Klasse SpielGUI
     */
    public SpielGUI()
    {
        fenster.add(hauptPanel);
        fenster.setTitle("Schiffe versenken");
        //fenster.setSize(1000, 900);
        fenster.setMinimumSize(new Dimension(1500, 1000));
        //fenster.setMinimumSize(new Dimension(900, 700));
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
        
        eigeneSeite.add(eigenerSpielplan,BorderLayout.CENTER);
        eigeneSeite.add(titelEigeneSeite, BorderLayout.NORTH);
        
        buttons.setLayout(new GridLayout(1,5,10,0));
        drehen = new JButton("Horizontal");
        drehen.addActionListener(e-> drehenKlick());
        buttons.add(drehen);
        schiff2 = new JButton("2er Schiff (4)");
        schiff2.addActionListener(e-> schiffLaengeKlick(2));
        buttons.add(schiff2);
        schiff3 = new JButton("3er Schiff (3)");
        schiff3.addActionListener(e-> schiffLaengeKlick(3));
        buttons.add(schiff3);
        schiff4 = new JButton("4er Schiff (2)");
        schiff4.addActionListener(e-> schiffLaengeKlick(4));
        buttons.add(schiff4);
        schiff5 = new JButton("5er Schiff (1)");
        schiff5.addActionListener(e-> schiffLaengeKlick(5));
        buttons.add(schiff5);
        eigeneSeite.add(buttons,BorderLayout.SOUTH);        
        
        gegnerSeite.setLayout(new BorderLayout(30,30));
        JLabel titelGegnerSeite = new JLabel("gegnerischer Spielplan", SwingConstants.CENTER);
        titelGegnerSeite.setFont(new Font("Arial", Font.BOLD, 25));
        
        gegnerSpielplan.klickbar(false);
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
        //Karte spielplan = new Karte();
        //hauptPanel.add(spielplan);
    }
    public void drehenKlick(){
        if((drehen.getText()).equals("Vertikal")){
            eigenerSpielplan.horizontal = true;
            drehen.setText("Horizontal");
        }else{
            eigenerSpielplan.horizontal = false;
            drehen.setText("Vertikal");
        }
        
    }
    public void schiffLaengeKlick(int pLaenge){
        eigenerSpielplan.schiffLaenge = pLaenge;
    }
    public void schiffPlatziert(int pSchiffLaenge){
        switch(pSchiffLaenge){
            case 2:
                anzahlSchiff2 = anzahlSchiff2 - 1;
                schiff2.setText("2er Schiff (" + anzahlSchiff2 + ")");
                if(anzahlSchiff2 < 1){
                    schiff2.setEnabled(false);
                    eigenerSpielplan.schiffLaenge = 0;
                }
                break;
            case 3:
                anzahlSchiff3 = anzahlSchiff3 - 1;
                schiff3.setText("3er Schiff (" + anzahlSchiff3 + ")");
                if(anzahlSchiff3 < 1){
                    schiff3.setEnabled(false);
                    eigenerSpielplan.schiffLaenge = 0;
                }
                break;
            case 4:
                anzahlSchiff4 = anzahlSchiff4 - 1;
                schiff4.setText("4er Schiff (" + anzahlSchiff4 + ")");
                if(anzahlSchiff4 < 1){
                    schiff4.setEnabled(false);
                    eigenerSpielplan.schiffLaenge = 0;
                }
                break;
            case 5:
                anzahlSchiff5 = anzahlSchiff5 - 1;
                schiff5.setText("5er Schiff (" + anzahlSchiff5 + ")");
                schiff5.setEnabled(false);
                eigenerSpielplan.schiffLaenge = 0;
                break;
        }
        if(anzahlSchiff2 == 0 && anzahlSchiff3 == 0 && anzahlSchiff4 == 0 && anzahlSchiff5 == 0){
            drehen.setText("Fertig");
            drehen.setEnabled(false);
            eigenerSpielplan.klickbar(false);
        }
    }
}
