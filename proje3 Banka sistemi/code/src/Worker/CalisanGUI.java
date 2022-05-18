package Worker;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import CMusteriSDGUI;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Login.*;
import functions.*;

public class CalisanGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalisanGUI frame = new CalisanGUI();
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
	public CalisanGUI() {
		setTitle("Çalışan Girişi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblHogeldinizIyialmalar = new JLabel("Hoşgeldiniz.. iyi Çalışmalar");
		lblHogeldinizIyialmalar.setBounds(10, 11, 240, 14);
		contentPane.add(lblHogeldinizIyialmalar);

		JButton btnCikis = new JButton("Çıkış");//CIKIS
		btnCikis.setBackground(Color.RED);
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lGUI = new LoginGUI();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btnCikis.setBounds(385, 11, 89, 23);
		contentPane.add(btnCikis);

		JButton btnNewButton_1 = new JButton("Müşteri Ekle");//MUSTERI EKLE	
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CMusteriEkleGUI cmeGUI=new CMusteriEkleGUI();
				cmeGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 36, 156, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_1_2_1_1 = new JButton("Müşteri Genel Durum");//MUSTERI GENEL DURUM
		btnNewButton_1_2_1_1.setBackground(Color.WHITE);
		btnNewButton_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CMusteriDurumGUI mdGUI=new CMusteriDurumGUI(null, rootPaneCheckingEnabled);
				mdGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2_1_1.setBounds(10, 104, 156, 23);
		contentPane.add(btnNewButton_1_2_1_1);

		JButton btnNewButton_3 = new JButton("Müşteri Hareketleri");//MUSTERI HAREKETLERI
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CMusteriHareketleriGUI mhGUI=new CMusteriHareketleriGUI(null, rootPaneCheckingEnabled);
				mhGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(10, 138, 156, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_1_1_1 = new JButton("Müşteri Sil & Düzenle");//MUSTERI SIL VE DUZENLE
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CMusteriSDGUI msdGUI= new CMusteriSDGUI(null, rootPaneCheckingEnabled);
				msdGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(10, 70, 156, 23);
		contentPane.add(btnNewButton_1_1_1);
	}

}
