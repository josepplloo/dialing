package com.mycompany.model;

public class Call {
  public int number;
  public int time;

  public Call (int number,int time) {
    this.number = number;
    this.time = time;
  }

  public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public void print(){
               System.out.println("Number:"+number + ", Time:"+time);
        }
}