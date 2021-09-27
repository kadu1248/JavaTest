package com.sigabem.freteendpoint.strategies;

import java.util.Calendar;

public interface Strategy {

  double calcularPreco(double peso);

  Calendar calcularData(Calendar data);

}
