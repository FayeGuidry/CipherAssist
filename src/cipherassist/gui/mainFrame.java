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
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class mainFrame 
{
	//Initialize JFrame
	private JFrame frmCipherAssist;
	private JTextField key_textField;
	public String background = "#404040";

	
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
		frmCipherAssist.getContentPane().setBackground(Color.decode(background));
		frmCipherAssist.setBackground(Color.decode(background));
		frmCipherAssist.setBounds(100, 100, 720, 480);
		frmCipherAssist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCipherAssist.getContentPane().setLayout(new CardLayout(0, 0));
		
		//===============================================================
		//                            Forms
		//===============================================================
		
		JPanel main_frm = new JPanel();
		JPanel login_frm = new JPanel();
		
		//===============================================================
		//                            Forms
		//===============================================================
		
		frmCipherAssist.getContentPane().add(login_frm, "name_455107982965741");
		login_frm.setLayout(new BorderLayout(0, 0));
		
		//Panels
		JPanel panel_1_east = new JPanel();
		login_frm.add(panel_1_east, BorderLayout.EAST);
		panel_1_east.setBackground(Color.decode(background));
		FlowLayout fl_panel_1_east = (FlowLayout) panel_1_east.getLayout();
		fl_panel_1_east.setHgap(110);
		
		JPanel panel_2_west = new JPanel();
		login_frm.add(panel_2_west, BorderLayout.WEST);
		panel_2_west.setBackground(Color.decode(background));
		FlowLayout fl_panel_2_west = (FlowLayout) panel_2_west.getLayout();
		fl_panel_2_west.setHgap(110);
		
		JPanel panel_5_center = new JPanel();
		login_frm.add(panel_5_center, BorderLayout.CENTER);
		panel_5_center.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12_signin = new JPanel();
		panel_5_center.add(panel_12_signin, BorderLayout.CENTER);
		panel_12_signin.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_12_signin.setBackground(Color.decode(background));
		panel_12_signin.setLayout(new GridLayout(0, 2, 0, 10));
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		panel_12_signin.add(lblUsername);
		
		//Username Text Field
		//Username Label
		JTextField username_Textfield;
		username_Textfield = new JTextField();
		username_Textfield.setHorizontalAlignment(SwingConstants.LEFT);
		username_Textfield.setBackground(Color.LIGHT_GRAY);
		panel_12_signin.add(username_Textfield);
		username_Textfield.setColumns(10);
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_12_signin.add(lblPassword);
		
		//Password Text Field
		//Password Label
		JTextField password_Textfield;
		password_Textfield = new JTextField();
		password_Textfield.setHorizontalAlignment(SwingConstants.LEFT);
		password_Textfield.setBackground(Color.LIGHT_GRAY);
		panel_12_signin.add(password_Textfield);
		password_Textfield.setColumns(10);
		
		JPanel panel_login_create = new JPanel();
		panel_login_create.setBackground(Color.decode(background));
		panel_5_center.add(panel_login_create, BorderLayout.SOUTH);
		panel_login_create.setLayout(new CardLayout(0, 0));
		
		JPanel panel_login_buttons = new JPanel();
		panel_login_create.add(panel_login_buttons, "name_456638280110000");
		panel_login_buttons.setBackground(Color.decode(background));
		panel_login_buttons.setLayout(new GridLayout(0, 1, 10, 5));
		
		
		
		//===============================================================
		//                           BUTTONS
		//===============================================================
		
		//Login Account Button
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//Check Login info here
				boolean loginTrue = true;
				
				//Continue to menu
				if (loginTrue == true)
				{
					main_frm.setVisible(true);
					login_frm.setVisible(false);
				}
			}
		});
		btnLogin.setBackground(Color.GRAY);
		panel_login_buttons.add(btnLogin);
		
		//Creating Account Button
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBackground(Color.GRAY);
		panel_login_buttons.add(btnCreateAccount);
		
		JPanel panel_create_buttons = new JPanel();
		panel_create_buttons.setBackground(Color.decode(background));
		panel_login_create.add(panel_create_buttons, "name_456645496345286");
		panel_create_buttons.setLayout(new GridLayout(2, 1, 0, 5));
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBackground(Color.GRAY);
		btnCreate.setForeground(Color.BLACK);
		panel_create_buttons.add(btnCreate);
		
		JButton btnCancel_Create = new JButton("Cancel");
		btnCancel_Create.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panel_login_buttons.setVisible(true);
				panel_create_buttons.setVisible(false);
			}
		});
		btnCancel_Create.setBackground(Color.GRAY);
		panel_create_buttons.add(btnCancel_Create);
		
		//This is what happens when you click a button
		btnCreateAccount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panel_create_buttons.setVisible(true);
				panel_login_buttons.setVisible(false);
			}
		});
		
		//===============================================================
		//                           BUTTONS
		//===============================================================
		
		JPanel panel_6_south = new JPanel();
		login_frm.add(panel_6_south, BorderLayout.SOUTH);
		FlowLayout fl_panel_6_south = (FlowLayout) panel_6_south.getLayout();
		fl_panel_6_south.setVgap(45);
		panel_6_south.setBackground(Color.decode(background));
		
		//Panels are being used to format the page and can otherwise be ignored.
		JPanel panel_4_north = new JPanel();
		login_frm.add(panel_4_north, BorderLayout.NORTH);
		panel_4_north.setBackground(Color.decode(background));
		panel_4_north.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setVgap(10);
		panel_7.setBackground(Color.decode(background));
		panel_4_north.add(panel_7, BorderLayout.NORTH);
		
		//This is the logoImage 
		JLabel logoImage = new JLabel("");
		panel_4_north.add(logoImage);
		logoImage.setHorizontalAlignment(SwingConstants.CENTER);
		logoImage.setIcon(new ImageIcon(mainFrame.class.getResource("/cipherassist/resources/cipher_assist_logoandtext_150.png")));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.decode(background));
		panel_4_north.add(panel_8, BorderLayout.SOUTH);
		
		main_frm.setBackground(Color.decode(background));
		frmCipherAssist.getContentPane().add(main_frm, "name_455973417632460");
		main_frm.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11_center = new JPanel();
		panel_11_center.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_11_center.setBackground(Color.decode(background));
		main_frm.add(panel_11_center, BorderLayout.CENTER);
		panel_11_center.setLayout(new GridLayout(10, 2, 0, 0));
		
		JLabel lblEncrypMeth = new JLabel("Encryption Method:");
		lblEncrypMeth.setForeground(Color.WHITE);
		panel_11_center.add(lblEncrypMeth);
		
		JComboBox comboBox_Encryption = new JComboBox();
		comboBox_Encryption.setModel(new DefaultComboBoxModel(new String[] {"ROT13", "Test 2", "Test 3", "Test 4", "Test 5"}));
		comboBox_Encryption.setBackground(Color.DARK_GRAY);
		panel_11_center.add(comboBox_Encryption);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setForeground(Color.WHITE);
		panel_11_center.add(lblKey);
		
		key_textField = new JTextField();
		key_textField.setBackground(Color.LIGHT_GRAY);
		panel_11_center.add(key_textField);
		key_textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode(background));
		panel_11_center.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnClearKey = new JButton("Clear");
		btnClearKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//Clear key
				key_textField.setText("");
			}
		});
		btnClearKey.setBackground(Color.GRAY);
		panel.add(btnClearKey, BorderLayout.EAST);
		
		JButton btnGenerateKey = new JButton("Generate");
		btnGenerateKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Get encryption method
				int encryptType = comboBox_Encryption.getSelectedIndex();
				//Generate Key from Data Structure
				//1: ROT13
				
			}
		});
		btnGenerateKey.setBackground(Color.GRAY);
		panel.add(btnGenerateKey, BorderLayout.CENTER);
		
		JLabel lblInput = new JLabel("Input:");
		lblInput.setForeground(Color.WHITE);
		lblInput.setBackground(Color.decode(background));
		panel_11_center.add(lblInput);
		
		JTextArea input_textArea = new JTextArea();
		input_textArea.setRows(2);
		input_textArea.setBackground(Color.LIGHT_GRAY);
		panel_11_center.add(input_textArea);
		
		JLabel lblOutput = new JLabel("Output:");
		lblOutput.setForeground(Color.WHITE);
		panel_11_center.add(lblOutput);
		
		JTextArea output_textArea = new JTextArea();
		output_textArea.setBackground(Color.LIGHT_GRAY);
		panel_11_center.add(output_textArea);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.DARK_GRAY);
		panel_11_center.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String in = input_textArea.getText();
				String out = "";
				
				//Encrypt in
				
				//Get encryption method
				int encryptType = comboBox_Encryption.getSelectedIndex();
				//Generate Key from Data Structure
				//1: ROT13
				
				//This is temp
				out = in;
				
				output_textArea.setText(out);
			}
		});
		btnEncrypt.setBackground(Color.GRAY);
		panel_13.add(btnEncrypt, BorderLayout.CENTER);
		
		JButton btnClearInOut = new JButton("Clear");
		btnClearInOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				input_textArea.setText("");
				output_textArea.setText("");
			}
		});
		btnClearInOut.setBackground(Color.GRAY);
		panel_13.add(btnClearInOut, BorderLayout.EAST);
		
		JPanel panel_10_west = new JPanel();
		panel_10_west.setBackground(Color.decode(background));
		FlowLayout fl_panel_10_west = (FlowLayout) panel_10_west.getLayout();
		fl_panel_10_west.setHgap(20);
		fl_panel_10_west.setVgap(20);
		main_frm.add(panel_10_west, BorderLayout.WEST);
		
		JPanel panel_9_east = new JPanel();
		main_frm.add(panel_9_east, BorderLayout.EAST);
		panel_9_east.setBackground(Color.decode(background));
		panel_9_east.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1_west = new JPanel();
		panel_1_west.setBackground(Color.decode(background));
		panel_9_east.add(panel_1_west, BorderLayout.WEST);
		panel_1_west.setLayout(new BorderLayout(0, 8));
		
		JPanel vault_frm = new JPanel();
		vault_frm.setBackground(Color.DARK_GRAY);
		frmCipherAssist.getContentPane().add(vault_frm, "name_613580021390995");
		vault_frm.setLayout(new BorderLayout(0, 0));
		
		JButton btnAccessVault = new JButton("Open Vault");
		btnAccessVault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				vault_frm.setVisible(true);
				main_frm.setVisible(false);
			}
		});
		btnAccessVault.setBackground(Color.GRAY);
		panel_1_west.add(btnAccessVault);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode(background));
		panel_1_west.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 5));
		
		JPanel settings_frm = new JPanel();
		settings_frm.setBackground(Color.decode(background));
		frmCipherAssist.getContentPane().add(settings_frm, "name_605979904012717");
		settings_frm.setLayout(new BorderLayout(0, 0));
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				settings_frm.setVisible(true);
				main_frm.setVisible(false);
			}
		});
		panel_1.add(btnSettings, BorderLayout.NORTH);
		btnSettings.setBackground(Color.GRAY);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//FINISH BACKGROUND ENCRYPTION FIRST IF NEEDED
				boolean ready = true;
				
				//LOGOUT
				if (ready == true)
				{
					login_frm.setVisible(true);
					main_frm.setVisible(false);
				}
			}
		});
		btnLogout.setBackground(Color.GRAY);
		panel_1.add(btnLogout, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(10);
		panel_2.setBackground(Color.decode(background));
		panel_1.add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode(background));
		panel_1_west.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel imageLogo = new JLabel("");
		panel_3.add(imageLogo, BorderLayout.SOUTH);
		imageLogo.setIcon(new ImageIcon(mainFrame.class.getResource("/cipherassist/resources/cipher_assist_logo_100.png")));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setVgap(15);
		panel_4.setBackground(Color.decode(background));
		panel_3.add(panel_4);
		
		JPanel panel_2_east = new JPanel();
		panel_2_east.setBackground(Color.decode(background));
		panel_9_east.add(panel_2_east, BorderLayout.EAST);
		
		JPanel panel_1_north = new JPanel();
		panel_1_north.setBackground(Color.decode(background));
		FlowLayout fl_panel_1_north = (FlowLayout) panel_1_north.getLayout();
		fl_panel_1_north.setVgap(10);
		main_frm.add(panel_1_north, BorderLayout.NORTH);
		
		JPanel panel_2_south = new JPanel();
		FlowLayout fl_panel_2_south = (FlowLayout) panel_2_south.getLayout();
		fl_panel_2_south.setVgap(10);
		panel_2_south.setBackground(Color.decode(background));
		main_frm.add(panel_2_south, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.decode(background));
		settings_frm.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_6.getLayout();
		flowLayout_3.setVgap(25);
		panel_6.setBackground(Color.decode(background));
		panel_5.add(panel_6, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.decode(background));
		panel_5.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("WARNING! THIS CAN NOT BE UNDONE!");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		panel_9.add(lblNewLabel);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		panel_9.add(btnDeleteAccount);
		btnDeleteAccount.setBackground(Color.GRAY);
		
		JButton btnLightMode = new JButton("Light Mode");
		btnLightMode.setEnabled(false);
		btnLightMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				background = "#ffffff";
				colorInitialize();
				main_frm.setVisible(true);
				settings_frm.setVisible(false);
			}
		});
		panel_9.add(btnLightMode);
		btnLightMode.setBackground(Color.GRAY);
		
		JButton btnReturn = new JButton("Back");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				main_frm.setVisible(true);
				settings_frm.setVisible(false);
			}
		});
		btnReturn.setBackground(Color.GRAY);
		panel_9.add(btnReturn);
		
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_10.getLayout();
		flowLayout_4.setVgap(35);
		panel_10.setBackground(Color.decode(background));
		panel_5.add(panel_10, BorderLayout.SOUTH);
		
		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_11.getLayout();
		flowLayout_5.setHgap(35);
		panel_11.setBackground(Color.decode(background));
		panel_5.add(panel_11, BorderLayout.WEST);
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_12.getLayout();
		flowLayout_6.setHgap(35);
		panel_5.add(panel_12, BorderLayout.EAST);
		panel_12.setBackground(Color.decode(background));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.DARK_GRAY);
		vault_frm.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Vault");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 24));
		panel_14.add(lblNewLabel_1);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.DARK_GRAY);
		vault_frm.add(panel_15, BorderLayout.SOUTH);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				main_frm.setVisible(true);
				vault_frm.setVisible(false);
			}
		});
		btnBack.setBackground(Color.GRAY);
		panel_15.add(btnBack, BorderLayout.EAST);
	}
	
	public void colorInitialize()
	{
		
	}
}
