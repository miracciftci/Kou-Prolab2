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
import javax.swing.JLabel;
import javax.swing.JTextField;
import Login.*;

public class KrediTalebiGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KrediTalebiGUI frame = new KrediTalebiGUI();
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
	public KrediTalebiGUI() {
		setTitle("Kredi talebi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnGeri = new JButton("Geri");//GERI
		btnGeri.setBackground(Color.WHITE);
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusteriGUI musteriGUI = new MusteriGUI();
				musteriGUI.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBounds(10, 11, 89, 23);
		contentPane.add(btnGeri);
		
		JButton btnNewButton = new JButton("Çıkış");//CIKIS
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lGUI = new LoginGUI();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(385, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblIstediinizKrediMiktar = new JLabel("İstediğiniz Kredi Miktarı");//ISTEDIGINIZ KREDI MIKTARI
		lblIstediinizKrediMiktar.setBounds(10, 94, 200, 21);
		contentPane.add(lblIstediinizKrediMiktar);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(274, 94, 200, 20);
		contentPane.add(textField);
		
		JButton btnIlet = new JButton("Ilet");//KAYDET
		btnIlet.setBackground(Color.GREEN);
		btnIlet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MHesapAcmaGUI mhaGUI=new MHesapAcmaGUI();
				mhaGUI.setVisible(true);
				dispose();
				
			}
		});
		btnIlet.setBounds(385, 140, 89, 23);
		contentPane.add(btnIlet);
	}

}
