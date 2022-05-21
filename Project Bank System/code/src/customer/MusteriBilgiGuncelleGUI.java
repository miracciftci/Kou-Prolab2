package customer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Login.*;
import functions.Customer;
import functions.CustomerOperations;

import javax.swing.JTextField;

public class MusteriBilgiGuncelleGUI extends JFrame {
	CustomerOperations mi = new CustomerOperations();
	
	
	private JPanel contentPane;
	private JTextField textAdi;
	private JTextField textSoyadi;
	private JTextField textTCNo;
	private JTextField textTelNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusteriBilgiGuncelleGUI frame = new MusteriBilgiGuncelleGUI();
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
	public MusteriBilgiGuncelleGUI() {
		setTitle("Bilgilerini güncelleme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JButton btnGeri = new JButton("Geri");// GERI
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

		JButton btnNewButton = new JButton("Çıkış");// CIKIS
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

		JLabel lblBilgileriniz = new JLabel("Bilgileriniz");
		lblBilgileriniz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBilgileriniz.setBounds(194, 11, 89, 21);
		contentPane.add(lblBilgileriniz);

		JButton btnNewButton_1 = new JButton("Kaydet");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad = textAdi.getText().toString();
				String soyad = textSoyadi.getText().toString();
				String tel = textTelNo.getText().toString();
				String tc = textTCNo.getText().toString();
				
				mi.bilgiGuncelleme(LoginGUI.musteriId, ad, soyad, tel, tc);	
				MHesapAcmaGUI mhaGUI = new MHesapAcmaGUI();
				mhaGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(385, 327, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Ad\u0131n\u0131z");
		lblNewLabel.setBounds(10, 63, 139, 23);
		contentPane.add(lblNewLabel);

		JLabel lblSoyadnz = new JLabel("Soyad\u0131n\u0131z");
		lblSoyadnz.setBounds(10, 110, 139, 23);
		contentPane.add(lblSoyadnz);

		JLabel lblAdresiniz = new JLabel("TC Numaran\u0131z");
		lblAdresiniz.setBounds(10, 155, 139, 23);
		contentPane.add(lblAdresiniz);

		JLabel lblTelefonNumaranz = new JLabel("Telefon Numaran\u0131z");
		lblTelefonNumaranz.setBounds(10, 201, 139, 23);
		contentPane.add(lblTelefonNumaranz);

		textAdi = new JTextField();
		textAdi.setBounds(234, 64, 108, 20);
		contentPane.add(textAdi);
		textAdi.setColumns(10);

		textSoyadi = new JTextField();
		textSoyadi.setColumns(10);
		textSoyadi.setBounds(234, 111, 108, 20);
		contentPane.add(textSoyadi);

		textTCNo = new JTextField();
		textTCNo.setColumns(10);
		textTCNo.setBounds(234, 156, 108, 20);
		contentPane.add(textTCNo);

		textTelNo = new JTextField();
		textTelNo.setColumns(10);
		textTelNo.setBounds(234, 202, 108, 20);
		contentPane.add(textTelNo);
		
		Customer musteri = mi.musteriBilgileriniGetir(LoginGUI.musteriId);
		
		textAdi.setText(musteri.getAd().toString());
		textSoyadi.setText(musteri.getSoyad().toString());
		textTCNo.setText(musteri.getTc().toString());
		textTelNo.setText(musteri.getTelno().toString());
	}

}
