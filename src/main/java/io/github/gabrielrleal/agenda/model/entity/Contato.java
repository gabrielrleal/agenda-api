package io.github.gabrielrleal.agenda.model.entity;
//comentários para fim de aprendizado.
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
//entidade que representa tabela no banco de dados
@Entity
@Getter
@Setter
@NoArgsConstructor //gera construtores sem argumento
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private Boolean favorito;


}
