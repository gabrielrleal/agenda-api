package io.github.gabrielrleal.agenda.model.repository;

import io.github.gabrielrleal.agenda.model.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

//classe que faz a inserção no banco de daods
public interface ContatoRepository extends JpaRepository<Contato, Integer> {//<entidade, chave primaria>


}
