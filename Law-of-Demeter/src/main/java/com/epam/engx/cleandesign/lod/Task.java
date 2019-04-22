package com.epam.engx.cleandesign.lod;

public class Task {

	private String name;
	private String id;
	private String userStoryName;

	public Task(String name) {
		String[] taskDetails = name.split(NameFormatter.DELIMITER);
		this.name = taskDetails[0];
		this.id = taskDetails[1];
		userStoryName = "Story" + NameFormatter.DELIMITER + id;
	}

	public String getUserStoryEmployeeName() {

		return new UserStory(userStoryName).getEmployeeName();
	}
}
