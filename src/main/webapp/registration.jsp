<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>
	<div class="container">
		<div class="row text-center" style="color: tomato;">
			<h2>User Registration</h2>
		</div>
		<hr>
		<div class="row col-md-10 col-md-offset-3">

			<div class="card card-body">

				<h2>User Register Form</h2>
				<div class="col-md-8 col-md-offset-3">

					<form action="<%=request.getContextPath()%>/register" method="post">

						<div class="form-group">
							<label for="uname">First Name:</label> <input type="text"
								class="form-control" id="firstName" placeholder="First Name"
								name="firstName" required>
						</div>

						<div class="form-group">
							<label for="uname">Last Name:</label> <input type="text"
								class="form-control" id="lastName" placeholder="last Name"
								name="lastName" required>
						</div>

						<div class="form-group">
							<label for="uname">Date of Birth:</label> <input type="dob"
								class="form-control" id="dob" placeholder="yyyy-mm-dd"
								name="dob" required>
						</div>

						<div class="form-group">
							<label for="uname">Address:</label> <input type="address"
								class="form-control" id="" address"" placeholder="Address"
								name="address" required>
						</div>

						<div class="form-group">
							<label for="uname">Phone Number:</label> <input type="text"
								class="form-control" id="phoneNumber" placeholder="Phone Number"
								name="phoneNo" required>
						</div>

						<div class="form-group">
							<label for="uname">Email Address:</label> <input type="text"
								class="form-control" id="emailAddress"
								placeholder="Email Address" name="emailAddress" required>
						</div>

						<div class="form-group">
							<label for="uname">User Name:</label> <input type="text"
								class="form-control" id="username" placeholder="Username"
								name="username" required>
						</div>

						<div class="form-group">
							<label for="uname">Password:</label> <input type="password"
								class="form-control" id="password" placeholder="Password"
								name="password" required>
						</div>


						<button type="submit" class="btn btn-primary">Submit</button>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>