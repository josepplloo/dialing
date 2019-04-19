package com.mycompany.app;

import java.util.concurrent.*;
import java.util.concurrent.PriorityBlockingQueue;
import com.mycompany.model.*;

public class Dispatcher {

  private PriorityBlockingQueue<Employee> queue;
  private ExecutorService executorService;

  public Dispatcher(PriorityBlockingQueue<Employee> queue, int calls) {
    this.queue = queue;
    this.executorService = Executors.newFixedThreadPool(calls);
  }

  public void dispatchCall(Call call) throws InterruptedException {
      Employee employee = queue.take();
      executorService.submit(answerCall(employee, call));
  }

  private Runnable answerCall(Employee employee, Call call) {
    Runnable r = () -> {
      try {
        System.out.println("Dialing from #" + call.number +" Assigned to " + employee.getName());
        Thread.sleep(call.getTime());
        queue.add(employee);
      } catch (InterruptedException e) {
        e.printStackTrace();
      };
    };
    return r;
  }

  void shutdown(int timeout) throws InterruptedException {
    executorService.shutdown();

    if(!executorService.awaitTermination(timeout, TimeUnit.SECONDS)){
      System.out.println("shutingdown . . .");
      executorService.shutdownNow();
    }

  }

}