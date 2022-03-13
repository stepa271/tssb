package com.tssb.dao.mapper;

import com.tssb.models.Ticket;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMapper implements RowMapper<Ticket> {
    @Override
    public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ticket ticket=new Ticket();
        ticket.setId(rs.getInt("id"));
        ticket.setClientId(rs.getInt("client_id"));
        ticket.setTrainNumber(rs.getInt("train_number"));
        return ticket;
    }
}
