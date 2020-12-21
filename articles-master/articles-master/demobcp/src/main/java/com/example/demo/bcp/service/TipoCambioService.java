package com.example.demo.bcp.service;

import com.example.demo.bcp.dao.ITipoCambioDAO;
import com.example.demo.bcp.model.TipoCambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoCambioService {

    @Autowired
    private ITipoCambioDAO dao;

    public TipoCambio save(TipoCambio t) { return dao.save(t); }

    public TipoCambio update(TipoCambio t) { return dao.save(t); }

    public void delete(TipoCambio t) { dao.delete(t); }

    public Iterable<TipoCambio> list() { return dao.findAll(); }

    public Optional<TipoCambio> listId(long id) {
        return dao.findById(id);
    }

}
