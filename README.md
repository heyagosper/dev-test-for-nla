Heya's Library Customer Loans Search

This project is a development skills test for a job application for the National Library of Australia. Functionality is described in Requirements.txt.

Database is prepopulated with sample data (see LoanController.init()) and the data is read dynamically and displayed in a single-page UI using jQuery. It's a Freemarker template although I didn't use any substitutions in the end, it's just straight out Javascript displaying JSON response data so I didn't need any.  

I used a template from Mykong.com for the basic skeleton and therefore have left Yong Mook Kim's License file intact. 

===============================

###1. Technologies used
* Maven 3
* Spring 3.2.13.RELEASE
* JDBI
* Freemarker
* Bootstrap 3
* jQuery

###2. To Run this project locally
shell
$ git clone https://github.com/heyagosper/dev-test-for nla
$ mvn jetty:run

Access http://localhost:8080/loans 

###3. To import this project into Eclipse IDE
1. $ mvn eclipse:eclipse
2. Import into Eclipse via **existing projects into workspace** option.
3. Done.

