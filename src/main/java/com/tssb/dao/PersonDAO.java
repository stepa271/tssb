package com.tssb.dao;

import com.tssb.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//общается с БД или списками
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {people=new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tomas"));
        people.add(new Person(++PEOPLE_COUNT,"Robin"));
        people.add(new Person(++PEOPLE_COUNT,"Mike"));
        people.add(new Person(++PEOPLE_COUNT,"Final"));
    }

    public  List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().
                filter(person->person.getId()==id).
                findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
            }

            public void update(int id, Person updatePersone){
            Person personToBeUpdated=show(id);
            personToBeUpdated.setName(updatePersone.getName());

            }

    public void delete(int id) {
        people.removeIf(p-> p.getId()==id);
    }
}
