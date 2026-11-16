package com.robin.mclientes.service;

import com.robin.mclientes.dto.ClienteRequestDto;
import com.robin.mclientes.dto.ClienteResponseDto;

import java.util.List;

public interface IClienteServi {
    ClienteResponseDto createCliente(ClienteRequestDto clienteRequestDto);
    List<ClienteResponseDto> getAllClientes();
    ClienteResponseDto getClienteById(String id);
    ClienteResponseDto updateCliente(String id, ClienteRequestDto clienteRequestDto);
    void deleteCliente(String id);
}
