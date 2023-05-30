package twittrfx.i18n;

import java.util.HashMap;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class I18nPM {
  private final HashMap<Caption, StringProperty> captions = new HashMap<>();

  public I18nPM(Language lang) {
    for (Caption caption : Caption.values()) {
      captions.put(caption, new SimpleStringProperty());
    }
    setLanguage(lang);
  }

  public void setLanguage(Language lang) {
    captions
        .entrySet()
        .forEach(entry -> entry.getValue().set(entry.getKey().getText(lang)));
  }

  public StringProperty get(Caption caption) {
    return captions.get(caption);
  }
}
