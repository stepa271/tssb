package com.tssb.dao.mapper;

import com.tssb.models.Schedule;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleMapper implements RowMapper<Schedule> {

    @Override
    public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
        Schedule schedule=new Schedule();
        schedule.setId(rs.getInt("id"));
        schedule.setTrainNumber(rs.getInt("train_number"));
        schedule.setStationId(rs.getInt("station_id"));
        schedule.setTime(rs.getString("time"));
        return schedule;
    }
}
