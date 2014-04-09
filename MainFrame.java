import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.*;
public class MainFrame extends Frame implements ActionListener,FocusListener,MouseListener {
	Connection conn;
	Statement stat;
	ResultSet r;
	MainFrame ia=this;
	Main mn;
	int f=0;
	int i=0,j=0;
	String pwd="";
	Boolean button1=false;
	Boolean button2=false;
	Boolean shifton=false;
	Label l[]=new Label[5];
	TextField tf[]=new TextField[2];
	Button bt[]=new Button[2];
	Label b[]=new Label[39];
	Button fp=new Button("Forgot Password?");
	Font f1=new Font("Arial",Font.BOLD,10);
	Font f2=new Font("Arial",Font.BOLD,14);
	Label msgf=new Label("*Don't worry about the cursor while typing in this keyboard.");
	MainFrame(Main m){
		this.setBounds(350,200,200,200);
		try{
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/bank_db","root","anand");
			stat=(Statement)conn.createStatement();
		}
		catch(SQLException se){
			System.out.println(se);
		}
		catch(Exception ee){
			System.out.println(ee);
		}
		mn=m;
		setLayout(null);
		setFont(f1);
		setTitle("Bank user Login");
		setBackground(Color.LIGHT_GRAY);
		this.setSize(900,250);
		Font AccNum=new Font("Arial",Font.BOLD,15);
		Font heading=new Font("Arial",Font.PLAIN,30);
		l[4]=new Label("Bank Account Login");
		l[3]=new Label("");
		l[1]=new Label("---------------------------------------------------------------------------------------");
		l[0]=new Label("Account Number");
		tf[0]=new TextField("",20);
		tf[0].addFocusListener(this);
		
		l[2]=new Label("Password");
		tf[1]=new TextField("",20);
		tf[1].setEditable(false);
		tf[1].addFocusListener(this);
		bt[0]=new Button("Login");
		bt[1]=new Button("Reset");
		tf[1].setEchoChar('*');
		l[4].setFont(heading);
		l[4].setBounds(50,30,300,35);
		add(l[4]);
		l[1].setBounds(0,70,350,20);
		add(l[1]);
		l[0].setFont(AccNum);
		l[0].setBounds(10,85,120,35);
		add(l[0]);
		tf[0].setBounds(150,95,150,20);
		add(tf[0]);
		l[2].setFont(AccNum);
		l[2].setBounds(10,130,120,35);
		add(l[2]);
		tf[1].setBounds(150,140,150,20);
		add(tf[1]);
		bt[0].setBounds(80,180,50,25);
		add(bt[0]);
		bt[1].setBounds(180,180,50,25);
		add(bt[1]);
		fp.setBounds(280,180,100,25);
		add(fp);
		fp.addActionListener(this);
		bt[0].addActionListener(this);
		bt[1].addActionListener(this);
		l[3].setBounds(20,210,200,20);
		add(l[3]);
			b[0]=new Label("1");
			b[0].setBounds(410,40,20,20);
			add(b[0]);
			b[0].addMouseListener(this);
			b[1]=new Label("2");
			b[1].setBounds(440,40,20,20);
			add(b[1]);
			b[1].addMouseListener(this);
			b[2]=new Label("3");
			b[2].setBounds(470,40,20,20);
			add(b[2]);
			b[2].addMouseListener(this);
			b[3]=new Label("4");
			b[3].setBounds(500,40,20,20);
			add(b[3]);
			b[3].addMouseListener(this);
			b[4]=new Label("5");
			b[4].setBounds(530,40,20,20);
			add(b[4]);
			b[4].addMouseListener(this);
			b[5]=new Label("6");
			b[5].setBounds(560,40,20,20);
			add(b[5]);
			b[5].addMouseListener(this);
			b[6]=new Label("7");
			b[6].setBounds(590,40,20,20);
			add(b[6]);
			b[6].addMouseListener(this);
			b[7]=new Label("8");
			b[7].setBounds(620,40,20,20);
			add(b[7]);
			b[7].addMouseListener(this);
			b[8]=new Label("9");
			b[8].setBounds(650,40,20,20);
			add(b[8]);
			b[8].addMouseListener(this);
			b[9]=new Label("0");
			b[9].setBounds(680,40,20,20);
			add(b[9]);
			b[9].addMouseListener(this);
			b[10]=new Label("Bksp");
			b[10].setBounds(710,40,40,20);
			add(b[10]);
			b[10].addMouseListener(this);
			b[11]=new Label("q");
			b[11].setBounds(430,70,20,20);
			add(b[11]);
			b[11].addMouseListener(this);
			b[12]=new Label("w");
			b[12].setBounds(460,70,20,20);
			add(b[12]);
			b[12].addMouseListener(this);
			b[13]=new Label("e");
			b[13].setBounds(490,70,20,20);
			add(b[13]);
			b[13].addMouseListener(this);
			b[14]=new Label("r");
			b[14].setBounds(520,70,20,20);
			add(b[14]);
			b[14].addMouseListener(this);
			b[15]=new Label("t");
			b[15].setBounds(550,70,20,20);
			add(b[15]);
			b[15].addMouseListener(this);
			b[16]=new Label("y");
			b[16].setBounds(580,70,20,20);
			add(b[16]);
			b[16].addMouseListener(this);
			b[17]=new Label("u");
			b[17].setBounds(610,70,20,20);
			add(b[17]);
			b[17].addMouseListener(this);
			b[18]=new Label("i");
			b[18].setBounds(640,70,20,20);
			add(b[18]);
			b[18].addMouseListener(this);
			b[19]=new Label("o");
			b[19].setBounds(670,70,20,20);
			add(b[19]);
			b[19].addMouseListener(this);
			b[20]=new Label("p");
			b[20].setBounds(700,70,20,20);
			add(b[20]);
			b[20].addMouseListener(this);
			b[21]=new Label("a");
			b[21].setBounds(450,100,20,20);
			add(b[21]);
			b[21].addMouseListener(this);
			b[22]=new Label("s");
			b[22].setBounds(480,100,20,20);
			add(b[22]);
			b[22].addMouseListener(this);
			b[23]=new Label("d");
			b[23].setBounds(510,100,20,20);
			add(b[23]);
			b[23].addMouseListener(this);
			b[24]=new Label("f");
			b[24].setBounds(540,100,20,20);
			add(b[24]);
			b[24].addMouseListener(this);
			b[25]=new Label("g");
			b[25].setBounds(570,100,20,20);
			add(b[25]);
			b[25].addMouseListener(this);
			b[26]=new Label("h");
			b[26].setBounds(600,100,20,20);
			add(b[26]);
			b[26].addMouseListener(this);
			b[27]=new Label("j");
			b[27].setBounds(630,100,20,20);
			add(b[27]);
			b[27].addMouseListener(this);
			b[28]=new Label("k");
			b[28].setBounds(660,100,20,20);
			add(b[28]);
			b[28].addMouseListener(this);
			b[29]=new Label("l");
			b[29].setBounds(690,100,20,20);
			add(b[29]);
			b[29].addMouseListener(this);
			b[31]=new Label("Shift");
			b[31].setBounds(410,130,40,20);
			add(b[31]);
			b[31].addMouseListener(this);
			b[32]=new Label("z");
			b[32].setBounds(470,130,20,20);
			add(b[32]);
			b[32].addMouseListener(this);
			b[33]=new Label("x");
			b[33].setBounds(500,130,20,20);
			add(b[33]);
			b[33].addMouseListener(this);
			b[34]=new Label("c");
			b[34].setBounds(530,130,20,20);
			add(b[34]);
			b[34].addMouseListener(this);
			b[35]=new Label("v");
			b[35].setBounds(560,130,20,20);
			add(b[35]);
			b[35].addMouseListener(this);
			b[36]=new Label("b");
			b[36].setBounds(590,130,20,20);
			add(b[36]);
			b[36].addMouseListener(this);
			b[37]=new Label("n");
			b[37].setBounds(620,130,20,20);
			add(b[37]);
			b[37].addMouseListener(this);
			b[38]=new Label("m");
			b[38].setBounds(650,130,20,20);
			add(b[38]);
			b[38].addMouseListener(this);
			b[30]=new Label("Shift");
			b[30].setBounds(680,130,40,20);
			add(b[30]);
			b[30].addMouseListener(this);
			for(int i=0;i<39;i++)
		{
			b[i].setFont(f2);
		}
			add(msgf);
			msgf.setBounds(400,200,500,20);
			this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we){
				ia.setVisible(false);
				mn.setVisible(true);
			}			
		});
	}
	/*public void paint(Graphics g) {
		
		g.drawString("*Note: Use this Keyboard (wherever available) for safe transaction",400,220);
	}*/
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("Login"))
		{
			try{
			String s1=tf[0].getText();
			String s2=tf[1].getText();
			if(!s1.equals(""))
			r=stat.executeQuery("SELECT * FROM Details WHERE AccountNumber="+s1+";");
			if(s1.equals("")||s2.equals(""))
				l[3].setText("*Please Fill in all the fields");
			else if(r.next() && r.getString("Pwd").equals(s2) && !s1.equals("") && !s2.equals(""))
			{
				if(isLong(s1)){
				JOptionPane.showMessageDialog(null,"Welcome "+r.getString("Name")+" !","Login Successful",JOptionPane.INFORMATION_MESSAGE);
				stat.execute("CREATE TABLE Temp (AccountNumber long,Name varchar(255),Pwd varchar(255),Pin varchar(3), Balance float,Ben1 long,Ben2 long, Ben3 long, Nick1 varchar(255),Nick2 varchar(255),Nick3 varchar(255),Email varchar(255),SecurityQuestion varchar(255),Answer varchar(255));");
				stat.executeUpdate("INSERT Temp SELECT * FROM Details WHERE AccountNumber="+s1+";");
				PrFrame f=new PrFrame(mn);
				f.setVisible(true);
				this.setVisible(false);
				try{
					r.close();
					conn.close();
					stat.close();
				}catch(SQLException eeee){
					System.out.println(eeee);
				}
				}
				else{
					JOptionPane.showMessageDialog(null,"Hey Hacker! :P","Found You!",JOptionPane.WARNING_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"AccountNumber/Password incorrect !","Login Failed",JOptionPane.ERROR_MESSAGE);
			}
			}
			catch(Exception se){
				System.out.println(se);
			}
		}
		else if(s.equals("Forgot Password?"))
		{
			if(!tf[0].getText().equals("")){
				String s5=tf[0].getText();	
				try{
				r=stat.executeQuery("SELECT * FROM Details WHERE AccountNumber="+s5+";");
				if(r.next()){
				String s1=tf[0].getText();
				ForPass fpwd=new ForPass(s1);
				fpwd.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null,"Invalid AccountNumber!","Error",JOptionPane.ERROR_MESSAGE);
				}
				}catch(SQLException ee){
					System.out.println(ee);
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"Enter the Account Number!","Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(s.equals("Reset")){
			tf[0].setText("");
			tf[1].setText("");
		}
	}
	public boolean isLong(String s4){
		int qw=0;
		for(qw=0;qw<s4.length();qw++)
		{
			if(Character.isDigit(s4.charAt(qw)))
				continue;
			else
				break;
		}
		if(qw!=s4.length())
				return false;
		else
			return true;
	}
	public void focusGained(FocusEvent fe){
		if(fe.getSource()==tf[0])
			f=0;
		else
			f=1;
		button1=button2=false;
		if(fe.getSource()==bt[0]){
			button1=true;
			button2=false;
		}
		if(fe.getSource()==bt[1])
		{
			button2=true;
			button1=false;
		}
	}
	public void focusLost(FocusEvent fe){
	}
	Boolean toggle(){
		if(shifton==true)
			return false;
		else
			return true;
	}
	public void mouseClicked(MouseEvent fe){
	}
	public void mousePressed(MouseEvent fe){
		for(i=0;i<39;i++)
		{
			if(fe.getSource()==b[31]||fe.getSource()==b[30])
			{
				shifton=toggle();
				break;
			}
			else if(fe.getSource()==b[10])
			{
				if(tf[f].getText().length()>0){
				String str=tf[f].getText();
				str=str.substring(0,str.length()-1);
				tf[f].setText(str);
				}
				break;				
			}
			else if(fe.getSource()==b[i])
			{
				b[i].setForeground(Color.WHITE);
				j=i;
				String s=b[j].getText();
				if(shifton==true)
				{
					s=s.toUpperCase();
				}
				String str=tf[f].getText();
				str+=s;
				tf[f].setText(str);
				pwd=tf[1].getText();
				break;
			}
		}
	}
	public void mouseEntered(MouseEvent fe){
	}
	public void mouseExited(MouseEvent fe){
	}
	public void mouseReleased(MouseEvent fe){
		b[j].setForeground(Color.BLACK);
	}
}
