package twittrfx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import twittrfx.i18n.Caption;
import twittrfx.i18n.I18nPM;
import twittrfx.i18n.Language;

public class AppStarter extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    PresentationModel pm = new PresentationModel();
    I18nPM i18n = new I18nPM(Language.EN);
    Parent rootPanel = new ApplicationUI(pm, i18n);

    Scene scene = new Scene(rootPanel);

    primaryStage.titleProperty().bind(i18n.get(Caption.WINDOW_TITLE));

    primaryStage.setScene(scene);

    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
