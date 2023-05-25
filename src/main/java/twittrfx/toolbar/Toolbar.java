package twittrfx.toolbar;

import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import twittrfx.ViewMixin;

public class Toolbar extends HBox implements ViewMixin {
  private ToolbarPM model;
  private Button saveButton;
  private Button addButton;

  public Toolbar(ToolbarPM model) {
    this.model = model;
    init();
  }

  @Override
  public void initializeSelf() {
    addStylesheetFiles("toolbar.css");
  }

  @Override
  public void initializeControls() {
    saveButton = new Button("Save");
    addButton = new Button("Add");
  }

  @Override
  public void layoutControls() {
    setPadding(new Insets(10));
    setId("toolbar");

    getChildren().addAll(saveButton, addButton);
  }

}
