package Controller;

import Model.Pokemon;
import View.PokedexView;
import Service.PokeService;
import org.springframework.web.bind.annotation.RestController;

public class PokemonController {
    private PokedexView view;
    private PokeService service;

    public PokemonController(PokedexView view, PokeService service) {
        this.view = view;
        this.service = service;
    }

    public void iniciar() {
        while (true) {
            String busca = view.pedirPokemon();
            if (busca.equalsIgnoreCase("sair")) break;

            try {
                Pokemon p = service.buscarPokemon(busca);
                view.mostrarPokemon(p.toString());
            } catch (Exception e) {
                view.erro("Erro ao buscar: " + e.getMessage());
            }
        }
    }
}

@RestController
@RequestMapping("/api/pokedex")
public class PokemonController{
    private final PokseService service;

    public PokemonController(Pokeservice service){
        this.service = service;
    }

    @GetMapping("/{idOuNome}")
    public PokemonDTO consultar(@PathVariable String idOUNome) {
        return service.buscarPokemon(idOuNome);
    }
}