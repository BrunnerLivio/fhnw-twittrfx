package twittrfx;

import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import twittrfx.bird.bird_list.BirdList;
import twittrfx.bird.bird_list.BirdListPM;
import twittrfx.bird.bird_view.BirdView;
import twittrfx.bird.bird_view.BirdViewPM;
import twittrfx.toolbar.Toolbar;
import twittrfx.toolbar.ToolbarPM;

public class ApplicationUI extends VBox implements ViewMixin {

  private final PresentationModel model;
  private Toolbar toolbar;
  private BirdView birdView;

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
    toolbar = new Toolbar(new ToolbarPM());
    birdView = new BirdView(new BirdViewPM());
  }

  @Override
  public void layoutControls() {
    getChildren().addAll(toolbar, birdView);
  }
}
