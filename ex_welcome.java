import java.awt.*;
import java.awt.event.*;


public class ex_welcome extends Frame implements ActionListener{
	
	Label l1,l2;
	Button b1;
	ex_welcome(String s){
		l1=new Label("Welcome");
		l2=new Label(s);
		
		l1.setBounds(50,50,75,25);
		add(l1);
		l2.setBounds(50,100,150,25);
		add(l2);
	
		b1= new Button("Exit");
		b1.addActionListener(this);
		b1.setBounds(50,150,75,25);
		add(b1);
		setLayout(null);
		
	}
	public static void main(String args[]){
		
		}
	public void actionPerformed(ActionEvent ae){
	System.exit(1);}
	}