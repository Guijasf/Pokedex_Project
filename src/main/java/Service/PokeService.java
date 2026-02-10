package Service;

import Model.PokemonDTO;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.*;

@Service
public class PokeService {
    public PokemonDTO buscarPokemon(String busca) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + busca.toLowerCase()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            String nome = json.get("name").getAsString();
            int id = json.get("id").getAsInt();
            // Caminho para a imagem oficial
            String img = json.getAsJsonObject("sprites")
                    .getAsJsonObject("other")
                    .getAsJsonObject("official-artwork")
                    .get("front_default").getAsString();

            return new PokemonDTO(id, nome.toUpperCase(), img);
        } catch (Exception e) {
            throw new RuntimeException("Pokemon não encontrado!");
        }
    }
}