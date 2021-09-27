package com.sigabem.freteendpoint.strategies;

import java.util.Calendar;

public class DDDsIguais implements Strategy {

  private double desconto = 0.50;

  @Override
  public double calcularPreco(double peso) {
    return peso * this.desconto;
  }

  @Override
  public Calendar calcularData(Calendar data) {
    data.add(Calendar.DAY_OF_MONTH, 1);
    return data;
  }

}
