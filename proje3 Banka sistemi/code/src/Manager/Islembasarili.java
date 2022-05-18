package Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.LoginGUI;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Islembasarili extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Islembasarili frame = new Islembasarili();
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
	public Islembasarili() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 160);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mudur mudurr =new Mudur();
				MudurGUI mGUI=new MudurGUI(mudurr);
				mGUI.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBackground(Color.WHITE);
		btnGeri.setBounds(10, 11, 89, 23);
		contentPane.add(btnGeri);
		
		JButton btnCikis = new JButton("\u00C3\u2021\u00C4\u00B1k\u00C4\u00B1\u00C5\u0178");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lGUI=new LoginGUI();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btnCikis.setBackground(Color.RED);
		btnCikis.setBounds(335, 11, 89, 23);
		contentPane.add(btnCikis);
		
		JLabel lblNewLabel = new JLabel("\u0130\u015Flem ba\u015Far\u0131yla ger\u00E7ekle\u015Fti.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(99, 45, 243, 91);
		contentPane.add(lblNewLabel);
	}
}
