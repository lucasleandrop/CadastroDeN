package dev.java.CadastroDeN.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota.";
    }


    //Adicionar / create
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }


    //Mostrar
    @GetMapping("/todos")
    public ResponseEntity<List<NinjaDTO>> mostrarTodos() {
        List<NinjaDTO> listaDeNinjas = ninjaService.mostrarTodos();
        return ResponseEntity.ok(listaDeNinjas);
    }


    //Procurar
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        NinjaDTO ninjaPorId = ninjaService.listarPorId(id);


        if (ninjaPorId != null) {
            return ResponseEntity.ok( ninjaPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado por ID : " + id);

        }

    }


    //Alterar
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO ninjaAtualizado = ninjaService.atualizarNinja(id, ninjaDTO);
        if (ninjaAtualizado != null) {
            return ResponseEntity.ok("Ninja alterado com sucesso: " + ninjaAtualizado.getNome() + " ID: " + ninjaAtualizado.getId());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado com a id: " + id);
        }
    }


    //Deletar
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        NinjaDTO ninjaEncontrado = ninjaService.listarPorId(id);
        if (ninjaService.listarPorId(id) != null) {
            ninjaService.deletarPorId(id);
            return ResponseEntity.ok("Ninja deletado com sucesso: ID: " + id + " Nome: " + ninjaEncontrado.getNome());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de id " + id + " não encontrado.");
        }
    }
}

