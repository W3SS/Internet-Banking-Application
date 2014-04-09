import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;
import java.io.*;
import javax.swing.*;
public class ReportFrame extends Frame implements ActionListener{
	Connection c;
	Statement s;
	ResultSet r;
	ReportFrame ia=this;
	Main mn;
	InsideAccFrame iaf;
	TextArea ta=new TextArea(500,500);
	Button print=new Button("Print");
	ReportFrame(Main m,InsideAccFrame fr) {
	try{
		c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/bank_db","root","anand");
		s=c.createStatement();
	}
	catch(SQLException e){
		System.out.println(e);
	}
	this.setBounds(500,200,200,200);
		iaf=fr;
		setLayout(null);
		mn=m;
		setTitle("Transaction Complete.");
		setBackground(Color.LIGHT_GRAY);
		this.setSize(500,500);
		add(ta);
		ta.setBounds(30,30,350,400);
		ta.setEditable(false);
		print.setBounds(150,450,60,20);
		add(print);
		print.addActionListener(this);
		try{
			r=s.executeQuery("SELECT * FROM Temp;");
			long longvar=0;
			float f1=0f;
			Date d=new Date();
			if(r.next())
			{
				ta.setText("Transferred to\t:\t"+iaf.tostring+"\n\nAmount\t\t:\tRs."+iaf.amttransd+"\n\nDate\t\t:\t"+d.toString());
				longvar=r.getLong("AccountNumber");
				f1=r.getFloat("Balance");
			}
			float f2=Float.valueOf(iaf.amttransd);
			float f3=f1-f2;
			Statement s9=c.createStatement();
			ResultSet r9=s9.executeQuery("SELECT * FROM Details WHERE AccountNumber="+iaf.tostring);
			if(r9.next())
			{
				float f9=r9.getFloat("Balance");
				f9=f9+Float.valueOf(iaf.amttransd);
				s9.execute("UPDATE Details SET Balance="+f9+"WHERE AccountNumber="+iaf.tostring+";");
			}
			s.execute("UPDATE Temp SET Balance="+f3+";");
			s.execute("UPDATE Details SET Balance="+f3+" WHERE AccountNumber="+longvar+";");
		}catch(SQLException ee){
			System.out.println(ee);
		}
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we){
			try {
				s.execute("DROP TABLE `bank_db`.`Temp`;");
			}
			catch(Exception e){
				System.out.println(e);
			}
				mn.setVisible(true);
				ia.setVisible(false);
			}			
		});
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Print"))
		{
			try{
			JFileChooser j=new JFileChooser();
			j.showSaveDialog(null);
			File f=j.getSelectedFile();
			BufferedWriter br=new BufferedWriter(new FileWriter(f));
			br.write(ta.getText());
			br.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
}