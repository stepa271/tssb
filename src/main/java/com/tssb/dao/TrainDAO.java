package com.tssb.dao;

import com.tssb.models.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TrainDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TrainDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Train> index() {
        return jdbcTemplate.query("SELECT * FROM Train",
                new BeanPropertyRowMapper<>(Train.class));
    }

    public Train show(int id) {

        return jdbcTemplate.query
                        ("SELECT * FROM train WHERE NUMTRAIN=?",
                                new Object[]{id},
                                new BeanPropertyRowMapper<>(Train.class)).
                stream().findAny().orElse(null);
    }

    public void save(Train train) {
        jdbcTemplate.update("INSERT INTO train VALUES(?,?)",
               train.getId(), train.getCapacity());
    }

    public void update(int train_num, Train updatedTrain) {
        jdbcTemplate.update("UPDATE Train SET capacity=? Where NUMTRAIN=?",
                updatedTrain.getCapacity(), train_num);
    }
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM train WHERE NUMTRAIN=?", id);
    }
}


