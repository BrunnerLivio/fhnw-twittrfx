package twittrfx.bird.bird_detail;

import javafx.beans.binding.Bindings;
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
    if (model.selectedBirdProperty().get() == null) {
      return;
    }

    title.textProperty().bind(model.selectedBirdProperty().get().nameProperty());
    continents.textProperty().bind(model.selectedBirdProperty().get().continentsProperty());
    imageView.imageProperty()
        .bind(Bindings.createObjectBinding(() -> updateImage(), model.selectedBirdProperty().get().imageProperty()));
  }

  public void unbind() {
    title.textProperty().unbind();
    continents.textProperty().unbind();
  }

  private Image updateImage() {
    String imageUrl = model.selectedBirdProperty().get().imageProperty().get();
    if (imageUrl == null) {
      return new Image(getClass().getResourceAsStream("image-not-found.png"));
    }

    try {
      return new Image(imageUrl);
    } catch (Exception e) {
      return new Image(getClass().getResourceAsStream("image-broken.png"));
    }
  }

  @Override
  public void setupValueChangedListeners() {
    model.selectedBirdProperty().addListener((observable, oldValue, newValue) -> {
      unbind();
      if (newValue != null) {
        setupBindings();
      }
    });
  }

  @Override
  public void layoutControls() {
    title.getStyleClass().add("title");
    imageView.getStyleClass().add("bird-image");

    // Does not exist as CSS properties :(
    // https://github.com/javafxports/openjdk-jfx/pull/30
    imageView.setFitHeight(200);
    imageView.setPreserveRatio(true);

    vBox.getChildren().addAll(title, continents);
    setHgrow(vBox, Priority.ALWAYS);

    getChildren().addAll(vBox, imageView);
  }
}
