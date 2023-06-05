package twittrfx;

import java.util.List;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import twittrfx.banner.ErrorBanner;
import twittrfx.bird.bird_view.BirdView;
import twittrfx.bird.bird_view.BirdViewPM;
import twittrfx.i18n.Caption;
import twittrfx.i18n.I18nPM;
import twittrfx.toolbar.Toolbar;

public class ApplicationUI extends VBox implements ViewMixin {

  private final PresentationModel model;
  private final I18nPM i18n;
  private Toolbar toolbar;
  private BirdView birdView;
  private ErrorBanner errorBanner;

  public ApplicationUI(PresentationModel model, I18nPM i18n) {
    this.model = model;
    this.i18n = i18n;
    init();
  }

  @Override
  public void initializeSelf() {
    addStylesheetFiles("style.css");
  }

  @Override
  public void initializeControls() {
    toolbar = new Toolbar(model, i18n);
    birdView = new BirdView(new BirdViewPM(model), i18n);
    errorBanner = new ErrorBanner();

    setVgrow(birdView, Priority.ALWAYS);
    getStyleClass().add("theme-light");
  }

  @Override
  public void setupBindings() {
    errorBanner.visibleProperty().bind(model.connectionStatusProperty().not());
    errorBanner.textProperty().bind(i18n.get(Caption.CONNECTION_ERROR));
  }

  @Override
  public void setupValueChangedListeners() {
    model.darkModeProperty().addListener((observable, oldValue, newValue) -> {
      getStyleClass().removeAll(List.of("theme-dark", "theme-light"));
      getStyleClass().add(newValue ? "theme-dark" : "theme-light");
    });
  }

  @Override
  public void layoutControls() {
    getChildren().addAll(toolbar, errorBanner, birdView);
  }
}
