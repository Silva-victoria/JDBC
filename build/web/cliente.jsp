<%@page import="model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%
    
    Exception requestEx = null;
    ArrayList<Cliente> list = new ArrayList<>();
    int count = 0;
    try{
        
        count = Cliente.getCount();
        list = Cliente.getList();
    }catch(Exception ex){
        requestEx = ex;    
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
    </head>
    <body>
        <h1>JDBC</h1>
        <h2>Total de Cliente (<%= count %> registros)</h2>
        <% if(requestEx !=null){%>
        <h2 style = "color:red"><%=requestEx.getMessage() %></h2>
         <%}%>
         <table border="1">
             <tr><th>id</th><th>name</th><th>Sobrenome</th></tr>
             <%for(Cliente a: Cliente.getList()){%>
             <tr>
                 
                 <td><%= a.getId() %></td>
                 <td><%= a.getName() %></td>
                  <td><%= a.getSname() %></td>
                 
             </tr>
             <%}%>  
         </table>
    </body>
</html>
