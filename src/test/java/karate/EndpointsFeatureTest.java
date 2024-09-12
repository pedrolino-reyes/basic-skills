package karate;

import com.calendula.basics.Application;
import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(
    classes = {Application.class},
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EndpointsFeatureTest {

    @LocalServerPort private String localServerPort;

    @Karate.Test
    public Karate testRoot() {
        return runScenario("Hit the root endpoint");
    }

    @Karate.Test
    public Karate testCalculator() {
        return runScenario("Hit the calculator endpoint");
    }

    private Karate runScenario(String s) {
        return Karate.run()
                .scenarioName(s)
                .relativeTo(getClass())
                .systemProperty("karate.port", localServerPort)
                .karateEnv("dev");
    }
}