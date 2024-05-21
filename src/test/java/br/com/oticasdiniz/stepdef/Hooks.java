package br.com.oticasdiniz.stepdef;

import br.com.oticasdiniz.utils.reports.screenshot.ScenarioRepository;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static br.com.oticasdiniz.base.BaseTest.setup;
import static br.com.oticasdiniz.base.BaseTest.teardown;

public class Hooks {
    @Before
    public static void before(Scenario scenario){
        setup("CHROME");
        ScenarioRepository.add(scenario);
    }

    @After
    public static void after(Scenario scenario){
        if (scenario.isFailed()){
            ScenarioRepository.screenShot();
        }
        teardown();
        ScenarioRepository.remove();
    }
}
