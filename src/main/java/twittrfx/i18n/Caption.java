package twittrfx.i18n;

public enum Caption {
  WINDOW_TITLE("TwittrFX"),
  POPULATION_TREND("Population Trend", "Populationstrend", "Arr Populations Trend"),
  POPULATION_STATUS("Population Status", "Bevölkerungsstatus", "Arr Bevölkerungsstatus"),
  AMOUNT_OF_BIRDS("Amount of Birds", "Anzahl der Vögel", "Anzahl Papageien"),
  HIGHEST_TOP_SPEED("Highest Top Speed", "Höchste Höchstgeschwindigkeit", "Schnell wie der Wind"),
  BIRDS_OF_SWITZERLAND("Birds of Switzerland", "Vögel der Schweiz", "Papageien der See"),

  NAME("Name", "Name", "Titel"),
  SHORT_DESCRIPTION("Short Description", "Kurzbeschreibung", "Kurzbeschreibung");

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
