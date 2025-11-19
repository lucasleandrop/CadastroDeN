package dev.java.CadastroDeN.Ninjas;


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
        //Adicionar / criar
        @PostMapping("/criar")
        public String criarNinhja() {
            return "Ninja Criado";
        }
            //Mostrar
            @GetMapping("/todos")
                    public List<NinjaModel> mostrarTodos (){
                return ninjaService.mostrarTodos();
            }

        //Procurar
        @GetMapping("/listar/{id}")
    public NinjaModel listarPorId(@PathVariable Long id) {
        return ninjaService.listarPorId(id);
    }

        //Alterar

        @PutMapping("/alterar")
    public String alterarPorId() {
        return "Alterar por ID";
    }

        //Deletar
        @DeleteMapping("/deletarID")
    public String deletarPorId() {
            return "Deletado por ID";
        }

    }
