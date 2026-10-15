package com.codescope;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.codescope.dao.ProjectHibernateDAO;
import com.codescope.model.Project;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProjectHibernateDAO dao = new ProjectHibernateDAO();
        System.out.println(
        	    "Total Projects: " + dao.getTotalProjects()
        	);
        while (true) {

            System.out.println("\n==============================");
            System.out.println("   CODESCOPE AI - HIBERNATE");
            System.out.println("==============================");
            System.out.println("1. Create Project");
            System.out.println("2. Read Project");
            System.out.println("3. Read All Projects");
            System.out.println("4. Update Project");
            System.out.println("5. Delete Project");
            System.out.println("6. Exit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter project name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter project path: ");
                    String path = scanner.nextLine();

                    Project project = new Project(
                            name,
                            path,
                            "Java",
                            LocalDateTime.now()
                    );

                    dao.createProject(project);
                    break;

                case 2:

                    System.out.print("Enter project ID: ");
                    int readId = scanner.nextInt();

                    Project foundProject = dao.getProjectById(readId);

                    if (foundProject != null) {
                        System.out.println("\nProject ID   : " + foundProject.getProjectId());
                        System.out.println("Project Name : " + foundProject.getProjectName());
                        System.out.println("Project Path : " + foundProject.getProjectPath());
                        System.out.println("Language     : " + foundProject.getLanguage());
                        System.out.println("Created At   : " + foundProject.getCreatedAt());
                    } else {
                        System.out.println("Project not found.");
                    }

                    break;

                case 3:

                    List<Project> projects = dao.getAllProjects();

                    if (projects == null || projects.isEmpty()) {
                        System.out.println("No projects found.");
                    } else {

                        System.out.println("\n--------- ALL PROJECTS ---------");

                        for (Project p : projects) {
                            System.out.println(
                                    "ID: " + p.getProjectId()
                                    + " | Name: " + p.getProjectName()
                                    + " | Language: " + p.getLanguage()
                            );
                        }
                    }

                    break;

                case 4:

                    System.out.print("Enter project ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    Project existingProject = dao.getProjectById(updateId);

                    if (existingProject != null) {

                        System.out.print("Enter new project name: ");
                        String newName = scanner.nextLine();

                        System.out.print("Enter new project path: ");
                        String newPath = scanner.nextLine();

                        existingProject.setProjectName(newName);
                        existingProject.setProjectPath(newPath);
                        existingProject.setLastScanned(LocalDateTime.now());

                        dao.updateProject(existingProject);

                    } else {
                        System.out.println("Project not found.");
                    }

                    break;

                case 5:

                    System.out.print("Enter project ID to delete: ");
                    int deleteId = scanner.nextInt();

                    dao.deleteProject(deleteId);

                    break;

                case 6:

                    System.out.println("Exiting CodeScope AI...");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
