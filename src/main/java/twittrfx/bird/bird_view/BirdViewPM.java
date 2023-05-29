package twittrfx.bird.bird_view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import twittrfx.bird.BirdPM;
import twittrfx.bird.BirdService;
import twittrfx.bird.BirdServiceLocal;

public class BirdViewPM {
  private final ObservableList<BirdPM> birds = FXCollections.observableArrayList();
  private final BirdService birdService = new BirdServiceLocal("birds_of_switzerland.tsv");

  private ObjectProperty<BirdPM> selectedBird = new SimpleObjectProperty<>();

  public BirdViewPM() {
    birds.addAll(this.birdService.load());
    selectedBird.setValue(birds.get(0));
  }

  public ObservableList<BirdPM> getBirds() {
    return birds;
  }

  public int highestTopSpeed() {
    return birds.stream()
        .mapToInt(bird -> bird.getTopSpeedInKmh())
        .max()
        .orElse(0);
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
