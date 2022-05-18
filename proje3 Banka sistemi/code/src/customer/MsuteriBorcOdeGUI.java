package customer;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Login.*;
import functions.Customer;
import functions.CustomerOperations;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class MsuteriBorcOdeGUI extends JFrame {
	CustomerOperations mi = new CustomerOperations();
	
	private JPanel contentPane;
	private JTextField textYazilanMiktar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MsuteriBorcOdeGUI frame = new MsuteriBorcOdeGUI();
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
	public MsuteriBorcOdeGUI() {
		setTitle("Kredi borcu ödeme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnGeri = new JButton("Geri");//GERI
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusteriGUI musteriGUI = new MusteriGUI();
				musteriGUI.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBackground(Color.WHITE);
		btnGeri.setBounds(10, 11, 89, 23);
		contentPane.add(btnGeri);
		
		JButton btnNewButton = new JButton("Çıkış");//CIKIS
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lGUI = new LoginGUI();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(385, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Öde");//ODE
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int miktar = Integer.parseInt(textYazilanMiktar.getText());
				mi.krediBorcuOdeme(miktar, LoginGUI.musteriId);
				MHesapAcmaGUI mhaGUI = new MHesapAcmaGUI();
				mhaGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(385, 327, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Bor\u00E7 Miktar\u0131n\u0131z");
		lblNewLabel.setBounds(10, 61, 123, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u00D6demek \u0130stedi\u011Finiz Miktar\u0131 Yaz\u0131n\u0131z");
		lblNewLabel_1.setBounds(10, 107, 203, 23);
		contentPane.add(lblNewLabel_1);
		
		textYazilanMiktar = new JTextField();
		textYazilanMiktar.setBounds(288, 108, 86, 20);
		contentPane.add(textYazilanMiktar);
		textYazilanMiktar.setColumns(10);
		
		JLabel borcmiktari = new JLabel("");
		borcmiktari.setBounds(288, 65, 86, 19);
		contentPane.add(borcmiktari);
		
		Customer musteri;
		
		musteri = mi.musteriBilgileriniGetir(LoginGUI.musteriId);
		borcmiktari.setText(String.valueOf(musteri.getKredi_borcu()));
		
	}

}
