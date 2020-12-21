package com.example.demo.bcp.dao;

import com.example.demo.bcp.model.TipoCambio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoCambioDAO extends CrudRepository<TipoCambio, Long> {

}
