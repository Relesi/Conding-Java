package com.conding.service;

import com.conding.domain.Conta;
import com.conding.domain.Endereco;
import org.springframework.boot.web.embedded.jetty.ConfigurableJettyWebServerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ContaService {

    public static List<Conta> contas;

    public static List<Endereco> enderecos;

    static{
        contas = new ArrayList<>(List.of(new Conta( 1L, "Renato", "Lessa",
                "07/10/2018", 3030303030L, 93939399393L,
                "renato.lessa@impacta.com.br",

                enderecos = new ArrayList<>(List.of(new Endereco())))));
    }


    public List<Conta> listAll() {
        return contas;
    }

    public Conta findById(Long id) {
        return contas.stream()
                .filter(conta -> conta.getId(). equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Conta não encontrada"));
    }

    public Conta save(Conta conta) {
        conta.setId(ThreadLocalRandom.current().nextLong(1, 100000));
        contas.add(conta);
        return conta;
    }

    public void delete(long id) {
        contas.remove((findById(id)));
    }

    public void replace(Conta conta) {
        delete(conta.getId());
        contas.add(conta);
    }

}
