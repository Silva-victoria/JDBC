/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Fatec
 */
public class Funcionario {
    private int id;
    private String name;
    private String Sname;
    
    public static ArrayList<Funcionario> getList() throws Exception{
        ArrayList<Funcionario> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM employees";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()){
            int id = rs.getInt("EmployeeId");
            String name = rs.getString("FirstName");
            String Sname = rs.getString("LastName");
            Funcionario a = new Funcionario (id,name,Sname);
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
        String query = "SELECT  count (*) as count FROM employees ";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()){
           count = rs.getInt("count");
        
        }
        rs.close(); 
        stmt.close(); 
        con.close();
        return count;
    }
    public Funcionario(int id, String name, String Sname) {
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