package twittrfx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import twittrfx.bird.BirdPM;
import twittrfx.bird.BirdService;
import twittrfx.bird.BirdServiceLocal;

public class PresentationModel {

  private final StringProperty greeting = new SimpleStringProperty("Hello World!");
  private final BooleanProperty darkMode = new SimpleBooleanProperty(false);

  private final BirdService birdService = new BirdServiceLocal("birds_of_switzerland.tsv");
  private final ObservableList<BirdPM> birds = FXCollections.observableArrayList();

  public PresentationModel() {
    birds.addAll(this.birdService.load());
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

  public void save() {
    birdService.saveAll(birds.stream().toList());
  }

  public ObservableList<BirdPM> getBirds() {
    return birds;
  }

}
