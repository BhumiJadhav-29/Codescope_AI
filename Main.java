package com.codescope;

import com.codescope.dao.ProjectDAO;

public class Main {

    public static void main(String[] args) {

        ProjectDAO projectDAO = new ProjectDAO();

        boolean deleted = projectDAO.deleteProject(1);

        if (deleted) {
            System.out.println("Project deleted successfully!");
        } else {
            System.out.println("Project not found.");
        }
    }
}