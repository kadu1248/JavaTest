package com.sigabem.freteendpoint.dto;

import java.util.Date;

public class FreteResponse {

  public Double vlTotalFrete;
  public String dataPrevistaEntrega;
  public String cepOrigem;
  public String cepDestino;

  public FreteResponse() {
  }

  public FreteResponse(Double vlTotalFrete, String dataPrevistaEntrega, String cepOrigem, String cepDestino) {
    this.vlTotalFrete = vlTotalFrete;
    this.dataPrevistaEntrega = dataPrevistaEntrega;
    this.cepOrigem = cepOrigem;
    this.cepDestino = cepDestino;
  }

  public Double getVlTotalFrete() {
    return vlTotalFrete;
  }

  public void setVlTotalFrete(Double vlTotalFrete) {
    this.vlTotalFrete = vlTotalFrete;
  }

  public String getDataPrevistaEntrega() {
    return dataPrevistaEntrega;
  }

  public void setDataPrevistaEntrega(String dataPrevistaEntrega) {
    this.dataPrevistaEntrega = dataPrevistaEntrega;
  }

  public String getCepOrigem() {
    return cepOrigem;
  }

  public void setCepOrigem(String cepOrigem) {
    this.cepOrigem = cepOrigem;
  }

  public String getCepDestino() {
    return cepDestino;
  }

  public void setCepDestino(String cepDestino) {
    this.cepDestino = cepDestino;
  }

}
