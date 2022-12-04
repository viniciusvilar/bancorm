package br.com.bancorm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    // Cadastrar Conta
    @PostMapping(path = {"", "/"})
    public void cadastrarConta(@RequestBody int idConta, @RequestBody String descricaoConta, @RequestBody float saldoConta) {
        Conta conta = new Conta(idConta, descricaoConta, saldoConta);
        servico.listaContas.add(conta);
    }

    //Depositar
    @PutMapping(path = "/{id}/deposito")
    public void depositarConta(@PathVariable int id, @RequestBody float valDeposito) {
        for (Conta listaContas : servico.listaContas) {
            if (listaContas.getIdConta() == id) {
                listaContas.setSaldoConta(valDeposito + listaContas.getSaldoConta());
            }
            
        }
    }

    //Sacar
    @PutMapping(path = "/{id}/saque")
    public void saqueConta(@PathVariable int id, @RequestBody float valSaque) {
        for (Conta listaContas : servico.listaContas) {
            if (listaContas.getIdConta() == id) {
                listaContas.setSaldoConta(listaContas.getSaldoConta() - valSaque);
            }
        }
    }

    //Saldo
    @GetMapping(path = "/{id}/saldo")
    public float saldoCOnta(@PathVariable int id) {
        float valSaldo = 0;
        for (Conta listaContas : servico.listaContas) {
            if (listaContas.getIdConta() == id) {
                valSaldo = listaContas.getSaldoConta();
            }
        }
        return valSaldo;
    }
}
