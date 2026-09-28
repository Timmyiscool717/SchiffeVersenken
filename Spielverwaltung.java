
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
        spieler1 = new Spieler();
        spieler2 = new Spieler();
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
        neuesSpiel.addText("Herzlich willkommen hier beim ultimativen 'Verflixte Sieben'-Spiel.\n" + neuesSpiel.aktuellerSpieler.getName() + ", Du fängst an mit einem Vermögen von " + neuesSpiel.aktuellerSpieler.getVermoegen() + ". Bitte setze Deinen Einsatz.\n");
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
}
