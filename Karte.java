import java.awt.*;
import java.awt.Graphics.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.event.*;

/**
 * Beschreiben Sie hier die Klasse Karte.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Karte extends JPanel
{
    private boolean horizontal = true;
    private JButton[][] spielfeld = new JButton[10][10]; 
    private int schiffLaenge = 5;
    private char[][] schiffFeld = new char[10][10]; 
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
                spielfeld[x][y].setBackground(Color.WHITE);
                //spielfeld[x][y].setForeground(Color.RED);
                spielfeld[x][y].setOpaque(true);
                final int posX = x;
                final int posY = y;
                spielfeld[x][y].setVisible(true);
                spielfeld[x][y].addActionListener(e-> spielfeldKlick(posX,posY));
                
                spielfeld[x][y].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    System.out.println("Betrete Button" + posX + "|" + posY);
                    ImageIcon schiff = new ImageIcon("Schiffteile/M.V.Schiff.png");
                    final int x = posX;
                    final int y = posY;
                    if(horizontal && x+schiffLaenge-1 <= 9){
                        if(feldEnabled(x,y,schiffLaenge, horizontal)){
                            for(int i = 0; i < schiffLaenge; i++){
                                if(i == 0){
                                    schiff = new ImageIcon("Schiffteile/H.R.Schiff.png");
                                }else if(i == schiffLaenge - 1){
                                    schiff = new ImageIcon("Schiffteile/V.R.Schiff.png");
                                }else{
                                    schiff = new ImageIcon("Schiffteile/M.V.Schiff.png");
                                }
                                spielfeld[x+i][y].setIcon(schiff);
                            }
                        }
                    }
                    if(!horizontal && y+schiffLaenge-1 <= 9){
                        if(feldEnabled(x,y,schiffLaenge, horizontal)) {
                            for(int i = 0; i < schiffLaenge; i++){
                                if(i == 0){
                                    schiff = new ImageIcon("Schiffteile/H.U.Schiff.png");
                                }else if(i == schiffLaenge - 1){
                                    schiff = new ImageIcon("Schiffteile/V.U.Schiff.png");
                                }else{
                                    schiff = new ImageIcon("Schiffteile/M.H.Schiff.png");
                                }
                                spielfeld[x][y+i].setIcon(schiff);
                            }
                        }
                    }

                    //spielfeld[x][y].setIcon(schiff);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    final int x = posX;
                    final int y = posY;
                    if(horizontal && x+schiffLaenge-1 <= 9){
                        if(feldEnabled(x,y,schiffLaenge,horizontal)){
                            for(int i = 0; i < schiffLaenge; i++){
                                spielfeld[x+i][y].setIcon(null);
                            }
                        }
                        
                    }   
                    if(!horizontal && y+schiffLaenge-1 <= 9){
                        if(feldEnabled(x,y,schiffLaenge,horizontal)){
                            for(int i = 0; i < schiffLaenge; i++){
                                spielfeld[x][y+i].setIcon(null);
                            }
                        }
                    }
                    
                    //spielfeld[x][y].setIcon(null);
                    System.out.println("Verlasse Button" + posX + "|" + posY);
                }
                });
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
        for(int i = 0; i < schiffLaenge; i++){
            if(horizontal){
                spielfeld[pPosX+i][pPosY].setEnabled(false);
            }else{
                spielfeld[pPosX][pPosY+i].setEnabled(false);
            }
        }
        //spielfeld[pPosX][pPosY].setEnabled(false);
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
    public boolean feldEnabled(int pX, int pY, int pLaenge, boolean pHorizontal){
        for(int i = 0; i < pLaenge; i++){
            if(pHorizontal && !spielfeld[pX+i][pY].isEnabled()){
                return false;
            }else if(!pHorizontal && !spielfeld[pX][pY+i].isEnabled()){
                return false;
            }
        }
        return true;
    }
}
