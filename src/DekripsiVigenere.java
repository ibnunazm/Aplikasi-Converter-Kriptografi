import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DekripsiVigenere extends JDialog {
    private JTextField inputCT;
    private JTextField inputKey;
    private JButton DECRYPTButton;
    private JTextField hasilDecrypt;
    private JPanel dekripsiVigenere;

    static String generateKey(JTextField str1, JTextField key1) {
        String str = str1.getText().replace(" ","");
        int x = str.length();
        String key = key1.getText();
        for (int i = 0; ; i++) {
            if (x == i)
                i = 0;
            if (key.length() == str.length())
                break;
            key += (key.charAt(i));
        }
        return key.toUpperCase();
    }

    static String originalText(JTextField str, String key){
        String orig_text="";
        String cipher_text = str.getText().toUpperCase().replace(" ","");

        for (int i = 0 ; i < cipher_text.length() && i < key.length(); i++) {
            // converting in range 0-25
            int x = (cipher_text.charAt(i) -
                    key.charAt(i) + 26) %26;

            // convert into alphabets(ASCII)
            x += 'A';
            orig_text+=(char)(x);
        }
        return orig_text;
    }
    public DekripsiVigenere(JFrame parent){
        super(parent);
        setTitle("MENU DEKRIPSI VIGENERE");
        setContentPane(dekripsiVigenere);
        setMinimumSize(new Dimension(800,900));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        DECRYPTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasilDecrypt.setText(originalText(inputCT,generateKey(inputCT,inputKey)));
            }
        });
    }
}
