package mamc.module.data.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import mamc.module.data.model.Person;
import mamc.module.data.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "api", produces = "application/json")
public class SpringBootDemoController {
    static final String INPUT_JSON_PATH = "src/main/resources/input.json";


    @Autowired
    PersonRepository repo;

    @GetMapping(value = "ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("addPerson")
    public ResponseEntity updatePersonInfo(@RequestBody Person person){
        repo.save(person);
        return new ResponseEntity(repo.save(person), HttpStatus.OK);
    }

    @GetMapping("addAllPeople")
    public ResponseEntity addAllPersons() throws IOException{
        return new ResponseEntity(repo.saveAll(getPeople()), HttpStatus.OK);
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

    @GetMapping("getPersonByName/{name}")
    public ResponseEntity<List<Person>> getPersonByName(@PathVariable("name") String name) {
        List<Person> personItem = repo.findByName(name);
        if (personItem.isEmpty() == false) {
            return new ResponseEntity<List<Person>>(personItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("deletePerson/{id}")
     public ResponseEntity deletePerson(@PathVariable("id") long id){
        Optional<Person> per= repo.findById(id);
        repo.delete(per.get());
        return new ResponseEntity<Person>(HttpStatus.OK);

    }

    @GetMapping("deleteAllPersons")
    public ResponseEntity deleteAllPersons(){
        repo.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

    public List<Person> getPeople() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(Paths.get(INPUT_JSON_PATH).toFile(), Person[].class));
    }

}

