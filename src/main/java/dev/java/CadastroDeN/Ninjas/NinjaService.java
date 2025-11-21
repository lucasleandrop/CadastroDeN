package dev.java.CadastroDeN.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }


    //Listar todos
    public List<NinjaModel> mostrarTodos (){
        return ninjaRepository.findAll();
    }
    //Listar por ID  |  Optional porque pode existar o id ou não.
    public NinjaModel listarPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);

    }

    //Criar um novo Ninja

    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Deletar o ninja - tem que ser void

    public void deletarPorId(Long id){
        ninjaRepository.deleteById(id);
    };

    //Atualizar o cadastro
    public NinjaModel atualizarNinja(Long id,NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }else {
            return null;
        }

    }

}
