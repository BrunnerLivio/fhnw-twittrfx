package twittrfx.bird.bird_list;

import java.util.stream.Collectors;

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
import twittrfx.i18n.Caption;
import twittrfx.i18n.I18nPM;

public class BirdListHeader extends GridPane implements ViewMixin {
  private final BirdViewPM model;
  private Text title;
  private Text amountOfBirds;
  private Text amountOfBirdsLabel;
  private Text highestTopSpeedLabel;
  private Text highestTopSpeed;
  private final I18nPM i18n;

  public BirdListHeader(BirdViewPM model, I18nPM i18n) {
    this.model = model;
    this.i18n = i18n;

    init();
  }

  @Override
  public void initializeControls() {
    title = new Text();
    amountOfBirdsLabel = new Text();
    amountOfBirds = new Text(Integer.toString(model.getBirds().size()));

    highestTopSpeedLabel = new Text();
    highestTopSpeed = new Text();
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

    getStyleClass().add("bird-list-title");
    add(title, 0, 0, 2, 1);
    add(amountOfBirdsLabel, 0, 1);
    add(amountOfBirds, 1, 1);
    add(highestTopSpeedLabel, 0, 2);
    add(highestTopSpeed, 1, 2);
  }

  @Override
  public void setupBindings() {
    title.textProperty().bind(i18n.get(Caption.BIRDS_OF_SWITZERLAND));
    amountOfBirdsLabel.textProperty().bind(Bindings.concat(i18n.get(Caption.AMOUNT_OF_BIRDS), ":"));
    highestTopSpeedLabel.textProperty().bind(Bindings.concat(i18n.get(Caption.HIGHEST_TOP_SPEED), ":"));
    highestTopSpeed.textProperty().bind(Bindings.concat(model.highestTopSpeed(), " km/h"));
    amountOfBirds.textProperty().bind(Bindings.size(model.getBirds()).asString());
    highestTopSpeed.textProperty().bind(
        Bindings.createIntegerBinding(() -> model.highestTopSpeed(), model.getBirds()).asString().concat(" km/h"));
  }
}
