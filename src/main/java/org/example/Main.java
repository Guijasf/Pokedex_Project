package org.example;

import Controller.PokemonController;
import Service.PokeService;
import View.PokedexView;

class Main {
    static void main() { // Sem public e sem String[] args
        PokedexView view = new PokedexView();
        PokeService service = new PokeService();

        PokemonController controller = new PokemonController(view, service);
        controller.iniciar();
    }
}