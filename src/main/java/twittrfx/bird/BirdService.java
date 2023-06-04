package twittrfx.bird;

import java.util.List;

public interface BirdService {
  public List<BirdPM> load() throws Exception;

  public void saveAll(List<BirdPM> birds) throws Exception;
}
