package cipherassist.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JDesktopPane;

public class mainFrame 
{
	//Initialize JFrame
	private JFrame frmCipherAssist;
	private JFrame login;

	
	//Launch
	public static void main(String[] args) 
	{
		//This try attempts to create the frame
		try 
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) 
		{
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					mainFrame window = new mainFrame();
					window.frmCipherAssist.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		//Main code goes here...
	}

	//This creates the frame
	public mainFrame() 
	{
		initialize();
	}

	//This creates all the elements of the frame
	private void initialize() 
	{
		//This could could probably be organized better...
		frmCipherAssist = new JFrame();
		frmCipherAssist.setIconImage(Toolkit.getDefaultToolkit().getImage(mainFrame.class.getResource("/cipherassist/resources/cipher_assist_logo_100.png")));
		frmCipherAssist.setTitle("Cipher Assist");
		frmCipherAssist.setResizable(false);
		frmCipherAssist.setForeground(Color.DARK_GRAY);
		frmCipherAssist.getContentPane().setBackground(Color.DARK_GRAY);
		frmCipherAssist.setBackground(Color.DARK_GRAY);
		frmCipherAssist.setBounds(100, 100, 720, 480);
		frmCipherAssist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCipherAssist.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel login_frm = new JPanel();
		frmCipherAssist.getContentPane().add(login_frm, "name_455107982965741");
		login_frm.setLayout(new BorderLayout(0, 0));
		
		//Panels
		JPanel panel_1 = new JPanel();
		login_frm.add(panel_1, BorderLayout.EAST);
		panel_1.setBackground(Color.DARK_GRAY);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(110);
		
		JPanel panel_2 = new JPanel();
		login_frm.add(panel_2, BorderLayout.WEST);
		panel_2.setBackground(Color.DARK_GRAY);
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setHgap(110);
		
		JPanel panel_5 = new JPanel();
		login_frm.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_5.add(panel, BorderLayout.CENTER);
		panel.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new GridLayout(0, 2, 0, 10));
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblUsername);
		
		//Username Text Field
		//Username Label
		JTextField username_Textfield;
		username_Textfield = new JTextField();
		username_Textfield.setHorizontalAlignment(SwingConstants.LEFT);
		username_Textfield.setBackground(Color.LIGHT_GRAY);
		panel.add(username_Textfield);
		username_Textfield.setColumns(10);
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPassword);
		
		//Password Text Field
		//Password Label
		JTextField password_Textfield;
		password_Textfield = new JTextField();
		password_Textfield.setHorizontalAlignment(SwingConstants.LEFT);
		password_Textfield.setBackground(Color.LIGHT_GRAY);
		panel.add(password_Textfield);
		password_Textfield.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_5.add(panel_3, BorderLayout.SOUTH);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setLayout(new GridLayout(0, 1, 10, 5));
		
		
		
		//===============================================================
		//                           BUTTONS
		//===============================================================
		
		//Login Account Button
		JButton btnLogin = new JButton("Login Account");
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//Action goes here
				
			}
		});
		btnLogin.setBackground(Color.GRAY);
		panel_3.add(btnLogin);
		
		//Creating Account Button
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBackground(Color.GRAY);
		panel_3.add(btnCreateAccount);
		
		//This is what happens when you click a button
		btnCreateAccount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//Action goes here
				
			}
		});
		
		//Quit Button
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBackground(Color.GRAY);
		panel_3.add(btnQuit);
		
		//===============================================================
		//                           BUTTONS
		//===============================================================
		
		JPanel panel_6 = new JPanel();
		login_frm.add(panel_6, BorderLayout.SOUTH);
		FlowLayout flowLayout_3 = (FlowLayout) panel_6.getLayout();
		flowLayout_3.setVgap(30);
		panel_6.setBackground(Color.DARK_GRAY);
		
		//Panels are being used to format the page and can otherwise be ignored.
		JPanel panel_4 = new JPanel();
		login_frm.add(panel_4, BorderLayout.NORTH);
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setVgap(10);
		panel_7.setBackground(Color.DARK_GRAY);
		panel_4.add(panel_7, BorderLayout.NORTH);
		
		//This is the logoImage 
		JLabel logoImage = new JLabel("");
		panel_4.add(logoImage);
		logoImage.setHorizontalAlignment(SwingConstants.CENTER);
		logoImage.setIcon(new ImageIcon(mainFrame.class.getResource("/cipherassist/resources/cipher_assist_logoandtext_150.png")));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.DARK_GRAY);
		panel_4.add(panel_8, BorderLayout.SOUTH);
		
		//This is what happens when you click a button
		btnQuit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//Action goes here
				
			}
		});
	}
}
