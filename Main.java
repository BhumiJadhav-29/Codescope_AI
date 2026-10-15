```java
package com.codescope;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.codescope.dao.ProjectDAO;
import com.codescope.model.Project;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProjectDAO dao = new ProjectDAO();

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("       CODESCOPE AI - JDBC");
            System.out.println("================================");
            System.out.println("1. Create Project");
            System.out.println("2. Read Project");
            System.out.println("3. Read All Projects");
            System.out.println("4. Update Project");
            System.out.println("5. Delete Project");
            System.out.println("6. Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    // CREATE
                    case 1: {
                        System.out.print("Enter project name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter project path: ");
                        String path = sc.nextLine();

                        Project project = new Project(
                            0,
                            name,
                            path,
                            "Java",
                            LocalDateTime.now(),
                            null
                        );

                        dao.createProject(project);
                        break;
                    }

                    // READ ONE
                    case 2: {
                        System.out.print("Enter project ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        Project project = dao.getProjectById(id);

                        if (project != null) {
                            System.out.println("\n--- Project Details ---");
                            System.out.println(
                                "Project ID: " + project.getProjectId()
                            );
                            System.out.println(
                                "Project Name: " + project.getProjectName()
                            );
                            System.out.println(
                                "Project Path: " + project.getProjectPath()
                            );
                            System.out.println(
                                "Language: " + project.getLanguage()
                            );
                            System.out.println(
                                "Created At: " + project.getCreatedAt()
                            );
                            System.out.println(
                                "Last Scanned: " + project.getLastScanned()
                            );
                        } else {
                            System.out.println("Project not found.");
                        }
                        break;
                    }

                    // READ ALL
                    case 3: {
                        List<Project> projects = dao.getAllProjects();

                        if (projects.isEmpty()) {
                            System.out.println("No projects found.");
                        } else {
                            System.out.println("\n--- All Projects ---");

                            for (Project project : projects) {
                                System.out.println(
                                    "ID: " + project.getProjectId()
                                    + " | Name: " + project.getProjectName()
                                    + " | Path: " + project.getProjectPath()
                                    + " | Language: " + project.getLanguage()
                                );
                            }
                        }
                        break;
                    }

                    // UPDATE
                    case 4: {
                        System.out.print("Enter project ID to update: ");
                        int id = Integer.parseInt(sc.nextLine());

                        Project project = dao.getProjectById(id);

                        if (project != null) {
                            System.out.print("Enter new project name: ");
                            project.setProjectName(sc.nextLine());

                            System.out.print("Enter new project path: ");
                            project.setProjectPath(sc.nextLine());

                            System.out.print("Enter new language: ");
                            project.setLanguage(sc.nextLine());

                            dao.updateProject(project);
                        } else {
                            System.out.println("Project not found.");
                        }
                        break;
                    }

                    // DELETE
                    case 5: {
                        System.out.print("Enter project ID to delete: ");
                        int id = Integer.parseInt(sc.nextLine());

                        dao.deleteProject(id);
                        break;
                    }

                    // EXIT
                    case 6: {
                        System.out.println("Exiting CodeScope AI...");
                        break;
                    }

                    default:
                        System.out.println(
                            "Invalid choice. Please enter 1 to 6."
                        );
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid numeric choice or ID.");
                choice = 0;
            }

        } while (choice != 6);

        sc.close();
    }
}
```
