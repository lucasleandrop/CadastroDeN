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
    @Column(name = "ID_Sequencial")
    private Long id;

    @Column(name = "Nome_Ninja")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "Idade")
    private int idade;

    @Column(name = "Img_URL")
    private String imgUrl;

    // Muitos ninjas para uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key / Chave estrangeira.
    private MissoesModel missoes;
}
