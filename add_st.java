import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class add_st extends Frame implements ActionListener{
  Button b;
  Label st,l_city,l_vil;
  TextField t_st,t_city,t_vil;
  String sql=null,st_name=null,city_name=null,vil_name=null;
  Connection conn = null;
  Statement stmt = null;
  ResultSet rs=null;

  add_st(){
    st=new Label("State");
    l_city=new Label("City");
    l_vil=new Label("Village");
    st.setBounds(40,50,50,22);
    l_city.setBounds(40,100,50,22);
    l_vil.setBounds(40,150,50,22);
    add(st);
    add(l_city);
    add(l_vil);
    t_st=new TextField(100);
    t_city=new TextField(100);
    t_vil=new TextField(100);
    t_st.setBounds(140,50,75,22);
    t_city.setBounds(140,100,75,22);
    t_vil.setBounds(140,150,75,22);
    add(t_st);
    add(t_city);
    add(t_vil);
    b=new Button("save");
    b.setBounds(100,200,50,22);
    add(b);
    b.addActionListener(this);
    setLayout(null);
  }
  public void actionPerformed(ActionEvent ae){
    st_name=t_st.getText();
    System.out.println(""+st_name);
    city_name=t_city.getText();
    System.out.println(""+city_name);
    vil_name=t_vil.getText();
    System.out.println(""+vil_name);
    try{
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
  		stmt = conn.createStatement();
      if(st_name.length()!=0){
        sql="insert into class_work.state_list values('"+st_name+"');";
        System.out.println(""+sql);
        stmt.executeUpdate(sql);
        if(city_name.length()!=0){
          sql="insert into class_work.city_list values('"+st_name+"','"+city_name+"');";
          System.out.println(""+sql);
          stmt.executeUpdate(sql);
          if(vil_name.length()!=0){
            sql="insert into class_work.city_village values('"+st_name+"','"+city_name+"','"+vil_name+"');";
            System.out.println(""+sql);
            stmt.executeUpdate(sql);
      }
    }
  }
    }catch(Exception e){
      System.out.println(""+e);
    }finally{
      try{
        conn.close();
        stmt.close();
        con_2 c=new con_2();
        c.setSize(400,300);
        c.setVisible(true);
        this.dispose();
      }catch(Exception e){
      }
    }
  }
  public static void main(String[] args) {
  }
}
