package Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.LoginGUI;
import functions.ManagerOperations;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SistemiIlerletGUI extends JFrame {
	ManagerOperations mi = new ManagerOperations();
	
	private JPanel contentPane;
	private JTextField textIlerlemeMiktari;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemiIlerletGUI frame = new SistemiIlerletGUI();
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
	public SistemiIlerletGUI() {
		setTitle("Sistemi ilerletme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Sistem Ka\u00E7 Ay \u0130lerlersin");
		lblNewLabel.setBounds(10, 77, 205, 27);
		contentPane.add(lblNewLabel);
		
		textIlerlemeMiktari = new JTextField();
		textIlerlemeMiktari.setBounds(269, 80, 130, 20);
		contentPane.add(textIlerlemeMiktari);
		textIlerlemeMiktari.setColumns(10);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mudur mudurr = new Mudur();
				MudurGUI mGUI = new MudurGUI(mudurr);
				mGUI.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBackground(Color.WHITE);
		btnGeri.setBounds(10, 11, 89, 23);
		contentPane.add(btnGeri);
		
		JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lGUI = new LoginGUI();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btnCikis.setBackground(Color.RED);
		btnCikis.setBounds(385, 11, 89, 23);
		contentPane.add(btnCikis);
		
		JButton btnNewButton = new JButton("\u0130lerlet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ay = Integer.parseInt(textIlerlemeMiktari.getText().toString()); 
				mi.SistemiIlerletme(ay);
				
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(385, 111, 89, 23);
		contentPane.add(btnNewButton);
	}

}
