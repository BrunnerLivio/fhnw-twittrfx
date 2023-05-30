package twittrfx.bird.bird_view;

import javafx.scene.control.SplitPane;
import twittrfx.ViewMixin;
import twittrfx.bird.bird_detail.BirdDetail;
import twittrfx.bird.bird_list.BirdList;
import twittrfx.i18n.I18nPM;

public class BirdView extends SplitPane implements ViewMixin {
  private final BirdViewPM model;
  private final I18nPM i18n;
  private BirdList birdList;
  private BirdDetail birdDetail;

  public BirdView(BirdViewPM model, I18nPM i18n) {
    this.model = model;
    this.i18n = i18n;
    init();
  }

  @Override
  public void initializeControls() {
    birdList = new BirdList(this.model, i18n);
    birdDetail = new BirdDetail(this.model, i18n);
  }

  @Override
  public void layoutControls() {
    getItems().addAll(birdList, birdDetail);
  }

}
