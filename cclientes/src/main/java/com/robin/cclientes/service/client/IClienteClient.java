package com.robin.cclientes.service.client;

import com.robin.cclientes.dto.ClienteRequestDto;
import com.robin.cclientes.dto.ClienteResponseDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;


public interface IClienteClient {

    @GetExchange("/api/clientes1/{id}")
    Mono<ClienteResponseDto> getClienteId(@PathVariable String id);

    @PostExchange("/api/clientes1")
    Mono<ClienteResponseDto> guardarCliente(@RequestBody ClienteRequestDto clienteRequestDto);

}
