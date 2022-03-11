package com.tssb.dao;
import com.tssb.models.Client;
import com.tssb.models.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ScheduleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Schedule> index(){
        return jdbcTemplate.query("SELECT * FROM Schedule",
                new BeanPropertyRowMapper<>(Schedule.class));
    }

    public Schedule show(int id){
        return jdbcTemplate.query("SELECT * FROM Schedule WHERE id=?",
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(Schedule.class)).
                stream().findAny().orElse(null);
    }
    public void save(Schedule schedule){
        jdbcTemplate.update("INSERT INTO Schedule VALUES(1,?,?,?)",
                schedule.getId(),schedule.getTrainNumber(),
                schedule.getIdStation(),schedule.getTime());
    }
    public void update(int id, Schedule updateSchedule){
        jdbcTemplate.update
                ("UPDATE Schedule SET train_number=?,station_id=?,time=? Where id=?",
               updateSchedule.getTrainNumber(),updateSchedule.getIdStation(),
                        updateSchedule.getTime(),id);
    }


    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Schedule WHERE id=?", id);
    }

}
