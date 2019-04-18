package com.mycompany.model;

public class Supervisor extends Employee {

  public Supervisor(String name) {
      super(name);
      setRole(Priority.SUPERVISOR);
  }
}