package twittrfx.bird.bird_list;

import javafx.beans.binding.Bindings;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import twittrfx.ViewMixin;
import twittrfx.bird.BirdPM;
import twittrfx.bird.bird_view.BirdViewPM;

public class BirdListTitle extends GridPane implements ViewMixin {
  private final BirdViewPM model;
  private Text title;
  private Text amountOfBirds;
  private Text amountOfBirdsLabel;
  private Text highestTopSpeedLabel;
  private Text highestTopSpeed;

  public BirdListTitle(BirdViewPM model) {
    this.model = model;
    init();
  }

  @Override
  public void initializeControls() {
    title = new Text("Birds of Switzerland");
    amountOfBirdsLabel = new Text("Amount of birds:");
    amountOfBirds = new Text(Integer.toString(model.getBirds().size()));

    highestTopSpeedLabel = new Text("Highest top speed:");
    highestTopSpeed = new Text(Integer.toString(model.highestTopSpeed()) + " km/h");
  }

  @Override
  public void layoutControls() {
    title.getStyleClass().add("title");
    ColumnConstraints cc = new ColumnConstraints();
    cc.setHgrow(Priority.ALWAYS);
    getColumnConstraints().addAll(cc, cc);

    RowConstraints rc = new RowConstraints();
    rc.setVgrow(Priority.ALWAYS);
    getRowConstraints().addAll(rc, rc, rc);

    setId("bird-list-title");
    add(title, 0, 0, 2, 1);
    add(amountOfBirdsLabel, 0, 1);
    add(amountOfBirds, 1, 1);
    add(highestTopSpeedLabel, 0, 2);
    add(highestTopSpeed, 1, 2);
  }

  @Override
  public void setupValueChangedListeners() {
    Bindings.size(model.getBirds()).addListener((observable, oldValue, newValue) -> {
      amountOfBirds.setText("Amount of birds: " + newValue);
    });

    model.getBirds().addListener((ListChangeListener<BirdPM>) c -> {
      while (c.next()) {
        if (c.wasAdded() || c.wasRemoved() || c.wasUpdated() || c.wasReplaced()) {
          highestTopSpeed.setText("Highest top speed: " + model.highestTopSpeed() + " km/h");
        }
      }
    });
  }

}
