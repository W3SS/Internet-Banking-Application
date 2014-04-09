import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class ChangePwdfp extends Frame implements ActionListener{
	Connection c;
	Statement s;
	ResultSet r;
	String acc;
	ChangePwdfp cp=this;
	Label old=new Label("New Password");
	Label neww=new Label("Confirm Password");
	TextField oldt=new TextField();
	TextField newt=new TextField();
	Font f1=new Font("Arial",Font.BOLD,10);
	Button done=new Button("Done");
	ChangePwdfp(String str){
	acc=str;
		try{
			c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/bank_db","root","anand");
			s=(Statement)c.createStatement();
		}catch(SQLException e){
			System.out.println(e);
		}
		this.setBounds(500,200,200,200);
		setBackground(Color.LIGHT_GRAY);
		
		setFont(f1);
		setTitle("Change Password");
		setVisible(true);
		setLayout(null);
		setSize(300,200);
		old.setBounds(30,60,100,20);
		neww.setBounds(30,90,110,20);
		oldt.setBounds(150,60,100,20);
		newt.setBounds(150,90,100,20);
		done.setBounds(100,120,40,20);
		add(old);
		add(neww);
		add(oldt);
		add(newt);
		oldt.setEchoChar('*');
		newt.setEchoChar('*');
		add(done);
		done.addActionListener(this);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				cp.setVisible(false);
			}
		});
	}
	public void actionPerformed(ActionEvent ae){
		String str=ae.getActionCommand();
		if(str.equals("Done"))
		{
			try{
			r=s.executeQuery("SELECT * FROM Details WHERE AccountNumber="+acc+";");
			if(oldt.getText().equals(newt.getText())&& !oldt.getText().equals("")){
				s.execute("UPDATE Details SET Pwd=\""+oldt.getText()+"\" WHERE AccountNumber="+acc+";");
				this.setVisible(false);
			}
			else if(oldt.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Do not leave the fields empty","Error",JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null,"Please check the fields properly","Error",JOptionPane.ERROR_MESSAGE);
			}
			}
			catch(SQLException e){
				System.out.println(e);
			}
		}
	}
}