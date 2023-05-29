package twittrfx.bird.bird_detail;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import twittrfx.ViewMixin;
import twittrfx.bird.bird_view.BirdViewPM;

public class BirdDetail extends VBox implements ViewMixin {
  private BirdViewPM model;
  private Text title;

  public BirdDetail(BirdViewPM model) {
    this.model = model;
    init();
  }

  @Override
  public void initializeControls() {
    title = new Text();
  }

  @Override
  public void setupBindings() {
    model.selectedBirdProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue != null) {
        title.textProperty().bind(newValue.nameProperty());
      }
    });
  }

  @Override
  public void layoutControls() {
    title.getStyleClass().add("title");
    getChildren().addAll(title);
  }

}
