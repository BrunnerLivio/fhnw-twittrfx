package twittrfx.toolbar;

import java.util.List;
import java.util.stream.Stream;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import twittrfx.PresentationModel;
import twittrfx.ViewMixin;
import twittrfx.i18n.I18nPM;
import twittrfx.i18n.Language;
import twittrfx.icons.AddIcon;
import twittrfx.icons.DarkModeIcon;
import twittrfx.icons.DeleteIcon;
import twittrfx.icons.EnglishIcon;
import twittrfx.icons.GermanIcon;
import twittrfx.icons.LightModeIcon;
import twittrfx.icons.PirateIcon;
import twittrfx.icons.SaveIcon;

public class Toolbar extends HBox implements ViewMixin {
  private PresentationModel model;
  private Button saveButton;
  private Button deleteButton;
  private Button addButton;
  private Button darkModeButton;
  private Button englishButton;
  private Button germanButton;
  private Button pirateButton;

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
    saveButton = new Button();
    addButton = new Button();
    darkModeButton = new Button();
    deleteButton = new Button();

    englishButton = new Button();
    germanButton = new Button();
    pirateButton = new Button();
  }

  @Override
  public void layoutControls() {
    saveButton.setGraphic(new SaveIcon());
    saveButton.getStyleClass().add("icon-button");

    addButton.setGraphic(new AddIcon());
    addButton.getStyleClass().add("icon-button");

    deleteButton.setGraphic(new DeleteIcon());
    deleteButton.getStyleClass().add("icon-button");

    darkModeButton.getStyleClass().add("icon-button");

    englishButton.setGraphic(new EnglishIcon());
    englishButton.getStyleClass().add("icon-button");

    germanButton.setGraphic(new GermanIcon());
    germanButton.getStyleClass().add("icon-button");

    pirateButton.setGraphic(new PirateIcon());
    pirateButton.getStyleClass().add("icon-button");

    setPadding(new Insets(10));
    setId("toolbar");


    HBox leftBox = new HBox();
    leftBox.getChildren().addAll(saveButton, addButton, deleteButton);
    leftBox.setSpacing(10);

    HBox rightBox = new HBox();
    rightBox.getChildren().addAll(darkModeButton, englishButton, germanButton, pirateButton);
    rightBox.setSpacing(10);

    HBox.setHgrow(leftBox, Priority.ALWAYS);
    getChildren().addAll(leftBox, rightBox);
  }

  @Override
  public void setupEventHandlers() {
    darkModeButton.setOnAction(event -> model.toggleDarkMode());
    saveButton.setOnAction(event -> model.save());
    addButton.setOnAction(event -> model.addBird());
    deleteButton.setOnAction(event -> model.removeBird(model.getSelectedBird()));

    englishButton.setOnAction(event -> i18n.setLanguage(Language.EN));
    germanButton.setOnAction(event -> i18n.setLanguage(Language.DE));
    pirateButton.setOnAction(event -> i18n.setLanguage(Language.PR));
  }

  @Override
  public void setupBindings() {
    deleteButton.disableProperty().bind(model.selectedBirdProperty().isNull());
    darkModeButton.graphicProperty()
        .bind(model.darkModeProperty().map(darkMode -> darkMode ? new LightModeIcon() : new DarkModeIcon()));
  }

}
