package com.tssb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TicketDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Ticket> index() {
        return jdbcTemplate.query("SELECT * FROM Ticket",
                new BeanPropertyRowMapper<>(Ticket.class));
    }
    public Ticket show(int id) {

        return jdbcTemplate.query("SELECT * FROM Ticket WHERE id=?",
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(Ticket.class)).
                stream().findAny().orElse(null);
    }
    public void save(Ticket ticket) {
        jdbcTemplate.update("INSERT INTO Ticket VALUES(1,?,?)",
                ticket.getTrainNumber(),ticket.getClientId());
    }
    public void update(int id, Ticket updatedTicket) {
        jdbcTemplate.update("UPDATE Ticket SET train_number=?,client_id=? Where id=?",
                updatedTicket.getTrainNumber(),updatedTicket.getClientId(), id);
    }
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Ticket WHERE id=?", id);
    }
}
