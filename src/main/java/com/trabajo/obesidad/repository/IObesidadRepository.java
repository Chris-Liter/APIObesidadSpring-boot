package com.trabajo.obesidad.repository;

import java.util.List;

import com.trabajo.obesidad.model.UsuarioModel;

public interface IObesidadRepository {
    
    public List<UsuarioModel> findAll();
    public int save(UsuarioModel c);
    public int update(UsuarioModel c);
    public int delete(int id);
}
