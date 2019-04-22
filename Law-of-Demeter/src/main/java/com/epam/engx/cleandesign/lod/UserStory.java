package com.epam.engx.cleandesign.lod;

public class UserStory {

	private String id;
	private String assigneeId;
	private Employee employee;

	public UserStory(String name) {
		String[] storyDetails = name.split(NameFormatter.DELIMITER);
		this.id = storyDetails[1];
		this.assigneeId = this.id;
		this.employee = new Employee(this.assigneeId);
	}

	public String getEmployeeName() {
		return this.employee.getName();
	}
}
