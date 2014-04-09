import java.awt.*;
import java.awt.event.*;
public class PrFrame extends Frame implements Runnable{
	Thread t;
	String msg="";
	Main mn;
	Font f1=new Font("Arial",Font.BOLD,12);
	PrFrame(Main m)
	{
		this.setSize(325,175);
		this.setBounds(500,200,325,175);
		setFont(f1);
		setBackground(Color.LIGHT_GRAY);
		t=new Thread(this);
		setTitle("Please wait...");
		t.start();		
		mn=m;
	}
	public void run(){
		int j=0;
		try {
			while(j<3){
				msg="Please wait while you are being redirected";
				int i=0;
				while(i<3){
					
					msg+=".";
					repaint();
					Thread.sleep(500);
					i++;
				}
				j++;
			}
			InsideAccFrame iaf=new InsideAccFrame(mn);
			iaf.setVisible(true);
			this.setVisible(false);
		}
		catch(InterruptedException e) {
			System.out.println("Aborted");
		}
	}
	public void paint(Graphics g){
		g.drawString(msg,25,100);
	}
}