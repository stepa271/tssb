package com.tssb.dao;

import com.tssb.models.Person;
import org.springframework.stereotype.Component;

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
       List <Person> people =new ArrayList<>();
        try {
            Statement statement=connection.createStatement();
            String SQL="SELECT * FROM Person";
            ResultSet resultSet=statement.executeQuery(SQL);
            while (resultSet.next()){
                Person person=new Person();
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
        //      return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null;
    }

    public void save(Person person) {
        try {
            Statement statement=connection.createStatement();
            String SQL="INSERT INTO Person VALUES("+1+",'"
                    +person.getName()+"'"+","+
                    person.getAge()+",'"+person.getEmail()+"')";
            // INSERT INTO Person VALUES(1,'Name',18,'email@mail.com')
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Person updatedPerson) {
    /*    Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());*/
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}