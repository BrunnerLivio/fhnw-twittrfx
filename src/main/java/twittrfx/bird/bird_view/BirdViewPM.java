package twittrfx.bird.bird_view;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import twittrfx.PresentationModel;
import twittrfx.bird.BirdPM;

public class BirdViewPM {
  private final PresentationModel rootModel;

  public BirdViewPM(PresentationModel rootModel) {
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
    return rootModel.getSelectedBird();
  }

  public void setSelectedBird(BirdPM bird) {
    rootModel.setSelectedBird(bird);
  }

  public ObjectProperty<BirdPM> selectedBirdProperty() {
    return rootModel.selectedBirdProperty();
  }
}
