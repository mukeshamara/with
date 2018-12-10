<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="cancel.do" method="post">
	User: <input type="text" name="cus_id"/><br/>
		order id: <input type="text" name="order_id"/><br/>
		<input type="submit" value="submit"/><br/>
	</form>
	
</body>
</html>

--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OrderCancellation</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>

<style type="text/css">
body {
  background-image:linear-gradient(rgba(0,0,0,0.1),rgba(0,0,0,0.1)),url(im.jpeg);

 

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
<div class="row">
<div class="container offset-md-6 col-lg-6" style="background-color: rgba(0, 0, 0, 0); color: white;">
<div class="container" style="padding: 30px;">
<h1>
<center>
<font color="black">
Order Cancellation
</font>
</center>
</h1>
</div>
<br></br>
	<sql:setDataSource driver="com.mysql.jdbc.Driver"

            url="jdbc:mysql://localhost:3306/mfrpproject"

            user="root" password="root"

            var="mysrc"

    />
    <sql:query var="stmt" dataSource="${mysrc}">

        select * from order_payment_screen where customer_id='${sessionScope.xyz.userid}';

    </sql:query>
  

<div class="container">
<form action="intocancel.do" method="post">
<div class="form-group row">
    <label for="id"  class="col-sm-2 col-form-label">
    <font color="black">
    
    ${errmsg5}
      <br></br>
    Customer ID
     </font>
    </label>
    
    <div class="col-sm-6">
    <font color="white"> ${sessionScope.xyz.userid}</font>
    </div>
</div>
<div class="form-group row">
    <label for="text"  class="col-sm-2 col-form-label">
    <font color="black">
   
    Order ID
     </font>
    </label>
    
    <div class="col-sm-6">
       <select name="order_id" id="order_id" class="form-control" required>

                <option value="none">Select the order_id</option>
			
                <c:forEach var="rs" items="${stmt.rows}">

                    <option value="${rs.order_id}">${rs.order_id}</option>

                </c:forEach>

            </select>

            <br/>



          </div>
</div>
<div class="form-group row">
    <label for="text"  class="col-sm-2 col-form-label">
    <font color="black">
   
    Account Number
     </font>
    </label>
    
    <div class="col-sm-6">
      <input type="text" class="form-control" name="name" id="name" required />
    </div>
</div>
<div class="form-group row">
    <label for="text"  class="col-sm-2 col-form-label">
    <font color="black">
   
    Bank Name
     </font>
    </label>
    
    <div class="col-sm-6">
      <input type="text" class="form-control" name="name" id="name" required />
    </div>
</div>
<div class="form-group row">
    <label for="text"  class="col-sm-2 col-form-label">
    <font color="black">
   
    Bank IFSC Code
     </font>
    </label>
    
    <div class="col-sm-6">
      <input type="text" class="form-control" name="name" id="name" required />
    </div>
</div>
<p>
</p>
<div class="form-group container" style="display: inline-block;">
<input class="btn btn-success" type="submit" value="Submit" />
<input class="btn btn-light" type="reset" value="Reset" />
</div>
</form>
</div>
</div>
</div>
</body>
</html>
