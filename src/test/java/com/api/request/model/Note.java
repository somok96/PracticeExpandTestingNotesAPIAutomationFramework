package com.api.request.model;

import com.api.constant.Category;

public class Note {

	private String title;
	private String description;
	private Category category;

	public Note(String title, String description, Category category) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Note [title=" + title + ", description=" + description + ", category=" + category + "]";
	}

}
