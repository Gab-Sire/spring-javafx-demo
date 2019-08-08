package com.demo.bean;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;
	private static AtomicInteger idNumber = new AtomicInteger();

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "IS_FORM")
	private Boolean isForm;

	public Task() {
		this.id = idNumber.incrementAndGet();
		this.name = "";
		this.description = "";
		this.isForm = false;
	}

	public Task(String name, String description) {
		this.id = idNumber.incrementAndGet();
		this.name = name;
		this.description = description;
		this.isForm = false;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean IsForm() {
		return isForm;
	}

	public void setIsForm(Boolean isForm) {
		this.isForm = isForm;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}

