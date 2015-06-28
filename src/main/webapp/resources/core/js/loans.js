var personsTable = $("#personsTable");
var booksTable = $("#booksTable");
var loansPanel = $("#loansPanel");

personsTable.hide();
loansPanel.hide();
booksTable.hide();

var renderPersonsTable = function() { 
	$.get("/loans/persons", 
	  function(data) {

		var htmlData = '';
		if (data && data.length > 0) {
	
	     htmlData += '<table class="table">'
			+'<caption>Customers</caption>'
	        +'<tr>'
	        +   '<th>Name</th>'  
		    +   '<th>Phone Number</th>'
		    +   '<th>Email Address</th>'
		    +   '<th>Action</th>'
	    	+'</tr>'
		  	for (var i = 0; i < data.length; i++) {
		  		var loansButtonId = 'loansButton_' + data[i].id;
		  		
		  		htmlData += '<tr><td>' + data[i].name + '</td>'
		  		    + '<td>' + data[i].phoneNumber + '</td>'
		  		    + '<td>' + data[i].emailAddress + '</td>'
		  		    + '<td>	 <button id="' + loansButtonId + '"'
		  		    + ' class="btn btn-default"'
		  		    + ' onclick="renderLoansForPerson(' + data[i].id + ');">' 
		  		    + ' View loans </button></td></tr>'; 	
		  	}
		  	
		  	htmlData += '</table>';
		    
		} 
		else {
		  	htmlData += 'No results found';		
		}
		
		$("#personData").empty().html(htmlData);		  
	    $("#personsTable").show();
	    $("#personsData").show();	    
	    $("#loansPanel").hide()	    
	    $("#booksTable").hide()

	  }
	)
};

$("#getPersonsButton").click(function() {
	renderPersonsTable();
});

var renderBooksTable = function() { 
	$.get("/loans/books", 
	  function(data) {
	  
	    var htmlData = '';
	  
		if (data && data.length > 0) {
	
	     htmlData += '<table class="table">'
			+'<caption>Our Catalogue</caption>'
	        +'<tr>'
	        +   '<th>Title</th>'  
		    +   '<th>Author</th>'
		    +   '<th>ISBN</th>'
	    	+'</tr>'
		  	for (var i = 0; i < data.length; i++) {
		  		htmlData += '<tr><td>' + data[i].title + '</td>'
		  		    + '<td>' + data[i].author + '</td>'
		  		    + '<td>' + data[i].isbn + '</td></tr>'; 	
		  	}
		  	
		  	htmlData += '</table>';
		    
		} 
		else {
		  	htmlData += 'No results found';		
		}
		
		$("#bookData").empty().html(htmlData);
	  
	    $("#booksTable").show();	
	    $("#personsTable").hide();
	  }
	)
};

$("#getBooksButton").click(function() {
	renderBooksTable();
});

var renderLoansForPerson = function(personId) { 
	$.get("/loans/booksOnLoan/"+personId, 
	  function(data) {
	  	var htmlData = '';
	  	     
		if (data && data.length > 0) {
		  	htmlData += '<table class="table">'
		  	
			+'<caption>Books on loan to customer id: ' + personId + '</caption>'
	        +'<tr>'
	        +   '<th>Title</th>'  
		    +   '<th>Author</th>'
		    +   '<th>ISBN</th>'
	    	+'</tr>'
		  	for (var i = 0; i < data.length; i++) {
		  		htmlData += '<tr><td>' + data[i].title + '</td>'
		  		    + '<td>' + data[i].author + '</td>'
		  		    + '<td>' + data[i].isbn + '</td></tr>'; 	
		  	}
		  	
		  	htmlData += '</table>';    
		} 
		else {
		  	htmlData += 'No results found';		
		}
		
		$("#loanedBookData").empty().html(htmlData);
		
		loansPanel.show();
	  }
	  
	)
};
  