package Manager;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import Login.*;
import functions.ManagerOperations;

public class ParaBekleGUI extends JFrame {
	ManagerOperations mi = new ManagerOperations();
	private JPanel contentPane;
	private JTextField textParaAdi;
	private JTextField textKurDeger;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParaBekleGUI frame = new ParaBekleGUI();
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
	public ParaBekleGUI() {
		setTitle("Para birimi ekleme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Eklemek İstediğiniz Para Birimi Adı:");//EKLEMEK ISTEDIGINIZ PARA BIRIMI ADI
		lblNewLabel.setBounds(10, 53, 200, 30);
		contentPane.add(lblNewLabel);
		
		textParaAdi = new JTextField();
		textParaAdi.setBounds(274, 58, 200, 20);
		contentPane.add(textParaAdi);
		textParaAdi.setColumns(10);
		
		JLabel lblEklemekIstediinizPara = new JLabel("Eklemek İstediğiniz Para Birimi Kur Değeri");//EKLEMEK ISTEDIGINIZ PARA BIRIMI KUR DEGERI
		lblEklemekIstediinizPara.setBounds(10, 101, 200, 30);
		contentPane.add(lblEklemekIstediinizPara);
		
		textKurDeger = new JTextField();
		textKurDeger.setColumns(10);
		textKurDeger.setBounds(274, 106, 200, 20);
		contentPane.add(textKurDeger);
		
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
		
		JButton btnKaydet = new JButton("Kaydet");//KAYDET
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String para_birimi = textParaAdi.getText();
				int kur = Integer.parseInt(textKurDeger.getText());
				mi.yeniParaBirimiEkleme(para_birimi, kur);
				Islembasarili isb=new Islembasarili();
				isb.setVisible(true);
				dispose();
			}
		});
		btnKaydet.setBackground(Color.GREEN);
		btnKaydet.setBounds(385, 150, 89, 23);
		contentPane.add(btnKaydet);
	}
}
