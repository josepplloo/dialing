package com.mycompany.model;

public class Director extends Employee {

  public Director(String name) {
      super(name);
      setRole(Priority.DIRECTOR);
  }
}