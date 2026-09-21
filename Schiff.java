
/**
 * Beschreiben Sie hier die Klasse Schiff.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Schiff
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int laenge;
    private int posX;
    private int posY;
    private boolean versenkt = false;
    private boolean horizontal = false;
    private boolean [] teileGetroffen = new boolean [laenge];
    /**
     * Konstruktor für Objekte der Klasse Schiff
     */
    public Schiff(int pLaenge, int pPosX, int pPosY)
    {
        laenge = pLaenge;
        posX = pPosX;
        posY = pPosY;
        for(int i = 0; i<laenge; i++){
            teileGetroffen[i] = false;
        }
    }

    public void setHorizontal(boolean pHorizontal)
    {
        horizontal = pHorizontal;
    }
    public boolean getHorizontal(){
        return horizontal;
    }
    public boolean getVersenkt (){
        return versenkt;
    }
    public void trefferUeberpruefen(int pPosX, int pPosY){
        int trefferPosX = pPosX;
        int trefferPosY = pPosY;
        for(int i = 0; i < laenge; i++){
            if(horizontal){
                if(trefferPosX == posX + i && trefferPosY == posY){
                    teileGetroffen[i] = true;
                }
            }else{
                if(trefferPosY == posY + i && trefferPosX == posX){
                    teileGetroffen[i] = true;
                }
            }
        }
    }
    public void versenktCheck(){
        int getroffeneTeile=0;
        for(int i = 0; i < laenge; i++){
            if(teileGetroffen[i] == true){
                getroffeneTeile +=1;
            }
        }
        if(getroffeneTeile == laenge){
            versenkt = true;
        }
    }
}
