package br.com.bancorm.model;

public class Conta {
    private long idConta;
    private String descricaoConta;
    private float saldoConta;

    public Conta(long idConta, String descricaoConta, float saldoConta) {
        this.idConta = idConta;
        this.descricaoConta = descricaoConta;
        this.saldoConta = saldoConta;
    }

    public long getIdConta() {
        return idConta;
    }
    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
    public String getDescricaoConta() {
        return descricaoConta;
    }
    public void setDescricaoConta(String descricaoConta) {
        this.descricaoConta = descricaoConta;
    }
    public float getSaldoConta() {
        return saldoConta;
    }
    public void setSaldoConta(float saldoConta) {
        this.saldoConta = saldoConta;
    }
}
