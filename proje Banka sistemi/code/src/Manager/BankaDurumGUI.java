package Manager;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import Login.*;
import functions.*;

public class BankaDurumGUI extends JFrame {
	ManagerOperations islemler = new ManagerOperations();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankaDurumGUI frame = new BankaDurumGUI();
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
	public BankaDurumGUI() {
		setTitle("Banka durumu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Bankan\u0131z\u0131n Durumu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(165, 11, 161, 23);
		contentPane.add(lblNewLabel);
		
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
		btnGeri.setBounds(0, 11, 89, 23);
		contentPane.add(btnGeri);
		
		JLabel lblGelir = new JLabel("Gelir");
		lblGelir.setBounds(10, 57, 188, 30);
		contentPane.add(lblGelir);
		
		JLabel lblGider = new JLabel("Gider");
		lblGider.setBounds(10, 98, 188, 30);
		contentPane.add(lblGider);
		
		JLabel lblKar = new JLabel("Kar");
		lblKar.setBounds(10, 139, 188, 30);
		contentPane.add(lblKar);
		
		JLabel lblToplamBakiye = new JLabel("Toplam Bakiye");
		lblToplamBakiye.setBounds(10, 180, 188, 30);
		contentPane.add(lblToplamBakiye);
		
		JLabel Geliralan = new JLabel("");
		Geliralan.setBounds(205, 57, 188, 30);
		contentPane.add(Geliralan);
		
		JLabel Gideralan = new JLabel("");
		Gideralan.setBounds(205, 98, 188, 30);
		contentPane.add(Gideralan);
		
		JLabel Karalan = new JLabel("");
		Karalan.setBounds(205, 139, 188, 30);
		contentPane.add(Karalan);
		
		JLabel Bakiyealan = new JLabel("");
		Bakiyealan.setBounds(205, 180, 188, 30);
		contentPane.add(Bakiyealan);
		
		int[] dizi = islemler.bankaninGenelDurumu();
		Geliralan.setText(String.valueOf(dizi[0]));
		Gideralan.setText(String.valueOf(dizi[1]));
		Karalan.setText(String.valueOf(dizi[2]));
		Bakiyealan.setText(String.valueOf(dizi[3]));
	}
}
