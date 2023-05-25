package twittrfx;

import javafx.scene.layout.StackPane;
import twittrfx.bird.bird_list.BirdList;
import twittrfx.bird.bird_list.BirdListPM;

public class ApplicationUI extends StackPane implements ViewMixin {

  private final PresentationModel model;
  private BirdList birdList;

  public ApplicationUI(PresentationModel model) {
    this.model = model;
    init();
  }

  @Override
  public void initializeSelf() {
    addStylesheetFiles("style.css");
  }

  @Override
  public void initializeControls() {
    birdList = new BirdList(new BirdListPM());
  }

  @Override
  public void layoutControls() {
    getChildren().add(birdList);
  }
}
