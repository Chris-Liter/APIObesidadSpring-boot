package com.trabajo.obesidad.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trabajo.obesidad.model.UsuarioModel;

@Repository
public class UsuarioRepository implements IObesidadRepository{

   @Autowired
    private JdbcTemplate jdbc;
    @Override
    public List<UsuarioModel> findAll() {
        String sql = "SELECT * FROM usuarios";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(UsuarioModel.class));
    }

    @Override
    public int save(UsuarioModel usuario) {
        String sql = "INSERT INTO usuarios(cedula, nombres, apellidos, telefono, correo, edad, altura, peso, historialfamiliar, entrecomidas, comidascaloricas, prediacnostico, recomendacion)\r\n" + //
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbc.update(sql, usuario.getCedula(), usuario.getNombres(), usuario.getApellidos(), usuario.getTelefono(), usuario.getCorreo(), usuario.getEdad(), usuario.getAltura(), usuario.getPeso(), usuario.isHistorialfamiliar(), usuario.getEntrecomidas(), usuario.isComidascaloricas(), usuario.getPrediacnostico(), usuario.getRecomendacion());
    }

    @Override
    public int update(UsuarioModel usuario) {
        String sql = "UPDATE usuarios set cedula = ?, nombres = ?, apellidos = ?, telefono = ?, correo = ?, edad = ?, altura = ?, peso = ?, historialfamiliar =?,entrecomidas = ?, comidascaloricas = ?, prediacnostico = ?, recomendacion = ? where id = ?";
        return jdbc.update(sql, usuario.getCedula(), usuario.getNombres(), usuario.getApellidos(), usuario.getTelefono(), usuario.getCorreo(), usuario.getEdad(), usuario.getAltura(), usuario.getPeso(), usuario.isHistorialfamiliar(), usuario.getEntrecomidas(), usuario.isComidascaloricas(), usuario.getPrediacnostico(), usuario.getRecomendacion(),usuario.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "Delete from usuarios where id = ?";
        return jdbc.update(sql, new Object[]{id});
    }
}
