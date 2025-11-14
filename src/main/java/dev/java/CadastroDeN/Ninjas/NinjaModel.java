package dev.java.CadastroDeN.Ninjas;


import dev.java.CadastroDeN.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Entity transforma uma classe em uma entidade do BD
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;


    // Muitos ninjas para uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key / Chave estrangeira.
    private MissoesModel missoes;
}
