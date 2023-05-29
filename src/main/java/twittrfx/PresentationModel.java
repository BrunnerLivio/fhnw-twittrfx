package twittrfx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PresentationModel {

  private final StringProperty applicationTitle = new SimpleStringProperty("JavaFX App");

  private final StringProperty greeting = new SimpleStringProperty("Hello World!");
  private final BooleanProperty darkMode = new SimpleBooleanProperty(false);

  public String getApplicationTitle() {
    return applicationTitle.get();
  }

  public StringProperty applicationTitleProperty() {
    return applicationTitle;
  }

  public void setApplicationTitle(String applicationTitle) {
    this.applicationTitle.set(applicationTitle);
  }

  public String getGreeting() {
    return greeting.get();
  }

  public StringProperty greetingProperty() {
    return greeting;
  }

  public void setGreeting(String greeting) {
    this.greeting.set(greeting);
  }

  public void toggleDarkMode() {
    darkMode.set(!darkMode.get());
  }

  public BooleanProperty isDarkMode() {
    return darkMode;
  }
}
