package com.robin.cclientes.service.client;

import com.robin.cclientes.dto.ClienteRequestDto;
import com.robin.cclientes.dto.ClienteResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClienteServImpl implements IClienteServ {

    private final IClienteClient clienteClient;

    @Override
    public Mono<ClienteResponseDto> getClienteId(String id) {
        return clienteClient.getClienteId(id);
    }

    @Override
    public Mono<ClienteResponseDto> guardarCliente(ClienteRequestDto clienteRequestDto) {
        return clienteClient.guardarCliente(clienteRequestDto);
    }

}
