package com.mycompany.model;

public class Employee implements Comparable<Employee> {
  private String name;
  private Priority rol;

  public Employee(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Priority getRol() {
    return rol;
  }

  public void setRol(Priority rol) {
    this.rol = rol;
  }

  @Override
  public int compareTo(Employee employee) {
        return this.rol.getPriority().compareTo(employee.getRol().getPriority());
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