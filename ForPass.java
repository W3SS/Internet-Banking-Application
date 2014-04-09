import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class ForPass extends Frame implements ActionListener{
	Connection c;
	Statement s;
	ResultSet r;
	ForPass p;
	String pwd,acc;
	Label ques=new Label("");
	TextField t=new TextField("");
	Button b=new Button("Change Password");
	Font f1=new Font("Arial",Font.BOLD,10);
	ForPass(String str){
		acc=str;
		try{
			c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/bank_db","root","anand");
			s=c.createStatement();
			r=s.executeQuery("SELECT * FROM Details WHERE AccountNumber="+str+";");
			if(r.next())
			{
				pwd=r.getString("Answer");
				ques.setText(r.getString("SecurityQuestion"));
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		setLayout(null);
		setSize(300,300);
		this.setBounds(500,200,300,200);
		setFont(f1);
		setBackground(Color.LIGHT_GRAY);
		add(ques);
		ques.setBounds(40,70,170,20);
		t.setBounds(40,100,100,20);
		add(t);
		add(b);
		b.setBounds(60,130,100,20);
		b.addActionListener(this);
		p=this;
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				p.setVisible(false);
			}
		});
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Change Password"))
		{
			if(pwd.equals(t.getText()))
			{
				ChangePwdfp cpfp=new ChangePwdfp(acc);
				cpfp.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Wrong Answer!","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}