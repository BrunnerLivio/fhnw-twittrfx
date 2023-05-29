package twittrfx.bird.bird_detail;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import twittrfx.ViewMixin;
import twittrfx.bird.bird_view.BirdViewPM;

public class BirdDetailHeader extends HBox implements ViewMixin {
  private BirdViewPM model;
  private Text title;
  private Text continents;
  private ImageView imageView;
  private VBox vBox;

  public BirdDetailHeader(BirdViewPM model) {
    this.model = model;
    init();
  }

  @Override
  public void initializeControls() {
    title = new Text();
    continents = new Text();
    imageView = new ImageView();
    vBox = new VBox();
  }

  @Override
  public void initializeSelf() {
    getStyleClass().add("bird-detail-header");
  }

  @Override
  public void setupBindings() {
    title.textProperty().bind(model.selectedBirdProperty().get().nameProperty());
    continents.textProperty().bind(model.selectedBirdProperty().get().continentsProperty());
    updateImage(model.selectedBirdProperty().get().imageProperty().get());
  }

  private void updateImage(String imageUrl) {
    imageView.setImage(new Image(imageUrl));
  }

  @Override
  public void setupValueChangedListeners() {
    model.selectedBirdProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue != null) {
        setupBindings();
      }
    });
  }

  @Override
  public void layoutControls() {
    title.getStyleClass().add("title");
    imageView.getStyleClass().add("bird-image");
    imageView.setFitHeight(200);
    imageView.setPreserveRatio(true);

    vBox.getChildren().addAll(title, continents);
    setHgrow(vBox, Priority.ALWAYS);

    getChildren().addAll(vBox, imageView);
  }
}
