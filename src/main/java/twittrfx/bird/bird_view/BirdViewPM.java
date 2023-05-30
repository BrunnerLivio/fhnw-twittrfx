package twittrfx.bird.bird_view;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import twittrfx.PresentationModel;
import twittrfx.bird.BirdPM;

public class BirdViewPM {
  private ObjectProperty<BirdPM> selectedBird = new SimpleObjectProperty<>();
  private final PresentationModel rootModel;

  public BirdViewPM(PresentationModel rootModel) {
    selectedBird.setValue(rootModel.getBirds().get(0));
    this.rootModel = rootModel;
  }

  public ObservableList<BirdPM> getBirds() {
    return rootModel.getBirds();
  }

  public IntegerBinding highestTopSpeed() {
    return Bindings
        .createIntegerBinding(() -> getBirds().stream().mapToInt(b -> b.getTopSpeedInKmh()).max().orElse(0),
            getBirds());
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
