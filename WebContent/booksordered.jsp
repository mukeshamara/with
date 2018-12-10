<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>

<style type="text/css">
body {
  background-image:linear-gradient(rgba(0,0,0,0.1),rgba(0,0,0,0.1)),url(im.jpg);

 

       height:100vh;

 

       background-size:cover;

 

       background-position:center;
}
label {
font-weight: bold;
}
</style>
</head>
<body>
 <h1><center>Welcome To Book Mart
    </center>
   </h1>
<div class="collapse navbar-collapse" id="navbarSupportedContent">
          
           <div class="navbar-right" style="color: white; font-size: 20px;">
              <div  class="nav-item dropdown" style="cursor: pointer">
                     <div class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                           
                            <span style="border: 1px solid white; border-radius: 100%; margin-right: 10px; text-align: center">
                                  <span class="fa fa-user" style="padding-left: 10px; padding-right: 5px;"></span>
                            </span>
                                                
                            ${ sessionScope.xyz.userid}
                            
                       </div>
                     
                        <a class="active" href="lo.jsp"><font face="verdana" color="MediumBlue">Home Page </font>  </a>&emsp;
                        <a href="userincart.jsp"> <font face="verdana" color="MediumBlue">Go to cart</font></a>&emsp;
                        <a href="${pageContext.request.contextPath}/beforecancel.do"><font face="verdana" color="MediumBlue" >Ordered Details to cancel</font></a>&emsp;
                        <a href="order.jsp"><font face="verdana" color="MediumBlue">Make Payment</font></a>&emsp;
                     	<a href="profile.jsp"><font face="verdana" color="MediumBlue">Profile</font></a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                     	<a href="${pageContext.request.contextPath}/ordered.do"><font face="verdana" color="MediumBlue">Ordered Details</font></a>&emsp;
                     	<a href="${pageContext.request.contextPath}/logout.do"><font face="verdana" color="MediumBlue">Logout</font></a>&emsp;
                      </div>
              </div>
           </div>
         </div>
       </nav>

<sql:setDataSource driver="com.mysql.jdbc.Driver"

            url="jdbc:mysql://localhost:3306/mfrpproject"

            user="root" password="root"

            var="mysrc"

    />



    <sql:query var="stmt" dataSource="${mysrc}">

        select p.book_id,p.book_name,p.Language,p.Delivery_Time,p.Author_Name,p.price,a.quantity_needed,a.order_id from product p join add_to_cart a on(a.book_id=p.book_id) where a.price_per_book>0 and order_id='${sessionScope.y1}';

    </sql:query>
    <br></br>
    
    <table border='1'>

        <tr>

           <th>Book Id</th><th>Book Name</th><th>Language</th><th>Delivery_Time</th><th>Author Name</th><th>Price of the Book</th><th>Quantity Ordered</th><th>Order ID</th>

        </tr>

        <c:forEach var="rs" items="${stmt.rows}">
	
            <tr>
				
                

                <td><font color="white">${rs.book_id}</font></td>
					
                <td><font color="white">${rs.book_name}</font></td>
                
                <td><font color="white">${rs.Language}</font></td>
                <td><font color="white">${rs.Delivery_Time}</font></td>
                <td><font color="white">${rs.Author_Name}</font></td>
                <td><font color="white">${rs.price}</font></td>
                <td><font color="white">${rs.quantity_needed}</font></td>
              <td><font color="white">${rs.order_id}</font></td>

            </tr>

        </c:forEach>
        
	

    </table>
    <br></br>
   
</div>