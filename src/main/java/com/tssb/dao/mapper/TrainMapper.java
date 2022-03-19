package com.tssb.dao.mapper;

import com.tssb.models.Train;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainMapper implements RowMapper<Train> {
    @Override
    public Train mapRow(ResultSet rs, int rowNum) throws SQLException {
        Train train= new Train();
        train.setId(rs.getInt("NUMTRAIN"));
        train.setCapacity(rs.getInt("capacity"));
        return train;
    }
}
