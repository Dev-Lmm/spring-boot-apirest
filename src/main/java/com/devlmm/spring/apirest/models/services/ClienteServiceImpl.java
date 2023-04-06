package com.devlmm.spring.apirest.models.services;

import com.devlmm.spring.apirest.models.dao.IClientDao;
import com.devlmm.spring.apirest.models.entity.Client;
import com.devlmm.spring.apirest.models.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{
    @Autowired
    private IClientDao clienteDao;
    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll(){
        return (List<Client>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Client> findAll(Pageable pageable) {
        return clienteDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Client findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Client save(Client client) {
        return clienteDao.save(client);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegiones() { return clienteDao.findAllRegiones(); }
}
