import java.net.*;
import java.io.*;
/**
 * Beschreiben Sie hier die Klasse Netzwerk.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Netzwerk
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String messagePlayer2;
    /**
     * Konstruktor für Objekte der Klasse Netzwerk
     */
    public Netzwerk()
    {
        // Instanzvariable initialisieren
        
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void start(int port) throws IOException, UnknownHostException, ClassNotFoundException, InterruptedException 
    {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        while((inputLine = in.readLine()) != null){
            if ("match.finished".equals(inputLine)){
                out.println("good bye");
                break;
            }
            messagePlayer2 = inputLine;
        }
    }
}
