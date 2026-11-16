import java.awt.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.lang.Exception;
import javax.swing.Timer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
 
/**
 * Beschreiben Sie hier die Klasse Spielverwaltung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public abstract class Spielverwaltung implements Netzwerk.Listener
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private boolean host;
    private Schiff [] schiffe = new Schiff[9];
    private Spieler spieler1,spieler2;
    private Spieler aktuellerSpieler;
    private boolean gesetzt;
    private boolean horizontal;
    
    private Netzwerk netzwerk1;
    private JFrame frame;
    private JLabel statusLabel;
    private boolean spielBeendet = false;
    

    /**
     * Konstruktor für Objekte der Klasse Spielverwaltung
     */
    public Spielverwaltung(boolean host)
    {
        this.host = host;
        /*schiffe[0]= new Schiff(2,0,0);
        schiffe[1]= new Schiff(2,0,0);
        schiffe[2]= new Schiff(2,0,0);
        schiffe[3]= new Schiff(2,0,0);
        schiffe[4]= new Schiff(3,0,0);
        schiffe[5]= new Schiff(3,0,0);
        schiffe[6]= new Schiff(3,0,0);
        schiffe[7]= new Schiff(4,0,0);
        schiffe[8]= new Schiff(4,0,0);
        schiffe[9]= new Schiff(5,0,0);
        
        spieler1 = new Spieler();
        spieler2 = new Spieler();
        aktuellerSpieler = spieler1;
        gesetzt = false;
        horizontal = false;*/
        SpielGUI gui = new SpielGUI();
    }

    public void spielerWechsel()
    {
        
        if (aktuellerSpieler == spieler1)
        {
            spieler1 = aktuellerSpieler;
            aktuellerSpieler = spieler2;
        } else
        {
            spieler2 = aktuellerSpieler;
            aktuellerSpieler = spieler1;
        }
    }
    
    public Spieler nichtAktuellerSpieler()
    {
        if (aktuellerSpieler == spieler1)
        {
            return spieler2;
        } else
        {
            return spieler1;
        }
    }
    
    public void schiffePlatzieren(int pPosX,int pPosY){
        int[] laengen = {2, 2, 2, 2, 3, 3, 3, 4, 4, 5};
        for (int i = 0; i < 9;i++){
            while(!gesetzt){
                int x = pPosX;
                int y = pPosY;
                if(horizontal){
                    int endeX = x + laengen[i];
                    int endeY = y;
                }else{
                    int endeY = y + laengen[i];
                    int endeX = x;
                }
                
                
            }
        
        }
    }
    public void verbinde(boolean alsHost, String ip, int port) {
        Thread thread = new Thread(() -> {
            try {
                netzwerk1 = new Netzwerk();
                netzwerk1.setListener(this);

                if (alsHost) {
                    setStatus("Warte auf den zweiten Spieler auf Port " + port + " ...");
                    netzwerk1.start(port);
                } else {
                    setStatus("Verbinde mit " + ip + ":" + port + " ...");
                    netzwerk1.client(ip, port);
                }
                setStatus("Verbunden. Warte auf Spielstart ...");
                netzwerk1.send("READY");
            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> {
                    setStatus("Verbindung fehlgeschlagen.");
                    JOptionPane.showMessageDialog(frame,
                        "Verbindung konnte nicht hergestellt werden:\n" +
                        e.getMessage(),
                        "Netzwerkfehler", JOptionPane.ERROR_MESSAGE);
                });
            }
        }, "Netzwerk-Verbindung");
        thread.setDaemon(true);
        thread.start();
    }
    private void setStatus(String text) {
        if (statusLabel != null) {
            SwingUtilities.invokeLater(() -> statusLabel.setText(text));
        }
    }
    @Override
    public void verbindungGeschlossen() {
        SwingUtilities.invokeLater(() -> {
            if (!spielBeendet) {
                setStatus("Netzwerkverbindung beendet.");
                JOptionPane.showMessageDialog(frame,
                    "Die Verbindung zum anderen Spieler wurde beendet.",
                    "Verbindung getrennt", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    @Override
    public void verbindungsfehler(Exception e) {
        SwingUtilities.invokeLater(() -> {
            if (!spielBeendet) {
                setStatus("Netzwerkfehler.");
                JOptionPane.showMessageDialog(frame,
                    "Netzwerkfehler:\n" + e.getMessage(),
                    "Netzwerkfehler", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
