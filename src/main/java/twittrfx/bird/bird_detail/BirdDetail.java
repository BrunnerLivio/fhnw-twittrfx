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
  }

  @Override
  public void setupBindings() {
  }

  @Override
  public void setupValueChangedListeners() {
  }

  @Override
  public void layoutControls() {
    getChildren().addAll(header, form);
  }

}
