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


        //Adicionar / create
        @PostMapping("/criar")
        public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
        }


            //Mostrar
            @GetMapping("/todos")
                    public List<NinjaDTO> mostrarTodos (){
                return ninjaService.mostrarTodos();
            }



        //Procurar
        @GetMapping("/listar/{id}")
    public NinjaDTO listarPorId(@PathVariable Long id) {
        return ninjaService.listarPorId(id);
    }



        //Alterar
        @PutMapping("/alterar/{id}")
    public NinjaDTO alterarPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id,ninjaAtualizado);
    }



        //Deletar
        @DeleteMapping("/deletar/{id}")
    public void deletarPorId(@PathVariable Long id) {
            ninjaService.deletarPorId(id);
        }

    }
