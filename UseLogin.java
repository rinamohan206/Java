import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UseLogin extends JFrame {

    private JTextField t1;
    private JPasswordField pf;
    private JButton btn, btn1;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UseLogin frame = new UseLogin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public UseLogin() {

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 50, 1000, 600);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel l2 = new JLabel("Login");
        l2.setFont(new Font("Times New Roman", Font.BOLD, 40));
        l2.setBounds(430, 30, 200, 50);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Username");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 28));
        l3.setBounds(220, 150, 180, 40);
        contentPane.add(l3);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.PLAIN, 28));
        t1.setBounds(450, 150, 280, 45);
        contentPane.add(t1);

        JLabel l4 = new JLabel("Password");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 28));
        l4.setBounds(220, 250, 180, 40);
        contentPane.add(l4);

        pf = new JPasswordField();
        pf.setFont(new Font("Tahoma", Font.PLAIN, 28));
        pf.setBounds(450, 250, 280, 45);
        contentPane.add(pf);

        btn = new JButton("Login");
        btn.setFont(new Font("Tahoma", Font.PLAIN, 24));
        btn.setBounds(450, 350, 130, 50);
        contentPane.add(btn);

        btn1 = new JButton("Clear");
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        btn1.setBounds(600, 350, 130, 50);
        contentPane.add(btn1);

        // Login Button
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String username = t1.getText();
                String password = new String(pf.getPassword());

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/StudentDB",
                            "root",
                            "root");

                    String query = "SELECT * FROM students WHERE username=? AND password=?";
                    PreparedStatement ps = con.prepareStatement(query);

                    ps.setString(1, username);
                    ps.setString(2, password);

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(btn,
                                "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(btn,
                                "Wrong Username or Password");
                    }

                    rs.close();
                    ps.close();
                    con.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(btn,
                            "Database Connection Error\n" + ex.getMessage());
                }
            }
        });

        // Clear Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("");
                pf.setText("");
            }
        });
    }
    
}

