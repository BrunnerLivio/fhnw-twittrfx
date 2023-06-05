package twittrfx.bird.bird_detail;

import javafx.scene.layout.VBox;
import twittrfx.ViewMixin;
import twittrfx.bird.bird_view.BirdViewPM;
import twittrfx.i18n.I18nPM;

public class BirdDetail extends VBox implements ViewMixin {
  private final BirdViewPM model;
  private final I18nPM i18n;
  private BirdDetailHeader header;
  private BirdDetailForm form;
  private VBox detail;
  private BirdDetailEmpty empty;

  public BirdDetail(BirdViewPM model, I18nPM i18n) {
    this.model = model;
    this.i18n = i18n;
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
    form = new BirdDetailForm(model, i18n);
    empty = new BirdDetailEmpty(i18n);
    detail = new VBox();

    detail.visibleProperty().bind(model.selectedBirdProperty().isNotNull());
    detail.managedProperty().bind(detail.visibleProperty());
    empty.visibleProperty().bind(model.selectedBirdProperty().isNull());
    empty.managedProperty().bind(empty.visibleProperty());
  }

  @Override
  public void setupBindings() {

  }

  @Override
  public void setupValueChangedListeners() {
  }

  @Override
  public void layoutControls() {
    detail.getChildren().addAll(header, form);
    getChildren().addAll(detail, empty);
  }

}
