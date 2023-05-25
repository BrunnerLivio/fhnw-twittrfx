package twittrfx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PresentationModelTest {

    @Test
    void testInitial() {
        // given
        PresentationModel pm = new PresentationModel();

        // when
        String applicationTitle = pm.getApplicationTitle();

        // then
        assertEquals("JavaFX App", applicationTitle);
    }

}
