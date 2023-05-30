package twittrfx.icons;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Icon extends ImageView {
  private Image image;

  public Icon(String imagePath) {
    image = getImage(imagePath);
    initializeSelf();
  }

  private Image getImage(String iconPath) {
    return new Image(getClass().getResourceAsStream(iconPath));
  }

  public void initializeSelf() {
    setFitHeight(32);
    setFitWidth(32);
    setImage(image);
    getStyleClass().add("icon");
  }
}
