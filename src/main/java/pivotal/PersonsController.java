package pivotal;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

@RestController
public class PersonsController {
    private JsonService jsonData = new JsonService("data.json");

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/io")
    public String io() throws InterruptedException {
        long sleepDuration = 200L + (long) (500L * Math.random());
        Thread.sleep(sleepDuration);
        return "done after " + sleepDuration + "ms";
    }

    @GetMapping("/person")
    public List person() throws IOException {
        jsonData.loadJson();
        return jsonData.getPersonsList();
    }

    @GetMapping("/person/{id}")
    public String personByID(@PathVariable Integer id) throws IOException {
        jsonData.loadJson();
        if (id < 1000 && id > 0){
            return jsonData.getPersonsList().get(id - 1).toString();
        }
        return "No one with that ID exists";
    }
}
