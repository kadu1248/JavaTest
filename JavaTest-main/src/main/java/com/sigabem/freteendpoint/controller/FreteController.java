package com.sigabem.freteendpoint.controller;

import com.sigabem.freteendpoint.dto.FreteRequest;
import com.sigabem.freteendpoint.dto.FreteResponse;
import com.sigabem.freteendpoint.service.FreteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Api(value = "SigaBem - Cálculo de Frete")
@CrossOrigin(origins = "*")
public class FreteController {

  private final FreteService freteService;

  public FreteController(FreteService freteService) {
    this.freteService = freteService;
  }

  @PostMapping("/calcularFrete")
  @ApiOperation(value = "Insere o cálculo do frete no banco de dados e retorna o mesmo")
  public ResponseEntity<FreteResponse> calcularFrete(@RequestBody FreteRequest freteRequest) {

    return ResponseEntity.status(HttpStatus.CREATED)
      .body(freteService.calcular(freteRequest));

  }

}
