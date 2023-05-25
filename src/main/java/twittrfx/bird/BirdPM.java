package twittrfx.bird;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BirdPM {
  private final StringProperty name = new SimpleStringProperty();
  private final StringProperty image = new SimpleStringProperty();
  private final StringProperty shortDescription = new SimpleStringProperty();
  private final StringProperty populationSize = new SimpleStringProperty();
  private final IntegerProperty maximumLifeSpanInYears = new SimpleIntegerProperty();
  private final IntegerProperty topSpeedInKmh = new SimpleIntegerProperty();
  private final StringProperty weight = new SimpleStringProperty();
  private final StringProperty length = new SimpleStringProperty();
  private final StringProperty wingspan = new SimpleStringProperty();
  private final StringProperty continents = new SimpleStringProperty();
  private final StringProperty diet = new SimpleStringProperty();
  private final StringProperty seasonalBehavior = new SimpleStringProperty();
  private final StringProperty independentAge = new SimpleStringProperty();
  private final StringProperty populationTrend = new SimpleStringProperty();
  private final StringProperty incubationPeriod = new SimpleStringProperty();

  public BirdPM(String[] line) {
    setName(line[0]);
    setImage(line[1]);
    setShortDescription(line[2]);
    setPopulationSize(line[3]);
    setMaximumLifeSpanInYears(Integer.parseInt(line[4]));
    setTopSpeedInKmh(Integer.parseInt(line[5]));
    setWeight(line[6]);
    setLength(line[7]);
    setWingspan(line[8]);
    setContinents(line[9]);
    setDiet(line[10]);
    setSeasonalBehavior(line[11]);
    setIndependentAge(line[12]);
    setPopulationTrend(line[13]);
    setIncubationPeriod(line[14]);

  }

  public StringProperty incubationPeriodProperty() {
    return incubationPeriod;
  }

  public String getIncubationPeriod() {
    return incubationPeriod.get();
  }

  public void setIncubationPeriod(String incubationPeriod) {
    this.incubationPeriod.set(incubationPeriod);
  }

  public StringProperty nameProperty() {
    return name;
  }

  public String getName() {
    return name.get();
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public StringProperty imageProperty() {
    return image;
  }

  public String getImage() {
    return image.get();
  }

  public void setImage(String image) {
    this.image.set(image);
  }

  public StringProperty shortDescriptionProperty() {
    return shortDescription;
  }

  public String getShortDescription() {
    return shortDescription.get();
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription.set(shortDescription);
  }

  public StringProperty populationSizeProperty() {
    return populationSize;
  }

  public String getPopulationSize() {
    return populationSize.get();
  }

  public void setPopulationSize(String populationSize) {
    this.populationSize.set(populationSize);
  }

  public IntegerProperty maximumLifeSpanInYearsProperty() {
    return maximumLifeSpanInYears;
  }

  public Integer getMaximumLifeSpanInYears() {
    return maximumLifeSpanInYears.get();
  }

  public void setMaximumLifeSpanInYears(Integer maximumLifeSpanInYears) {
    this.maximumLifeSpanInYears.set(maximumLifeSpanInYears);
  }

  public IntegerProperty topSpeedInKmhProperty() {
    return topSpeedInKmh;
  }

  public Integer getTopSpeedInKmh() {
    return topSpeedInKmh.get();
  }

  public void setTopSpeedInKmh(Integer topSpeedInKmh) {
    this.topSpeedInKmh.set(topSpeedInKmh);
  }

  public StringProperty weightProperty() {
    return weight;
  }

  public String getWeight() {
    return weight.get();
  }

  public void setWeight(String weight) {
    this.weight.set(weight);
  }

  public StringProperty lengthProperty() {
    return length;
  }

  public String getLength() {
    return length.get();
  }

  public void setLength(String length) {
    this.length.set(length);
  }

  public StringProperty wingspanProperty() {
    return wingspan;
  }

  public String getWingspan() {
    return wingspan.get();
  }

  public void setWingspan(String wingspan) {
    this.wingspan.set(wingspan);
  }

  public StringProperty continentsProperty() {
    return continents;
  }

  public String getContinents() {
    return continents.get();
  }

  public void setContinents(String continents) {
    this.continents.set(continents);
  }

  public StringProperty dietProperty() {
    return diet;
  }

  public String getDiet() {
    return diet.get();
  }

  public void setDiet(String diet) {
    this.diet.set(diet);
  }

  public StringProperty seasonalBehaviorProperty() {
    return seasonalBehavior;
  }

  public String getSeasonalBehavior() {
    return seasonalBehavior.get();
  }

  public void setSeasonalBehavior(String seasonalBehavior) {
    this.seasonalBehavior.set(seasonalBehavior);
  }

  public StringProperty independentAgeProperty() {
    return independentAge;
  }

  public String getIndependentAge() {
    return independentAge.get();
  }

  public void setIndependentAge(String independentAge) {
    this.independentAge.set(independentAge);
  }

  public StringProperty populationTrendProperty() {
    return populationTrend;
  }

  public String getPopulationTrend() {
    return populationTrend.get();
  }

  public void setPopulationTrend(String populationTrend) {
    this.populationTrend.set(populationTrend);
  }
}
