import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
public class TfFrame extends Frame implements Runnable{
	Image img;
	Connection c;
	Statement s;
	TfFrame ia=this;
	Main mn;
	boolean isalive=true;
	InsideAccFrame iaf;
	int i=1,j=1;
	Thread t=new Thread(this);
	TfFrame(Main m,InsideAccFrame fr){
	isalive=true;
	try{
		c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/bank_db","root","anand");
		s=c.createStatement();
	}
	catch(SQLException se){
		System.out.println(se);
	}
		this.setSize(300,200);
		iaf=fr;
		this.setBounds(500,200,300,200);
		mn=m;
		setTitle("Please Wait...");
		setBackground(Color.LIGHT_GRAY);
		Font f=new Font("Arial",Font.BOLD,15);
		t.start();
		setFont(f);
		this.addWindowListener(new WindowAdapter(){
			@Override
			synchronized public void windowClosing(WindowEvent we){
				isalive=false;
				ia.setVisible(false);
				mn.setVisible(true);
				try{
				s.execute("DROP TABLE Temp;");
				}
				catch(SQLException see)
				{
					System.out.println(see);
				}
			}			
		});
	}
	public void run(){
		i=1;j=1;
		while(i<=56){
		img=Toolkit.getDefaultToolkit().createImage(j+".png");
		repaint();
		j=(j+1)%9;
		j=j==0?1:j;
		i++;
		try{
		Thread.sleep(100);
		}catch(Exception e){
			System.out.println(e);
		}
		}
		if(isalive){
		ReportFrame rf=new ReportFrame(mn,iaf);
		rf.setVisible(true);
		this.setVisible(false);
		}
	}
	public void update(Graphics g) {
		g.drawImage(img,75,30,this);
		g.drawString("Processing...",115,105);
	}
	public void paint(Graphics g) {
		update(g);
	}
}
