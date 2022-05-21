package Manager;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import Login.*;
import functions.ManagerOperations;

public class MaasBelirleGUI extends JFrame {
	ManagerOperations mi = new ManagerOperations();
	private JPanel contentPane;
	private JTextField textMiktar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaasBelirleGUI frame = new MaasBelirleGUI();
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
	public MaasBelirleGUI() {
		setTitle("Çalışan maaşı belirleme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnGeri = new JButton("Geri");//GERI
		btnGeri.setBackground(Color.WHITE);
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mudur mudurr =new Mudur();
				MudurGUI mGUI=new MudurGUI(mudurr);
				mGUI.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBounds(10, 11, 89, 23);
		contentPane.add(btnGeri);
		
		JButton btnCikis = new JButton("Çıkış");//CIKIS
		btnCikis.setBackground(Color.RED);
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lGUI=new LoginGUI();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btnCikis.setBounds(385, 11, 89, 23);
		contentPane.add(btnCikis);
		
		JLabel lblEklenecekMiktar = new JLabel("Çalışanların maaşı:");//EKLENECEK MIKTAR
		lblEklenecekMiktar.setBounds(10, 75, 200, 30);
		contentPane.add(lblEklenecekMiktar);
		
		textMiktar = new JTextField();
		textMiktar.setColumns(10);
		textMiktar.setBounds(274, 80, 200, 20);
		contentPane.add(textMiktar);
		
		JButton btnKaydet = new JButton("Kaydet");//KAYDET
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int miktar = Integer.parseInt(textMiktar.getText());
				mi.Mt_temsilcilerininMaasi(miktar);
				Islembasarili isb=new Islembasarili();
				isb.setVisible(true);
				dispose();
			}
		});
		btnKaydet.setBackground(Color.GREEN);
		btnKaydet.setBounds(385, 111, 89, 23);
		contentPane.add(btnKaydet);
	}

}
