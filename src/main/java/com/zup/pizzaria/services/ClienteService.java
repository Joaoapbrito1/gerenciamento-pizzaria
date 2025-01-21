package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.dtos.ClienteRequestDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteDTO criarCliente(ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = new Cliente(
                clienteRequestDTO.getNome(),
                clienteRequestDTO.getEmail(),
                clienteRequestDTO.getTelefone()
        );
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return new ClienteDTO(
                clienteSalvo.getId(),
                clienteSalvo.getNome(),
                clienteSalvo.getEmail(),
                clienteSalvo.getTelefone()
        );
    }
}
