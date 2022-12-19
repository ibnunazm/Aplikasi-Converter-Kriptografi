import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DekripsiCaesar extends JDialog{
    private JTextField inputCT;
    private JComboBox keyCaesar;
    private JButton DECRYPTButton;
    private JTextField hasilDecrypt;
    private JPanel dekripsiCaesar;
    public static final String alfabet ="abcdefghijklmnopqrstuvwxyz";

    public DekripsiCaesar(JFrame parent){
        super(parent);
        setTitle("MENU DEKRIPSI CAESAR");
        setContentPane(dekripsiCaesar);
        setMinimumSize(new Dimension(800,900));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        DECRYPTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciphertext = inputCT.getText().toLowerCase();

                String plaintext = "";
                int key = Integer.parseInt(keyCaesar.getSelectedItem().toString());
                for (int i = 0; i < ciphertext.length(); i++) {
                    int pos = alfabet.indexOf(ciphertext.charAt(i));

                    int dekripsiPos = (pos - key) % 26;
                    if (dekripsiPos < 0) {
                        dekripsiPos = alfabet.length() + dekripsiPos;
                    }
                    char dekripsiChar = alfabet.charAt(dekripsiPos);

                    plaintext += dekripsiChar;
                    hasilDecrypt.setText(plaintext);
                }
            }
        });
    }
}
