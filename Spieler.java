                                                                    
/**
 * Beschreiben Sie hier die Klasse Spieler.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spieler
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String name;
    private int anzahlSchiffe;

    /**
     * Konstruktor für Objekte der Klasse Spieler
     */
    public Spieler(int anzahlSchiffe)
    {
        // Instanzvariable initialisieren
        anzahlSchiffe = 10;
    }

    public int getAnzahlschiffe() {
       return anzahlSchiffe;
    }
}
