import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hotel Booking System");
        JLabel namelb,emaillb,mobilelb,genderlb,checkinlb,checkoutlb,paymentlb,addresslb,bookingIdlb;
        JTextField nametf,emailtf,mobiletf,gendertf,checkintf,checkouttf,paymenttf,addresstf;
        JButton bookBtn,clearBtn,exitBtn;


        namelb = new JLabel("Name:");
        emaillb = new JLabel("Email:");
        mobilelb = new JLabel("Mobile:");
        genderlb = new JLabel("Gender:");
        checkinlb = new JLabel("Checkin:");
        checkoutlb = new JLabel("checkout:");
        paymentlb = new JLabel("Payment:");
        addresslb = new JLabel("Address:");
        bookingIdlb = new JLabel();


        nametf = new JTextField();
        emailtf = new JTextField();
        mobiletf = new JTextField();
        gendertf = new JTextField();
        checkintf = new JTextField();
        checkouttf = new JTextField();
        paymenttf = new JTextField();
        addresstf = new JTextField();


        bookBtn = new JButton("Book Now");
        clearBtn = new JButton("Clear");
        exitBtn = new JButton("Exit");

        // set the Bounds
        namelb.setBounds(20,30,100,30);
        emaillb.setBounds(20,70,100,30);
        mobilelb.setBounds(20,110,100,30);
        genderlb.setBounds(20,150,100,30);
        checkinlb.setBounds(290,30,100,30);
        checkoutlb.setBounds(290,70,100,30);
        paymentlb.setBounds(290,110,100,30);
        addresslb.setBounds(290,150,100,30);
        bookingIdlb.setBounds(30,350,400,30);

        nametf.setBounds(120,30,150,30);
        emailtf.setBounds(120,70,150,30);
        mobiletf.setBounds(120,110,150,30);
        gendertf.setBounds(120,150,150,30);
        checkintf.setBounds(390,30,150,30);
        checkouttf.setBounds(390,70,150,30);
        paymenttf.setBounds(390,110,150,30);
        addresstf.setBounds(390,150,150,30);


        frame.add(namelb);
        frame.add(emaillb);
        frame.add(mobilelb);
        frame.add(genderlb);
        frame.add(checkinlb);
        frame.add(checkoutlb);
        frame.add(paymentlb);
        frame.add(addresslb);
        frame.add(bookingIdlb);
        frame.add(nametf);
        frame.add(emailtf);
        frame.add(mobiletf);
        frame.add(gendertf);
        frame.add(checkintf);
        frame.add(checkouttf);
        frame.add(paymenttf);
        frame.add(addresstf);



        bookBtn.setBounds(80,250,120,40);
        clearBtn.setBounds(220,250,120,40);
        exitBtn.setBounds(360,250,120,40);
        frame.add(bookBtn);
        frame.add(clearBtn);
        frame.add(exitBtn);








        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(600,500);
        frame.setVisible(true);

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //to clear the form
                nametf.setText("");
                emailtf.setText("");
                mobiletf.setText("");
                gendertf.setText("");
                checkintf.setText("");
                checkouttf.setText("");
                paymenttf.setText("");
                addresstf.setText("");
            }
        });

        bookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //for validation
                if(nametf.getText().toString().isEmpty() ||
                emailtf.getText().toString().isEmpty()||
                mobiletf.getText().toString().isEmpty()||
                gendertf.getText().toString().isEmpty()||
                checkintf.getText().toString().isEmpty()||
                paymenttf.getText().toString().isEmpty()||
                addresstf.getText().toString().isEmpty()||
                checkouttf.getText().toString().isEmpty())
                {
                    bookingIdlb.setText("Please fill your details!");
                }
                else{
                    String url="jdbc:mysql://localhost:3306/hotelbooking";
                    String username="root";
                    String password="";
                    try {
                        Connection connection= DriverManager.getConnection(url,username,password);
                        String sql = " insert into booking "
                                + " values (Null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStmt = connection.prepareStatement(sql);
                        preparedStmt.setString (1,nametf.getText().toString());
                        preparedStmt.setString (2,emailtf.getText().toString());
                        preparedStmt.setString(3, mobiletf.getText().toString());
                        preparedStmt.setString(4, gendertf.getText().toString());
                        preparedStmt.setString(5, checkintf.getText().toString());
                        preparedStmt.setString(6, checkouttf.getText().toString());
                        preparedStmt.setString(7, paymenttf.getText().toString());
                        preparedStmt.setString(8, addresstf.getText().toString());
                        preparedStmt.setString(9, bookingIdlb.getText().toString());

                        preparedStmt.execute();

                        System.out.println("Your Database is connected");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex+ "Not Connected!");
                    }
                    Random random= new Random();
                    int id= random.nextInt(999999);
                    bookingIdlb.setText("Your booking confirmed and booking id:" +id);
                }

            }
        });

        }
    }
