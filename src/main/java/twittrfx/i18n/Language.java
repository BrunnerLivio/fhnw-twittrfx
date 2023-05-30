package twittrfx.i18n;

public enum Language {
  DE("Deutsch"),
  EN("English"),
  PR("Pirate");

  private final String language;

  Language(String language) {
    this.language = language;
  }

  public String getLanguage() {
    return language;
  }
}
