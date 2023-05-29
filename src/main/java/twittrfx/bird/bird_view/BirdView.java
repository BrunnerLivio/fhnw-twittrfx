package twittrfx.bird.bird_view;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import twittrfx.ViewMixin;
import twittrfx.bird.bird_detail.BirdDetail;
import twittrfx.bird.bird_list.BirdList;

public class BirdView extends GridPane implements ViewMixin {
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
    ColumnConstraints cc = new ColumnConstraints();
    cc.setHgrow(Priority.ALWAYS);
    getColumnConstraints().addAll(cc, cc);

    RowConstraints rc = new RowConstraints();
    rc.setVgrow(Priority.ALWAYS);
    getRowConstraints().addAll(rc);

    add(birdList, 0, 0);
    add(birdDetail, 1, 0);
  }

}
