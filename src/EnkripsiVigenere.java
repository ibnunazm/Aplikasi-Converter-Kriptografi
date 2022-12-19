import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class EnkripsiVigenere extends JDialog {
    private JPanel enkripsiVigenere;
    private JTextField inputPT;
    private JButton ENCRYPTButton;
    private JTextField hasilEnkps;
    private JTextField inputKey;

    //Polimorph, OVERLOAD
    static String toCipherText(JTextField str1){
        String cipher_text="";
        String forKey = "";
        String str = str1.getText().toUpperCase().replace(" ","");
        String alfabet ="abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        int batas = rand.nextInt(str.length()-1)+1;

        for(int i = 0; i<batas; i++){
            int temp = rand.nextInt(26);
            forKey += alfabet.charAt(temp);
        }

        String key = generateKey(forKey,str.length());

        for (int i = 0; i < str.length(); i++) {
            int x = (str.charAt(i) + key.charAt(i)) %26;
            x += 'A';
            cipher_text+=(char)(x);
        }
        return cipher_text + ", " + "Key: " + forKey;
    }

    //OVERLOAD
    static String toCipherText(JTextField str1, String key)
    {
        String cipher_text="";
        String str = str1.getText().toUpperCase().replace(" ","");

        for (int i = 0; i < str.length(); i++) {
            int x = (str.charAt(i) + key.charAt(i)) %26;
            x += 'A';
            cipher_text+=(char)(x);
        }
        return cipher_text;
    }
    //Polimorph, OVERLOAD
    static String generateKey(String key1,int limit) {
        String keyAwal = "";
        int a = 0;
        for (int i = 0; i < limit; i++){
            keyAwal += key1.charAt(a%key1.length());
            a++;
        }

        return keyAwal.toUpperCase();
    }

    //OVERLOAD
    static String generateKey(JTextField str1, JTextField key1) {
        String str = str1.getText();
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
    public EnkripsiVigenere(JFrame parent){
        super(parent);
        setTitle("MENU ENKRIPSI VIGENERE");
        setContentPane(enkripsiVigenere);
        setMinimumSize(new Dimension(700,900));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        ENCRYPTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(inputKey.getText().equals("")){
                    hasilEnkps.setText(toCipherText(inputPT));
                }
                else {
                    hasilEnkps.setText(toCipherText(inputPT,generateKey(inputPT,inputKey)));
                }
            }
        });
    }
}
