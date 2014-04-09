import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.*;
public class InsideAccFrame extends Frame implements MouseListener,ActionListener {
	Connection c;
	ResultSet re,qw;
	Statement stat;
	Font f1=new Font("Arial",Font.BOLD,10);
	InsideAccFrame ia=this;
	Label acactr=new Label("• Transfer ");
	Label va=new Label("• View Account");
	Label addben=new Label("• Add Beneficiary");
	Label upprof=new Label("• Update Profile");
	Button logout=new Button("Logout");
	Button b[]=new Button[12];
	/*--------------------------Temporary Store-------------------*/
	String ben1="",ben2="",ben3="",tostring="";
	int beni=0;
	public String amttransd="";
	String to="";
	Main mn;
	/*------------------------------------------------------------*/
	/*-------------------------UPDATE PROFILE---------------------*/
	Button pinchnge=new Button("Change Pin");
	Button pwdchnge=new Button("Change Password");
	Label emailchnge=new Label("Email");
	TextField emailchnget=new TextField();
	Button update=new Button("Update");
	/*------------------------------------------------------------*/
	/*--------------------------ACACTR----------------------------*/
	Label chacc=new Label("Choose Account");
	Choice chacct=new Choice();
	Label amt=new Label("Amount");
	Button transfer=new Button("Transfer");
	TextField amtt=new TextField();
	/*------------------------------------------------------------*/
	/*--------------------------VA--------------------------------*/
	Label bal=new Label("Balance");
	Label minbal=new Label("Minimum Balance");
	Label wdable=new Label("Withdrawable");
	TextField minbalval=new TextField("");
	TextField balval=new TextField("");
	TextField wdablet=new TextField("");
	/*------------------------------------------------------------*/
	/*--------------------------AddBeneficiary--------------------*/
	Label benaccnum=new Label("Beneficiary Account");
	Label nick=new Label("NickName");
	TextField benaccnumt=new TextField();
	TextField nickt=new TextField();
	Button addbenb=new Button("Add");
	/*------------------------------------------------------------*/
	InsideAccFrame(Main m){
		try{
		c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/bank_db","root","anand");
		stat=c.createStatement();
		}
		catch(Exception e){
			System.out.println(e);
		}
		mn=m;
		setFont(f1);
		setTitle("In-Account");
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		this.setSize(650,200);
		/*---------------------Update Profile---------------------*/
		emailchnge.setBounds(150,50,100,20);
		emailchnget.setBounds(300,50,150,20);
		pinchnge.setBounds(150,90,80,20);
		pwdchnge.setBounds(250,90,110,20);
		update.setBounds(470,50,50,20);
		add(emailchnge);
		add(emailchnget);
		add(pinchnge);
		add(update);
		add(pwdchnge);
		pinchnge.addActionListener(this);
		pwdchnge.addActionListener(this);
		update.addActionListener(this);
		emailchnge.setVisible(false);
		emailchnget.setVisible(false);
		pinchnge.setVisible(false);
		pwdchnge.setVisible(false);
		update.setVisible(false);
		/*--------------------------------------------------------*/
		/*----------------------ACACTR----------------------------*/
		chacc.setBounds(150,50,100,20);
		add(chacc);
		chacc.setVisible(false);
		chacct.setBounds(300,50,150,20);
		add(chacct);
		chacct.setVisible(false);
		amt.setBounds(150,90,100,20);
		add(amt);
		amt.setVisible(false);
		amtt.setVisible(false);
		add(amtt);
		amtt.setBounds(300,90,100,20);
		amtt.setEditable(false);
		transfer.setBounds(200,130,60,20);
		transfer.setVisible(false);
		add(transfer);
		transfer.addActionListener(this);
		/*--------------------------------------------------------*/
		/*---------------------VA---------------------------------*/
		bal.setBounds(150,50,100,20);
		add(bal);
		bal.setVisible(false);
		balval.setVisible(false);
		add(balval);
		balval.setBounds(300,50,100,20);
		minbal.setBounds(150,90,100,20);
		add(minbal);
		minbal.setVisible(false);
		minbalval.setBounds(300,90,100,20);
		add(minbalval);
		minbalval.setVisible(false);
		wdable.setBounds(150,130,100,20);
		add(wdable);
		minbalval.setEditable(false);
		balval.setEditable(false);
		minbalval.setText("500");
		wdablet.setEditable(false);
		add(wdablet);
		wdablet.setVisible(false);
		wdablet.setBounds(300,130,100,20);
		wdable.setVisible(false);
		/*---------------------------------------------------------*/
		/*----------------------Add Beneficiary--------------------*/
		benaccnum.setBounds(150,50,110,20);
		add(benaccnum);
		benaccnum.setVisible(false);
		benaccnumt.setBounds(300,50,100,20);
		add(benaccnumt);
		benaccnumt.setVisible(false);
		nick.setVisible(false);
		add(nick);
		nick.setBounds(150,90,100,20);
		nickt.setVisible(false);
		nickt.setBounds(300,90,100,20);
		add(nickt);
		addbenb.setVisible(false);
		add(addbenb);
		addbenb.setBounds(250,130,60,20);
		addbenb.addActionListener(this);
		try{
			qw=stat.executeQuery("SELECT * FROM Temp;");
			if(qw.next()){
			long l=qw.getLong("Ben1");
			ben1=Long.toString(l)+"-"+qw.getString("Nick1");
			l=qw.getLong("Ben2");
			ben2=Long.toString(l)+"-"+qw.getString("Nick2");
			l=qw.getLong("Ben3");
			ben3=Long.toString(l)+"-"+qw.getString("Nick3");
			choiceUpdate();
			for(beni=1;beni<4;beni++)
			{
				if(Long.toString(qw.getLong("Ben"+beni)).equals("0")){
					beni-=1;
					break;
				}
			}
			}
			if(beni==4)
				beni=0;
		}
		catch(SQLException se){
			System.out.println(se);
		}
		/*---------------------------------------------------------*/
		/*-----------------------Applet Body-----------------------*/
		this.setBounds(500,200,650,200);
		acactr.setBounds(10,40,100,20);
		add(acactr);
		acactr.addMouseListener(this);
		va.setBounds(10,70,100,20);
		add(va);
		va.addMouseListener(this);
		addben.setBounds(10,100,100,20);
		add(addben);
		upprof.setBounds(10,130,100,20);
		add(upprof);
		upprof.addMouseListener(this);
		add(logout);
		logout.setBounds(10,160,100,20);
		logout.addActionListener(this);
		addben.addMouseListener(this);
		/*----------------------------------------------------------*/
		/*----------------------KeyPad------------------------------*/
		b[1]=new Button("1");
		add(b[1]);
		b[1].setBounds(500,50,20,20);
		b[1].addActionListener(this);
		b[2]=new Button("2");
		add(b[2]);
		b[2].setBounds(530,50,20,20);
		b[2].addActionListener(this);
		b[3]=new Button("3");
		add(b[3]);
		b[3].setBounds(560,50,20,20);
		b[3].addActionListener(this);
		b[4]=new Button("4");
		add(b[4]);
		b[4].setBounds(500,80,20,20);
		b[4].addActionListener(this);
		b[5]=new Button("5");
		add(b[5]);
		b[5].setBounds(530,80,20,20);
		b[5].addActionListener(this);
		b[6]=new Button("6");
		add(b[6]);
		b[6].setBounds(560,80,20,20);
		b[6].addActionListener(this);
		b[7]=new Button("7");
		add(b[7]);
		b[7].setBounds(500,110,20,20);
		b[7].addActionListener(this);
		b[8]=new Button("8");
		add(b[8]);
		b[8].setBounds(530,110,20,20);
		b[8].addActionListener(this);
		b[9]=new Button("9");
		add(b[9]);
		b[9].setBounds(560,110,20,20);
		b[9].addActionListener(this);
		b[0]=new Button("0");
		add(b[0]);
		b[0].setBounds(500,140,20,20);
		b[0].addActionListener(this);
		b[10]=new Button("Bksp");
		add(b[10]);
		b[11]=new Button(".");
		add(b[11]);
		b[11].setBounds(530,140,20,20);
		b[11].addActionListener(this);
		b[10].setBounds(560,140,40,20);
		b[10].addActionListener(this);
		for(int o=0;o<12;o++)
		{
			b[o].setVisible(false);
		}

		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we){
			try {
				stat.execute("DROP TABLE `bank_db`.`Temp`;");
			}
			catch(Exception e){
				System.out.println(e);
			}
				ia.setVisible(false);
				mn.setVisible(true);
			}			
		});
		/*---------------------------------------------------------*/
	}
	public void actionPerformed(ActionEvent ae) {
		String s=new String();
		s=ae.getActionCommand();
		if(s.equals("Bksp"))
		{
			if(amtt.getText().length()!=0){
			String str=amtt.getText();
			str=str.substring(0,str.length()-1);
			amtt.setText(str);
			}
		}
		if(s.equals("Transfer"))
		{
			to=chacct.getSelectedItem();
			try{
			qw=stat.executeQuery("SELECT * FROM Temp;");
			if(qw.next()){
			float f1=qw.getFloat("Balance");
			amttransd=amtt.getText();
			if(!amtt.getText().equals(""))
			{
				if((f1-500)>=Float.valueOf(amttransd)){
					
					PinFrame pf=new PinFrame(mn,this);
					pf.setVisible(true);
					this.setVisible(false);
					tostring=accnumfind();
				}
				else{
					JOptionPane.showMessageDialog(null,"Check Your amount withdrawable value!");
				}
			}
			}
			}catch(SQLException ser){
				System.out.println(ser);
			}
		}
		if(s.equals("Change Pin")){
			ChangePin cpin=new ChangePin();
			cpin.setVisible(true);
		}
		if(s.equals("Change Password")){
			ChangePwd cpwd=new ChangePwd();
			cpwd.setVisible(true);
		}
		if(s.equals("Logout"))
		{
			try {
				stat.execute("DROP TABLE `bank_db`.`Temp`;");
			}
			catch(Exception e){
				System.out.println(e);
			}
			JOptionPane.showMessageDialog(null,"Thank You for using this portal!");
			MainFrame mf=new MainFrame(new Main());
			mf.setVisible(true);
			this.setVisible(false);
		}
		if(s.equals("Add"))
		{
			String s1=benaccnumt.getText();
			String s2=nickt.getText();
			try{
			Statement s5=c.createStatement();
			ResultSet re3=s5.executeQuery("SELECT * FROM Details WHERE AccountNumber="+s1+";");
			if(re3.next())
			{
			
			beni=(beni%3)+1;
			try {
				Statement stat2=(Statement)c.createStatement();
				ResultSet re2=stat2.executeQuery("SELECT * FROM Temp;");
				if(re2.next()){
					long s3=re2.getLong("AccountNumber");
					stat2.execute("UPDATE Temp SET Ben"+beni+"="+s1+", Nick"+beni+"=\""+s2+"\" WHERE AccountNumber="+s3+";");
					stat2.execute("UPDATE Details SET Ben"+beni+"="+s1+", Nick"+beni+"=\""+s2+"\" WHERE AccountNumber="+s3+";");
					JOptionPane.showMessageDialog(null,"Successfully Added");
				}
				re2=stat2.executeQuery("SELECT * FROM Temp;");
				if(re2.next())
				{
					ben1=Long.toString(re2.getLong("Ben1"))+"-"+re2.getString("Nick1");
					ben2=Long.toString(re2.getLong("Ben2"))+"-"+re2.getString("Nick2");
					ben3=Long.toString(re2.getLong("Ben3"))+"-"+re2.getString("Nick3");
					choiceUpdate();
				}
			}catch(Exception e){
				System.out.println(e);
			}
			}
			else{
				JOptionPane.showMessageDialog(null,"No Such Account Exist","Error!",JOptionPane.ERROR_MESSAGE);
			}
			}catch(Exception e){
				System.out.println(e);
			}
		}
		if(s.equals("Update"))
		{
			try{
				Statement stat2=(Statement)c.createStatement();
				ResultSet re2=stat2.executeQuery("SELECT * FROM Temp;");
				if(re2.next()){
					long s3=re2.getLong("AccountNumber");
					stat2.execute("UPDATE Temp SET Email=\""+emailchnget.getText()+"\" WHERE AccountNumber="+s3+";");
					stat2.execute("UPDATE Details SET Email=\""+emailchnget.getText()+"\" WHERE AccountNumber="+s3+";");
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		else if(!s.equals("Bksp")&&!s.equals("Logout")&&!s.equals("Transfer")&&!s.equals("Add")&&!s.equals("Change Pin")&&!s.equals("Change Password")&&!s.equals("Update"))
		{
			amtt.setText(amtt.getText()+s);
		}
		
	}	
	String accnumfind(){
		String s="";
		for(int i=0;i<to.length();i++)
		{
			if(to.charAt(i)=='-')
				break;
			else{
				s+=to.charAt(i);
			}
		}
		return s;
	}
	void choiceUpdate(){
		chacct.removeAll();
		if(!ben1.equals("0-null"))
			chacct.add(ben1);
		if(!ben2.equals("0-null"))
			chacct.add(ben2);
		if(!ben3.equals("0-null"))
			chacct.add(ben3);
	}
	public void mouseEntered(MouseEvent me) {
		if(me.getSource()==acactr)
			showTransferOptions();
		if(me.getSource()==va)
		{
			try{
			showViewAccount();
			qw=stat.executeQuery("SELECT * FROM Temp;");
			if(qw.next())
			{
				float f=qw.getFloat("Balance");
				balval.setText(Float.toString(f));
				f=f-500;
				wdablet.setText(Float.toString(f));
			}
			}catch(SQLException seq){
				System.out.println(seq);
			}
		}
		if(me.getSource()==addben)
			showbenoptions();
		if(me.getSource()==upprof){
			showUpdateProfile();
			try{
			qw=stat.executeQuery("SELECT * FROM Temp;");
			if(qw.next())
			{
				emailchnget.setText(qw.getString("Email"));
			}
			}
			catch(SQLException see){
				System.out.println(see);
			}
		}
	}
	public void mouseExited(MouseEvent me) {			
	}
	public void mouseClicked(MouseEvent me) {
	}
	public void mousePressed(MouseEvent me){
	}
	public void mouseReleased(MouseEvent me){
	}
	/*--------------Show Methods--------------*/
	public void showTransferOptions()
	{
		hideUpdateProfile();
		hidebenoptions();
		hideViewAccount();
		chacc.setVisible(true);		
		chacct.setVisible(true);
		amt.setVisible(true);
		amtt.setVisible(true);
		transfer.setVisible(true);
		for(int o=0;o<12;o++)
		{
			b[o].setVisible(true);
		}
	}
	public void showViewAccount(){
		hideUpdateProfile();
		hideTransferOptions();
		hidebenoptions();
		bal.setVisible(true);
		minbal.setVisible(true);
		wdable.setVisible(true);
		minbalval.setVisible(true);
		balval.setVisible(true);
		wdablet.setVisible(true);
	}
	public void showbenoptions() {
		hideUpdateProfile();
		hideTransferOptions();
		hideViewAccount();
		benaccnum.setVisible(true);
		benaccnumt.setVisible(true);
		nick.setVisible(true);
		nickt.setVisible(true);
		addbenb.setVisible(true);
		nickt.setText("");
		benaccnumt.setText("");
	}
	public void showUpdateProfile(){
		hideTransferOptions();
		hideViewAccount();
		hidebenoptions();
		emailchnge.setVisible(true);
		emailchnget.setVisible(true);
		pinchnge.setVisible(true);
		pwdchnge.setVisible(true);
		update.setVisible(true);
	}
	/*---------------------------------------------*/
	public void hidebenoptions() {
		benaccnum.setVisible(false);
		benaccnumt.setVisible(false);
		nick.setVisible(false);
		nickt.setVisible(false);
		addbenb.setVisible(false);
	}
	public void hideViewAccount() {
		bal.setVisible(false);
		minbal.setVisible(false);
		wdable.setVisible(false);
		minbalval.setVisible(false);
		balval.setVisible(false);
		wdablet.setVisible(false);
	}
	public void hideTransferOptions() {
			chacc.setVisible(false);
			chacct.setVisible(false);
			amt.setVisible(false);
			amtt.setVisible(false);
			amtt.setText("");
			transfer.setVisible(false);
			for(int o=0;o<12;o++)
			{
			b[o].setVisible(false);
			}
	}
	public void hideUpdateProfile(){
		emailchnge.setVisible(false);
		emailchnget.setVisible(false);
		pinchnge.setVisible(false);
		pwdchnge.setVisible(false);
		update.setVisible(false);
	}
}