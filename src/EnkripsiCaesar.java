import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnkripsiCaesar extends JDialog {
    private JPanel enkripsiCaesar;
    private JTextField inputPT;
    private JComboBox keyCaesar;
    private JButton ENCRPYTButton;
    private JTextField hasilEncrypt;
    public static final String alfabet ="abcdefghijklmnopqrstuvwxyz";

    public EnkripsiCaesar(JFrame parent){
        super(parent);
        setTitle("MENU ENKRIPSI CAESAR");
        setContentPane(enkripsiCaesar);
        setMinimumSize(new Dimension(700,900));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        ENCRPYTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputPT.getText().toLowerCase();

                String ciphertext = "";
                int key = Integer.parseInt(keyCaesar.getSelectedItem().toString());
                for (int i = 0; i < text.length(); i++) {
                    if(text.charAt(i) == ' '){
                        continue;
                    }
                    int pos = alfabet.indexOf(text.charAt(i));
                    int enkripsiPos = (pos + key) % 26;
                    char enkripsiChar = alfabet.charAt(enkripsiPos);

                    ciphertext += enkripsiChar;
                    hasilEncrypt.setText(ciphertext);
                }
            }
        });
    }
}

