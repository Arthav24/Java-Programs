import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class con_1  extends Frame implements ActionListener {
		TextField t1,t2;
		Label l1,l2;
		Button b;
		  Connection conn = null;
		  String sql;
	Statement stmt = null;
	String n=null;
	int i=0;
		con_1(){
		
		t1=new TextField(25);
		t2=new TextField(25);
		l1=new Label("Roll no");
		l2=new Label("Name");
		t1.setBounds(140,95,75,25);
		t2.setBounds(140,140,75,25);
		l1.setBounds(50,80,75,50);
		l2.setBounds(50,125,75,50);
		b=new Button("Save");
		b.setBounds(100,185,90,30);
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(b);
		b.addActionListener(this);
		setLayout(null);
		try{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
		stmt = conn.createStatement();
		
		
      sql = "select * from class_work.save where rno=(select max(rno) from class_work.save);";
	    //sql = "select max(rno) from class_work.save;";

		ResultSet rs = stmt.executeQuery(sql);	
		if(rs.next()==true){
			
			i=Integer.parseInt(rs.getString("rno"));
			i++;
			t1.setText(""+i);
			
		}
		else{
		i=100;
		t1.setText(""+i);}
		}
		catch(Exception e){
      
   }finally{
		try{
            stmt.close();
      
            
      }catch(Exception e){}
       
   }
		
		}
	public void actionPerformed(ActionEvent ae){
				
		n=t2.getText();
		sql="insert into class_work.save values("+i+",'"+n+"');";
		try{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
		stmt = conn.createStatement();
		
		
	 stmt.executeUpdate(sql);
	 
	 sql = "select * from class_work.save where rno=(select max(rno) from class_work.save);";
	    //sql = "select max(rno) from class_work.save;";
	  ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()==true){
			
			i=Integer.parseInt(rs.getString("rno"));
			i++;
			t1.setText(""+i);
			
		}
		else{
		i=100;
		t1.setText(""+i);}
	 
		}
		catch(Exception e){
      
   }finally{
		try{
            stmt.close();
			t2.setText("");
			t2.requestFocus();
      
            conn.close();
      }catch(Exception e){}
       
   }
		
		
		
		
		}
		public static void main(String args[]){
		con_1 e =new con_1();
		e.setSize(500,500);
		e.setVisible(true);
	}		
		
	
		}