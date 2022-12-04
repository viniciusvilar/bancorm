package br.com.bancorm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bancorm.model.Conta;

@Service
public class ContaService {
    public List<Conta> listaContas = new ArrayList<Conta>();

    public List<Conta> listaContas() {
        return null;
    }
}
