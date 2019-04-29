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
//import javafx.fxml.Initializable;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.lang.model.element.QualifiedNameable;
import javax.swing.AbstractListModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import cipherassist.fileio.CipherIO;
import cipherassist.user.Accounts;
import cipherassist.user.User;
import cipherassist.user.Vault;
import cipherassist.user.VaultItem;
import cipherassist.user.VaultItemList;
//Import other packages
//import cipherassist.encryption.*;
import cipherassist.verification.*;
import cipherassist.encryption.Encrypt;
import cipherassist.encryption.EncryptionMethod;
import cipherassist.fileio.*;

public class mainFrame 
{
	//Initialize JFrame
	private JFrame frmCipherAssist;
	private JTextField key_textField;
	public String background = "#404040";
	private JTextField textField_Date;
	private JTextField textField_Name;
	private JTextField textField_Input;
	public int dataIndex = 0;
	public boolean newData;
	Color mainColor = new Color(0.2f, 0.2f, 0.2f, 1f);
	Color textColor = new Color(1f, 1f, 1f, 1f);
	Color textBoxColor = new Color(1f, 1f, 1f, 1f);
	boolean lightMode = false;
	Settings settings;
	boolean CreateAccountTrue = true;
	String username;
	String password;
	public User user;
	public Hashmap hashmap;
	JLabel lblWelcome = new JLabel("Welcome");
	Vault vault;
	VaultItemList itemlist;
	
