package com.heyagosper.loans.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heyagosper.loans.model.Book;
import com.heyagosper.loans.model.Person;
import com.heyagosper.loans.service.LoanService;

/**
 * Command object for the loan system.
 * 
 * supports getPersons, getBooks, 
 * 
 * @author heya
 *
 */
@Controller
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@PostConstruct
	public void init() {
	   try {
		   loanService.initialiseTestDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        return "loans";
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Person> getPersons() {

		List<Person> persons = new ArrayList<Person>();
		try {
			persons = loanService.getPersons();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persons;
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Book> getBooks() {

		List<Book> books = new ArrayList<Book>();
		try {
			books = loanService.getBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return books;

	}

	@RequestMapping(value = "/booksOnLoan/{personId}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Book> getBooksOnLoan(@PathVariable String personId) {
		List<Book> books = new ArrayList<Book>();
		try {
			
			books = loanService.getBooksOnLoanToPerson(Integer.parseInt(personId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return books;

	}
}