package com.heyagosper.loans.model;

/**
 * Models the join class between Person and Book. 
 * A loan is a relationship between a book and the person who borrowed it.
 */
public class Loan {
	private int personId;
	private int bookId;

	public Loan(int personId, int bookId) {
		super();
		this.personId = personId;
		this.bookId = bookId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result + personId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (bookId != other.bookId)
			return false;
		if (personId != other.personId)
			return false;
		return true;
	}

}
