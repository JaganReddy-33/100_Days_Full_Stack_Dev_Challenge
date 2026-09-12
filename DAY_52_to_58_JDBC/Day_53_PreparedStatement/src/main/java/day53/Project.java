package day53;

import java.sql.Date;

public class Project {
    private int projectId;
    private String projectName;
    private int employeeId;
    private Date startDate;
    private Date endDate;
    private double budget;

    public Project() {
    }

    public Project(int projectId, String projectName, int employeeId, Date startDate, Date endDate, double budget) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", employeeId=" + employeeId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", budget=" + budget +
                '}';
    }
}