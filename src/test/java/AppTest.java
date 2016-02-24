import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Regulation Pad Check");
  }

  @Test
  public void padsAreNotRegulation() {
    goTo("http://localhost:4567/");
    fill("#width").with("13");
    fill("#length").with("45");
    submit(".btn");
    assertThat(pageSource()).contains("Your pads are not regulation");
  }

    @Test
    public void padsAreRegulation() {
      goTo("http://localhost:4567/");
      fill("#width").with("11");
      fill("#length").with("35");
      submit(".btn");
      assertThat(pageSource()).contains("Your pads are regulation");
  }
}
