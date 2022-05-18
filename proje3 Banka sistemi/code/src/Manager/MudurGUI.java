package Manager;
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

public class MudurGUI extends JFrame {
	static Mudur mudur = new Mudur();

	private JPanel w_pane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MudurGUI frame = new MudurGUI(mudur);
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
	public MudurGUI(Mudur mudurr) {
		setTitle("Müdür Girişi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		w_pane.setLayout(null);
		setContentPane(w_pane);

		JLabel lblNewLabel = new JLabel("Hoşgeldiniz..");
		lblNewLabel.setBounds(10, 11, 240, 14);
		w_pane.add(lblNewLabel);

		JButton btnCikis = new JButton("Çıkış");//CIKIS
		btnCikis.setBackground(Color.RED);
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lGUI = new LoginGUI();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btnCikis.setBounds(385, 7, 89, 23);
		w_pane.add(btnCikis);

		JButton btnNewButton_1 = new JButton("Banka Durumu");//BANKA DURUMU
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankaDurumGUI bdurumGUI = new BankaDurumGUI();
				bdurumGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 36, 177, 35);
		w_pane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Para Birimi Ekle");//PARA BIRIMI EKLE
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParaBekleGUI pbeGUI=new ParaBekleGUI();
				pbeGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(10, 82, 177, 35);
		w_pane.add(btnNewButton_2);

		JButton btnNewButton_1_1 = new JButton("Çalışanların Maaşı");//CALISANLARIN MAASI
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaasBelirleGUI mbGUI=new MaasBelirleGUI();
				mbGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(10, 128, 177, 35);
		w_pane.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Gecikme Faizi");//GECIKME FAIZI
		btnNewButton_1_2.setBackground(Color.WHITE);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GecikmeFaiziGUI gfGUI=new GecikmeFaiziGUI();
				gfGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setBounds(10, 174, 177, 35);
		w_pane.add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("Müşteri Ekle");//MUSTERI EKLE
		btnNewButton_1_3.setBackground(Color.WHITE);
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusteriEkleGUI meGUI=new MusteriEkleGUI();
				meGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_3.setBounds(10, 220, 177, 35);
		w_pane.add(btnNewButton_1_3);

		JButton btnNewButton_1_4 = new JButton("Sistemi Ilerlet");//SISTEMI ILERLET
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SistemiIlerletGUI siGUI=new SistemiIlerletGUI();
				siGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_4.setBackground(Color.WHITE);
		btnNewButton_1_4.setBounds(10, 312, 177, 35);
		w_pane.add(btnNewButton_1_4);

		JButton btnNewButton_1_5 = new JButton("Gerçekleşen işlemler");//GERCEKLESEN ISLEMLER
		btnNewButton_1_5.setBackground(Color.WHITE);
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MudurGerceklesenislemlerGUI giGUI=new MudurGerceklesenislemlerGUI(null, rootPaneCheckingEnabled);
				giGUI.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1_5.setBounds(10, 266, 177, 35);
		w_pane.add(btnNewButton_1_5);
	}
}
