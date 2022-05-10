<%@page import="model.Funcionario"%>
<%@page import="java.util.ArrayList"%>
<%
    
    Exception requestEx = null;
    ArrayList<Funcionario> list = new ArrayList<>();
    int count = 0;
    try{
        
        count = Funcionario.getCount();
        list = Funcionario.getList();
    }catch(Exception ex){
        requestEx = ex;    
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionários</title>
    </head>
    <body>
        <h1>JDBC</h1>
        <h2>Total de funcionários (<%= count %> registros)</h2>
        <% if(requestEx !=null){%>
        <h2 style = "color:red"><%=requestEx.getMessage() %></h2>
         <%}%>
         <table border="1">
             <tr><th>id</th><th>name</th><th>Sobrenome</th></tr>
             <%for(Funcionario a: Funcionario.getList()){%>
             <tr>
                 
                 <td><%= a.getId() %></td>
                 <td><%= a.getName() %></td>
                  <td><%= a.getSname() %></td>
                 
             </tr>
             <%}%>  
         </table>
    </body>
</html>
