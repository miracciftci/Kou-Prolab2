package customer;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Login.*;

public class MusteriGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusteriGUI frame = new MusteriGUI();
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
	public MusteriGUI() {
		setTitle("Müşteri Girişi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblHogeldinizDeerliMterimiz = new JLabel("Hoşgeldiniz Değerli Müşterimiz");
		lblHogeldinizDeerliMterimiz.setBounds(10, 11, 240, 14);
		contentPane.add(lblHogeldinizDeerliMterimiz);

		JButton btnNewButton = new JButton("Çıkış");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lGUI = new LoginGUI();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(385, 7, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblYapmakIstediinizIlem = new JLabel("Yapmak İstediğiiniz işlem");
		lblYapmakIstediinizIlem.setBounds(10, 51, 240, 14);
		contentPane.add(lblYapmakIstediinizIlem);

		JButton btnNewButton_1 = new JButton(" Hesap Açma");// HESAP ACMA
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MHesapAcmaGUI mhaGUI = new MHesapAcmaGUI();
				mhaGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 76, 147, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Hesap Silme");// HESAP SILME
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MHesapAcmaGUI mhaGUI=new MHesapAcmaGUI();
				mhaGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(10, 110, 147, 23);
		contentPane.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Kredi Talebi");// KREDI TALEBI
		btnNewButton_1_2.setBackground(Color.WHITE);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KrediTalebiGUI ktGUI = new KrediTalebiGUI();
				ktGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setBounds(10, 144, 147, 23);
		contentPane.add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("Bilgilerimi Güncelle");// BILGILERIMI GUNCELLE
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusteriBilgiGuncelleGUI mbgGUI=new MusteriBilgiGuncelleGUI();
				mbgGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_3.setBackground(Color.WHITE);
		btnNewButton_1_3.setBounds(10, 212, 147, 23);
		contentPane.add(btnNewButton_1_3);

		JButton btnNewButton_1_4 = new JButton("Kredi Borcu ödeme");// BORC ODE
		btnNewButton_1_4.setBackground(Color.WHITE);
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MsuteriBorcOdeGUI mboGUI=new MsuteriBorcOdeGUI();
				mboGUI.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1_4.setBounds(10, 178, 147, 23);
		contentPane.add(btnNewButton_1_4);

		JButton btnNewButton_1_3_1 = new JButton("Para Transferi");// PARA TRANSFERI
		btnNewButton_1_3_1.setBackground(Color.WHITE);
		btnNewButton_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParaTransferiGUI ptGUI = new ParaTransferiGUI();
				ptGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_3_1.setBounds(10, 246, 147, 23);
		contentPane.add(btnNewButton_1_3_1);

		JButton btnNewButton_1_3_1_1 = new JButton("Hesap Hareketleri");// HESAP HAREKETLERI
		btnNewButton_1_3_1_1.setBackground(Color.WHITE);
		btnNewButton_1_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MHesapHareketleriGUI mhhGUI = new MHesapHareketleriGUI(null, rootPaneCheckingEnabled);
				mhhGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_3_1_1.setBounds(10, 280, 147, 23);
		contentPane.add(btnNewButton_1_3_1_1);
	}

}
