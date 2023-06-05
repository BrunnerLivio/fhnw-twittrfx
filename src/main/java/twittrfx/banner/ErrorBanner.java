package twittrfx.banner;

import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import twittrfx.ViewMixin;
import twittrfx.icons.ErrorIcon;

public class ErrorBanner extends HBox implements ViewMixin {
  private Text text;
  private ErrorIcon icon;

  public ErrorBanner() {
    init();
  }

  @Override
  public void initializeSelf() {
    getStyleClass().add("error-banner");
    addStylesheetFiles("error-banner.css");
  }

  @Override
  public void initializeControls() {
    text = new Text();
    icon = new ErrorIcon();

    setAlignment(Pos.CENTER);
    setVisible(false);
    text.setTextAlignment(TextAlignment.CENTER);
  }

  @Override
  public void setupValueChangedListeners() {
  }

  @Override
  public void layoutControls() {
    getChildren().addAll(icon, text);
  }

  @Override
  public void setupBindings() {
    managedProperty().bind(visibleProperty());
  }

  public StringProperty textProperty() {
    return text.textProperty();
  }
}
