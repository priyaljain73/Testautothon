import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/composite_feature", format = {
    "json:target/destination/cucumber.json"}, tags = {})
public class CucumberRunner {
}
