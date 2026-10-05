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
    public interface Listener{
        void nachrichtEmpfangen(String nachricht);
        void verbindungGeschlossen();
        void verbindungsfehler(Exception e);
    }
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private Listener listener;
    private Thread anfangsThread;
    public void setListener(Listener listener){
        this.listener = listener;
    }
    /**
     * Konstruktor für Objekte der Klasse Netzwerk
     */
    public Netzwerk()
    {
        // Instanzvariable initialisieren
        
    }
    private void initialisierenStreams() throws IOException {
        in = new BufferedReader(
            new InputStreamReader(socket.getInputStream(), "UTF-8"));
        out = new PrintWriter(
            new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
    }
    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void start(int port) throws IOException
    {
        ServerSocket server = new ServerSocket(port);
        try {
            socket = server.accept();
        } finally{
            server.close();
        }
        initialisierenStreams();
        starteEmpfangsThread();
    }
    public void client(String ip, int port) throws IOException {
        socket = new Socket();
        socket.connect(new InetSocketAddress(ip, port), 8000);
        initialisierenStreams();
        starteEmpfangsThread();
    }
    private void starteEmpfangsThread() {
        anfangsThread = new Thread(() -> {
            try {
                String zeile;
                while ((zeile = in.readLine()) != null) {
                    if (listener != null) {
                        listener.nachrichtEmpfangen(zeile);
                    }
                }
                if (listener != null) listener.verbindungGeschlossen();
            } catch (IOException e) {
                if (listener != null) listener.verbindungsfehler(e);
            }
        }, "Netzwerk-Empfang");
        anfangsThread.setDaemon(true);
        anfangsThread.start();
    }
    public synchronized void send(String nachricht){
        if (out != null){
            out.println(nachricht);
        }
    }
    public void schliessen() {
        try {
            if (socket != null) socket.close();
        } catch (IOException ignored)  {
        }
    }
}
