package twittrfx.bird.bird_detail;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.util.converter.NumberStringConverter;
import twittrfx.ViewMixin;
import twittrfx.bird.BirdPM;
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

  private TextField populationSize;
  private Label populationSizeLabel;

  private TextField maximumLifeSpan;
  private Label maximumLifeSpanLabel;

  private TextField topSpeed;
  private Label topSpeedLabel;

  private TextField weight;
  private Label weightLabel;

  private TextField length;
  private Label lengthLabel;

  private TextField wingspan;
  private Label wingspanLabel;

  private TextField continents;
  private Label continentsLabel;

  private TextField incubationPeriod;
  private Label incubationPeriodLabel;

  private TextField diet;
  private Label dietLabel;

  private TextField seasonalBehavior;
  private Label seasonalBehaviorLabel;

  private TextField independentAge;
  private Label independentAgeLabel;

  private TextField populationTrend;
  private Label populationTrendLabel;

  private TextField populationStatus;
  private Label populationStatusLabel;

  private TextField image;
  private Label imageLabel;

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

    maximumLifeSpan = new TextField();
    maximumLifeSpanLabel = new Label();

    populationSize = new TextField();
    populationSizeLabel = new Label();

    topSpeed = new TextField();
    topSpeedLabel = new Label();

    weight = new TextField();
    weightLabel = new Label();

    length = new TextField();
    lengthLabel = new Label();

    wingspan = new TextField();
    wingspanLabel = new Label();

    continents = new TextField();
    continentsLabel = new Label();

    incubationPeriod = new TextField();
    incubationPeriodLabel = new Label();

    diet = new TextField();
    dietLabel = new Label();

    seasonalBehavior = new TextField();
    seasonalBehaviorLabel = new Label();

    independentAge = new TextField();
    independentAgeLabel = new Label();

    populationTrend = new TextField();
    populationTrendLabel = new Label();

    populationStatus = new TextField();
    populationStatusLabel = new Label();

    image = new TextField();
    imageLabel = new Label();
  }

  @Override
  public void initializeSelf() {
    addStylesheetFiles("bird_detail_form.css");
    getStyleClass().add("bird-detail-form");
  }

  @Override
  public void setupBindings() {
    if (model.selectedBirdProperty().get() == null) {
      return;
    }

    name.textProperty().bindBidirectional(model.selectedBirdProperty().get().nameProperty());
    shortDescription.textProperty().bindBidirectional(model.selectedBirdProperty().get().shortDescriptionProperty());
    nameLabel.textProperty().bind(i18n.get(Caption.NAME));
    shortDescriptionLabel.textProperty().bind(i18n.get(Caption.SHORT_DESCRIPTION));
    maximumLifeSpanLabel.textProperty().bind(i18n.get(Caption.MAXIMUM_LIFE_SPAN));

    maximumLifeSpan.textProperty().bindBidirectional(
        model.selectedBirdProperty().get().maximumLifeSpanInYearsProperty(),
        new NumberStringConverter());

    populationSizeLabel.textProperty().bind(i18n.get(Caption.POPULATION_SIZE));
    populationSize.textProperty().bindBidirectional(model.selectedBirdProperty().get().populationSizeProperty());

    topSpeedLabel.textProperty().bind(i18n.get(Caption.TOP_SPEED));
    topSpeed.textProperty().bindBidirectional(model.selectedBirdProperty().get().topSpeedInKmhProperty(),
        new NumberStringConverter());

    weightLabel.textProperty().bind(i18n.get(Caption.WEIGHT));
    weight.textProperty().bindBidirectional(model.selectedBirdProperty().get().weightProperty());

    lengthLabel.textProperty().bind(i18n.get(Caption.LENGTH));
    length.textProperty().bindBidirectional(model.selectedBirdProperty().get().lengthProperty());

    wingspanLabel.textProperty().bind(i18n.get(Caption.WINGSPAN));
    wingspan.textProperty().bindBidirectional(model.selectedBirdProperty().get().wingspanProperty());

    continentsLabel.textProperty().bind(i18n.get(Caption.CONTINENTS));
    continents.textProperty().bindBidirectional(model.selectedBirdProperty().get().continentsProperty());

    incubationPeriodLabel.textProperty().bind(i18n.get(Caption.INCUBATION_PERIOD));
    incubationPeriod.textProperty().bindBidirectional(model.selectedBirdProperty().get().incubationPeriodProperty());

    dietLabel.textProperty().bind(i18n.get(Caption.DIET));
    diet.textProperty().bindBidirectional(model.selectedBirdProperty().get().dietProperty());

    seasonalBehaviorLabel.textProperty().bind(i18n.get(Caption.SEASONAL_BEHAVIOR));
    seasonalBehavior.textProperty().bindBidirectional(model.selectedBirdProperty().get().seasonalBehaviorProperty());

    independentAgeLabel.textProperty().bind(i18n.get(Caption.INDEPENDENT_AGE));
    independentAge.textProperty().bindBidirectional(model.selectedBirdProperty().get().independentAgeProperty());

    populationTrendLabel.textProperty().bind(i18n.get(Caption.POPULATION_TREND));
    populationTrend.textProperty().bindBidirectional(model.selectedBirdProperty().get().populationTrendProperty());

    populationStatusLabel.textProperty().bind(i18n.get(Caption.POPULATION_STATUS));
    populationStatus.textProperty().bindBidirectional(model.selectedBirdProperty().get().populationStatusProperty());

    imageLabel.textProperty().bind(i18n.get(Caption.IMAGE));
    image.textProperty().bindBidirectional(model.selectedBirdProperty().get().imageProperty());
  }

  private void unbind(BirdPM oldValue) {
    name.textProperty().unbindBidirectional(oldValue.nameProperty());
    shortDescription.textProperty().unbindBidirectional(oldValue.shortDescriptionProperty());
    maximumLifeSpan.textProperty().unbindBidirectional(oldValue.maximumLifeSpanInYearsProperty());
    populationSize.textProperty().unbindBidirectional(oldValue.populationSizeProperty());
    topSpeed.textProperty().unbindBidirectional(oldValue.topSpeedInKmhProperty());
    weight.textProperty().unbindBidirectional(oldValue.weightProperty());
    length.textProperty().unbindBidirectional(oldValue.lengthProperty());
    wingspan.textProperty().unbindBidirectional(oldValue.wingspanProperty());
    continents.textProperty().unbindBidirectional(oldValue.continentsProperty());
    incubationPeriod.textProperty().unbindBidirectional(oldValue.incubationPeriodProperty());
    diet.textProperty().unbindBidirectional(oldValue.dietProperty());
    seasonalBehavior.textProperty().unbindBidirectional(oldValue.seasonalBehaviorProperty());
    independentAge.textProperty().unbindBidirectional(oldValue.independentAgeProperty());
    populationTrend.textProperty().unbindBidirectional(oldValue.populationTrendProperty());
    populationStatus.textProperty().unbindBidirectional(oldValue.populationStatusProperty());
    image.textProperty().unbindBidirectional(oldValue.imageProperty());
  }

  @Override
  public void setupValueChangedListeners() {
    model.selectedBirdProperty().addListener((observable, oldValue, newValue) -> {
      if (oldValue != null) {
        unbind(oldValue);
      }
      if (newValue != null) {
        setupBindings();
      }
    });
  }

  @Override
  public void layoutControls() {
    ColumnConstraints cc = new ColumnConstraints();
    cc.setHgrow(Priority.ALWAYS);
    getColumnConstraints().addAll(cc, cc, cc, cc, cc, cc, cc, cc, cc, cc);

    RowConstraints rc = new RowConstraints();
    rc.setVgrow(Priority.ALWAYS);
    getRowConstraints().addAll(rc, rc, rc);

    add(nameLabel, 0, 0);
    add(name, 1, 0);

    add(shortDescriptionLabel, 0, 1);
    add(shortDescription, 1, 1, 3, 1);

    add(populationSizeLabel, 2, 2);
    add(populationSize, 3, 2);
    add(maximumLifeSpanLabel, 0, 2);
    add(maximumLifeSpan, 1, 2);

    add(topSpeedLabel, 0, 3);
    add(topSpeed, 1, 3);
    add(weightLabel, 2, 3);
    add(weight, 3, 3);

    add(lengthLabel, 0, 4);
    add(length, 1, 4);
    add(wingspanLabel, 2, 4);
    add(wingspan, 3, 4);

    add(continentsLabel, 0, 5);
    add(continents, 1, 5);
    add(incubationPeriodLabel, 2, 5);
    add(incubationPeriod, 3, 5);

    add(dietLabel, 0, 6);
    add(diet, 1, 6, 3, 1);

    add(seasonalBehaviorLabel, 0, 7);
    add(seasonalBehavior, 1, 7);
    add(independentAgeLabel, 2, 7);
    add(independentAge, 3, 7);

    add(populationTrendLabel, 0, 8);
    add(populationTrend, 1, 8);
    add(populationStatusLabel, 2, 8);
    add(populationStatus, 3, 8);

    add(imageLabel, 0, 9);
    add(image, 1, 9, 3, 1);
  }
}
