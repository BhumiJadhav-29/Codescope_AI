package com.codescope.model;

import java.time.LocalDateTime;

public class Project {

    
	private int projectId;
    private String projectName;
    private String projectPath;
    private String language;
    private LocalDateTime createdAt;
    private LocalDateTime lastScanned;
    public Project() {
    }
    public Project(int projectId, String projectName, String projectPath, String language, LocalDateTime createdAt,
			LocalDateTime lastScanned) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectPath = projectPath;
		this.language = language;
		this.createdAt = createdAt;
		this.lastScanned = lastScanned;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectPath() {
		return projectPath;
	}
	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getLastScanned() {
		return lastScanned;
	}
	public void setLastScanned(LocalDateTime lastScanned) {
		this.lastScanned = lastScanned;
	}

}
