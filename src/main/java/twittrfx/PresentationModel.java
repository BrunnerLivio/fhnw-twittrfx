package twittrfx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import twittrfx.bird.BirdPM;
import twittrfx.bird.BirdService;
import twittrfx.bird.BirdServiceLocal;

public class PresentationModel {

  private ObjectProperty<BirdPM> selectedBird = new SimpleObjectProperty<>();
  private final BooleanProperty darkMode = new SimpleBooleanProperty(false);

  private final BirdService birdService = new BirdServiceLocal("birds_of_switzerland.tsv");
  private final ObservableList<BirdPM> birds = FXCollections.observableArrayList();

  public PresentationModel() {
    birds.addAll(this.birdService.load());
    selectedBird.setValue(getBirds().get(0));
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

  public void addBird() {
    BirdPM bird = new BirdPM("New Bird");
    birds.add(bird);
    setSelectedBird(bird);
  }

  public BirdPM getSelectedBird() {
    return selectedBird.getValue();
  }

  public void setSelectedBird(BirdPM selectedBird) {
    this.selectedBird.setValue(selectedBird);
  }

  public ObjectProperty<BirdPM> selectedBirdProperty() {
    return selectedBird;
  }

}
