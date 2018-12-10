<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<style>
body {
    background: url("image.jpg");
}
</style>
</head>
<body>
		<h1> Welcome to the BOOK SHOP</h1>
		${errmsg}
		<form action="login.do" method="post">
		User: <input type="text" name="userid"/><br/>
		Password: <input type="text" name="pass"/><br/>
		<input type="submit" value="submit"/><br/>
		<a href="new.jsp">New User</a>
		</form>
		
</body>
</html> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<style type="text/css">
	body {
	
		background: url("image.jpg");
		overflow-x: hidden;
	
	}
	label {
	
		font-weight: bold;
	
	}
</style>
</head>
<body>
	<div class="wrapper row justify-content-center">
		   <h1>Welcome To Book Mart</h1>
		<div class="container col-sm-4" style="background-color: rgba(0, 0, 0, 0); color: white; margin-top: 100px; padding-bottom: 50px">
		
			<div class="row justify-content-center" style="padding: 30px; padding-bottom: 0px;">
				<h1>Login</h1> <br/>
						
			</div>			
			
			<div class="row justify-content-center" style="padding: 5px;">							
				${errmsg}
			</div>
			
			<div class="container">
				<form action="login.do" method="post">
				
					<div class="form-group row">
					    <label for="username" class="offset-sm-1 col-sm-2 col-form-label">Username</label>
					    <div class="col-sm-8">
					      <input type="text" class="form-control" name="username" id="username" placeholder="Enter your user id" ">
					    </div>
					</div>
				
					<div class="form-group row">
						<label for="password" class="offset-sm-1 col-sm-2 col-form-label">Password</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" name="password" id="password" >
						</div>
					</div>
				
					<div class="row justify-content-center">
						
						<button class="btn btn-success" type="submit" style="margin: 10px;">Login</button>
						<button class="btn btn-light" type="reset" style="margin: 10px;">Reset</button>
						
					</div>
				
				</form>
				
				<div class="row  justify-content-center">
					New User: &nbsp;<a href="new.jsp">Create a new account</a>
				</div>
				
			</div>
		
		</div>
	
	</div>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<style type="text/css">
	body {
	
		background: url("image.jpg");
		overflow-x: hidden;
	
	}
	label {
	
		font-weight: bold;
	
	}
</style>
</head>
<body>
	<div class="wrapper row justify-content-center">
		   <h1>Welcome To Book Mart</h1>
		<div class="container col-sm-4" style="background-color: rgba(0, 0, 0, 0); color: white; margin-top: 100px; padding-bottom: 50px">
		
			<div class="row justify-content-center" style="padding: 30px; padding-bottom: 0px;">
				<h1>Login</h1> <br/>
						
			</div>			
			
			<div class="row justify-content-center" style="padding: 5px;">							
				${errmsg}
			</div>
			
			<div class="container">
				<form action="login.do" method="post">
				
					<div class="form-group row">
					    <label for="username" class="offset-sm-1 col-sm-2 col-form-label">Username</label>
					    <div class="col-sm-8">
					      <input type="text" class="form-control" name="userid" id="username" placeholder="Enter your user id" ">
					    </div>
					</div>
				
					<div class="form-group row">
						<label for="password" class="offset-sm-1 col-sm-2 col-form-label">Password</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" name="pass" id="password" >
						</div>
					</div>
				
					<div class="row justify-content-center">
						
						<button class="btn btn-success" type="submit" style="margin: 10px;">Login</button>
						<button class="btn btn-light" type="reset" style="margin: 10px;">Reset</button>
						
					</div>
				
				</form>
				
				<div class="row  justify-content-center">
					New User: &nbsp;<a href="new.jsp">Create a new account</a>
				</div>
				
			</div>
		
		</div>
	
	</div>
</body>
</html>

--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<style type="text/css">
body {
       background-image:linear-gradient(rgba(0,0,0,0.1),rgba(0,0,0,0.1)),url(im2.jpg);

 

       height:100vh;

 

       background-size:cover;

 

       background-position:center;
       
        align:center;
}
label {
font-weight: bold;
}
#align
{
 
        text-align: left corner;

}
</style>
</head>
<body>
<div class="wrapper row justify-content-center">
<font color="SlateBlue">
   <h1>Welcome To Book Mart
    
   </h1>
   </font>
<div class="container col-sm-4" style="background-color: rgba(0, 0, 0,0); color: white; margin-top: 100px; padding-bottom: 50px">
<div class="row justify-content-center" id="align" style="padding: 10px; padding-bottom: 0px;">
<h1>
<font color="Chocolate">
&nbsp;Login
</font>
</h1> <br/>
</div> 
<div class="row justify-content-center" style="padding: 5px;"> 

${errmsg}

</div>
<div class="container">

<form action="login.do" method="post">
<div class="form-group row">
    <label for="username"  class="offset-sm-1 col-sm-2 col-form-label ">
    <font color="black">
   &nbsp;   &nbsp;&nbsp;Username
    </font>
    </label>
    <div class="col-sm-8">
      <input type="text" class="form-control" name="username" id="username" placeholder="Enter your user id" >
    </div>
</div>
<div class="form-group row">
<label for="password" class="offset-sm-1 col-sm-2 col-form-label ">
<font color="black">
&nbsp;   &nbsp;&nbsp;Password
</font>
</label>
<div class="col-sm-8">
<input type="password" class="form-control" name="password" id="password" >
</div>
</div>
<div class="row justify-content-center">
<button class="btn btn-success" type="submit" style="margin: 10px;">Login</button>
<button class="btn btn-light" type="reset" style="margin: 10px;">Reset</button>
</div>
</form>
<div class="row  justify-content-center">
<font color="greenBlue">New User? Register Here </font>&nbsp;<a href="new.jsp"><font color="greenblack">&nbsp;Register</font></a>
</div>
</div>
</div>

</div>
</body>
</html>