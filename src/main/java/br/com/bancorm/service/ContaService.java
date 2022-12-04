package br.com.bancorm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bancorm.model.Conta;

@Service
public class ContaService {
    public List<Conta> listaContas = new ArrayList<Conta>();

    public List<Conta> listaContas() {
        return listaContas;
    }

    public void criarConta(Conta conta) {
        listaContas.add(conta);
    }

    public void depositarConta(int id, float valor) {
        for (Conta contas : listaContas) {
            if (contas.getIdConta() == id) {
                contas.setSaldoConta(contas.getSaldoConta() + valor);
            }
        }
    }

    public void saqueConta(int id, float valor) {
        for (Conta contas : listaContas) {
            if (contas.getIdConta() == id) {
                contas.setSaldoConta(contas.getSaldoConta() - valor);
            }
        }
    }

    public float saldoConta(int id) {
        float valSaldo = 0;
        for (Conta contas : listaContas) {
            if (contas.getIdConta() == id) {
                valSaldo = contas.getSaldoConta();
            }
        }
        return valSaldo;
    }

    public void deletarConta(int idConta) {
        for (Conta contas : listaContas) {
            if (contas.getIdConta() == idConta) {
                listaContas.remove(contas);
            }
        }
    }

    public void contasCadastradas() {
        for (Conta contas : listaContas) {
            System.out.println(contas.getIdConta());
            System.out.println(contas.getDescricaoConta());
            System.out.println(contas.getSaldoConta());
        }
    }
}
