package com.codescope.dao;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.codescope.config.DatabaseConnection;
import com.codescope.model.Project;

public class ProjectDAO {

    public void createProject(Project project) {

        String sql = """
                INSERT INTO projects
                (project_name, project_path, language, created_at)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, project.getProjectName());
            statement.setString(2, project.getProjectPath());
            statement.setString(3, project.getLanguage());
            statement.setObject(4, project.getCreatedAt());

            statement.executeUpdate();

            System.out.println("Project created successfully!");

        } catch (SQLException e) {
            System.out.println("Failed to create project.");
            e.printStackTrace();
        }
    }
    public List<Project> getAllProjects() {

        List<Project> projects = new ArrayList<>();

        String sql = "SELECT * FROM projects";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Project project = new Project();

                project.setProjectId(resultSet.getInt("project_id"));
                project.setProjectName(resultSet.getString("project_name"));
                project.setProjectPath(resultSet.getString("project_path"));
                project.setLanguage(resultSet.getString("language"));

                projects.add(project);
            }

        } catch (SQLException e) {
            System.out.println("Failed to retrieve projects.");
            e.printStackTrace();
        }

        return projects;
    }
    public boolean updateProject(Project project) {

        String sql = """
                UPDATE projects
                SET project_name = ?,
                    project_path = ?,
                    language = ?
                WHERE project_id = ?
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, project.getProjectName());
            statement.setString(2, project.getProjectPath());
            statement.setString(3, project.getLanguage());
            statement.setInt(4, project.getProjectId());

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Failed to update project.");
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteProject(int projectId) {

        String sql = "DELETE FROM projects WHERE project_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, projectId);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Failed to delete project.");
            e.printStackTrace();
            return false;
        }
    }
}