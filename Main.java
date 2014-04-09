import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
public class Main extends Frame implements ActionListener,Runnable{
	MainFrame process;
	String msg="";
	Button b[]=new Button[3];
	Thread t;
	Font f=new Font("Arial",Font.BOLD,15);
	Font f1=new Font("Arial",Font.BOLD,10);
	Label l=new Label();	
	Image img;
	Main(){
		init();
		t=new Thread(this,"Message");
		t.start();
	}
	public void init(){
		setLayout(null);
		setFont(f1);
		setBackground(Color.LIGHT_GRAY);
		setTitle("Welcome to E-Banking Portal");
		this.setBounds(500,200,300,200);
		b[0]=new Button("Personal Banking");
		b[0].setBounds(40,60,110,20);
		add(b[0]);
		b[0].addActionListener(this);
		add(l);
		l.setBounds(200,40,250,20);
		l.setFont(f);
		l.setForeground(Color.BLUE);
		b[1]=new Button("Corporate Banking");
		b[1].setBounds(40,90,110,20);
		add(b[1]);
		b[1].addActionListener(this);
		b[2]=new Button("Register");
		b[2].setBounds(70,120,50,20);
		add(b[2]);
		img=Toolkit.getDefaultToolkit().createImage("download.jpg");
		b[2].addActionListener(this);
		setSize(500,200);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
	}
	public void run(){
		msg="Contact the bank to credit money into your account... ";
		while(true)
		{
			l.setText(msg);
			try{
				Thread.sleep(100);
			}catch(Exception e){
				System.out.println(e);
			}
			char c=msg.charAt(0);
			msg=msg.substring(1,msg.length());
			msg+=c;
			l.setText("");
		}
	}
	public static void main(String args[]){
		Main m=new Main();
		m.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s=="Personal Banking"){
			process=new MainFrame(this);
			process.setVisible(true);
			this.setVisible(false);
		}
		if(s=="Register")
		{
			Register r=new Register(this);
			r.setVisible(true);
			this.setVisible(false);
		}
		if(s=="Corporate Banking"){
			JOptionPane.showMessageDialog(null,"Sorry! This Link is under Construction...");
		}
	}
	public void paint(Graphics g){
		g.drawImage(img,300,120,this);
	}
}