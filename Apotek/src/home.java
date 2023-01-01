import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

class home extends JFrame {

	JLabel adduser = new JLabel(new ImageIcon(getClass().getResource("/image/menuadmin.png")));
	JLabel addobat = new JLabel(new ImageIcon(getClass().getResource("/image/addobat.png")));
	JLabel kasir = new JLabel(new ImageIcon(getClass().getResource("/image/kasir.png")));
	JLabel hoveruser = new JLabel(new ImageIcon(getClass().getResource("/image/hoveradmin.png")));
	JLabel dbobat_hover = new JLabel(new ImageIcon(getClass().getResource("/image/hoverobat.png")));
	JLabel kasir_hover = new JLabel(new ImageIcon(getClass().getResource("/image/hoverkasir.png")));

	JLabel home_jl_keluar = new JLabel(new ImageIcon(getClass().getResource("/image/logout.png")));
	private final JLabel Menu = new JLabel("");
	private LabelTime waktu;
	home(String nama) {
		setLocation(120, 50);
		setSize(1100, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Menu Admin Apotek Unjani");
		JOptionPane.showMessageDialog(null, "Login Berhasil", "Konfirmasi",JOptionPane.INFORMATION_MESSAGE);
		KomponenVisual();
		AksiReaksi();
		JOptionPane.showMessageDialog(null, "Selamat Datang " + nama, "Konfirmasi",
		JOptionPane.INFORMATION_MESSAGE);
        setLocationRelativeTo(null);
        userInterface();
		setResizable(false);

	}
	private void userInterface(){
        waktu = new LabelTime();
        waktu.setForeground(Color.WHITE);
        waktu.setSize(200, 100);
        waktu.setLocation(800, 551);
        waktu.setFont(new Font("Arial", Font.BOLD, 24));
        waktu.setHorizontalAlignment(LabelTime.RIGHT);
        
        getContentPane().add(waktu);
		waktu.setBounds(750, 520, 300, 40);
    }
    
	void KomponenVisual() {

		getContentPane().setLayout(null);

		getContentPane().add(adduser);
		adduser.setBounds(180, 180, 170, 170);
		adduser.setCursor(new Cursor(Cursor.HAND_CURSOR));

		getContentPane().add(hoveruser);
		hoveruser.setBounds(0, 361, 1084, 150);
		hoveruser.setVisible(false);

		getContentPane().add(addobat);
		addobat.setBounds(465, 180, 170, 170);
		addobat.setCursor(new Cursor(Cursor.HAND_CURSOR));

		getContentPane().add(dbobat_hover);
		dbobat_hover.setBounds(0, 361, 1084, 150);
		dbobat_hover.setVisible(false);

		// kadaluarsa
		getContentPane().add(kasir);
		kasir.setBounds(750, 180, 170, 170);
		kasir.setCursor(new Cursor(Cursor.HAND_CURSOR));

		getContentPane().add(kasir_hover);
		kasir_hover.setBounds(0, 361, 1084, 150);
		kasir_hover.setVisible(false);

		// logout
		getContentPane().add(home_jl_keluar);
		home_jl_keluar.setBounds(30, 530, 117, 20);
		home_jl_keluar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		
		getContentPane().setBackground(new Color(8, 63, 89));
		Menu.setIcon(new ImageIcon(getClass().getResource("/image/titlemenu.png")));
		Menu.setHorizontalAlignment(SwingConstants.CENTER);
		Menu.setForeground(Color.WHITE);
		Menu.setFont(new Font("Nirmala UI", Font.BOLD, 40));
		Menu.setBounds(0, 21, 1084, 139);
		
		getContentPane().add(Menu);
		setVisible(true);
	}

	void AksiReaksi() {

		
		home_jl_keluar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new login();
				dispose();
			}
		});
		
		adduser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				adduser.setIcon(new ImageIcon(getClass().getResource("/image/menuadmin.png")));
				hoveruser.setVisible(true);
			}

			public void mouseExited(MouseEvent e) {
				adduser.setIcon(new ImageIcon(getClass().getResource("/image/menuadmin.png")));
				hoveruser.setVisible(false);
			}

			public void mouseClicked(MouseEvent e) {
				new AddAdmin();
			}
		});

		addobat.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				addobat.setIcon(new ImageIcon(getClass().getResource("/image/addobat.png")));
				dbobat_hover.setVisible(true);
			}

			public void mouseExited(MouseEvent e) {
				addobat.setIcon(new ImageIcon(getClass().getResource("/image/addobat.png")));
				dbobat_hover.setVisible(false);
			}

			public void mouseClicked(MouseEvent e) {
				new AddObat();
			}
		});

		kasir.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				kasir.setIcon(new ImageIcon(getClass().getResource("/image/kasir.png")));
				kasir_hover.setVisible(true);

			}

			public void mouseExited(MouseEvent e) {
				kasir.setIcon(new ImageIcon(getClass().getResource("/image/kasir.png")));
				kasir_hover.setVisible(false);
			}

			public void mouseClicked(MouseEvent e) {
				new BayardiKasir();
			}
		});

	}

	public static void main(String args[]) {
		new home("");
	}

}