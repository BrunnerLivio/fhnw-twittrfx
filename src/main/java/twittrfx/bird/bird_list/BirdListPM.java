package twittrfx.bird.bird_list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import twittrfx.bird.BirdPM;
import twittrfx.bird.BirdService;
import twittrfx.bird.BirdServiceLocal;

public class BirdListPM {
  private final ObservableList<BirdPM> birds = FXCollections.observableArrayList();
  private final BirdService birdService = new BirdServiceLocal();

  public BirdListPM() {
    birds.addAll(this.birdService.load());
  }

  public ObservableList<BirdPM> getBirds() {
    return birds;
  }
}
