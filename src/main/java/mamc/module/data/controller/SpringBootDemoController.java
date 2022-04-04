package mamc.module.data.controller;

import mamc.module.data.model.Person;
import mamc.module.data.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "api", produces = "application/json")
public class SpringBootDemoController {

    @Autowired
    PersonRepository repo;

    //TODO: API that queries DB in differents ways with Spring Data JPa
    @GetMapping(value = "ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("addPerson")
    public ResponseEntity updatePersonInfo(@RequestBody Person person){
        repo.save(person);
        return new ResponseEntity(repo.save(person), HttpStatus.OK);
    }

    @PostMapping("addPersonsBulk")
    public ResponseEntity updatePersonInfo(@RequestBody List<Person> personList){
        //repo.saveAll(personList);
        return new ResponseEntity(repo.saveAll(personList), HttpStatus.OK);
    }

    @GetMapping("getAllPersons")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> personList = repo.findAll();
        return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
    }

    @GetMapping("getPersonById/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
        Optional<Person> personItem = repo.findById(id);
        if (personItem.isPresent()) {
            return new ResponseEntity<Person>(personItem.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //TODO: fixdis
    @GetMapping("deletePerson/{id}")
     public ResponseEntity deletePerson(@PathVariable("id") long id){
            repo.delete(repo.findById(id).get());
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/deleteAllPersons")
    public ResponseEntity deleteAllPersons(){
        return null;
    }





}
