package twittrfx.bird.bird_detail;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import twittrfx.ViewMixin;
import twittrfx.bird.bird_view.BirdViewPM;
import twittrfx.i18n.Caption;
import twittrfx.i18n.I18nPM;

public class BirdDetailForm extends GridPane implements ViewMixin {
  private final BirdViewPM model;
  private final I18nPM i18n;
  private TextField name;
  private Label nameLabel;

  private TextField shortDescription;
  private Label shortDescriptionLabel;

  public BirdDetailForm(BirdViewPM model, I18nPM i18n) {
    this.model = model;
    this.i18n = i18n;
    init();
  }

  @Override
  public void initializeControls() {
    name = new TextField();
    nameLabel = new Label();

    shortDescription = new TextField();
    shortDescriptionLabel = new Label();
  }

  @Override
  public void setupBindings() {
    name.textProperty().bindBidirectional(model.selectedBirdProperty().get().nameProperty());
    shortDescription.textProperty().bindBidirectional(model.selectedBirdProperty().get().shortDescriptionProperty());
    nameLabel.textProperty().bind(i18n.get(Caption.NAME));
    shortDescriptionLabel.textProperty().bind(i18n.get(Caption.SHORT_DESCRIPTION));
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
    ColumnConstraints cc = new ColumnConstraints();
    cc.setHgrow(Priority.ALWAYS);
    getColumnConstraints().addAll(cc, cc, cc, cc);

    RowConstraints rc = new RowConstraints();
    rc.setVgrow(Priority.ALWAYS);
    getRowConstraints().addAll(rc, rc, rc);

    add(nameLabel, 0, 0);
    add(name, 1, 0);

    add(shortDescriptionLabel, 0, 1);
    add(shortDescription, 1, 1, 3, 1);
  }
}
