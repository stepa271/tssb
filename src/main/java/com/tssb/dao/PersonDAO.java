package com.tssb.dao;

import com.tssb.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//общается с БД или списками
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    private static final String URL = "jdbc:mysql://hs-02:3306/sbb";
    private static final String username = "rootroot";
    private static final String password = "rootroot";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                people.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public Person show(int id) {
        Person person=null;
        try {
            PreparedStatement preparedStatement=connection.
                    prepareStatement("SELECT * FROM Person WHERE id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();

            person=new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setEmail(resultSet.getString("email"));
            person.setAge(resultSet.getInt("age"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
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