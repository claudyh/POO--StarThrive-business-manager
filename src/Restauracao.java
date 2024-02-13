import java.io.Serializable;

/***
 * Classe filha "Restauracao" que contém o nEmpregadosMesa, o custoEmpregadosMesa, o nMedioClientesDiario e o salarioMedioAnual
 * @author Cláudia Torres e Tiago Dias
 * @version 17
 */
public abstract class Restauracao extends Empresa implements Serializable {
    //Variables
    protected int nEmpregadosMesa;
    protected double custoEmpregadosMesa;
    protected int nMedioClientesDiario;
    protected double salarioMedioAnual;

    //Constructor
    /**
     * Construtor principal de "Restauracao"
     * @param nome nome da empresa (String)
     * @param categoria categoria da empresa (String)
     * @param distrito distrito da empresa (String)
     * @param localizacao localização da empresa (GPS)
     * @param nEmpregadosMesa - numero empregados mesa (int)
     * @param custoEmpregadosMesa - custo empregados mesa (double)
     * @param nMedioClientesDiario - n medio clientes diario (int)
     * @param salarioMedioAnual - salario medio anual (double)
     */
    public Restauracao(String nome, String categoria, String distrito, GPS localizacao, int nEmpregadosMesa, double custoEmpregadosMesa, int nMedioClientesDiario, double salarioMedioAnual) {
        super(nome, categoria, distrito, localizacao);
        this.nEmpregadosMesa = nEmpregadosMesa;
        this.custoEmpregadosMesa = custoEmpregadosMesa;
        this.nMedioClientesDiario = nMedioClientesDiario;
        this.salarioMedioAnual = salarioMedioAnual;
    }

    //Getters
    /**
     * Getter de "Restauracao" para a variável nEmpregadosMesa
     * @return nEmpregadosMesa
     */
    public int getnEmpregadosMesa() { return nEmpregadosMesa; }
    /**
     * Getter de "Restauracao" para a variável custoEmpregadosMesa
     * @return custoEmpregadosMesa
     */
    public double getCustoEmpregadosMesa() { return custoEmpregadosMesa; }
    /**
     * Getter de "Restauracao" para a variável nMedioClientesDiario
     * @return nMedioClientesDiario
     */
    public int getnMedioClientesDiario() { return nMedioClientesDiario; }
    /**
     * Getter de "Restauracao" para a variável salarioMedioAnual
     * @return salarioMedioAnual
     */
    public double getSalarioMedioAnual() { return salarioMedioAnual; }

    //Setters
    /**
     * Setter de "Restauracao" para a variável nEmpregadosMesa
     * @param nEmpregadosMesa
     */
    public void setnEmpregadosMesa(int nEmpregadosMesa) { this.nEmpregadosMesa = nEmpregadosMesa; }
    /**
     * Setter de "Restauracao" para a variável custoEmpregadosMesa
     * @param custoEmpregadosMesa
     */
    public void setCustoEmpregadosMesa(double custoEmpregadosMesa) { this.custoEmpregadosMesa = custoEmpregadosMesa; }
    /**
     * Setter de "Restauracao" para a variável nMedioClientesDiario
     * @param nMedioClientesDiario
     */
    public void setnMedioClientesDiario(int nMedioClientesDiario) { this.nMedioClientesDiario = nMedioClientesDiario; }
    /**
     * Setter de "Restauracao" para a variável salarioMedioAnual
     * @param salarioMedioAnual
     */
    public void setSalarioMedioAnual(double salarioMedioAnual) { this.salarioMedioAnual = salarioMedioAnual; }

    //Methods
    @Override
    public String toString() {
        return super.toString()
                + ",|Nº empregados de mesa:" + getnEmpregadosMesa()
                + ",|Custo dos empregados de mesa:" + getCustoEmpregadosMesa()
                + ",|Nº médio de clientes diário:" + getnMedioClientesDiario()
                + ",|Custo do salário médio anual:" + getSalarioMedioAnual();
    }

    public double despesaAnual() { return getnEmpregadosMesa() * getSalarioMedioAnual(); }

    public int maisClientes(int valor) {
        if (getnMedioClientesDiario() > valor) {
            valor = getnMedioClientesDiario();
        }
        return valor;
    }
}