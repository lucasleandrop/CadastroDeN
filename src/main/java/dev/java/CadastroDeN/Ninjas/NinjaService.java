package dev.java.CadastroDeN.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

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



}
