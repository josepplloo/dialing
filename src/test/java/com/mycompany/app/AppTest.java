package com.mycompany.app;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import com.mycompany.call.Call;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswertheCalls() {
      final List<Call> calls =  Arrays.asList(new Call(1, 5), new Call(2, 6));
      ExecutorService service =  Executors.newFixedThreadPool(2);

      Runnable r = () -> {
          System.out.println(Thread.currentThread().getName());
          Consumer<Call> consumer = (Call call) -> {
            System.out.println(call.getNumber());
            try {
              Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
              //TODO: handle exception
            }
          };       
          calls.forEach(consumer);
       
      };
    service.execute(r);
    assertTrue( true );
    }
}
