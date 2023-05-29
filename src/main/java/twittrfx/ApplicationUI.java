package twittrfx;

import java.util.List;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import twittrfx.bird.bird_view.BirdView;
import twittrfx.bird.bird_view.BirdViewPM;
import twittrfx.toolbar.Toolbar;

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
    toolbar = new Toolbar(this.model);
    birdView = new BirdView(new BirdViewPM());
    setVgrow(birdView, Priority.ALWAYS);
    getStyleClass().add("theme-light");
  }

  @Override
  public void setupValueChangedListeners() {
    model.isDarkMode().addListener((observable, oldValue, newValue) -> {
      getStyleClass().removeAll(List.of("theme-dark", "theme-light"));
      getStyleClass().add(newValue ? "theme-dark" : "theme-light");
    });
  }

  @Override
  public void layoutControls() {
    getChildren().addAll(toolbar, birdView);
  }
}
