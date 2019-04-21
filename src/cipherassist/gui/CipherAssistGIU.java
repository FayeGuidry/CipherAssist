package cipherassist.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CipherAssistGIU
{
    private JButton closeBtn;
    private JPanel panelMain;
    private JButton button1;
    private JLabel logoImage;

    public CipherAssistGIU() {
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }

    public static void main(String[] args)
    {
        //This is only in the command line.
        System.out.println("Cipher Assist");
        System.out.println("\tBy ConnorGuidry, KheKit, and Geoffery10");

        JFrame mainFrame = new JFrame("Cipher Assist");
        mainFrame.setContentPane(new CipherAssistGIU().panelMain);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
