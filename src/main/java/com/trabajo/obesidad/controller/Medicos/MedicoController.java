package com.trabajo.obesidad.controller.Medicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabajo.obesidad.model.Medicos.MedicosModel;
import com.trabajo.obesidad.repository.Medicos.IMedicoRepository;

@Service
public class MedicoController implements IMedicoController {

    @Autowired
    private IMedicoRepository iCategoriaRepository;

    @Override
    public List<MedicosModel> findAll() {
        List<MedicosModel> list = null;
        try {
            list = iCategoriaRepository.findAll();
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public int save(MedicosModel pr) {
        int row;
        try {
            row = iCategoriaRepository.save(pr);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int update(MedicosModel pr) {
        int row;
        try {
            row = iCategoriaRepository.update(pr);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int delete(int id) {
        int row;
        try {
            row = iCategoriaRepository.delete(id);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }

    @Override
    public MedicosModel login(String nombre, String pass) {
        MedicosModel medico;
        try {
            medico = iCategoriaRepository.login(nombre, pass);
        } catch (Exception e) {
            throw e;
        }
        return medico;
    }

}
