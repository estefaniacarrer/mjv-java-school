import java.time.LocalDate;
import java.util.List;

public class Terminal {
    public static void main(String[] args){
        Conta conta3 = new Conta();
        System.out.println(conta3.saldo);

        boolean sacou = conta3.sacar(50);
        if(sacou){
            System.out.println(conta3.saldo);
        }else {
            System.out.println("Saldo insuficiente");
        }

        List<Transacao> transacoes = conta3.transacoes;

        for(Transacao transacao : transacoes) {
            System.out.println(transacao.descricao + " " + transacao.valor);
            System.out.println(" ");
        }

        // Criar clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNome("João Silva");
        cliente1.setCpf("1234567890");
        cliente1.setTelefone(987654321);
        cliente1.setNascimento(LocalDate.of(1990, 5, 15));

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria Souza");
        cliente2.setCpf("0987654321");
        cliente2.setTelefone(123456789);
        cliente2.setNascimento(LocalDate.of(1985, 9, 20));

        // Criar contas
        Conta conta1 = new Conta();
        conta1.setCliente(cliente1);
        conta1.setNumConta(1);
        conta1.setNumAgencia(1234);
        conta1.setSaldo(1000.0);

        Conta conta2 = new Conta();
        conta2.setCliente(cliente2);
        conta2.setNumConta(2);
        conta2.setNumAgencia(5678);
        conta2.setSaldo(500.0);

        // Executar ações
        boolean saqueEfetuado = conta1.sacar(200.0);
        System.out.println("Saque efetuado: " + saqueEfetuado);
        System.out.println("Saldo conta 1 após saque: " + conta1.getSaldo());

        boolean transferenciaEfetuada = conta1.transferir(conta2, 300.0);
        System.out.println("Transferência efetuada: " + transferenciaEfetuada);
        System.out.println("Saldo conta 1 após transferência: " + conta1.getSaldo());
        System.out.println("Saldo conta 2 após transferência: " + conta2.getSaldo());

        conta2.cancelarConta("Falta de uso");
        System.out.println("Conta 2 está ativa? " + conta2.isAtiva());

        // Consultar extrato entre datas
        LocalDate dataInicial = LocalDate.of(2023, 1, 1);
        LocalDate dataFinal = LocalDate.of(2023, 6, 14);
        Double saldoEntreDatas = conta1.consultarExtratoEntreDatas(dataInicial, dataFinal);
        System.out.println("Saldo da conta 1 entre " + dataInicial + " e " + dataFinal + ": " + saldoEntreDatas);
    }
}