package com.robin.cclientes.service.client;

import com.robin.cclientes.dto.ClienteRequestDto;
import com.robin.cclientes.dto.ClienteResponseDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;


public interface IClienteClient {

    @GetExchange("/api/v1/cliente/{id}")
    ClienteResponseDto getClienteId(@PathVariable String id);

    @PostExchange("/api/v1/cliente")
    ClienteResponseDto guardarCliente(@Pa ClienteRequestDto clienteRequestDto);

}
