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

public class mainFrame 
{
	//Initialize JFrame
	private JFrame frmCipherAssist;
	private JTextField key_textField;

	
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
		panel_1_east.setBackground(Color.DARK_GRAY);
		FlowLayout fl_panel_1_east = (FlowLayout) panel_1_east.getLayout();
		fl_panel_1_east.setHgap(110);
		
		JPanel panel_2_west = new JPanel();
		login_frm.add(panel_2_west, BorderLayout.WEST);
		panel_2_west.setBackground(Color.DARK_GRAY);
		FlowLayout fl_panel_2_west = (FlowLayout) panel_2_west.getLayout();
		fl_panel_2_west.setHgap(110);
		
		JPanel panel_5_center = new JPanel();
		login_frm.add(panel_5_center, BorderLayout.CENTER);
		panel_5_center.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12_signin = new JPanel();
		panel_5_center.add(panel_12_signin, BorderLayout.CENTER);
		panel_12_signin.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_12_signin.setBackground(Color.DARK_GRAY);
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
		panel_login_create.setBackground(Color.DARK_GRAY);
		panel_5_center.add(panel_login_create, BorderLayout.SOUTH);
		panel_login_create.setLayout(new CardLayout(0, 0));
		
		JPanel panel_login_buttons = new JPanel();
		panel_login_create.add(panel_login_buttons, "name_456638280110000");
		panel_login_buttons.setBackground(Color.DARK_GRAY);
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
		panel_create_buttons.setBackground(Color.DARK_GRAY);
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
		panel_6_south.setBackground(Color.DARK_GRAY);
		
		//Panels are being used to format the page and can otherwise be ignored.
		JPanel panel_4_north = new JPanel();
		login_frm.add(panel_4_north, BorderLayout.NORTH);
		panel_4_north.setBackground(Color.DARK_GRAY);
		panel_4_north.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setVgap(10);
		panel_7.setBackground(Color.DARK_GRAY);
		panel_4_north.add(panel_7, BorderLayout.NORTH);
		
		//This is the logoImage 
		JLabel logoImage = new JLabel("");
		panel_4_north.add(logoImage);
		logoImage.setHorizontalAlignment(SwingConstants.CENTER);
		logoImage.setIcon(new ImageIcon(mainFrame.class.getResource("/cipherassist/resources/cipher_assist_logoandtext_150.png")));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.DARK_GRAY);
		panel_4_north.add(panel_8, BorderLayout.SOUTH);
		
		main_frm.setBackground(Color.DARK_GRAY);
		frmCipherAssist.getContentPane().add(main_frm, "name_455973417632460");
		main_frm.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11_center = new JPanel();
		panel_11_center.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_11_center.setBackground(Color.DARK_GRAY);
		main_frm.add(panel_11_center, BorderLayout.CENTER);
		panel_11_center.setLayout(new GridLayout(10, 2, 0, 0));
		
		JLabel lblEncrypMeth = new JLabel("Encryption Method:");
		lblEncrypMeth.setForeground(Color.WHITE);
		panel_11_center.add(lblEncrypMeth);
		
		JList list = new JList();
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setVisibleRowCount(2);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(Color.LIGHT_GRAY);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Test 1", "Test 2", "Test 3", "Test 4", "Test 5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_11_center.add(list);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setForeground(Color.WHITE);
		panel_11_center.add(lblKey);
		
		key_textField = new JTextField();
		key_textField.setBackground(Color.LIGHT_GRAY);
		panel_11_center.add(key_textField);
		key_textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel_11_center.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnClearKey = new JButton("Clear");
		btnClearKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				key_textField.setText("");
			}
		});
		btnClearKey.setBackground(Color.GRAY);
		panel.add(btnClearKey, BorderLayout.EAST);
		
		JButton btnGenerateKey = new JButton("Generate");
		btnGenerateKey.setBackground(Color.GRAY);
		panel.add(btnGenerateKey, BorderLayout.CENTER);
		
		JLabel lblInput = new JLabel("Input:");
		lblInput.setForeground(Color.WHITE);
		lblInput.setBackground(Color.DARK_GRAY);
		panel_11_center.add(lblInput);
		
		JTextArea input_textArea = new JTextArea();
		input_textArea.setRows(2);
		input_textArea.setBackground(Color.LIGHT_GRAY);
		panel_11_center.add(input_textArea);
		
		JLabel lblOutput = new JLabel("Output:");
		lblOutput.setForeground(Color.WHITE);
		panel_11_center.add(lblOutput);
		
		JTextArea Output_textArea = new JTextArea();
		Output_textArea.setBackground(Color.LIGHT_GRAY);
		panel_11_center.add(Output_textArea);
		
		JPanel panel_10_west = new JPanel();
		panel_10_west.setBackground(Color.DARK_GRAY);
		FlowLayout fl_panel_10_west = (FlowLayout) panel_10_west.getLayout();
		fl_panel_10_west.setHgap(20);
		fl_panel_10_west.setVgap(20);
		main_frm.add(panel_10_west, BorderLayout.WEST);
		
		JPanel panel_9_east = new JPanel();
		main_frm.add(panel_9_east, BorderLayout.EAST);
		panel_9_east.setBackground(Color.DARK_GRAY);
		panel_9_east.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1_west = new JPanel();
		panel_1_west.setBackground(Color.DARK_GRAY);
		panel_9_east.add(panel_1_west, BorderLayout.WEST);
		panel_1_west.setLayout(new BorderLayout(0, 0));
		
		JLabel imageLogo = new JLabel("");
		imageLogo.setIcon(new ImageIcon(mainFrame.class.getResource("/cipherassist/resources/cipher_assist_logo_100.png")));
		panel_1_west.add(imageLogo, BorderLayout.NORTH);
		
		JButton btnAccessVault = new JButton("Open Vault");
		btnAccessVault.setBackground(Color.GRAY);
		panel_1_west.add(btnAccessVault);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setBackground(Color.GRAY);
		panel_1_west.add(btnSettings, BorderLayout.SOUTH);
		
		JPanel panel_2_east = new JPanel();
		panel_2_east.setBackground(Color.DARK_GRAY);
		panel_9_east.add(panel_2_east, BorderLayout.EAST);
		
		JPanel panel_1_north = new JPanel();
		panel_1_north.setBackground(Color.DARK_GRAY);
		FlowLayout fl_panel_1_north = (FlowLayout) panel_1_north.getLayout();
		fl_panel_1_north.setVgap(10);
		main_frm.add(panel_1_north, BorderLayout.NORTH);
		
		JPanel panel_2_south = new JPanel();
		FlowLayout fl_panel_2_south = (FlowLayout) panel_2_south.getLayout();
		fl_panel_2_south.setVgap(10);
		panel_2_south.setBackground(Color.DARK_GRAY);
		main_frm.add(panel_2_south, BorderLayout.SOUTH);
	}
}
