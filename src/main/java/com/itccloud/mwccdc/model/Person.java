package com.itccloud.mwccdc.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String firstName;
    private String lastName;
    private String gender;
    private Address address;

    public Person() {
    }

    public Person(String firstName, String lastName, String gender, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGender() { return gender; }
    public Address getAddress() { return address; }

    public static List<Person> readPeople(Reader reader) throws IOException {
        List<Person> people = new ArrayList<>();
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setIgnoreSurroundingSpaces(true)
                .build();

        try (CSVParser csvParser = new CSVParser(reader, format)) {
            for (CSVRecord record : csvParser) {
                Address address = Address.fromString(record.get(3));
                people.add(new Person(record.get(0), record.get(1), record.get(2), address));
            }
        }
        return people;
    }
}