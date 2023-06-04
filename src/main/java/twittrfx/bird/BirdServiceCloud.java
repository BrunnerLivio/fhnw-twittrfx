package twittrfx.bird;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BirdServiceCloud implements BirdService {
  public BirdServiceCloud() {
  }

  public List<BirdPM> load() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    URI uri = URI.create("http://localhost:8000/bird");
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest
        .newBuilder()
        .uri(uri)
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
  public void saveAll(List<BirdPM> birds) throws Exception {
    URI uri = URI.create("http://localhost:8000/bird");
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(birds);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest
        .newBuilder()
        .uri(uri)
        .header("accept", "application/json")
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(json))
        .build();
    client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
  }

}
