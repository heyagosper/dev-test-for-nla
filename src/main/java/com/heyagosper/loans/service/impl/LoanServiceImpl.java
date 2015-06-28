package com.heyagosper.loans.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.h2.jdbcx.JdbcConnectionPool;
import org.skife.jdbi.v2.DBI;
import org.springframework.stereotype.Service;

import com.heyagosper.loans.dao.LoanDAO;
import com.heyagosper.loans.model.Book;
import com.heyagosper.loans.model.Person;
import com.heyagosper.loans.service.LoanService;

/*
 * Implementation of the Loan service 
 */
@Service
public class LoanServiceImpl implements LoanService {
	
	
	
	/*
	 * (non-Javadoc)
	 * @see com.heyagosper.loans.service.LoanService#initialiseTestDatabase()
	 */
	public void initialiseTestDatabase() throws SQLException {
		
		
		// using in-memory H2 database via a pooled DataSource
		JdbcConnectionPool ds = JdbcConnectionPool.create("jdbc:h2:mem:test2",
		                                                  "username",
		                                                  "password");
		DBI dbi = new DBI(ds);
		
		LoanDAO loansDAO = dbi.open(LoanDAO.class);

		// create the tables
		loansDAO.createPersonTable();
		loansDAO.createBookTable();
		loansDAO.createLoanTable();
		
		// add some Person records
		for (int i = 1; i <= 5; i++) {
			loansDAO.insertPerson(1000 + i, "Person" + (1000 + i), "(02)12341234", "email@email.com");					
		}
		
		// add some Books
		for (int i = 1; i <= 10; i++) {
			loansDAO.insertBook(i, "Title" + i, "Author" + i, "978034540447" + i);
		}
		
		// loan out some books to some persons
		for (int i = 1; i <= 3; i++) {
			loansDAO.insertLoan(1000 + i, i);					
		}
		
		// let's lend out a couple more books to person 1
		loansDAO.insertLoan(1001, 4);
		loansDAO.insertLoan(1001, 5);
		
		ds.dispose();
	}

	/*
	 * (non-Javadoc)
	 * @see com.heyagosper.loans.service.LoanService#getPersons()
	 */
	public List<Person> getPersons() throws SQLException {
		
		List<Person> persons = new ArrayList<Person>();
		
		// using in-memory H2 database via a pooled DataSource
		JdbcConnectionPool ds = JdbcConnectionPool.create("jdbc:h2:mem:test2",
		                                                  "username",
		                                                  "password");
		
		DBI dbi = new DBI(ds);
		
		LoanDAO loansDAO = dbi.onDemand(LoanDAO.class);
		
		persons = loansDAO.getAllPersons();
		
		ds.dispose();
		
		return persons;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.heyagosper.loans.service.LoanService#getBooks()
	 */
	public List<Book> getBooks() throws SQLException {
		
		List<Book> books = new ArrayList<Book>();
		
		// using in-memory H2 database via a pooled DataSource
		JdbcConnectionPool ds = JdbcConnectionPool.create("jdbc:h2:mem:test2",
		                                                  "username",
		                                                  "password");
		DBI dbi = new DBI(ds);
		
		LoanDAO loansDAO = dbi.open(LoanDAO.class);
		
		books = loansDAO.getAllBooks();
		
		ds.dispose();
		
		return books;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.heyagosper.loans.service.LoanService#getBooksOnLoanToPerson(int)
	 */
	public List<Book> getBooksOnLoanToPerson(int personId) throws SQLException {
		List<Book> books = new ArrayList<Book>();
		
		// using in-memory H2 database via a pooled DataSource
		JdbcConnectionPool ds = JdbcConnectionPool.create("jdbc:h2:mem:test2",
		                                                  "username",
		                                                  "password");
		DBI dbi = new DBI(ds);
		
		LoanDAO loansDAO = dbi.open(LoanDAO.class);
		
		books = loansDAO.findBooksOnLoanToPerson(personId);
		
		ds.dispose();
		
		return books;
	}

}
