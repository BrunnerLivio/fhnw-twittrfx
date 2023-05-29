package twittrfx.bird.bird_view;

import javafx.scene.control.SplitPane;
import twittrfx.ViewMixin;
import twittrfx.bird.bird_detail.BirdDetail;
import twittrfx.bird.bird_list.BirdList;

public class BirdView extends SplitPane implements ViewMixin {
  private BirdViewPM model;
  private BirdList birdList;
  private BirdDetail birdDetail;

  public BirdView(BirdViewPM model) {
    this.model = model;
    init();
  }

  @Override
  public void initializeControls() {
    birdList = new BirdList(this.model);
    birdDetail = new BirdDetail(this.model);
  }

  @Override
  public void layoutControls() {
    getItems().addAll(birdList, birdDetail);
  }

}
