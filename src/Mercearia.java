import java.io.Serializable;

/***
 * Classe filha "Mercearia" que contém o custoLimpezaAnual
 * @author Cláudia Torres e Tiago Dias
 * @version 8
 */
public abstract class Mercearia extends Empresa implements Serializable {
    //Variable
    protected double custoLimpezaAnual;

    //Constructor
    /**
     * Construtor principal de "Mercearia"
     * @param nome nome da empresa (String)
     * @param categoria categoria da empresa (String)
     * @param distrito distrito da empresa (String)
     * @param localizacao localização da empresa (GPS)
     * @param custoLimpezaAnual custo de limpeza anual (double)
     */
    public Mercearia(String nome, String categoria, String distrito, GPS localizacao, double custoLimpezaAnual) {
        super(nome, categoria, distrito, localizacao);
        this.custoLimpezaAnual = custoLimpezaAnual;
    }

    //Getter
    /**
     * Getter de "Mercearia" para a variável custoLimpezaAnual
     * @return custoLimpezaAnual
     */
    public double getCustoLimpezaAnual() { return custoLimpezaAnual; }

    //Setter
    /**
     * Setter de "Mercearia" para a variável custoLimpezaAnual
     * @param custoLimpezaAnual
     */
    public void setCustoLimpezaAnual(double custoLimpezaAnual) { this.custoLimpezaAnual = custoLimpezaAnual; }

    //Methods
    @Override
    public String toString() {
        return  super.toString()
                + ",|Custo anual de limpeza do estabelecimento:" + getCustoLimpezaAnual();
    }

    public double despesaAnual(){ return getCustoLimpezaAnual(); }
    public int maisClientes(int valor) {return -1;}
}