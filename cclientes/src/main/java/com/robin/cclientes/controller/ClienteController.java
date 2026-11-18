package com.robin.cclientes.controller;

import com.robin.cclientes.dto.ClienteRequestDto;
import com.robin.cclientes.dto.ClienteResponseDto;
import com.robin.cclientes.service.client.IClienteServ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clientes2")
public class ClienteController {

    private final IClienteServ clienteService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ClienteResponseDto> obtenerClientePorId(@PathVariable String id) {
        return clienteService.getClienteId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ClienteResponseDto> guardarCliente(@Valid @RequestBody ClienteRequestDto clienteRequestDto) {
        return clienteService.guardarCliente(clienteRequestDto);
    }

}
