package Controller;

import Model.PokemonDTO;
import Service.PokeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pokedex")
public class PokemonController {
    private final PokeService service;

    public PokemonController(PokeService service) {
        this.service = service;
    }

    @GetMapping("/{idOuNome}")
    public PokemonDTO consultar(@PathVariable String idOuNome) {
        return service.buscarPokemon(idOuNome);
    }
}