package twittrfx.bird;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BirdServiceLocalTest {
  @Test
  public void testLoad() {
    // given
    BirdServiceLocal service = new BirdServiceLocal("fixture_birds_of_switzerland.tsv");

    // when
    List<BirdPM> birds = service.load();

    // then
    assertEquals(2, birds.size());
    assertEquals("African stonechat", birds.get(0).getName());
    assertEquals("https://martinfrancois.github.io/bird-images/saxicola-torquatus-gauteng-south-africa-female-8.jpg",
        birds.get(0).getImage());
    assertEquals("A short description.", birds.get(0).getShortDescription());
    assertEquals("Unknown", birds.get(0).getPopulationSize());
  }
}
