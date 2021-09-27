package com.sigabem.freteendpoint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Frete {

  @Id
  @GeneratedValue
  private Long freteId;

  private Double peso;
  private String cepOrigem;
  private String cepDestino;
  private String nomeDestinatario;
  private Double vlTotalFrete;
  private String dataPrevistaEntrega;
  private String dataConsulta;

  public Frete() {
  }

  public Frete(Long freteId, Double peso, String cepOrigem, String cepDestino, String nomeDestinatario,
               Double vlTotalFrete, String dataPrevistaEntrega, String dataConsulta) {
    this.freteId = freteId;
    this.peso = peso;
    this.cepOrigem = cepOrigem;
    this.cepDestino = cepDestino;
    this.nomeDestinatario = nomeDestinatario;
    this.vlTotalFrete = vlTotalFrete;
    this.dataPrevistaEntrega = dataPrevistaEntrega;
    this.dataConsulta = dataConsulta;
  }

  public Long getFreteId() {
    return freteId;
  }

  public void setFreteId(Long freteId) {
    this.freteId = freteId;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
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

  public String getNomeDestinatario() {
    return nomeDestinatario;
  }

  public void setNomeDestinatario(String nomeDestinatario) {
    this.nomeDestinatario = nomeDestinatario;
  }

  public Double getVlTotalFrete() {
    return vlTotalFrete;
  }

  public void setVlTotalFrete(Double vlTotalFrete) {
    this.vlTotalFrete = vlTotalFrete;
  }

  public String getDataPrevistaEntrega(String format) {
    return dataPrevistaEntrega;
  }

  public void setDataPrevistaEntrega(String dataPrevistaEntrega) {
    this.dataPrevistaEntrega = dataPrevistaEntrega;
  }

  public String getDataConsulta() {
    return dataConsulta;
  }

  public void setDataConsulta(String dataConsulta) {
    this.dataConsulta = dataConsulta;
  }

}
