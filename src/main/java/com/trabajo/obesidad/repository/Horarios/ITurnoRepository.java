package com.trabajo.obesidad.repository.Horarios;


import java.util.List;

import com.trabajo.obesidad.model.Horarios.TurnoModel;;

public interface ITurnoRepository {
    public List<TurnoModel> findAll();
    public int save(TurnoModel c);
    public int update(TurnoModel c);
    public int delete(int id);
}
