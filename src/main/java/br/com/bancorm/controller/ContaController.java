package br.com.bancorm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancorm.model.Conta;
import br.com.bancorm.service.ContaService;

@RestController
@RequestMapping(path = "/contabancaria")
public class ContaController {
    @Autowired
    private ContaService servico;

    public List<Conta> mostrarTodasContas() {
        return servico.listaContas();
    }

    @GetMapping(path = "/mostrarcontas")
    public void mostrarContas() {
        servico.contasCadastradas();
    }

    // Cadastrar Conta
    @PostMapping(path = {"", "/"})
    public void cadastrarConta(@RequestBody Conta conta) {;
        servico.criarConta(conta);
    }

    //Depositar
    @PutMapping(path = "/{id}/deposito")
    public void depositarConta(@PathVariable int idConta, @RequestBody String valDeposito) {
        System.out.println(valDeposito);
        //servico.depositarConta(id, valDeposito);
    }

    //Sacar
    @PutMapping(path = "/{id}/saque")
    public void saqueConta(@PathVariable int idConta, @RequestBody float valSaque) {
        servico.saqueConta(idConta, valSaque);
    }

    //Saldo
    @GetMapping(path = "/{id}/saldo")
    public float saldoCOnta(@PathVariable int id) {
        float saldoConta = servico.saldoConta(id);
        return saldoConta;
    }

    //deletar
    @DeleteMapping(path = "/{id}")
    public void apagarConta(@PathVariable int id) {
        servico.deletarConta(id);
    }
}
