package twittrfx.bird.bird_detail;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import twittrfx.ViewMixin;
import twittrfx.bird.bird_view.BirdViewPM;

public class BirdDetail extends VBox implements ViewMixin {
  private BirdViewPM model;
  private BirdDetailHeader header;

  public BirdDetail(BirdViewPM model) {
    this.model = model;
    init();
  }

  @Override
  public void initializeSelf() {
    addStylesheetFiles("bird_detail.css");
    getStyleClass().add("bird-detail");
  }

  @Override
  public void initializeControls() {
    header = new BirdDetailHeader(model);
  }

  @Override
  public void setupBindings() {
  }

  @Override
  public void setupValueChangedListeners() {
  }

  @Override
  public void layoutControls() {
    getChildren().addAll(header);
  }

}
