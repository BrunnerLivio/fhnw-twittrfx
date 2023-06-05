package twittrfx;

import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import twittrfx.bird.BirdPM;
import twittrfx.bird.BirdService;
import twittrfx.bird.BirdServiceCloud;
import twittrfx.bird.BirdServiceLocal;

public class PresentationModel {
  private final ObjectProperty<ConnectionType> connectionType = new SimpleObjectProperty<>(
      ConnectionType.LOCAL);
  private final SimpleBooleanProperty connectionStatus = new SimpleBooleanProperty(false);
  private final BirdService birdServiceLocal = new BirdServiceLocal("birds_of_switzerland.tsv");
  private final BirdService birdServiceCloud = new BirdServiceCloud("http://localhost:8000");

  private BirdService birdService = birdServiceLocal;

  private ObjectProperty<BirdPM> selectedBird = new SimpleObjectProperty<>();
  private final BooleanProperty darkMode = new SimpleBooleanProperty(false);

  private final ObservableList<BirdPM> birds = FXCollections
      .observableArrayList(item -> new Observable[] { item.topSpeedInKmhProperty() });

  public PresentationModel() {
    load();
  }

  private void load() {
    birds.clear();

    try {
      birds.addAll(this.birdService.load());
      selectedBird.setValue(getBirds().get(0));
      connectionStatus.set(true);
    } catch (Exception e) {
      connectionStatus.set(false);
      selectedBird.setValue(null);
    }

  }

  public void toggleDarkMode() {
    darkMode.set(!darkMode.get());
  }

  public void save() {
    try {
      this.birdService.saveAll(birds.stream().toList());
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalStateException("save failed");
    }
  }

  public ObservableList<BirdPM> getBirds() {
    return birds;
  }

  public void addBird() {
    BirdPM bird = new BirdPM("New Bird");
    birds.add(bird);
    setSelectedBird(bird);
  }

  public void removeBird(BirdPM bird) {
    birds.remove(bird);
    setSelectedBird(birds.get(birds.size() - 1));
  }

  public BirdPM getSelectedBird() {
    return selectedBird.getValue();
  }

  public void setSelectedBird(BirdPM selectedBird) {
    this.selectedBird.setValue(selectedBird);
  }

  public void toggleConnectionType() {
    if (connectionType.get() == ConnectionType.LOCAL) {
      connectionType.set(ConnectionType.CLOUD);
      birdService = birdServiceCloud;
    } else {
      connectionType.set(ConnectionType.LOCAL);
      birdService = birdServiceLocal;
    }

    load();
  }

  public ObjectProperty<ConnectionType> getConnectionTypeProperty() {
    return connectionType;
  }

  public ObjectProperty<BirdPM> selectedBirdProperty() {
    return selectedBird;
  }

  public BooleanProperty darkModeProperty() {
    return darkMode;
  }

  public BooleanProperty connectionStatusProperty() {
    return connectionStatus;
  }
}
