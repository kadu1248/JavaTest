package com.sigabem.freteendpoint.service;

import com.sigabem.freteendpoint.dto.CepResponse;
import com.sigabem.freteendpoint.dto.FreteRequest;
import com.sigabem.freteendpoint.dto.FreteResponse;
import com.sigabem.freteendpoint.entity.Frete;
import com.sigabem.freteendpoint.repository.FreteRepository;
import com.sigabem.freteendpoint.strategies.Context;
import com.sigabem.freteendpoint.strategies.DDDsIguais;
import com.sigabem.freteendpoint.strategies.UFsDiferentes;
import com.sigabem.freteendpoint.strategies.UFsIguais;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Service
public class FreteService {

  private final FreteRepository freteRepository;
  private final ViaCepAPI viaCepAPI;

  public FreteService(FreteRepository freteRepository, ViaCepAPI viaCepAPI) {
    this.freteRepository = freteRepository;
    this.viaCepAPI = viaCepAPI;
  }

  public FreteResponse calcular(FreteRequest freteRequest) {

    CepResponse cepOrigemResponse = viaCepAPI.cepOrigemResponse(freteRequest);
    CepResponse cepDestinoResponse = viaCepAPI.cepDestinoResponse(freteRequest);

    double totalDesconto;
    Calendar dataPrevista;
    if (Objects.equals(cepDestinoResponse.getDdd(), cepOrigemResponse.getDdd())) {
      Context contextDDD = new Context(new DDDsIguais());
      totalDesconto = contextDDD.calcularPreco(freteRequest.getPeso());
      dataPrevista = contextDDD.calcularData();
    } else if (Objects.equals(cepDestinoResponse.getUf(), cepOrigemResponse.getUf())) {
      Context contextUFsIguais = new Context(new UFsIguais());
      totalDesconto = contextUFsIguais.calcularPreco(freteRequest.getPeso());
      dataPrevista = contextUFsIguais.calcularData();
    } else {
      Context contextUFsDiferentes = new Context(new UFsDiferentes());
      totalDesconto = contextUFsDiferentes.calcularPreco(freteRequest.getPeso());
      dataPrevista = contextUFsDiferentes.calcularData();
    }

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    FreteResponse freteResponse = new FreteResponse();
    freteResponse.setDataPrevistaEntrega(formatter.format(dataPrevista.getTime()));
    freteResponse.setVlTotalFrete(totalDesconto);
    freteResponse.setCepDestino(freteRequest.getCepDestino());
    freteResponse.setCepOrigem(freteRequest.getCepOrigem());

    Date date = new Date();
    Frete frete = new Frete();
    frete.setPeso(freteRequest.getPeso());
    frete.setCepOrigem(freteRequest.getCepOrigem());
    frete.setCepDestino(freteRequest.getCepDestino());
    frete.setNomeDestinatario(freteRequest.getNomeDestinatario());
    frete.setVlTotalFrete(freteResponse.getVlTotalFrete());
    frete.setDataPrevistaEntrega(formatter.format(dataPrevista.getTime()));
    frete.setDataConsulta(formatter.format(date));

    freteRepository.save(frete);
    return freteResponse;

  }

}
