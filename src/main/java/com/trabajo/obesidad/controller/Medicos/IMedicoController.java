package com.trabajo.obesidad.controller.Medicos;

import java.util.List;

import com.trabajo.obesidad.model.Medicos.MedicosModel;

public interface IMedicoController {
    public List<MedicosModel> findAll();
    public int save(MedicosModel c);
    public int update(MedicosModel c);
    public int delete(int id);
    public MedicosModel login(String nombre, String pass);
}
