package com.trabajo.obesidad.repository.Horarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trabajo.obesidad.model.Horarios.TurnoModel;

@Repository
public class TurnoRepository implements ITurnoRepository{

    @Autowired
    private JdbcTemplate jdbc;
    
    @Override
    public List<TurnoModel> findAll() {
        String sql = "SELECT * FROM turnos";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(TurnoModel.class));
    }

    @Override
    public int save(TurnoModel usuario) {
        String sql = "INSERT INTO turnos(fecha, hora, id_usuario, id_medico)\r\n" + //
                        "VALUES (?, ?, ?, ?)";
        return jdbc.update(sql, usuario.getFecha(), usuario.getHora(), usuario.getId_usuario(), usuario.getId_medico());
    }

    @Override
    public int update(TurnoModel usuario) {
        String sql = "UPDATE turnos set fecha = ?, hora = ?, id_usuario = ?, id_medico = ? where id = ?";
        return jdbc.update(sql, usuario.getFecha(), usuario.getHora(), usuario.getId_usuario(), usuario.getId_medico(), usuario.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "Delete from turnos where id = ?";
        return jdbc.update(sql, new Object[]{id});
    }

}