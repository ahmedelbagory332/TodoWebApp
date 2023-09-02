<!-- <html> -->
	<!-- <head> -->
		<!-- <title> My first HTML Page - JSP</title> -->
	<!-- </head> -->
	<!-- <body>
		<!-- Welcome to login page ${name} -->
<!-- </body> -->
<!-- </html> -->

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
		<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >

</head>
<body>
    <div class="container text-center">
       <h1>Login</h1>

      <pre>${errorMessage}</pre>

        <form method="post" style="max-width: 600px; margin: 0 auto;">
        <div class="m-3">

            <div class="form-group row mb-3">
                <label class="col-4 col-form-label">Name: </label>
                <div class="col-8">
                    <input type="text" name="name" class="form-control" required />
                </div>
            </div>

            <div class="form-group row mb-3">
                <label class="col-4 col-form-label">Password: </label>
                <div class="col-8">
                    <input type="password" name="password" class="form-control"  required />
                </div>
            </div>

            <div>
                <button type="submit" class="btn btn-primary">Sign In</button>
            </div>
        </div>
        </form>
    </div>
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    		<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
