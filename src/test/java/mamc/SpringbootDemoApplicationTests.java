package mamc;

import com.fasterxml.jackson.databind.ObjectMapper;
import mamc.module.data.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
class SpringbootDemoApplicationTests {



    @Test
    public void readInput() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Person> myPeople = Arrays.asList(mapper.readValue(Paths.get("src/main/resources/input.json").toFile(), Person[].class));
        Assert.notNull(myPeople);
    }

}
