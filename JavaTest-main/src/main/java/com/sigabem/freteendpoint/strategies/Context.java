package com.sigabem.freteendpoint.strategies;

import java.util.Calendar;

public class Context {

  private final Strategy strategy;

  public Context(Strategy strategy){
    this.strategy = strategy;
  }

  public double calcularPreco(double peso){
    return strategy.calcularPreco(peso);
  }

  public Calendar calcularData() {
    Calendar data = Calendar.getInstance();
    data.setTime(new java.util.Date());
    return strategy.calcularData(data);
  }

}
