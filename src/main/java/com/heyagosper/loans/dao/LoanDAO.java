package com.heyagosper.loans.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.springframework.stereotype.Component;

import com.heyagosper.loans.model.Book;
import com.heyagosper.loans.model.Person;

/**
 * This is a DAO using the JDBI SQL Object style.
 * 
 * All database calls for this application go through this interface.
 */
@Component
public interface LoanDAO {
	
	@SqlUpdate("CREATE TABLE PERSON("
			+ " id int primary key, " + " name varchar(255), "
			+ " phone_number varchar(32)," + " email_address varchar(255))")
	void createPersonTable();

	@SqlUpdate("CREATE TABLE BOOK("
			+ " id int primary key, " + " title varchar(255), "
			+ " author varchar(255)," + " isbn varchar(32))")
	void createBookTable();
	
	@SqlUpdate("CREATE TABLE LOAN( "
			+ " person_id int,"
			+ " book_id int)")
	void createLoanTable();
	
	@SqlUpdate("INSERT INTO PERSON (id, name, phone_number, email_address) values"
			+ "(:id, :name, :phoneNumber, :emailAddress)")
	void insertPerson(
			@Bind("id") int id, 
			@Bind("name") String name,
			@Bind("phoneNumber") String phoneNumber,
			@Bind("emailAddress") String emailAddress);

	@SqlUpdate("INSERT INTO BOOK " + "(id, title, author, isbn) values"
			+ "(:id, :title, :author, :isbn)")
	void insertBook(
			@Bind("id") int id, 
			@Bind("title") String name,
			@Bind("author") String author,
			@Bind("isbn") String isbn);
	
	@SqlUpdate("INSERT INTO LOAN (person_id, book_id) values"
			+ "(:personId, :bookId)")
	void insertLoan(
			@Bind("personId") int personId, 
			@Bind("bookId") int bookId);	
	
	@SqlQuery("select * from person")
	@Mapper(PersonMapper.class)
	public List<Person> getAllPersons();

	@SqlQuery("select * from book")
	@Mapper(BookMapper.class)
	public List<Book> getAllBooks();
	
	@SqlQuery("select * from book where id in (select book_id from loan where person_id = :personId)")
	@Mapper(BookMapper.class)
	public List<Book> findBooksOnLoanToPerson(@Bind("personId") int personId);

	/**
	 * close with no args is used to close the connection
	 */
	void close();
}
