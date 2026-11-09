import java.awt.*;
import java.awt.Graphics.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
/**
 * Beschreiben Sie hier die Klasse Karte.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Karte extends JPanel
{
    
    
    /**
     * Konstruktor für Objekte der Klasse Karte
     */
    public Karte()
    {
        
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(400,400));
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int w = getWidth()/10;
        int h = getHeight()/10;
        g.setColor(Color.BLACK);
        for(int y = 0; y < 10; y++){
            for(int x = 0; x < 10; x++){
                g.drawRect(x*w,y*h,w,h);
            }
        }
        
    }
}
