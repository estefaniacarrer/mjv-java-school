import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Conta {


    Cliente cliente;
    Integer numConta;
    Integer numAgencia;
    Double saldo= 130.0;
    boolean ativa = true;

    List<Transacao> transacoes = new ArrayList<>();

    public boolean sacar(double valor) {
        if (valor > saldo) {
            return false;
        } else {
            saldo -= valor;
            incluirTransacao(valor);
            return true;
        }
    }

    private void incluirTransacao(Double valor) {
        Transacao t = new Transacao();
        t.data = LocalDate.now();
        t.tipo = "SAQUE";
        t.descricao = "Saque em especie";
        t.valor = valor;
        transacoes.add(t);
    }

    public boolean transferir (Conta contaDestino, Double valor){
        if (saldo < valor){
            return false;
        } else {
            saldo-= valor;
            return true;
        }
    }

    public void cancelarConta (String justificativa){
        this.ativa = false;
    }

    public Double consultarExtratoEntreDatas (LocalDate dataInicial, LocalDate dataFinal){
        Double saldoEntreDatas = 30.0;

        for (Transacao transacao : transacoes) {
            LocalDate dataTransacao = transacao.getData();

            if (dataTransacao.isAfter(dataInicial) && dataTransacao.isBefore(dataFinal)) {
                if (transacao.getTipo().equals("SAQUE")) {
                    saldoEntreDatas -= transacao.getValor();
                } else if (transacao.getTipo().equals("DEPOSITO")) {
                    saldoEntreDatas += transacao.getValor();
                }
            }
        }

        return saldoEntreDatas;
    }

    public Double consultarSaldo () {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getNumConta() {
        return numConta;
    }

    public void setNumConta(Integer numConta) {
        this.numConta = numConta;
    }

    public Integer getNumAgencia() {
        return numAgencia;
    }

    public void setNumAgencia(Integer numAgencia) {
        this.numAgencia = numAgencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}
