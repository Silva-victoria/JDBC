package model;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Fatec
 */
public class Cliente {
    private int id;
    private String name;
    private String Sname;
    
    public static ArrayList<Cliente> getList() throws Exception{
        ArrayList<Cliente> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM customers";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()){
            int id = rs.getInt("CustomerId");
            String name = rs.getString("FirstName");
            String Sname = rs.getString("LastName");
            Cliente a = new Cliente (id,name,Sname);
            list.add(a);
        
        }
        rs.close(); 
        stmt.close(); 
        con.close();
        return list;
    }

    
    
     public static int getCount() throws Exception{
        int count = 0;
  
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        String query = "SELECT  count (*) as count FROM customers ";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()){
           count = rs.getInt("count");
        
        }
        rs.close(); 
        stmt.close(); 
        con.close();
        return count;
    }
    public Cliente (int id, String name, String Sname) {
        this.id = id;
        this.name = name;
        this.Sname = Sname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
        public String getSname() {
        return Sname;
    }

    public void setSname(String Sname) {
        this.Sname = Sname;
    }
    
}