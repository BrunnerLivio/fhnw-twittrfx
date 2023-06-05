package twittrfx.bird;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BirdServiceCloud implements BirdService {
  private URI birdUri;
  HttpClient client = HttpClient.newHttpClient();
  ObjectMapper mapper = new ObjectMapper();

  public BirdServiceCloud(String baseUrl) {
    this.birdUri = URI.create(baseUrl + "/bird");
  }

  public List<BirdPM> load() throws InterruptedException, JsonProcessingException, IOException {
    HttpRequest request = HttpRequest
        .newBuilder()
        .uri(this.birdUri)
        .header("accept", "application/json")
        .GET()
        .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    String jsonResponse = response.body();

    List<BirdPM> birds = mapper.readValue(jsonResponse, new TypeReference<List<BirdPM>>() {
    });
    return birds;
  }

  @Override
  public void saveAll(List<BirdPM> birds) throws JsonProcessingException, InterruptedException, IOException {
    String json = mapper.writeValueAsString(birds);

    HttpRequest request = HttpRequest
        .newBuilder()
        .uri(this.birdUri)
        .header("accept", "application/json")
        .header("Content-Type", "application/json")
        .POST(BodyPublishers.ofString(json))
        .build();

    client.sendAsync(request, BodyHandlers.ofString());
  }

}
