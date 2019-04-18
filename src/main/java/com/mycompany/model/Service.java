package com.mycompany.model;

import java.util.concurrent.Callable;

import com.mycompany.app.Dispatcher;

public class Service implements Callable<Employee>{
  private Call call;
  private Dispatcher dispatcher;

  public Service(Dispatcher dispatcher, Call call) {
    this.dispatcher = dispatcher;
    this.call = call;
}

  @Override
  public Employee call() throws Exception {
    return dispatcher.dispatchCall(call);
  };

}