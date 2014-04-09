import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
public class PinFrame extends Frame implements ActionListener,MouseListener{
	Connection conn;
	Statement stat;
	ResultSet r;
	Label cvc=new Label("Enter PIN Number");
	PinFrame ia=this;
	InsideAccFrame f;
	int i=0,j=0;
	String pin="",amttransd="";
	TextField tf=new TextField(10);
	Button submit=new Button("Enter");
	Label b[]=new Label[39];
	Button bak=new Button("Back");
	Font f1=new Font("Arial",Font.BOLD,10);
	Font f4=new Font("Arial",Font.BOLD,15);
	Main mn;
	PinFrame(Main m,InsideAccFrame fr){
		mn=m;
		this.setBounds(500,200,200,200);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		try{
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/bank_db","root","anand");
			stat=conn.createStatement();
		}
		catch(SQLException e){
			System.out.println(e);
		}
		this.setSize(400,240);
		f=fr;
		add(cvc);
		setTitle("--------------------------------");
		setFont(f1);
		tf.setEditable(false);
		cvc.setBounds(10,40,120,20);
		add(tf);
		tf.setBounds(150,40,30,20);
		tf.setEchoChar('*');
		b[0]=new Label("1");
			b[0].setBounds(20,70,20,20);
			add(b[0]);
			b[0].addMouseListener(this);
			b[1]=new Label("2");
			b[1].setBounds(50,70,20,20);
			add(b[1]);
			b[1].addMouseListener(this);
			b[2]=new Label("3");
			b[2].setBounds(80,70,20,20);
			add(b[2]);
			b[2].addMouseListener(this);
			b[3]=new Label("4");
			b[3].setBounds(110,70,20,20);
			add(b[3]);
			b[3].addMouseListener(this);
			b[4]=new Label("5");
			b[4].setBounds(140,70,20,20);
			add(b[4]);
			b[4].addMouseListener(this);
			b[5]=new Label("6");
			b[5].setBounds(170,70,20,20);
			add(b[5]);
			b[5].addMouseListener(this);
			b[6]=new Label("7");
			b[6].setBounds(200,70,20,20);
			add(b[6]);
			b[6].addMouseListener(this);
			b[7]=new Label("8");
			b[7].setBounds(230,70,20,20);
			add(b[7]);
			b[7].addMouseListener(this);
			b[8]=new Label("9");
			b[8].setBounds(260,70,20,20);
			add(b[8]);
			b[8].addMouseListener(this);
			b[9]=new Label("0");
			b[9].setBounds(290,70,20,20);
			add(b[9]);
			b[9].addMouseListener(this);
			b[10]=new Label("Bksp");
			b[10].setBounds(320,70,40,20);
			add(b[10]);
			b[10].addMouseListener(this);
			b[11]=new Label("q");
			b[11].setBounds(30,100,20,20);
			add(b[11]);
			b[11].addMouseListener(this);
			b[12]=new Label("w");
			b[12].setBounds(60,100,20,20);
			add(b[12]);
			b[12].addMouseListener(this);
			b[13]=new Label("e");
			b[13].setBounds(90,100,20,20);
			add(b[13]);
			b[13].addMouseListener(this);
			b[14]=new Label("r");
			b[14].setBounds(120,100,20,20);
			add(b[14]);
			b[14].addMouseListener(this);
			b[15]=new Label("t");
			b[15].setBounds(150,100,20,20);
			add(b[15]);
			b[15].addMouseListener(this);
			b[16]=new Label("y");
			b[16].setBounds(180,100,20,20);
			add(b[16]);
			b[16].addMouseListener(this);
			b[17]=new Label("u");
			b[17].setBounds(210,100,20,20);
			add(b[17]);
			b[17].addMouseListener(this);
			b[18]=new Label("i");
			b[18].setBounds(240,100,20,20);
			add(b[18]);
			b[18].addMouseListener(this);
			b[19]=new Label("o");
			b[19].setBounds(270,100,20,20);
			add(b[19]);
			b[19].addMouseListener(this);
			b[20]=new Label("p");
			b[20].setBounds(300,100,20,20);
			add(b[20]);
			b[20].addMouseListener(this);
			b[21]=new Label("a");
			b[21].setBounds(50,130,20,20);
			add(b[21]);
			b[21].addMouseListener(this);
			b[22]=new Label("s");
			b[22].setBounds(80,130,20,20);
			add(b[22]);
			b[22].addMouseListener(this);
			b[23]=new Label("d");
			b[23].setBounds(110,130,20,20);
			add(b[23]);
			b[23].addMouseListener(this);
			b[24]=new Label("f");
			b[24].setBounds(140,130,20,20);
			add(b[24]);
			b[24].addMouseListener(this);
			b[25]=new Label("g");
			b[25].setBounds(170,130,20,20);
			add(b[25]);
			b[25].addMouseListener(this);
			b[26]=new Label("h");
			b[26].setBounds(200,130,20,20);
			add(b[26]);
			b[26].addMouseListener(this);
			b[27]=new Label("j");
			b[27].setBounds(230,130,20,20);
			add(b[27]);
			b[27].addMouseListener(this);
			b[28]=new Label("k");
			b[28].setBounds(260,130,20,20);
			add(b[28]);
			b[28].addMouseListener(this);
			b[29]=new Label("l");
			b[29].setBounds(290,130,20,20);
			add(b[29]);
			b[29].addMouseListener(this);
			b[32]=new Label("z");
			b[32].setBounds(70,160,20,20);
			add(b[32]);
			b[32].addMouseListener(this);
			b[33]=new Label("x");
			b[33].setBounds(100,160,20,20);
			add(b[33]);
			b[33].addMouseListener(this);
			b[34]=new Label("c");
			b[34].setBounds(130,160,20,20);
			add(b[34]);
			b[34].addMouseListener(this);
			b[35]=new Label("v");
			b[35].setBounds(160,160,20,20);
			add(b[35]);
			b[35].addMouseListener(this);
			b[36]=new Label("b");
			b[36].setBounds(190,160,20,20);
			add(b[36]);
			b[36].addMouseListener(this);
			b[37]=new Label("n");
			b[37].setBounds(220,160,20,20);
			add(b[37]);
			b[37].addMouseListener(this);
			b[38]=new Label("m");
			b[38].setBounds(250,160,20,20);
			add(b[38]);
			b[38].addMouseListener(this);
			for(i=0;i<39;i++)
			{
				if(i==31||i==30)
					continue;
				b[i].setFont(f4);
			}
		add(submit);
		submit.setBounds(200,40,40,20);
		submit.addActionListener(this);
		add(bak);
		bak.setBounds(300,40,40,20);
		bak.addActionListener(this);
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
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Enter"))
		{
			if(tf.getText().equals("")||tf.getText().length()!=3)
			{	
				JOptionPane.showMessageDialog(null,"Three characters required!","Warning",JOptionPane.WARNING_MESSAGE);
			}
			else if(tf.getText().length()==3){
			try{
				r=stat.executeQuery("SELECT * FROM Temp;");
				if(r.next()){
					if(r.getString("Pin").equals(tf.getText())){
						TfFrame tf=new TfFrame(mn,f);
						tf.setVisible(true);
						this.setVisible(false);
					}
				}
			}catch(SQLException see){
				System.out.println(see);
			}
			}
		}
		else if(s.equals("Back"))
		{
			InsideAccFrame iac=new InsideAccFrame(mn);
			this.setVisible(false);
			iac.setVisible(true);
		}
	}
	public void paint(Graphics g){
		g.drawString("This is to confirm that only authoized account holder has logged in.",20,210);
		g.drawString("Please Use the Virtual Keypad provided for Security",20,230);
	}
	public void mouseClicked(MouseEvent fe){
	}
	public void mousePressed(MouseEvent fe){
		
		for(i=0;i<39;i++)
		{
			if(fe.getSource()==b[10])
			{
				if(tf.getText().length()!=0){
				String str=tf.getText();
				str=str.substring(0,str.length()-1);
				tf.setText(str);
				}
				break;
			}	
			else if(i==31||i==32)
			{
				continue;
			}
			else if(fe.getSource()==b[i])
			{
				b[i].setForeground(Color.WHITE);
				j=i;
				String s=b[j].getText();
				tf.setText(tf.getText()+s);
				pin=tf.getText();
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