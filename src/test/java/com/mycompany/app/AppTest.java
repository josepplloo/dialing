package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.logging.Logger;

import com.mycompany.model.*;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
  private static final Logger LOGGER = Logger.getLogger(AppTest.class.getName());

    
    @Test
    public void shouldDispatchtheCalls() throws InterruptedException, ExecutionException {
      PriorityBlockingQueue<Employee> emploees = new PriorityBlockingQueue<>();

      List<Employee> staff = Arrays.asList(
          new Employee("mkyong"),
          new Employee("jack"),
          new Employee("lawrence")
      );

      final List<Call> calls =  Arrays.asList(new Call(1, 5), new Call(2, 6));

      staff.stream().map(i -> emploees.add(i)) ;
      
      Dispatcher dispatcher = new Dispatcher(emploees);

      ExecutorService executorService = Executors.newFixedThreadPool(2); 
        
      List<Callable<Employee>> callablesEmployeeList = new ArrayList<>();
      calls.stream().map(call -> callablesEmployeeList.add(new Service(dispatcher, call)));
      
      
      List<Future<Employee>> futureList = executorService.invokeAll(callablesEmployeeList);

      for(Future<Employee> future : futureList) {
        Employee e = future.get();
        LOGGER.info(e.getName());
        assert future.isDone();
      }
       
      executorService.shutdown();
    }
}
