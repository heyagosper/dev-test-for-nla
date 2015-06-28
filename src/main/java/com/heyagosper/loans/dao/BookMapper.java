package com.heyagosper.loans.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.heyagosper.loans.model.Book;

/**
 * Maps SQL results into a Book object.
 * @author heya
 *
 */
public class BookMapper implements ResultSetMapper<Book> {
	public Book map(int index, ResultSet rs, StatementContext context)
			throws SQLException {
		return new Book(rs.getInt("id"), rs.getString("title"),
				rs.getString("author"), rs.getString("isbn"));
	}
}
