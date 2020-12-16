package io.github.gabrielrleal.agenda.model.api.rest;

import io.github.gabrielrleal.agenda.model.entity.Contato;
import io.github.gabrielrleal.agenda.model.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos")
@RequiredArgsConstructor//cria construtor com argumentos obrigatorios (modificador final = obrigatorio)
public class ContatoController {
    private final ContatoRepository repository;  //final para exigir do constrututor para fazer a dependencial

    //ADICIONA CONTATO (POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato save ( @RequestBody Contato contato ) {//requestbody -> corpo da requisicao
        return repository.save(contato);// retorna novo contato com id gerado pelo banco de dados
    }
    //DELETA CONTATO (POST)
    @DeleteMapping("{id}")//parametro da url "{id}"
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete ( @PathVariable Integer id){//integer por causa do id  do cantato ser também integer
        repository.deleteById(id);
    }
    //LISTAR CONTATOS (GET)
    @GetMapping
    public List<Contato> list(){
        return repository.findAll();
    }
    //FAVORITAR
    @PatchMapping("{id}/favorito")
    public void favorite( @PathVariable Integer id, @RequestBody Boolean favorito){
        Optional<Contato> contato = repository.findById(id);
        contato.ifPresent( c -> {
            c.setFavorito(favorito);
            repository.save(c);
        }  );

    }

}
