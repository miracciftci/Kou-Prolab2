package Manager;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import Login.*;

public class GecikmeFaiziGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textOran;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GecikmeFaiziGUI frame = new GecikmeFaiziGUI();
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
	public GecikmeFaiziGUI() {
		setTitle("Gecikme faizi belirleme");
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
				Mudur mudurr =new Mudur();
				MudurGUI mGUI=new MudurGUI(mudurr);
				mGUI.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBounds(10, 11, 89, 23);
		contentPane.add(btnGeri);
		
		JButton btnCikis = new JButton("��k��");//CIKIS
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
		
		JLabel lblGecikmeFaiziOran = new JLabel("Gecikme Faizi Oran�");//GECIKME FAIZ ORANI
		lblGecikmeFaiziOran.setBounds(10, 86, 200, 30);
		contentPane.add(lblGecikmeFaiziOran);
		
		textOran = new JTextField();
		textOran.setColumns(10);
		textOran.setBounds(274, 91, 200, 20);
		contentPane.add(textOran);
		
		JButton btnKaydet = new JButton("Kaydet");//KAYDET
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Islembasarili isb=new Islembasarili();
				isb.setVisible(true);
				dispose();
			}
		});
		btnKaydet.setBackground(Color.GREEN);
		btnKaydet.setBounds(385, 122, 89, 23);
		contentPane.add(btnKaydet);
	}
}
