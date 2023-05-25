package twittrfx.bird;

import java.util.List;

public interface BirdService {
  public List<BirdPM> load();

  public void saveAll(List<BirdPM> birds);
}
