package banco;

public class cuenta {
    private double saldo;
    String codigo;
    protected String oficina;
    public String titular;

    cuenta() {
        this.saldo = 140;
        this.codigo = "36320";
        this.oficina = "Chapela";
        this.titular = "Anxo";
    }

    public cuenta(String codigo, String oficina, String titular) {
        this.saldo = 0;
        this.codigo = codigo;
        this.oficina = oficina;
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
