package com.trabajo.obesidad.controller;
import java.util.List;

import com.trabajo.obesidad.model.*;

public interface IUsuarioController {
    public List<UsuarioModel> findAll();
    public int save(UsuarioModel c);
    public int update(UsuarioModel c);
    public int delete(int id);
}
