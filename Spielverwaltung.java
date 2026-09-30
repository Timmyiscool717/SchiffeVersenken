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
public class Spielverwaltung 
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Schiff [] schiffe = new Schiff[4];
    private Spieler spieler1,spieler2;
    private Spieler aktuellerSpieler;
    private boolean gesetzt;
    

    /**
     * Konstruktor für Objekte der Klasse Spielverwaltung
     */
    public Spielverwaltung()
    {
        schiffe[0]= new Schiff(2,0,0);
        spieler1 = new Spieler(10);
        spieler2 = new Spieler(10);
        aktuellerSpieler = spieler1;
        gesetzt = false;
        
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public static void main(String[] args)
    {
        Spielverwaltung neuesSpiel = new Spielverwaltung();
        
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
    public Schiff gameOver(){
        if (getVersenkt() == true){
        
        }
    
    }
}
