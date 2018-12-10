<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1" import="java.util.*,com.model.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Search</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

 

    <script>

        $(document).ready(function(){

        $("#fromloc").change(function(){

           

            $.ajax({

                    type: "GET",

                    url: "GetBooks",

                    data: "fromloc="+$("#fromloc").val(),

                    dataType: "text",

                    success: function(result){

                    var jd = $.parseJSON(result);

                        $(jd).each(function (index, data) {

                        var row = "";

                            row += "<tr><td>" +"<font color=white>"+ data.bid +"</font>"+ "</td>";

                            row += "<td>"+"<font color=white>"+data.bname+"</font>"+ "</td>";

                            row += "<td>"+"<font color=white>"+data.price+"</font>"+ "</td>";

                            row += "<td id='tot"+index+"' >"+data.tobo+"</td>";

                            row += "<td><input type='text' name='seatcnt' id='seatcnt"+index+"'></td>";

                            row += "<td><input type='button' id='book"+index+"' value='Book' ";

                            row += "onclick='bookfun("+index+","+data.price+","+data.bid+","+data.tots+")' ";

                           row +="/></td></tr>";

                            $("#table1").append(row);

                            

                            $("#fids").append("<option value='"+data.bid+"'>"+data.bid+"</option>");

                           

                        });

                      

                    }

                

                });

        });

       

        

        });

        function bookfun(ind,pr,fno,tots)

    {

           

        var sreq = $("#seatcnt"+ind).val();  //3

        alert("Books "+sreq+" booked on "+fno);

        $.ajax({

                type: "POST",

                url: "updatedetails",

                data: "fid="+fno+"&cnt="+sreq+"&pri="+pr+"&tobooks="+tots,

                dataType: "text",

                success: function(result){

                alert(result);

                $("#tot"+ind).text(tots-sreq);

                $("#seatcnt"+ind).val("");

                }

            

               });

   

     }

    </script>
<style>
       body {
       
              
  background-image:linear-gradient(rgba(0,0,0,0.1),rgba(0,0,0,0.1)),url(im.jpeg);

 

       height:100vh;

 

       background-size:cover;

 

       background-position:center;
       
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
              
       
   <sql:setDataSource driver="com.mysql.jdbc.Driver"

            url="jdbc:mysql://localhost:3306/mfrpproject"

            user="root" password="root"

            var="mysrc"

    />
    <sql:query var="stmt" dataSource="${mysrc}">

        select distinct customer_id from add_to_cart where customer_id='${sessionScope.xy}';

    </sql:query>

   
<br></br>
        From: <select name="fromloc" id="fromloc">

                <option value="none">Select...</option>
				<br></br>
                <c:forEach var="rs" items="${stmt.rows}">

                    <option value="${rs.customer_id}">${rs.customer_id}</option>

                </c:forEach>

            </select>

            <br/>

       
<br></br>
        <table id="table1" border="1">

            <tr>

                <th>Book Id</th><th>Book Name</th>

                <th>Price of the Book</th><th>Books Available</th>

                <th>Books Needed</th>

                <th>Action</th>

            </tr>

           

        </table>
		<br></br>
       			<a href="order.jsp"><font color="white">Pay Now</font></a>

           

   

    <%-- <a href="success.jsp?val=128">Click here</a>

 

    <form action="login.do" method="post">

            User name:<br>

            <input type="text" name="userid" pattern="[a-zA-Z][0-9]{5}" title="Invalid user id"> <br/>

            User password:<br/>

            <input type="password" name="psw"> <br/>

            <input type="submit" value="Login Now" /> &nbsp; &nbsp;

            <input type="reset" value="Clear Fields" />

    </form>

    <br/>

    ${errmsg}

--%>

 

 

 

   

</body>

</html>