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
    public boolean horizontal = true;
    private JButton[][] spielfeld = new JButton[10][10]; 
    public int schiffLaenge = 5;
    private SpielGUI gui;
    private char[][] schiffFeld = new char[10][10]; 
    private boolean feind;
    /**
     * Konstruktor für Objekte der Klasse Karte
     */
    public Karte(SpielGUI pGui, boolean pFeind)
    {
        setBackground(Color.BLACK);
        //setPreferredSize(new Dimension(400,400));
        setSize(new Dimension(400,400));
        gui = pGui;
        feind = pFeind;
        for (int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                schiffFeld[j][i] = '.';
            }
        }
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
                    //System.out.println("Betrete Button" + posX + "|" + posY);
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
        //System.out.println("Button" + pPosX + "|" + pPosY);
        if(horizontal && pPosX+schiffLaenge-1 <= 9){
            if(feldEnabled(pPosX,pPosY,schiffLaenge, horizontal)){
                for(int i = 0; i < schiffLaenge; i++){
                        spielfeld[pPosX+i][pPosY].setEnabled(false);
                        spielfeld[pPosX+i][pPosY].setDisabledIcon(spielfeld[pPosX+i][pPosY].getIcon());
                        schiffFeld[pPosX+i][pPosY] = 'S';
                }
                gui.schiffPlatziert(schiffLaenge);
            }
        }
        if(!horizontal && pPosY+schiffLaenge-1 <= 9){
            if(feldEnabled(pPosX,pPosY,schiffLaenge, horizontal)){
                for(int i = 0; i < schiffLaenge; i++){
                        spielfeld[pPosX][pPosY+i].setEnabled(false);
                        spielfeld[pPosX][pPosY+i].setDisabledIcon(spielfeld[pPosX][pPosY+i].getIcon());
                        schiffFeld[pPosX][pPosY+i] = 'S';
                }
                gui.schiffPlatziert(schiffLaenge);
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
