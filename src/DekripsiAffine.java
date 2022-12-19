import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DekripsiAffine extends JDialog{
    private JPanel dekripsiAffine;
    private JTextField inputCT;
    private JButton DECRYPTButton;
    private JTextField hasilDecrypt;
    private JComboBox inputKey1;
    private JComboBox inputKey2;

    static String decryptCipher(JTextField str, JComboBox Key1, JComboBox Key2)
    {
        String cipher = str.getText().toUpperCase();
        int key1 = Integer.parseInt(Key1.getSelectedItem().toString());
        int key2 = Integer.parseInt(Key2.getSelectedItem().toString());
        String msg = "";
        int a_inv = 0;
        int flag = 0;

        for (int i = 0; i < 26; i++)
        {
            flag = (key1 * i) % 26;

            if (flag == 1)
            {
                a_inv = i;
            }
        }
        for (int i = 0; i < cipher.length(); i++)
        {
            if (cipher.charAt(i) != ' ')
            {
                msg = msg + (char) (((a_inv *
                        ((cipher.charAt(i) + 'A' - key2)) % 26)) + 'A');
            }
            else
            {
                msg += cipher.charAt(i);
            }
        }

        return msg;
    }

    public DekripsiAffine(JFrame parent){
        super(parent);
        setTitle("MENU DEKRIPSI AFFINE");
        setContentPane(dekripsiAffine);
        setMinimumSize(new Dimension(800,900));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        DECRYPTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasilDecrypt.setText(decryptCipher(inputCT,inputKey1,inputKey2));
            }
        });
    }
}
