package com.springvalidation.controller;

import com.springvalidation.model.FormValidation;
import com.springvalidation.model.Index;
import com.springvalidation.model.Person;
import com.springvalidation.util.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ejb.EJB;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus
 */
@Controller
@RequestMapping("/")
public class FormController
    {

    @EJB
    private DBManager dbManager;

    @RequestMapping(value = "/form")
    public String form(Model model)
        {
        model.addAttribute("formValidation", new FormValidation());
        return "formvalidation";
        }

    @RequestMapping(value = "/")
    public String index(Model model)
    {
        Index indx = new Index();
        List<Person> persons = new ArrayList<>(100);
        for (int i = 0; i < 77; i++)
        {
            Person person = new Person();
            person.setId(String.valueOf(i));
            person.setFirstName("John" + i);
            person.setLastName("the Baptist" + i);
            persons.add(person);
        }
        model.addAttribute("persons", persons);
        model.addAttribute("index", indx);
        return "index";
    }

        @RequestMapping(value = {"/table"}, method = RequestMethod.GET)
        public String table(Model model)
        {
            List<Person> persons = new ArrayList<>(100);
            for (int i = 0; i < 100; i++)
            {
                Person person = new Person();
                person.setId(String.valueOf(i));
                person.setFirstName("John" + i);
                person.setLastName("Doe" + i);
                persons.add(person);
            }
            model.addAttribute("persons", persons);
            return "table";
        }

    @Transactional
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String indexvalidation(Model model, @Valid Index index, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            List<Person> persons = new ArrayList<>(100);
            for (int i = 0; i < 78; i++)
            {
                Person person = new Person();
                person.setId(String.valueOf(i));
                person.setFirstName("Johnny" + i);
                person.setLastName("the Baptist" + i);
                persons.add(person);
            }
            model.addAttribute("persons", persons);
            return "index";
        }
        dbManager.createMessage(index.getData());
        return "redirect:/success";
    }


        @RequestMapping(value = "/success")
    public String success()
        {
        return "success";
        }


    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String formvalidation(@Valid FormValidation formValidation, BindingResult bindingResult)
        {

        if(bindingResult.hasErrors())
            {
                return "formvalidation";
            }


        return "redirect:/success";

        }

    }
