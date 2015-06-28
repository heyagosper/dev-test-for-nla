<!DOCTYPE html>
<html lang="en">
<head>
<title>Maven + Spring MVC</title>
 
<link href="resources/core/css/loans.css" rel="stylesheet" />
<link href="resources/core/css/bootstrap.min.css" rel="stylesheet" />

</head>
 
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Loans System for NLA</a>
	</div>
  </div>
</nav>
 
<div class="jumbotron">
  <div class="container">
	<h1>Customer Loan Search</h1>
	<div class="row">
		<div class="col-md-12">
			<h2> Actions </h2> 

			<p>
				Click a button to see the customers or books in the system. 
				Once the customer search results are shown click "View loans"
				to see the books that are on loan to that customer. 
			</p>

			<button id="getPersonsButton" class="btn btn-default">List Customers</button>
			<button id="getBooksButton" class="btn btn-default">List Books</button>

    	</div>
	</div>
  </div>	
</div>

<div class="container">
 
  <div id="personsTable" class="row">
	<div class="col-md-6">
	    <div id="personData" class="table-responsive"></div>
    </div>
    
    <!-- right hand panel displaying loan details -->
	<div id="loansPanel" class="col-md-6">
	  <div id="loanedBookData" class="table-responsive"></div>
    </div>
  </div>
    
	<div id="booksTable" class="row">
		<div class="col-md-6">
		    <div id="bookData" class="table-responsive"></div>
         </div>
	</div>
  
</div>  


<hr>

<div class="col-md-6">
  
  <footer>
	<p>&copy; Heya Gosper 2015</p>
  </footer>
</div>

<script type='text/javascript' 
	src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js'>
</script>

<script src='resources/core/js/bootstrap.min.js' type="text/javascript"></script>
<script src='resources/core/js/loans.js' type="text/javascript"></script>
 
</body>

</html>