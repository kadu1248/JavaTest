package com.sigabem.freteendpoint.strategies;

import java.util.Calendar;

public class UFsDiferentes implements Strategy  {

  private double desconto = 1;

  @Override
  public double calcularPreco(double peso) {
    return peso * this.desconto;
  }

  @Override
  public Calendar calcularData(Calendar data) {
    data.add(Calendar.DAY_OF_MONTH, 10);
    return data;
  }

}
