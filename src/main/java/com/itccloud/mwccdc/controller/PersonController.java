package com.itccloud.mwccdc.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itccloud.mwccdc.model.Person;

@Controller
public class PersonController {

    @GetMapping("/persons")
    public String listPersons(Model model) throws IOException {
        ClassPathResource csv = new ClassPathResource("persons.csv");
        try (Reader reader = new InputStreamReader(csv.getInputStream(), StandardCharsets.UTF_8)) {
            List<Person> people = Person.readPeople(reader);
            model.addAttribute("people", people);
        }
        return "persons";
    }
}