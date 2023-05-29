package twittrfx.toolbar;

import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import twittrfx.PresentationModel;
import twittrfx.ViewMixin;

public class Toolbar extends HBox implements ViewMixin {
  private PresentationModel model;
  private Button saveButton;
  private Button addButton;
  private Button darkModeButton;

  public Toolbar(PresentationModel model) {
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
    darkModeButton = new Button("Dark Mode");
  }

  @Override
  public void layoutControls() {
    setPadding(new Insets(10));
    setId("toolbar");

    getChildren().addAll(saveButton, addButton, darkModeButton);
  }

  @Override
  public void setupEventHandlers() {
    darkModeButton.setOnAction(event -> model.toggleDarkMode());
  }

}
