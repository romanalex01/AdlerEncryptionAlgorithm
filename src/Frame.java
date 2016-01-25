import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Frame extends JFrame implements ActionListener {
    private JPanel background;
    private JLabel infoInputdate;
    private TextField inputDate;
    private JLabel infoOutputdate;
    private TextArea outputDate;
    private JButton encrypts;

    public Frame() {
        background = new JPanel(null);

        infoInputdate = new JLabel("Enter data for enctipting:");
        infoInputdate.setBounds(5,5, 488, 30);
        inputDate = new TextField(null);
        inputDate.setBounds(5, 25, 488, 40);
        infoOutputdate = new JLabel("Result data: ");
        infoOutputdate.setBounds(5, 60, 488, 30);
        outputDate = new TextArea(null);
        outputDate.setBounds(5, 95, 488, 130);
        outputDate.setEditable(false);
        encrypts = new JButton("Encrypts");
        encrypts.setBounds(50, 230, 400, 30);
        encrypts.addActionListener(this);

        background.add(infoInputdate);
        background.add(inputDate);
        background.add(infoOutputdate);
        background.add(outputDate);
        background.add(encrypts);
        add(background);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(encrypts)) {
            if (!inputDate.getText().trim().equals("") || inputDate.getText().trim().length()!=0) {
                Adler instance = new Adler();
                instance.insertToA(inputDate.getText());
                outputDate.setText(instance.convertToAscii(inputDate.getText()));
                outputDate.setText(outputDate.getText() + "\n" +instance.showArray("A", instance.A));
                instance.insertToB();
                outputDate.setText(outputDate.getText() + "\n" + instance.showArray("B", instance.B));
                outputDate.setText(outputDate.getText() + "\nA = " + instance.A.get(instance.A.size()-1) + " = " + instance.convertToHexArray(instance.A) + " hex");
                outputDate.setText(outputDate.getText() + "\nB = " + instance.B.get(instance.B.size()-1) + " = " + instance.convertToHexArray(instance.B) + " hex");
                outputDate.setText(outputDate.getText() + "\nResult = " + instance.convertToHexArray(instance.B) + instance.convertToHexArray(instance.A));

            } else {
                outputDate.setText("");
            }
        }
    }
}
