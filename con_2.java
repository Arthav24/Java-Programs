import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class con_2 extends Frame implements ItemListener,ActionListener{
  List st=null,city=null,vil=null;
  Button b,b1;
  Label l_st,l_city,l_village;
  Connection conn = null;
  String sql=null,s_st=null,s_city=null;
  Statement stmt = null;
  ResultSet rs=null;

  con_2(){
    l_st=new Label("State");
    l_city=new Label("City");
    l_village=new Label("Village");
    create_con();
    st=new List();
    city=new List();
    vil=new List();
    update_state();
    l_st.setBounds(50,50,75,22);
    l_city.setBounds(50,100,75,22);
    l_village.setBounds(50,150,75,22);
    st.setBounds(150,50,150,22);
    city.setBounds(150,100,150,22);
    vil.setBounds(150,150,150,22);
    add(l_st);
    add(l_city);
    add(l_village);
    add(st);
    add(city);
    add(vil);
    b1=new Button("Exit");
    b=new Button("new");
    b.setBounds(125,200,50,22);
    b1.setBounds(200,200,50,22);
    add(b);
    add(b1);
    b1.addActionListener(this);
    b.addActionListener(this);
    st.addItemListener(this);
    city.addItemListener(this);
    vil.addItemListener(this);
    setLayout(null);
  }
  public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==b){
      add_st ad=new add_st();
    ad.setSize(250,250);
    ad.setVisible(true);
    this.setVisible(false);
    update_state();
  }
  else if(ae.getSource()==b1){
    try{
      conn.close();
      stmt.close();
    }catch(Exception e){
      System.out.println(""+e);
    }finally{
      System.exit(0);
      }
    }
  }
  public void itemStateChanged(ItemEvent ie){
    if(ie.getSource()==st){
    s_st =st.getSelectedItem();
    try{
    city.removeAll();
    sql="select * from class_work.city_list where state='"+s_st+"';";
    rs=stmt.executeQuery(sql);
    while(rs.next()){
      city.add(rs.getString("city"));
    }
  }catch(Exception e){
      System.out.println(""+e);
  }}
    else if(ie.getSource()==city){
      s_city=city.getSelectedItem();
      try{
        vil.removeAll();
        sql="select * from class_work.city_village where city='"+s_city+"' and state='"+s_st+"';";
        rs=stmt.executeQuery(sql);
        while(rs.next()){
          vil.add(rs.getString("village"));
        }
      }catch(Exception e){
          System.out.println(""+e);
      }
    }
  }
  void update_state(){
    st.removeAll();
    city.removeAll();
    vil.removeAll();
    try{
    sql="select * from class_work.state_list;";
    rs=stmt.executeQuery(sql);
    while(rs.next()){
      st.add(rs.getString("state"));
    }}catch(Exception e){System.out.println(""+e);}
  }
  void create_con(){
    try{
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
    stmt = conn.createStatement();
  }catch(Exception e){
    System.out.println(""+e);
  }
}
  public static void main(String args[]){
    con_2 e=new con_2();
    e.setSize(400,300);
    e.setVisible(true);
  }
}
