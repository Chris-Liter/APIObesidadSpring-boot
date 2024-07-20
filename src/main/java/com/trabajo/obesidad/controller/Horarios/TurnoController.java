package com.trabajo.obesidad.controller.Horarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabajo.obesidad.model.Horarios.TurnoModel;
import com.trabajo.obesidad.repository.Horarios.ITurnoRepository;

@Service
public class TurnoController implements ITurnoController{

    @Autowired
    private ITurnoRepository iCategoriaRepository;

    @Override
    public List<TurnoModel> findAll() {
        List<TurnoModel> list = null;
        try{
            list = iCategoriaRepository.findAll();
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public int save(TurnoModel pr) {
        int row;
        try{
            row = iCategoriaRepository.save(pr);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int update(TurnoModel pr) {
        int row;
        try{
            row = iCategoriaRepository.update(pr);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int delete(int id) {
        int row;
        try{
            row = iCategoriaRepository.delete(id);
        }catch (Exception e){
            throw e;
        }
        return row;
    }
    
}
