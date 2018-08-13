package pivotal;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonServiceTest {

    private JsonService jsonData = new JsonService("testData.json");

    @Test
    public void contextLoads() throws Exception {
        assertThat(jsonData.getPersonsList() == null);
    }

    @Test
    public void loadData() throws Exception {
        jsonData.loadJson();
        assertThat(jsonData.getPersonsList().size() == 1000);
    }

    @Test
    public void testPerson() throws Exception {
        jsonData.loadJson();
        Person person = jsonData.getPersonsList().get(0);
        assertThat(person.getId() == 749);
        assertThat(person.getFirst_name().equals("Test"));
        assertThat(person.getLast_name().equals("User"));
        assertThat(person.getEmail().equals("testuser@example.com"));
        assertThat(person.getGender().equals("Male"));
        assertThat(person.getIp_address().equals("00.000.00.00"));
    }
}
