import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class Register extends Frame implements ActionListener {
	Connection c=null;
	Statement stat;
	Register ia=this;
	Font f1=new Font("Arial",Font.BOLD,10);
	Main mn;
	Label name=new Label("Name: ");
	Label email=new Label("Email:");
	Label acc=new Label("Account Number:");
	Label pwd=new Label("Password: ");
	Label conf=new Label("Confirm Password: ");
	Label msg=new Label("Note: All fields are mandatory.");
	Label msg2=new Label("Make sure you give a difficult password for tighter security.");
	Label sec=new Label("Security Question");
	Label ans=new Label("Answer");
	TextField anst=new TextField("");
	Choice secchoice=new Choice();
	TextField namet=new TextField("");
	TextField em=new TextField("");
	TextField accnum=new TextField("");
	TextField pwd1=new TextField("");
	TextField pwd2=new TextField("");
	Button reg=new Button("Register");
	Register(Main m){
	setFont(f1);
	this.setBounds(500,200,200,200);
		try{
			c=DriverManager.getConnection("jdbc:mysql://localhost:3307/bank_db","root","anand");
			stat=c.createStatement();
		}
		catch(SQLException e){
			System.out.println(e);
		}
		mn=m;
		setLayout(null);
		setTitle("Register: Fill all the fields");
		setBackground(Color.LIGHT_GRAY);
		setSize(400,400);
		pwd1.setEchoChar('*');
		pwd2.setEchoChar('*');
		add(acc);
		acc.setBounds(20,40,150,20);
		add(pwd);
		pwd.setBounds(20,70,150,20);
		add(conf);
		conf.setBounds(20,100,150,20);
		add(accnum);
		accnum.setBounds(200,40,150,20);
		add(pwd1);
		pwd1.setBounds(200,70,150,20);
		add(pwd2);
		pwd2.setBounds(200,100,150,20);
		add(name);
		name.setBounds(20,130,150,20);
		add(namet);
		add(email);
		email.setBounds(20,160,150,20);
		add(em);
		em.setBounds(200,160,150,20);
		namet.setBounds(200,130,150,20);
		sec.setBounds(20,190,100,20);
		add(sec);
		secchoice.setBounds(200,190,170,20);
		add(secchoice);
		secchoice.add("What was your nickname? ");
		secchoice.add("What is your native town?");
		secchoice.add("What is your favorite movie?");
		secchoice.add("What is your pet's name?");
		secchoice.add("What is your favorite team?");
		ans.setBounds(20,220,100,20);
		add(ans);
		anst.setBounds(200,220,150,20);
		add(anst);
		add(reg);
		reg.setBounds(100,250,60,20);
		reg.addActionListener(this);
		add(msg);
		msg.setBounds(20,280,400,20);
		add(msg2);
		msg2.setBounds(20,310,400,20);
		
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we){
				ia.setVisible(false);
				mn.setVisible(true);
			}			
		});
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s=="Register")
		{	
			if(accnum.getText().length()!=0 &&pwd1.getText().equals(pwd2.getText()) && !namet.getText().equals(""))
			{
				try{
				Scanner sc=new Scanner(System.in);
				System.out.println("-----------------------Bank Database------------------\n");
				System.out.print("Enter the balance available in the account: ");
				float amtf=0f;
				while(amtf<500)
				{
				amtf=sc.nextFloat();
				if(amtf<500)
				System.out.println("Minimum Balance is 500.");
				}
				
				System.out.print("Enter the PIN number for the account: ");
				String pin=sc.nextLine(); 
				pin=sc.nextLine();
				stat.executeUpdate("INSERT INTO Details (AccountNumber,Name,Pwd,Balance,Pin,Email,SecurityQuestion,Answer) VALUES ( "+accnum.getText()+",\'"+namet.getText()+"\',\'"+pwd1.getText()+"\',"+amtf+",\""+pin+"\",\""+em.getText()+"\",\""+secchoice.getSelectedItem()+"\",\""+anst.getText()+"\" );");
				JOptionPane.showMessageDialog(null,"Registered Successfully!");
				this.setVisible(false);
				mn.setVisible(true);
				c.close();
				}
				catch(SQLException se){
					System.out.println(se);
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"Please Check the fields and fill them correctly...");
				this.setVisible(true);
			}			
		}
	}
}