package com.tssb.dao;

import com.tssb.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//общается с БД или списками
@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
       return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
    }

    public Person show(int id) {

        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},new PersonMapper()).
                stream().findAny().orElse(null);
    }

    public void save(Person person) {
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("INSERT INTO Person VALUES(1,?,?,?)");
            preparedStatement.setString(1,person.getName());
            preparedStatement.setInt(2,person.getAge());
            preparedStatement.setString(3,person.getEmail());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

/*        try {
            Statement statement=connection.createStatement();
            String SQL="INSERT INTO Person VALUES("+1+",'"
                    +person.getName()+"'"+","+
                    person.getAge()+",'"+person.getEmail()+"')";
            // INSERT INTO Person VALUES(1,'Name',18,'email@mail.com')
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public void update(int id, Person updatedPerson) {
        try {
            PreparedStatement preparedStatement=connection.
                    prepareStatement("UPDATE Person SET name=?, age=?,email=? WHERE id=?");
            preparedStatement.setString(1,updatedPerson.getName());
            preparedStatement.setInt(2,updatedPerson.getAge());
            preparedStatement.setString(3,updatedPerson.getEmail());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement=
                    connection.prepareStatement("DELETE FROM Person WHERE id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}