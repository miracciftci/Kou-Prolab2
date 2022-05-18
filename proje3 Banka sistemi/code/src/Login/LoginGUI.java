 package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Manager.*;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import Worker.*;
import customer.*;
import functions.*;

public class LoginGUI extends JFrame {
	public static int musteriId;
	public static int calisanId;
	public static int mcalisanId;
		
	private JPanel w_giris;
	private JTextField textMudurTC;
	private JTextField textCalisanTC;
	private JTextField textMusteriTC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		
		setBackground(Color.BLACK);
		setResizable(false);
		setTitle("Banka Gir\u015Fi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 500, 400);
		w_giris = new JPanel();
		w_giris.setBackground(Color.WHITE);
		w_giris.setForeground(Color.BLACK);
		w_giris.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_giris);
		w_giris.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 464, 257);
		w_giris.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Müdür Girişi", null, panel, null);
		panel.setLayout(null);

		JButton mdrbtn = new JButton("Müdür");
		mdrbtn.setBounds(10, 11, 439, 30);
		panel.add(mdrbtn);
		mdrbtn.setBackground(Color.WHITE);
		mdrbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mudur mudurr = new Mudur();
				MudurGUI mGUI = new MudurGUI(mudurr);
				mGUI.setVisible(true);
				dispose();
			}
		});
		mdrbtn.setForeground(Color.BLACK);

		JLabel lblTc = new JLabel("ID Numarası giriniz:");
		lblTc.setBounds(10, 74, 125, 30);
		panel.add(lblTc);

		textMudurTC = new JTextField();
		textMudurTC.setBounds(145, 79, 212, 20);
		panel.add(textMudurTC);
		textMudurTC.setColumns(10);

		JButton btnNewButton = new JButton("Giriş");//MUDUR
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mcalisanId = Integer.parseInt(textMudurTC.getText().toString());
				Mudur mudurr = new Mudur();
				MudurGUI mGUI = new MudurGUI(mudurr);
				mGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(145, 188, 212, 30);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Çalışan GiriŞi", null, panel_1, null);
		panel_1.setLayout(null);

		JButton workerbtn = new JButton("Çalışan");
		workerbtn.setBounds(10, 11, 439, 30);
		panel_1.add(workerbtn);
		workerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalisanGUI cGUI = new CalisanGUI();
				cGUI.setVisible(true);
				dispose();
			}
		});
		workerbtn.setBackground(Color.WHITE);

		JLabel lblTc_1 = new JLabel("ID Numaranız:");
		lblTc_1.setBounds(10, 74, 125, 30);
		panel_1.add(lblTc_1);

		textCalisanTC = new JTextField();
		textCalisanTC.setColumns(10);
		textCalisanTC.setBounds(145, 79, 212, 20);
		panel_1.add(textCalisanTC);
		

		JButton btnNewButton_1 = new JButton("Giriş ");//CALISAN
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calisanId = Integer.parseInt(textCalisanTC.getText().toString());
				CalisanGUI cGUI = new CalisanGUI();
				cGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(145, 188, 212, 30);
		panel_1.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Müşteri Girişi", null, panel_2, null);
		panel_2.setLayout(null);

		JButton musteribtn = new JButton("Müşteri");
		musteribtn.setBackground(Color.WHITE);
		musteribtn.setBounds(10, 11, 439, 30);
		panel_2.add(musteribtn);

		JLabel lblTc_2 = new JLabel("ID Numaranız:");
		lblTc_2.setBounds(10, 74, 125, 30);
		panel_2.add(lblTc_2);

		textMusteriTC = new JTextField();
		textMusteriTC.setColumns(10);
		textMusteriTC.setBounds(145, 79, 212, 20);
		panel_2.add(textMusteriTC);

		JButton btnNewButton_2 = new JButton("Giriş ");//MUSTERI
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musteriId = Integer.parseInt(textMusteriTC.getText().toString());
				MusteriGUI msGUI = new MusteriGUI();
				msGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(145, 188, 212, 30);
		panel_2.add(btnNewButton_2);
		musteribtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusteriGUI msGUI = new MusteriGUI();
				msGUI.setVisible(true);
				dispose();
			}
		});
	}
}
