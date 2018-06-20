import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import com.bancolombia.reto.utils.BeforeSuite;
import com.bancolombia.reto.utils.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

//import org.junit.runner.RunWith;
//
//import cucumber.api.CucumberOptions;
//import net.serenitybdd.cucumber.CucumberWithSerenity;
//
//@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(features ="src/test/resources/features/AgendarCitas.feature" , tags="@Exitoso")
////@CucumberOptions(features ="src/test/resources/features/ColorLib/nombre.feature")
//public class HerokuAppRunner {
//	
//}

@CucumberOptions(features = "src/test/resources/features/AgendarCitas.feature", tags = "@TestCase1", snippets = SnippetType.CAMELCASE, plugin = {
"json:target/cucumber_json/cucumber.json" })

@RunWith(RunnerPersonalizado.class)
public class HerokuAppRunner {
	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
	DataToFeature.overrideFeatureFiles("./src/test/resources/features/");
	}
}
