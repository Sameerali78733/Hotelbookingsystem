import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        JFrame frame=new JFrame("ChatApplication");
        JLabel  usernamelb= new JLabel("Name");
        JTextField usernametf= new JTextField();
        JButton sendbtn=new JButton("Send your massage");


        JLabel massagelb = new JLabel("Enter Massage");
        JTextField massagetf = new JTextField();

        frame.add(usernamelb);
        frame.add(usernametf);
        frame.add(massagelb);
        frame.add(massagetf);
        frame.add(sendbtn);

        usernamelb.setBounds(20,30,100,30);
        massagelb.setBounds(20,70,100,30);

        usernametf.setBounds(120,30,150,30);
        massagetf.setBounds(120,70,150,30);
        sendbtn.setBounds(50,120,200,40);





        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(350,350);
        frame.setVisible(true);


        sendbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usernametf.getText().toString().isEmpty()||massagetf.getText().toString().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Please enter Massage");

                }
                else {
                    String url="jdbc:mysql://localhost:3306/massagechat";
                    String username="root";
                    String password="";
                    try {
                        Connection connection= DriverManager.getConnection(url,username,password);
                        String sql = " insert into Massage "
                                + " values (Null, ?,?)";
                        PreparedStatement preparedStmt = connection.prepareStatement(sql);
                        preparedStmt.setString (1,usernametf.getText().toString());
                        preparedStmt.setString (2,massagetf.getText().toString());

                        preparedStmt.execute();
                        System.out.println("DataBase is connected");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex+"Error");

                    }
                }


            }
        });

    }
    }

