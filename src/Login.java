import MIktea.MikTeaShop;
import MIktea.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel mainPanel;
    private JPasswordField txtPass;
    private JTextField txtUser;
    private JButton LogButton;
    private JButton exitButton;

    public Login(String title){
        super (title);
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void exit() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void login() {
        String name = txtUser.getText();
        String pass = String.valueOf(txtPass.getPassword());
        MikTeaShop d  = null;
        User admin = new User("Admin","123");
        User checkUser = new User(name,pass);

        boolean login = false;

        if(admin.equals(checkUser)){
            d = new MikTeaShop(name);
            login = true;
        }
        if(login){
            d.setVisible(true);
            this.setVisible(false);
        }else {
            showMess("Login Failed");
        }
    }
    private void showMess(String mess) {
        JOptionPane.showMessageDialog(this,mess);
    }


    public static void main(String[] args) {
        JFrame f = new Login("Login");
        f.setVisible(true);
        }
    }




