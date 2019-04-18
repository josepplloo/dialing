package com.mycompany.app;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Logger;


import com.mycompany.model.Call;
import com.mycompany.model.Employee;

public class Dispatcher {
  private final static Logger LOGGER = Logger.getLogger(Dispatcher.class.getName());


  private PriorityBlockingQueue<Employee> employees;

  public Dispatcher(PriorityBlockingQueue<Employee> employees) {
    this.employees = employees;
  }

  public Employee dispatchCall(Call call) {
    Employee employee = null;
    try {
      employee = employees.take();
      LOGGER.info("Dialing from #" + call.number + " Assigned to " + employee);
      Thread.sleep(call.time*1000);
      LOGGER.info("Hang up to " +call.number);
      employees.add(employee);
    } catch (InterruptedException e) {
      LOGGER.warning(""+e);
    }
    return employee;
}
}