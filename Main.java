package com.codescope;

import java.time.LocalDateTime;
import java.util.List;

import com.codescope.dao.ProjectDAO;
import com.codescope.model.Project;

public class Main {

    public static void main(String[] args) {

        ProjectDAO projectDAO = new ProjectDAO();

        // ==============================
        // CREATE
        // ==============================

        Project project = new Project();

        project.setProjectName("CodeScope Demo");
        project.setProjectPath("C:\\Projects\\CodeScopeDemo");
        project.setLanguage("Java");
        project.setCreatedAt(LocalDateTime.now());

        projectDAO.createProject(project);


        // ==============================
        // READ
        // ==============================

        List<Project> projects = projectDAO.getAllProjects();

        System.out.println("\n===== ALL PROJECTS =====");

        for (Project p : projects) {

            System.out.println("----------------------------");
            System.out.println("Project ID : " + p.getProjectId());
            System.out.println("Name       : " + p.getProjectName());
            System.out.println("Path       : " + p.getProjectPath());
            System.out.println("Language   : " + p.getLanguage());
        }


        // ==============================
        // UPDATE
        // ==============================

        Project updateProject = new Project();

        updateProject.setProjectId(1);
        updateProject.setProjectName("CodeScope AI");
        updateProject.setProjectPath("C:\\Projects\\CodeScopeAI");
        updateProject.setLanguage("Java");

        boolean updated = projectDAO.updateProject(updateProject);

        if (updated) {
            System.out.println("\nProject updated successfully!");
        } else {
            System.out.println("\nProject not found.");
        }


        // ==============================
        // READ AFTER UPDATE
        // ==============================

        projects = projectDAO.getAllProjects();

        System.out.println("\n===== AFTER UPDATE =====");

        for (Project p : projects) {

            System.out.println("----------------------------");
            System.out.println("Project ID : " + p.getProjectId());
            System.out.println("Name       : " + p.getProjectName());
            System.out.println("Path       : " + p.getProjectPath());
            System.out.println("Language   : " + p.getLanguage());
        }


        // ==============================
        // DELETE
        // ==============================

        /*
         * Uncomment this section only when
         * you actually want to delete project ID 1.
         */

        /*
        boolean deleted = projectDAO.deleteProject(1);

        if (deleted) {
            System.out.println("\nProject deleted successfully!");
        } else {
            System.out.println("\nProject not found.");
        }
        */
    }
}