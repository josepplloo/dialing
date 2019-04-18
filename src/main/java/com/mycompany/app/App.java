package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import com.mycompany.model.*;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) throws Exception {
    System.out.println("-=Welcome to the Callcenter=_");
    new App().simulation();
  }

  public void simulation() throws ExecutionException, InterruptedException {
    
    List<Employee> employees = Arrays.asList(
      new Operator("Peter"),
      new Operator("Fred"),
      new Operator("Luis"),
      new Operator("Malcom"),
      new Operator("Stheve"),
      new Supervisor("Monica"),
      new Supervisor("Pola"),
      new Supervisor("Stefany"),
      new Director("Mary")
    );
    
    PriorityBlockingQueue<Employee> staff = new PriorityBlockingQueue<>();
    for (Employee employee : employees) {
      staff.add(employee);
    }
    Dispatcher dispatcher = new Dispatcher(staff, 10);

    Random rand = new Random(); 
    int value = rand.nextInt(50); 

    for(int i = 0; i < 10; i++) {
      dispatcher.dispatchCall(new Call(i, (value + 50)*100));
      value = rand.nextInt(50);
    }

    dispatcher.shutdown(20);
  }  
}
