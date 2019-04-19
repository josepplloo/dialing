package com.mycompany.model;

public class Employee implements Comparable<Employee> {
  private String name;
  private Priority role;

  public Employee(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Priority getRole() {
    return role;
  }

  public void setRole(Priority role) {
    this.role = role;
  }

  @Override
  public int compareTo(Employee employee) {
    return this.role.getPriority().compareTo(employee.getRole().getPriority());
  }

  enum Priority {
        
    OPERATOR(1),
    SUPERVISOR(2),
    DIRECTOR(3);

    private Integer priority;

    Priority(Integer priority) {
      this.priority = priority;
    }

    public Integer getPriority() {
      return priority;
    }
    
  }
}