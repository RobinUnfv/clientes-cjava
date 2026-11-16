package com.robin.mclientes.mapper;

import com.robin.mclientes.dto.ClienteRequestDto;
import com.robin.mclientes.dto.ClienteResponseDto;
import com.robin.mclientes.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    Cliente toCliente(ClienteRequestDto requestDto);

    ClienteResponseDto toClienteResponseDto(Cliente cliente);

    void updateClienteFromRequest(ClienteResponseDto requestDto, @MappingTarget Cliente cliente);

}
