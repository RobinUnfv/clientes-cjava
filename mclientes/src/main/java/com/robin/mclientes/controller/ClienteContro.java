package com.robin.mclientes.controller;

import com.robin.mclientes.dto.ClienteRequestDto;
import com.robin.mclientes.dto.ClienteResponseDto;
import com.robin.mclientes.service.IClienteServi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
@RequiredArgsConstructor
public class ClienteContro {

    private final IClienteServi clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDto crearCliente(@Valid @RequestBody ClienteRequestDto clienteRequestDto) {
        return clienteService.createCliente(clienteRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteResponseDto> listaClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDto obtenerClientePorId(@PathVariable String id) {
        return clienteService.getClienteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void actualizarCliente(@PathVariable String id, @Valid @RequestBody ClienteRequestDto clienteRequestDto) {
        clienteService.updateCliente(id, clienteRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarCliente(@PathVariable String id) {
        clienteService.deleteCliente(id);
    }


}
