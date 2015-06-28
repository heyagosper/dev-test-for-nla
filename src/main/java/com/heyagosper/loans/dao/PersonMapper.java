package com.heyagosper.loans.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.heyagosper.loans.model.Person;

/** 
 * Maps SQL results into a Book object. 
 */
public class PersonMapper implements ResultSetMapper<Person> {
  public Person map(int index, ResultSet rs, StatementContext context) throws SQLException
  {
    return new Person(rs.getInt("id"), rs.getString("name"), rs.getString("phone_number"), rs.getString("email_address"));
  }
}

