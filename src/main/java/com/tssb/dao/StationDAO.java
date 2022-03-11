package com.tssb.dao;

import com.tssb.models.Client;
import com.tssb.models.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StationDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Station> index(){
        return jdbcTemplate.query("SELECT * FROM Station",
                new BeanPropertyRowMapper<>(Station.class));
    }

    public Station show(int id){
        return jdbcTemplate.query("SELECT * FROM Station WHERE id=?",
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(Station.class)).
                stream().findAny().orElse(null);
    }

    public void save(Station station){
        jdbcTemplate.update("INSERT INTO Station VALUES(1,?)",
                station.getName());
    }
    public void update(int id, Station updateStation){
        jdbcTemplate.update("UPDATE Station SET name=? Where id=?",
              updateStation.getName() , id);    }

    public void delete(int id){
        jdbcTemplate.update
                ("DELETE FROM Station WHERE id=?", id);
    }

}
