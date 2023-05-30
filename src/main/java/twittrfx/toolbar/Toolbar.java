package twittrfx.toolbar;

import java.util.List;
import java.util.stream.Stream;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import twittrfx.PresentationModel;
import twittrfx.ViewMixin;
import twittrfx.i18n.I18nPM;
import twittrfx.i18n.Language;

public class Toolbar extends HBox implements ViewMixin {
  private PresentationModel model;
  private Button saveButton;
  private Button addButton;
  private Button darkModeButton;
  private List<Button> languages = Stream.of(Language.values())
      .map(language -> new Button(language.getLanguage()))
      .toList();

  private I18nPM i18n;

  public Toolbar(PresentationModel model, I18nPM i18n) {
    this.model = model;
    this.i18n = i18n;
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
    getChildren().addAll(languages);
  }

  @Override
  public void setupEventHandlers() {
    darkModeButton.setOnAction(event -> model.toggleDarkMode());
    saveButton.setOnAction(event -> model.save());
    languages.forEach(button -> button.setOnAction(event -> i18n.setLanguage(Stream.of(Language.values())
        .filter(language -> language.getLanguage().equals(button.getText()))
        .findFirst()
        .orElseThrow())));
  }

}
