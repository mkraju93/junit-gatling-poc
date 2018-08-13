package pivotal;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

public class JsonService {

    private String fileName;
    private List<Person> personsList;

    public JsonService(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Person> getPersonsList() {
        return personsList;
    }

    public void loadJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Person>> mapType = new TypeReference<List<Person>>() {};
        personsList = objectMapper.readValue(new File("data.json"), mapType);
    }
}
