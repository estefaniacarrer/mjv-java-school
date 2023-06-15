import java.time.LocalDate;

public class Transacao {

    Double valor;
    String tipo;
    String descricao;
    LocalDate data;

    @Override
    public String toString(){
        return "Transacao{" +
                "data=" + data +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", tipo='" + tipo + '\'' +
                '}';

    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
