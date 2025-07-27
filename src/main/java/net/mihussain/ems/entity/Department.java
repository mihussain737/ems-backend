package net.mihussain.ems.entity;

import jakarta.persistence.*;

@Entity
@Table(name="departments")
public class Department {

    public Long getId() {
        return id;
    }

    public Department() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public Department(Long id, String departmentName, String departmentDescription) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;
    private String departmentDescription;
}
