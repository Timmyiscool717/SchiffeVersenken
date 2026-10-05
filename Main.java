import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Beschreiben Sie hier die Klasse Main.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Main
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private JFrame frame;
    private JTextField ipField;
    private JTextField portField;
    private JRadioButton hostButton;
    private JRadioButton clientButton;


    public static void main (String[] args){
        SwingUtilities.invokeLater(() -> new Main().Startfenster());
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    private void  Startfenster(){
        frame = new JFrame("Schiffe Versenken");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
      
        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
      
        JLabel title = new JLabel("Schiffe Versenken", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));
        root.add(title, BorderLayout.NORTH);
        
        JPanel center = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.anchor = GridBagConstraints.WEST;
      
        hostButton = new JRadioButton("Spiel hosten", true);
        clientButton = new JRadioButton("Beitreten");
        ButtonGroup group = new ButtonGroup();
        group.add(hostButton);
        group.add(clientButton);
        
        c.gridx = 0;c.gridy = 0;
        center.add(hostButton, c);
        c.gridx = 1;
        center.add(clientButton, c);
        
        c.gridx = 0; c.gridy = 1;
        center.add(new JLabel("IP-Addresse des Hosts:"),c);
        ipField = new JTextField("192.168.1.1",15);
        c.gridx = 1;
        center.add(ipField, c );
        
        c.gridx = 0; c.gridy = 2;
        center.add(new JLabel("Port:"), c);
        portField = new JTextField("8080", 8);
        c.gridx = 1;
        center.add(portField, c);
        
        root.add(center, BorderLayout.CENTER);
        
        JButton start = new JButton("Starten");
        start.addActionListener(e -> starten());
            
        JPanel bottom = new JPanel();
        bottom.add(start);
        root.add(bottom, BorderLayout.SOUTH);
        
        hostButton.addActionListener(e -> ipField.setEnabled(false));
        clientButton.addActionListener(e -> ipField.setEnabled(true));
        ipField.setEnabled(false);
        
        frame.setContentPane(root);
        frame.setVisible(true);
    }
    
    private void starten(){
        int port;
        try {
            port = Integer.parseInt(portField.getText().trim());
            if (port < 1 || port > 65535) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame,
                "Bitte einen gültigen Port zwischen 1 und 65535 angeben.","Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean host = hostButton. isSelected();
        String ip = ipField.getText().trim();
        
        frame.dispose();
        
        Spielverwaltung spiel = new Spielverwaltung(host);
    }
}
