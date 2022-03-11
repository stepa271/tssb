package com.tssb.dao;

import com.tssb.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Client> index(){
        return jdbcTemplate.query("SELECT * FROM Client",
        new BeanPropertyRowMapper<>(Client.class));
    }
    public Client show(int id){
        return jdbcTemplate.query("SELECT * FROM Client WHERE id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Client.class)).
                stream().findAny().orElse(null);
    }
    public void save(Client client){
        jdbcTemplate.update("INSERT INTO Client VALUES(1,?,?,?)",
                client.getName(),client.getSurname(),client.getBirthday());
    }

    public void update(int id, Client updateClient){
        jdbcTemplate.update("UPDATE Client SET name=?,surname=?,birthdate=? Where id=?",
                updateClient.getName(),updateClient.getSurname(),
                updateClient.getBirthday(), id);    }


    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Client WHERE id=?", id);
    }

}
