package com.robin.mclientes.service;

import com.robin.mclientes.dto.ClienteRequestDto;
import com.robin.mclientes.dto.ClienteResponseDto;
import com.robin.mclientes.mapper.ClienteMapper;
import com.robin.mclientes.model.Cliente;
import com.robin.mclientes.repository.IClienteRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteServImpl implements IClienteServi{

    private final IClienteRepo clienteRepo;
    private final ClienteMapper clienteMapper;


    @Override
    public ClienteResponseDto createCliente(ClienteRequestDto clienteRequestDto) {
        var cliente = clienteMapper.toCliente(clienteRequestDto);
        var clienteS = clienteRepo.save(cliente);
        return clienteMapper.toClienteResponseDto(clienteS);
    }

    @Override
    public List<ClienteResponseDto> getAllClientes() {
        return clienteRepo.findAll().stream()
                .map(clienteMapper::toClienteResponseDto)
                .toList();
    }

    @Override
    public ClienteResponseDto getClienteById(String id) {
        var cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
        return clienteMapper.toClienteResponseDto(cliente);
    }

    @Override
    public ClienteResponseDto updateCliente(String id, ClienteRequestDto clienteRequestDto) {
        var cliente = clienteRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Cliente no encontrado con id: " + id)
        );
        clienteMapper.updateClienteFromRequest(clienteRequestDto, cliente);
        var clienteSave = clienteRepo.save(cliente);
        log.info("Cliente actualizado: {}", clienteSave);
        return clienteMapper.toClienteResponseDto(clienteSave);
    }

    @Override
    public void deleteCliente(String id) {
      if (!clienteRepo.existsById(id)) {
          throw new RuntimeException("Cliente no encontrado con id: " + id);
      }
      clienteRepo.deleteById(id);
      log.info("Cliente eliminado con id: {}", id);
    }
}
