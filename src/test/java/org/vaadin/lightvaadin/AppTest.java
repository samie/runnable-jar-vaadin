package org.vaadin.lightvaadin;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppTest {
  private static int port = (int) (System.currentTimeMillis() % 10000);
  private static AtomicBoolean started = new AtomicBoolean();
  
  @BeforeClass
  public synchronized static void startServer() throws Exception {
    if (!started.get()) {
      App.start(port);
      started.set(true);
    }
    Configuration.startMaximized = false;
    Configuration.reportsFolder = "target/surefire-reports";
  }

  @Test
  public void canSayHelloWorld() {
    open("http://localhost:" + port);
    $(".helloworldui").shouldHave(text("Hello world"));
    $(".v-button").shouldHave(text("Click me")).click();
    $(withText("Hello at")).should(appear);
  }
}
