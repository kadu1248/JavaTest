package com.sigabem.freteendpoint.service;

import com.sigabem.freteendpoint.dto.CepResponse;
import com.sigabem.freteendpoint.dto.FreteRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepAPI {

  public CepResponse cepOrigemResponse(FreteRequest freteRequest) {

    RestTemplate restTemplate = new RestTemplate();

    return restTemplate
      .getForObject("https://viacep.com.br/ws/" +
      freteRequest.getCepOrigem() + "/json", CepResponse.class);

  }

  public CepResponse cepDestinoResponse(FreteRequest freteRequest) {

    RestTemplate restTemplate = new RestTemplate();

    return restTemplate
      .getForObject("https://viacep.com.br/ws/" +
      freteRequest.getCepDestino() + "/json", CepResponse.class);

  }

}
