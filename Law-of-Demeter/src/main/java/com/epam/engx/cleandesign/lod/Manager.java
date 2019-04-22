package com.epam.engx.cleandesign.lod;

public class Manager {

	private Task task;

	public String whoIsAssignedTo(String taskName) {
		this.task = new Task(taskName);
		return this.task.getUserStoryEmployeeName();
	}
}
