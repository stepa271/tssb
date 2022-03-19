package com.tssb.dao.mapper;

import com.tssb.models.Station;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StationMapping implements RowMapper<Station> {

    @Override
    public Station mapRow(ResultSet rs, int rowNum) throws SQLException {
        Station station=new Station();
        station.setId(rs.getInt("id"));
        station.setName(rs.getString("name"));
        return station;
    }
}
