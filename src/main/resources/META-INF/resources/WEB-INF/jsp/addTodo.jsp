<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
		<link href="/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css"  rel="stylesheet">
	    <title>Add Todo Page</title>
	</head>
	<body>
     <%@ include file="common/navigation.jspf" %>
		<div class="container text-center">
			<h1>Enter Todo Details</h1>
	<form:form method="post" modelAttribute="todo" style="max-width: 600px; margin: 0 auto;">
		<div class="m-3">

            <div class="form-group row mb-3">
                <form:label class="col-4 col-form-label" path="description">Description</form:label>
                <div class="col-8">
                <form:input type="text" path="description" required="required"/>
                </div>
                <form:errors path="description" cssClass="text-warning"/>
            </div>

            <div class="form-group row mb-3">
                <form:label class="col-4 col-form-label" path="targetDate">Target Date</form:label>
                <div class="col-8">
                <form:input type="text" path="targetDate" required="required"/>
                </div>
                <form:errors path="targetDate" cssClass="text-warning"/>
            </div>

            <div class="form-group row mb-3">
                <form:label class="col-4 col-form-label" path="done">Is Done</form:label>
                <div class="col-8">
                <form:input type="text" path="done" required="required"/>
                </div>
                <form:errors path="done" cssClass="text-warning"/>
            </div>

            </fieldset>
                <input type="submit" class="btn btn-success"/>
                <form:input type="hidden" path="id"/>
             </fieldset>

        </div>
	</form:form>

		</div>
		<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
		<script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
        		$('#targetDate').datepicker({
        		    format: 'yyyy-mm-dd'
        		});
        		</script>
	</body>
</html>

