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
    
    private JButton[][] spielfeld = new JButton[10][10]; 
    /**
     * Konstruktor für Objekte der Klasse Karte
     */
    public Karte()
    {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(400,400));
        setLayout(new GridLayout(10, 10));
        for(int y=0;y< 10; y++){
            for(int x = 0; x < 10; x++){
                spielfeld[x][y] = new JButton(); 
                spielfeld[x][y].setBackground(Color.BLUE);
                spielfeld[x][y].setForeground(Color.RED);
                spielfeld[x][y].setOpaque(true);
                final int posX = x;
                final int posY = y;
                spielfeld[x][y].setVisible(true);
                spielfeld[x][y].addActionListener(e-> spielfeldKlick(posX,posY));
                this.add(spielfeld[x][y]);
            }
        }
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void spielfeldKlick(int pPosX, int pPosY){
        System.out.println("Button" + pPosX + "|" + pPosY);
        spielfeld[pPosX][pPosY].setEnabled(false);
    }
    public void klickbar(boolean pKlickbar){
        boolean klickbar = pKlickbar;
        for(int y = 0; y < spielfeld[0].length ; y ++){
            for(int x = 0 ; x < spielfeld.length; x++){
                if(klickbar){
                    spielfeld[x][y].setEnabled(true);
                }else{
                    spielfeld[x][y].setEnabled(false);
                }
            }
        }
    }
}
