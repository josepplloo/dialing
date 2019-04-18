package com.mycompany.model;

public class Operator extends Employee {

  public Operator(String name) {
      super(name);
      setRole(Priority.OPERATOR);
  }
}