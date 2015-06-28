package com.heyagosper.loans.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.heyagosper.loans.model.Book;
import com.heyagosper.loans.model.Person;

@Service
public interface LoanService {
	
	/**
	 * Creates the database tables and inserts some data.
	 */
	public void initialiseTestDatabase() throws SQLException; 

	/**
	 * Gets a list of Person objects. Okay, they are people. But it is a list of Person so getPersons seems right. 
	 * @return a List containing Person data objects
	 * @throws SQLException 
	 */
	public List<Person> getPersons() throws SQLException;
	
	/**
	 * Gets a list of Book objects. 
	 * @return a List containing Book data objects
	 * @throws SQLException 
	 */
	public List<Book> getBooks() throws SQLException;
	
	/**
	 * Gets a list of books on loan to a specific person
	 * @param personId the customer who has the loans
	 * @return a List of Books
	 */
	public List<Book> getBooksOnLoanToPerson(int personId) throws SQLException;

}
