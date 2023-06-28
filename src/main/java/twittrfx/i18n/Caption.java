package twittrfx.i18n;

public enum Caption {
  WINDOW_TITLE("TwittrFX"),
  POPULATION_TREND("Population Trend", "Populationstrend", "Arr Populations Trend"),
  POPULATION_STATUS("Population Status", "Bevölkerungsstatus", "Arr Bevölkerungsstatus"),
  AMOUNT_OF_BIRDS("Amount of Birds", "Anzahl der Vögel", "Anzahl Papageien"),
  HIGHEST_TOP_SPEED("Highest Top Speed", "Höchste Höchstgeschwindigkeit", "Schnell wie der Wind"),
  BIRDS_OF_SWITZERLAND("Birds of Switzerland", "Vögel der Schweiz", "Papageien der See"),

  NAME("Name", "Name", "Titel"),
  SHORT_DESCRIPTION("Short Description", "Kurzbeschreibung", "Kurzbeschreibung"),
  MAXIMUM_LIFE_SPAN("Maximum Life Span", "Maximale Lebensdauer", "Maximale Lebensdauer"),
  POPULATION_SIZE("Population Size", "Bevölkerungsgröße", "Bevölkerungsgröße"),
  TOP_SPEED("Top Speed", "Höchstgeschwindigkeit", "Höchstgeschwindigkeit"),
  WEIGHT("Weight", "Gewicht", "Gewicht"),
  LENGTH("Length", "Länge", "Länge"),
  WINGSPAN("Wingspan", "Spannweite", "Spannweite"),
  CONTINENTS("Continents", "Kontinente", "Kontinente"),
  INCUBATION_PERIOD("Incubation Period", "Brutzeit", "Brutzeit"),
  DIET("Diet", "Diät", "Diät"),
  SEASONAL_BEHAVIOR("Seasonal Behavior", "Saisonales Verhalten", "Saisonales Verhalten"),
  INDEPENDENT_AGE("Independent Age", "Unabhängiges Alter", "Unabhängiges Alter"),
  IMAGE("Image", "Bild", "Bild"),
  CONNECTION_ERROR("The data source is unavailable", "Die Datenquelle ist nicht verfügbar",
      "Die Quelle bring kein Wasser arr"),
  NO_BIRD_SELECTED("No bird selected", "Kein Vogel ausgewählt", "Kein Papagei in Sicht"),
  NO_TABLE_ITEMS("No table items", "Keine Tabellenelemente", "Keine Tabellenelemente");
  ;

  private final String english;
  private final String german;
  private final String pirate;

  Caption(String caption) {
    this(caption, caption, caption);
  }

  Caption(String english, String german, String pirate) {
    this.english = english;
    this.german = german;
    this.pirate = pirate;
  }

  public String getEnglish() {
    return english;
  }

  public String getGerman() {
    return german;
  }

  public String getPirate() {
    return pirate;
  }

  public String getText(Language lang) {
    switch (lang) {
      case DE:
        return getGerman();
      case EN:
        return getEnglish();
      case PR:
        return getPirate();
      default:
        return getEnglish();
    }
  }
}
