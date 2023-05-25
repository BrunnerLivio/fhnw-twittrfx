package twittrfx.bird.bird_detail;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import twittrfx.ViewMixin;

public class BirdDetail extends VBox implements ViewMixin {
  private BirdDetailPM model;

  public BirdDetail(BirdDetailPM model) {
    this.model = model;
    init();
  }

  @Override
  public void initializeControls() {
  }

  @Override
  public void layoutControls() {
    getChildren().addAll(new Text("Hello World"));
  }

}
