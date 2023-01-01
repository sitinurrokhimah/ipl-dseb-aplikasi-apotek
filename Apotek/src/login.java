import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class login extends JFrame {
	JLabel username = new JLabel("Username");
	JLabel lpassword = new JLabel("Password");
	JTextField txtusername = new JTextField();
	JPasswordField txtpassword = new JPasswordField();
	JButton masuk = new JButton("Masuk");
	JLabel menu = new JLabel(new ImageIcon(getClass().getResource("/image/Login admin apotek unjani.png")));
	login() {
		setSize(440, 356);
		setTitle("Menu Login Admin Apotek Unjani");
		setLocation(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KomponenVisual();
		AksiReaksi();
	}

	void KomponenVisual() {
		getContentPane().setLayout(null);
		
		getContentPane().add(menu);
		menu.setBounds(0, 11, 424, 90);
		
		getContentPane().add(username);
		username.setBounds(87, 127, 150, 20);
		username.setForeground(Color.white);
		username.setFont(new Font("Rockwell", Font.BOLD, 17));

		getContentPane().add(lpassword);
		lpassword.setBounds(87, 179, 150, 20);
		lpassword.setForeground(Color.white);
		lpassword.setFont(new Font("Rockwell", Font.BOLD, 17));

		getContentPane().add(txtusername);
		txtusername.setBounds(187, 127, 130, 25);
		getContentPane().add(txtpassword);
		txtpassword.setBounds(187, 179, 130, 25);

		getContentPane().add(masuk);
		masuk.setBounds(187, 231, 130, 25);

		getContentPane().setBackground(new Color(13, 55, 73));
		setVisible(true);
	}

	void AksiReaksi() {
		masuk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent me) {
				try {
					String nama = txtusername.getText();
					String password = txtpassword.getText();

					Class.forName("com.mysql.jdbc.Driver");

					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");

					Statement st = koneksi.createStatement();
					String sql = "select * from admin where Username = '" + nama + "' and Password = '" + password + "'";

					ResultSet rs = st.executeQuery(sql);
					if (rs.next()) {
						if ((rs.getString(1).equals(nama)) && (rs.getString(2).equals(password))) {
							JOptionPane.showMessageDialog(null, "Selamat Datang " + nama, "Konfirmasi",
									JOptionPane.INFORMATION_MESSAGE);
						}
						home go = new home(nama); // pemanggilan class lain
						go.KomponenVisual();
						go.AksiReaksi();
						dispose(); // untuk menutup login
					} else if(nama.equals("")||password.equals("")){
						JOptionPane.showMessageDialog(null, "Nama atau Password Masih Kosong", "Konfirmasi",
								JOptionPane.INFORMATION_MESSAGE);
					} else{
						JOptionPane.showMessageDialog(null, "Username atau Password Salah", "Konfirmasi",
								JOptionPane.INFORMATION_MESSAGE);
					}
					st.close();
					koneksi.close();
					txtusername.setText("");
					txtpassword.setText("");
				} catch (Exception ex) {
					System.out.println("Error: " + ex);
				}
			}
		});

	}

	public static void main(String[] args) {
		new login();
		
	}
}
