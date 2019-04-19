package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

import com.mycompany.model.*;
import org.junit.Test;

public class AppTest {
  private static final Logger LOGGER = Logger.getLogger(AppTest.class.getName());

    @Test
    public void shouldDispatchtheCalls() throws InterruptedException, ExecutionException {
      PriorityBlockingQueue<Employee> emploees = new PriorityBlockingQueue<>();

      List<Employee> staff = Arrays.asList(
          new Supervisor("jack"),
          new Director("lawrence"),
          new Operator("mkyong")
      );

      for (Employee s : staff) {
        System.out.println(s.getName());
        emploees.add(s);
      }
      
      Dispatcher dispatcher = new Dispatcher(emploees, 3);

      final List<Call> calls =  Arrays.asList(
        new Call(1, 9), new Call(2, 6),
        new Call(3, 6), new Call(4, 5),
        new Call(5, 5), new Call(6, 10),
        new Call(7, 8), new Call(8, 9),
        new Call(9, 6), new Call(10, 8));
      
      for (Call c : calls) {
        System.out.println(c.getTime());
        dispatcher.dispatchCall(c);
      }
       
      dispatcher.shutdown(20);
    }

    @Test
    public void testEmploeesRole() {
      Operator operator = new Operator("Peter");
      Director director = new Director("Mr Burns");
      Supervisor supervisor = new Supervisor("Ms Smiters");
      assertEquals("Smitters is my boss", 1, supervisor.compareTo(operator));
      assertEquals("Burns is my boss", 1, director.compareTo(operator));
    }
}
