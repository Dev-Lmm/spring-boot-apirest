package com.devlmm.spring.apirest.models.services;

import com.devlmm.spring.apirest.models.entity.Client;
import com.devlmm.spring.apirest.models.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClienteService {
    public List<Client> findAll();
    public Page<Client> findAll(Pageable pageable);
    public Client findById(Long id);
    public Client save(Client client);
    public void  delete(Long id);
    public List <Region> findAllRegiones();
}
