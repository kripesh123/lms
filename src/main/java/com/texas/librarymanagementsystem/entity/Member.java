package com.texas.librarymanagementsystem.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String type;
	private Boolean status;
	
	@OneToMany(mappedBy="member",cascade=CascadeType.MERGE)
	@JsonManagedReference
	private List<Transaction> transactions;
	
	@CreationTimestamp
	private Date memberShipDate;
	
	private int issuedBook;
	private int maxBookLimit;
	
	@UpdateTimestamp
	private Date updateMemberShipDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getMemberShipDate() {
		return memberShipDate;
	}

	public void setMemberShipDate(Date memberShipDate) {
		this.memberShipDate = memberShipDate;
	}

	public int getIssuedBook() {
		return issuedBook;
	}

	public void setIssuedBook(int issuedBook) {
		this.issuedBook = issuedBook;
	}

	public int getMaxBookLimit() {
		return maxBookLimit;
	}

	public void setMaxBookLimit(int maxBookLimit) {
		this.maxBookLimit = maxBookLimit;
	}

	public Date getUpdateMemberShipDate() {
		return updateMemberShipDate;
	}

	public void setUpdateMemberShipDate(Date updateMemberShipDate) {
		this.updateMemberShipDate = updateMemberShipDate;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
}
