package com.trabajo.obesidad.repository.Medicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trabajo.obesidad.model.Medicos.MedicosModel;

@Repository
public class MedicoRepository implements IMedicoRepository{

    @Autowired
    private JdbcTemplate jdbc;
    @Override
    public List<MedicosModel> findAll() {
        String sql = "SELECT * FROM medicos";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(MedicosModel.class));
    }

    @Override
    public int save(MedicosModel usuario) {
        String sql = "INSERT INTO medicos(nombre, pass) VALUES (?, ?)";
        return jdbc.update(sql, usuario.getNombre(), usuario.getPass());
    }

    @Override
    public int update(MedicosModel usuario) {
        String sql = "UPDATE medicos set nombre = ?, pass = ? where id = ?";
        return jdbc.update(sql, usuario.getNombre(), usuario.getPass(), usuario.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "Delete from medicos where id = ?";
        return jdbc.update(sql, new Object[]{id});
    }

    @Override
    public MedicosModel login(String nombre, String pass) {
        String SQL = "Select * from medicos where nombre = ? and pass = ?";
        return jdbc.queryForObject(SQL, new Object[]{nombre, pass}, new BeanPropertyRowMapper<>(MedicosModel.class));
    }
    
}
