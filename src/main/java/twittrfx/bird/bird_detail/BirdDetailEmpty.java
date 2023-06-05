package twittrfx.bird.bird_detail;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import twittrfx.ViewMixin;
import twittrfx.i18n.Caption;
import twittrfx.i18n.I18nPM;

public class BirdDetailEmpty extends VBox implements ViewMixin {
  private Text text;
  private final I18nPM i18n;

  public BirdDetailEmpty(I18nPM i18n) {
    this.i18n = i18n;
    init();
  }

  @Override
  public void initializeControls() {
    text = new Text();
    text.getStyleClass().add("title");

    setAlignment(Pos.CENTER);
  }

  @Override
  public void setupBindings() {
    text.textProperty().bind(i18n.get(Caption.NO_BIRD_SELECTED));
  }

  @Override
  public void layoutControls() {
    getChildren().add(text);
  }

}