	//public ArrayList<String> dataList = new ArrayList<String>();
	
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
	public mainFrame() throws ClassNotFoundException, IOException 
	{
		
		try {
			hashmap = CipherIO.access();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initialize();
	}

	//This creates all the elements of the frame
	private void initialize() throws ClassNotFoundException, IOException 
	{
		String path = new File(".").getCanonicalPath();
		path += "\\" + "settings" + ".dat";
		settings = CipherIO.access(path);
		lightMode = settings.isLightmodeEnabled();
		
		
		if (lightMode == false)
		{
			mainColor = new Color(0.2f, 0.2f, 0.2f, 1f);
			textColor = new Color(1f, 1f, 1f, 1f);
			textBoxColor = new Color(1f, 1f, 1f, 1f);
		}
		else
		{
			mainColor = new Color(0.9f, 0.9f, 0.9f, 1f);
			textColor = new Color(0.2f, 0.2f, 0.2f, 1f);
			textBoxColor = new Color(1f, 1f, 1f, 1f);
		}
		
		frmCipherAssist = new JFrame();
		frmCipherAssist.setIconImage(Toolkit.getDefaultToolkit().getImage(mainFrame.class.getResource("/cipherassist/resources/cipher_assist_logo_100.png")));
		frmCipherAssist.setTitle("Cipher Assist");
		frmCipherAssist.setResizable(false);
		frmCipherAssist.getContentPane().setBackground(mainColor);
		frmCipherAssist.setBackground(mainColor);
		frmCipherAssist.setBounds(100, 100, 720, 480);
		frmCipherAssist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCipherAssist.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel main_frm = new JPanel();
		JPanel login_frm = new JPanel();
		
		frmCipherAssist.getContentPane().add(login_frm, "name_455107982965741");
		login_frm.setLayout(new BorderLayout(0, 0));
		
		//Panels
		JPanel panel_1_east = new JPanel();
		login_frm.add(panel_1_east, BorderLayout.EAST);
		panel_1_east.setBackground(mainColor);
		FlowLayout fl_panel_1_east = (FlowLayout) panel_1_east.getLayout();
		fl_panel_1_east.setHgap(110);
		
		JPanel panel_2_west = new JPanel();
		login_frm.add(panel_2_west, BorderLayout.WEST);
		panel_2_west.setBackground(mainColor);
		FlowLayout fl_panel_2_west = (FlowLayout) panel_2_west.getLayout();
		fl_panel_2_west.setHgap(110);
		
		JPanel panel_5_center = new JPanel();
		login_frm.add(panel_5_center, BorderLayout.CENTER);
		panel_5_center.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12_signin = new JPanel();
		panel_5_center.add(panel_12_signin, BorderLayout.CENTER);
		panel_12_signin.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_12_signin.setBackground(mainColor);
		panel_12_signin.setLayout(new GridLayout(0, 2, 0, 10));
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(textColor);
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
		lblPassword.setForeground(textColor);
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
		panel_login_create.setBackground(mainColor);
		panel_5_center.add(panel_login_create, BorderLayout.SOUTH);
		panel_login_create.setLayout(new CardLayout(0, 0));
		
		JPanel panel_login_buttons = new JPanel();
		panel_login_create.add(panel_login_buttons, "name_456638280110000");
		panel_login_buttons.setBackground(mainColor);
		panel_login_buttons.setLayout(new GridLayout(0, 1, 10, 5));
		
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.setBackground(Color.GRAY);
		panel_login_buttons.add(btnLogin);
		
		//Creating Account Button
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBackground(Color.GRAY);
		panel_login_buttons.add(btnCreateAccount);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBackground(Color.GRAY);
		panel_login_buttons.add(btnQuit);
		
		JPanel panel_create_buttons = new JPanel();
		panel_create_buttons.setBackground(mainColor);
		panel_login_create.add(panel_create_buttons, "name_456645496345286");
		panel_create_buttons.setLayout(new GridLayout(3, 1, 0, 5));
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBackground(Color.GRAY);
		btnCreate.setForeground(Color.BLACK);
		panel_create_buttons.add(btnCreate);
		
		JButton btnCancel_Create = new JButton("Cancel");
		btnCancel_Create.setBackground(Color.GRAY);
		panel_create_buttons.add(btnCancel_Create);
		
		JButton btnQuit2 = new JButton("Quit");
		btnQuit2.setBackground(Color.GRAY);
		panel_create_buttons.add(btnQuit2);
		
		JPanel panel_6_south = new JPanel();
		login_frm.add(panel_6_south, BorderLayout.SOUTH);
		FlowLayout fl_panel_6_south = (FlowLayout) panel_6_south.getLayout();
		fl_panel_6_south.setVgap(45);
		panel_6_south.setBackground(mainColor);
		
		//Panels are being used to format the page and can otherwise be ignored.
		JPanel panel_4_north = new JPanel();
		login_frm.add(panel_4_north, BorderLayout.NORTH);
		panel_4_north.setBackground(mainColor);
		panel_4_north.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setVgap(10);
		panel_7.setBackground(mainColor);
		panel_4_north.add(panel_7, BorderLayout.NORTH);
		
		//This is the logoImage 
		JLabel logoImage = new JLabel("");
		panel_4_north.add(logoImage);
		logoImage.setHorizontalAlignment(SwingConstants.CENTER);
		logoImage.setIcon(new ImageIcon(mainFrame.class.getResource("/cipherassist/resources/cipher_assist_logoandtext_150.png")));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(mainColor);
		panel_4_north.add(panel_8, BorderLayout.SOUTH);
		
		main_frm.setBackground(mainColor);
		frmCipherAssist.getContentPane().add(main_frm, "name_455973417632460");
		main_frm.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11_center = new JPanel();
		panel_11_center.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_11_center.setBackground(mainColor);
		main_frm.add(panel_11_center, BorderLayout.CENTER);
		panel_11_center.setLayout(new GridLayout(11, 2, 0, 0));
		
		
		lblWelcome.setForeground(Color.WHITE);
		panel_11_center.add(lblWelcome);
		
		JLabel lblEncrypMeth = new JLabel("Encryption Method:");
		lblEncrypMeth.setForeground(textColor);
		panel_11_center.add(lblEncrypMeth);
		
		JComboBox comboBox_Encryption = new JComboBox();
		comboBox_Encryption.setModel(new DefaultComboBoxModel(new String[] {"ROT13"}));
		comboBox_Encryption.setBackground(mainColor);
		panel_11_center.add(comboBox_Encryption);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setForeground(textColor);
		panel_11_center.add(lblKey);
		
		key_textField = new JTextField();
		key_textField.setBackground(Color.LIGHT_GRAY);
		panel_11_center.add(key_textField);
		key_textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(mainColor);
		panel_11_center.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnClearKey = new JButton("Clear");
		btnClearKey.setBackground(Color.GRAY);
		panel.add(btnClearKey, BorderLayout.EAST);
		
		JButton btnGenerateKey = new JButton("Generate");
		btnGenerateKey.setBackground(Color.GRAY);
		panel.add(btnGenerateKey, BorderLayout.CENTER);
		
		JLabel lblInput = new JLabel("Input:");
		lblInput.setForeground(textColor);
		lblInput.setBackground(mainColor);
		panel_11_center.add(lblInput);
		
		JTextArea input_textArea = new JTextArea();
		input_textArea.setRows(2);
		input_textArea.setBackground(Color.LIGHT_GRAY);
		panel_11_center.add(input_textArea);
		
		JLabel lblOutput = new JLabel("Output:");
		lblOutput.setForeground(textColor);
		panel_11_center.add(lblOutput);
		
		JTextArea output_textArea = new JTextArea();
		output_textArea.setBackground(Color.LIGHT_GRAY);
		panel_11_center.add(output_textArea);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(mainColor);
		panel_11_center.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setBackground(Color.GRAY);
		panel_13.add(btnEncrypt, BorderLayout.CENTER);
		
		JPanel panel_28 = new JPanel();
		panel_28.setBackground(mainColor);
		panel_13.add(panel_28, BorderLayout.EAST);
		panel_28.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setBackground(Color.GRAY);
		panel_28.add(btnDecrypt);
		
		JButton btnClearInOut = new JButton("Clear");
		panel_28.add(btnClearInOut);
		btnClearInOut.setBackground(Color.GRAY);
		
		btnClearInOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				input_textArea.setText("");
				output_textArea.setText("");
			}
		});
		
		JPanel panel_10_west = new JPanel();
		panel_10_west.setBackground(mainColor);
		FlowLayout fl_panel_10_west = (FlowLayout) panel_10_west.getLayout();
		fl_panel_10_west.setHgap(20);
		fl_panel_10_west.setVgap(20);
		main_frm.add(panel_10_west, BorderLayout.WEST);
		
		JPanel panel_9_east = new JPanel();
		main_frm.add(panel_9_east, BorderLayout.EAST);
		panel_9_east.setBackground(mainColor);
		panel_9_east.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1_west = new JPanel();
		panel_1_west.setBackground(mainColor);
		panel_9_east.add(panel_1_west, BorderLayout.WEST);
		panel_1_west.setLayout(new BorderLayout(0, 8));
		
		JPanel vault_frm = new JPanel();
		vault_frm.setBackground(mainColor);
		frmCipherAssist.getContentPane().add(vault_frm, "name_613580021390995");
		vault_frm.setLayout(new BorderLayout(0, 0));
		
		JButton btnAccessVault = new JButton("Open Vault");
		btnAccessVault.setBackground(Color.GRAY);
		panel_1_west.add(btnAccessVault);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(mainColor);
		panel_1_west.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 5));
		
		JPanel settings_frm = new JPanel();
		settings_frm.setBackground(mainColor);
		frmCipherAssist.getContentPane().add(settings_frm, "name_605979904012717");
		settings_frm.setLayout(new BorderLayout(0, 0));
		
		JButton btnSettings = new JButton("Settings");
		panel_1.add(btnSettings, BorderLayout.NORTH);
		btnSettings.setBackground(Color.GRAY);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.GRAY);
		panel_1.add(btnLogout, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(10);
		panel_2.setBackground(mainColor);
		panel_1.add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(mainColor);
		panel_1_west.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel imageLogo = new JLabel("");
		panel_3.add(imageLogo, BorderLayout.SOUTH);
		imageLogo.setIcon(new ImageIcon(mainFrame.class.getResource("/cipherassist/resources/cipher_assist_logo_100.png")));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setVgap(15);
		panel_4.setBackground(mainColor);
		panel_3.add(panel_4);
		
		JPanel panel_2_east = new JPanel();
		panel_2_east.setBackground(mainColor);
		panel_9_east.add(panel_2_east, BorderLayout.EAST);
		
		JPanel panel_1_north = new JPanel();
		panel_1_north.setBackground(mainColor);
		FlowLayout fl_panel_1_north = (FlowLayout) panel_1_north.getLayout();
		fl_panel_1_north.setVgap(10);
		main_frm.add(panel_1_north, BorderLayout.NORTH);
		
		JPanel panel_2_south = new JPanel();
		FlowLayout fl_panel_2_south = (FlowLayout) panel_2_south.getLayout();
		fl_panel_2_south.setVgap(10);
		panel_2_south.setBackground(mainColor);
		main_frm.add(panel_2_south, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(mainColor);
		settings_frm.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_6.getLayout();
		flowLayout_3.setVgap(25);
		panel_6.setBackground(mainColor);
		panel_5.add(panel_6, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(mainColor);
		panel_5.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new GridLayout(5, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("WARNING! THIS CAN NOT BE UNDONE!");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(mainColor);
		panel_9.add(lblNewLabel);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnDeleteAccount.setForeground(Color.RED);
		panel_9.add(btnDeleteAccount);
		btnDeleteAccount.setBackground(Color.GRAY);
			
		String btnLightModeName;
		if (lightMode == false)
		{
			btnLightModeName = "Light Mode";
		}
		else
		{
			btnLightModeName = "Dark Mode";
		}
		
		JLabel lblNewLabel_7 = new JLabel("Theme Changes Take Effect After Restart");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_7.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_7);
		JButton btnLightMode = new JButton(btnLightModeName);
		btnLightMode.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panel_9.add(btnLightMode);
		btnLightMode.setBackground(Color.GRAY);
		
		JButton btnReturn = new JButton("Back");
		btnReturn.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnReturn.setBackground(Color.GRAY);
		panel_9.add(btnReturn);
		
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_10.getLayout();
		flowLayout_4.setVgap(35);
		panel_10.setBackground(mainColor);
		panel_5.add(panel_10, BorderLayout.SOUTH);
		
		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_11.getLayout();
		flowLayout_5.setHgap(35);
		panel_11.setBackground(mainColor);
		panel_5.add(panel_11, BorderLayout.WEST);
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_12.getLayout();
		flowLayout_6.setHgap(35);
		panel_5.add(panel_12, BorderLayout.EAST);
		panel_12.setBackground(mainColor);
		
		JPanel panel_21 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel_21.getLayout();
		flowLayout_10.setHgap(35);
		panel_21.setBackground(mainColor);
		vault_frm.add(panel_21, BorderLayout.WEST);
		
		JPanel panel_23 = new JPanel();
		FlowLayout flowLayout_11 = (FlowLayout) panel_23.getLayout();
		flowLayout_11.setHgap(35);
		panel_23.setBackground(mainColor);
		vault_frm.add(panel_23, BorderLayout.EAST);
		
		JPanel panel_20 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_20.getLayout();
		flowLayout_9.setVgap(35);
		panel_20.setBackground(mainColor);
		vault_frm.add(panel_20, BorderLayout.NORTH);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(mainColor);
		vault_frm.add(panel_15, BorderLayout.SOUTH);
		panel_15.setLayout(new BorderLayout(0, 10));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(mainColor);
		FlowLayout flowLayout_7 = (FlowLayout) panel_16.getLayout();
		flowLayout_7.setVgap(10);
		panel_15.add(panel_16, BorderLayout.NORTH);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(mainColor);
		panel_15.add(panel_17, BorderLayout.EAST);
		
		JButton btnBack = new JButton("Back");
		panel_17.add(btnBack);
		btnBack.setBackground(Color.GRAY);
		
		JPanel panel_19 = new JPanel();
		panel_17.add(panel_19);
		FlowLayout flowLayout_8 = (FlowLayout) panel_19.getLayout();
		flowLayout_8.setAlignment(FlowLayout.RIGHT);
		panel_19.setBackground(mainColor);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(mainColor);
		panel_15.add(panel_18, BorderLayout.SOUTH);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBackground(mainColor);
		vault_frm.add(panel_26, BorderLayout.CENTER);
		panel_26.setLayout(new CardLayout(0, 0));
		
		JPanel panel_VaultMain = new JPanel();
		panel_26.add(panel_VaultMain, "name_873603184342500");
		panel_VaultMain.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_VaultMain.setBackground(mainColor);
		panel_VaultMain.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Vault");
		lblNewLabel_1.setIcon(new ImageIcon(mainFrame.class.getResource("/cipherassist/resources/cipher_assist_logo_100.png")));
		panel_VaultMain.add(lblNewLabel_1, BorderLayout.NORTH);
		lblNewLabel_1.setForeground(textColor);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 24));
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(mainColor);
		panel_VaultMain.add(panel_22, BorderLayout.CENTER);
		panel_22.setLayout(new GridLayout(5, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Data in Vault:");
		panel_22.add(lblNewLabel_3);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(textColor);
		
		JComboBox<String> comboBox_Data = new JComboBox<String>();
		comboBox_Data.setBackground(mainColor);
		panel_22.add(comboBox_Data);
		
		JLabel lblNewLabel_2 = new JLabel("Date Created:");
		panel_22.add(lblNewLabel_2);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(textColor);
		
		textField_Date = new JTextField();
		panel_22.add(textField_Date);
		textField_Date.setEditable(false);
		textField_Date.setBackground(Color.GRAY);
		textField_Date.setColumns(10);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(mainColor);
		panel_22.add(panel_24);
		panel_24.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(mainColor);
		panel_24.add(panel_25, BorderLayout.EAST);
		panel_25.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.GRAY);
		panel_25.add(btnAdd);
		
		textField_Name = new JTextField();
		
		JButton btnEdit = new JButton("Edit/View");
		JPanel panel_VaultView = new JPanel();
		
		btnEdit.setBackground(Color.GRAY);
		panel_25.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.GRAY);
		btnDelete.setForeground(Color.BLACK);
		panel_25.add(btnDelete);
		
		panel_VaultView.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_VaultView.setBackground(mainColor);
		panel_26.add(panel_VaultView, "name_873614038905000");
		panel_VaultView.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(mainColor);
		panel_VaultView.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Name:");
		lblNewLabel_4.setForeground(textColor);
		panel_14.add(lblNewLabel_4);
		
		textField_Name.setBackground(Color.GRAY);
		panel_14.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Input:");
		lblNewLabel_5.setForeground(textColor);
		panel_14.add(lblNewLabel_5);
		
		textField_Input = new JTextField();
		textField_Input.setBackground(Color.GRAY);
		panel_14.add(textField_Input);
		textField_Input.setColumns(10);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBackground(mainColor);
		panel_VaultView.add(panel_27, BorderLayout.SOUTH);
		
		JButton btn_Save = new JButton("Save");
		btn_Save.setBackground(Color.GRAY);
		panel_27.add(btn_Save);
		
		JButton btnCancel = new JButton("Cancel");
		
		btnCancel.setBackground(Color.GRAY);
		panel_27.add(btnCancel);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(new ImageIcon(mainFrame.class.getResource("/cipherassist/resources/cipher_assist_logo_100.png")));
		panel_VaultView.add(lblNewLabel_6, BorderLayout.NORTH);
		
		
		
		//===============================================================
		//                          COMBO BOX
		//===============================================================
		
		comboBox_Data.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dataIndex = comboBox_Data.getSelectedIndex();
				VaultItem item = itemlist.getEntry(dataIndex + 1);
				
				//Get date from data at index
				//textField_Date.setText(data.getDate(index));
				textField_Date.setText(item.getTimestamp());
			}
		});
		
		//===============================================================
		//                           BUTTONS
		//===============================================================
		
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				boolean loginTrue = false;
				username = username_Textfield.getText();
				password = password_Textfield.getText();
				
				String path = "";
				try {
					path = new File(".").getCanonicalPath();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				path += "\\" + username;
				File file = new File(path);
				
				if ((hashmap.hasThisUsername(username)) && (file.exists()))
				{	
					//Get hashed password
					String hashedPassword = "";
					String hashFromMap = "";
					try {
						SHA256 hash = new SHA256(password);
						hashedPassword = hash.getHash();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//Get hash 
					hashFromMap = hashmap.get(username);
					
					//Check Login info here
					if (hashFromMap.equals(hashedPassword))
					{
						loginTrue = true;
						try {
							//System cannot find file from username because it has been deleted, but its still checking anyway
							user = CipherIO.unseal(username, password);
						} catch (InvalidKeyException | ClassNotFoundException | InvalidKeySpecException
								| NoSuchAlgorithmException | InvalidAlgorithmParameterException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						vault = user.getVault();
						itemlist = new VaultItemList();
						itemlist = vault.getVaultItemList();
						comboBox_Data.setModel(new DefaultComboBoxModel<String>(itemlist.toStringArray()));
					}
					else
					{
						loginTrue = false;
					}
				}
				else
					loginTrue = false;
				
				
				//loginTrue = Verify.checkLogin(username, password);
				
				//Continue to menu
				if (loginTrue == true)
				{
					main_frm.setVisible(true);
					login_frm.setVisible(false);
					lblWelcome.setText("Welcome " + username);
					frmCipherAssist.setDefaultCloseOperation(0);
				}
			}
		});
	
		btnQuit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					CipherIO.store(settings);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		btnQuit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					CipherIO.store(settings);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		btnCancel_Create.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				CreateAccountTrue = false;
				panel_login_buttons.setVisible(true);
				panel_create_buttons.setVisible(false);
			}
		});
		
		btnCreateAccount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				CreateAccountTrue = true;
				panel_create_buttons.setVisible(true);
				panel_login_buttons.setVisible(false);
			}
		});
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//FINISH BACKGROUND ENCRYPTION FIRST IF NEEDED
				boolean ready = true; 
				vault.setVaultItemList(itemlist);
				user.setVault(vault);
				
				try {
					CipherIO.seal(user, username);
				} catch (InvalidKeyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvalidKeySpecException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalBlockSizeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchPaddingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvalidAlgorithmParameterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					CipherIO.store(hashmap);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				user = null;
				vault = null;
				itemlist = null;
				
				//LOGOUT
				if (ready == true)
				{
					username_Textfield.setText("");
					password_Textfield.setText("");
					login_frm.setVisible(true);
					main_frm.setVisible(false);
					frmCipherAssist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		});
		
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				settings_frm.setVisible(true);
				main_frm.setVisible(false);
			}
		});
		
		btnAccessVault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				vault_frm.setVisible(true);
				main_frm.setVisible(false);
			}
		});
		
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//Remove user
				hashmap.remove(username);
				//Remove file
				String path;
				try {
					path = new File(".").getCanonicalPath();
					path += "\\" + username;
					File file = new File(path);
					file.delete();
					user = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Logout
				username_Textfield.setText("");
				password_Textfield.setText("");
				login_frm.setVisible(true);
				settings_frm.setVisible(false);
			}
		});
		
		btnLightMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				FileOutputStream outStream;
				
				
				//LEGACY CODE LIKELY NOT NEEDED
				background = "#ffffff";
				//LEGACY CODE LIKELY NOT NEEDED
				
				if (lightMode == false)
				{
					btnLightMode.setText("Dark Mode");
					lightMode = true;
				}
				else
				{
					btnLightMode.setText("Light Mode");
					lightMode = false;
				}
				
				settings.setLightmodeEnabled(lightMode);
			}
		});
		
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				main_frm.setVisible(true);
				settings_frm.setVisible(false);
			}
		});

		btnEncrypt.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String in = input_textArea.getText();
				int encryptIndex = comboBox_Encryption.getSelectedIndex();
				
				EncryptionMethod encryptionType = Encrypt.getMethod(encryptIndex);
				
				//Encrypt in
				encryptionType.setKey(key_textField.getText());
				String result = encryptionType.getEncryptedString(in);
				
				output_textArea.setText(result);
			}
		}); 
		
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String in = input_textArea.getText();
				int encryptIndex = comboBox_Encryption.getSelectedIndex();
				
				EncryptionMethod encryptionType = Encrypt.getMethod(encryptIndex);
				
				//Decrypt in
				encryptionType.setKey(key_textField.getText());
				String result = encryptionType.getDecryptedString(in);
				
				output_textArea.setText(result);
			}
		});

		btnGenerateKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Get encryption method
				int encryptType = comboBox_Encryption.getSelectedIndex();
				//Generate Key from Data Structure
				//1: ROT13
				
			}
		});

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				username = username_Textfield.getText();
				password = password_Textfield.getText();
				//Check Login info here
				boolean createTrue = false;
				
				user = Accounts.createUser(username, password);
				String hashedPassword = "";
				
				try {
					SHA256 hash = new SHA256(password);
					hashedPassword = hash.getHash();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				String path = "";
				try {
					path = new File(".").getCanonicalPath();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				path += "\\" + username;
				File file = new File(path);
				
				//Check if account already exists
				if ((!hashmap.hasThisUsername(username)) && (!file.exists()))
				{
					hashmap.add(username, hashedPassword);
					try {
						CipherIO.seal(user, username);
					} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException
							| IllegalBlockSizeException | NoSuchPaddingException | InvalidAlgorithmParameterException
							| IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						user = CipherIO.unseal(username, password);
					} catch (InvalidKeyException | ClassNotFoundException | InvalidKeySpecException
							| NoSuchAlgorithmException | InvalidAlgorithmParameterException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					vault = user.getVault();
					itemlist = new VaultItemList();
					itemlist = vault.getVaultItemList();
					comboBox_Data.setModel(new DefaultComboBoxModel<String>(itemlist.toStringArray()));
					createTrue = true;
				}
				
				//Continue to menu
				if (createTrue == true)
				{
					lblWelcome.setText("Welcome " + user.getUsername());
					main_frm.setVisible(true);
					login_frm.setVisible(false);
				}
			}
		});
		
		btnClearKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//Clear key
				key_textField.setText("");
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				main_frm.setVisible(true);
				vault_frm.setVisible(false);
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	
				newData = true;
				panel_VaultView.setVisible(true);
				panel_VaultMain.setVisible(false);
				btnBack.setEnabled(false);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				newData = false;
				//String name = (String) comboBox_Data.getItemAt(dataIndex);
				dataIndex = comboBox_Data.getSelectedIndex();
				VaultItem item = itemlist.getEntry(dataIndex + 1);
				String name = item.getFilename();
				textField_Name.setText(name);
				String input = item.getData();
				textField_Input.setText(input);
				
				panel_VaultView.setVisible(true);
				panel_VaultMain.setVisible(false);
				btnBack.setEnabled(false);
			}
		});
		
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				
				dataIndex = comboBox_Data.getSelectedIndex();
				itemlist.remove(dataIndex + 1);
				
				comboBox_Data.setModel(new DefaultComboBoxModel<String>(itemlist.toStringArray()));
				
				VaultItem item;
				dataIndex = 0;
				
				item = itemlist.getEntry(dataIndex + 1);
				//item.setTimestamp(date.format(timestamp));
				
				comboBox_Data.setSelectedIndex(0);
				textField_Date.setText(item.getTimestamp());
			}
		});
		
		btn_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				String name = textField_Name.getText();
				String input = textField_Input.getText();
				VaultItem item;
				//dataIndex
				//Send input and name to data structure
				
				//reload comboBox_Data
				if(newData == true) //Add
				{
					//comboBox_Data.addItem(name);
					dataIndex = (comboBox_Data.getItemCount());
					//save name and input
					
					item = new VaultItem();
					item.setFilename(name);
					item.setData(input);
					itemlist.add(item);
					item.setTimestamp(date.format(timestamp));
					textField_Date.setText(item.getTimestamp());
				}
				else if (newData == false) //Edit
				{
					//comboBox_Data.setSelectedIndex(dataIndex);
					//comboBox_Data.getModel().setSelectedItem(name);
					//comboBox_Data.setSelectedItem(name);
					//save name and input
					
					item = itemlist.getEntry(dataIndex + 1);
					item.setFilename(name);
					item.setData(input);
				}
				
				//Exit add
				textField_Name.setText("");
				textField_Input.setText("");
				panel_VaultMain.setVisible(true);
				panel_VaultView.setVisible(false);
				btnBack.setEnabled(true);
				
				comboBox_Data.setModel(new DefaultComboBoxModel<String>(itemlist.toStringArray()));
				comboBox_Data.setSelectedIndex(dataIndex);
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				textField_Name.setText("");
				textField_Input.setText("");
				panel_VaultMain.setVisible(true);
				panel_VaultView.setVisible(false);
				btnBack.setEnabled(true);
			}
		});

		//===============================================================
		//                       BUTTONS END
		//===============================================================
	}
}
