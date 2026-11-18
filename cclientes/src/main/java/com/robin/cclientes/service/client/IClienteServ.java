package com.robin.cclientes.service.client;

import com.robin.cclientes.dto.ClienteRequestDto;
import com.robin.cclientes.dto.ClienteResponseDto;
import reactor.core.publisher.Mono;

public interface IClienteServ {

    Mono<ClienteResponseDto> getClienteId(String id);
    Mono<ClienteResponseDto> guardarCliente(ClienteRequestDto dto);
}
