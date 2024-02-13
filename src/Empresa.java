import java.io.Serializable;

/***
 * Classe pai "Empresa" que contém o nome, a categoria, o distrito e a localização
 * @author Cláudia Torres e Tiago Dias
 * @version 6
 */
public abstract class Empresa implements Serializable {
    //Variables
    protected String nome;
    protected String categoria;
    protected String distrito;
    protected GPS localizacao;

    //Constructor
    /**
     * Constructor principal de "Empresa"
     * @param nome nome da empresa (String)
     * @param categoria categoria da empresa (String)
     * @param distrito distrito da empresa (String)
     * @param localizacao localização da empresa (GPS)
     */
    public Empresa(String nome, String categoria, String distrito, GPS localizacao) {
        this.nome = nome;
        this.categoria= categoria;
        this.distrito = distrito;
        this.localizacao = localizacao;
    }

    //Getters
    /***
     * Getter de "Empresa" para a variável nome
     * @return nome
     */
    public String getNome() { return nome; }
    /***
     * Getter de "Empresa" para a variável categoria
     * @return categoria
     */
    public String getCategoria() { return categoria; }
    /***
     * Getter de "Empresa" para a variável distrito
     * @return distrito
     */
    public String getDistrito() { return distrito; }
    /***
     * Getter de "Empresa" para a variável localizacao
     * @return localizacao
     */
    public GPS getLocalizacao() { return localizacao; }
    /***
     * Getter de "Empresa" para o método receitaAnual
     * @return receitaAnual()
     */
    public double getRA() { return receitaAnual(); }
    /***
     * Getter de "Empresa" para o método despesaAnual
     * @return despesaAnual()
     */
    public double getDA() { return despesaAnual(); }
    /***
     * Getter de "Empresa" para o método Lucro
     * @return Lucro()
     */
    public double getLucro() { return lucro(); }

    //Setters
    /**
     * Setter de "Empresa" para a variável nome
     * @param nome
     */
    public void setNome(String nome) { this.nome = nome; }
    /**
     * Setter de "Empresa" para a variável categoria
     * @param categoria
     */
    public void setCategoria(String categoria) { this.categoria = categoria; }
    /**
     * Setter de "Empresa" para a variável distrito
     * @param distrito
     */
    public void setDistrito(String distrito) { this.distrito = distrito; }
    /**
     * Setter de "Empresa" para a variável localizacao
     * @param localizacao
     */
    public void setLocalizacao(GPS localizacao) { this.localizacao = localizacao; }

    //Methods
    /**
     * Método que escreve todas as informações desta classe
     * @return string que contém variáveis
     */
    @Override
    public String toString() {
        return "|Empresa:" + getNome()
                + ",|Distrito:" + getDistrito()
                + ",|Localização:" + getLocalizacao(); }

    /***
     * Método abstrato que nos devolve o tipo da classe (só para impressao)
     * @return string com o tipo de estabelecimento
     */
    public abstract String tipo();
    /**
     *  Método que nos devolve o lucro
     * @return valor do lucro (double)
     */
    public double lucro() { return receitaAnual() - despesaAnual(); }
    /**
     * Método que nos devolve sim se houver lucro e não caso contrário
     * @return String "Sim" ou "Não"
     */
    public String lucroSimNao() {
        String l= "Não";
        if(lucro() > 0)
            l= "Sim";
        return l;
    }

    //Abstract Methods
    /***
     * Método abstrato definido para calcular a despesa anual
     */
    public abstract double despesaAnual();
    /**
     * Método abstrato definido para calcular a receita anual
     */
    public abstract double receitaAnual();

    /**
     * Método que compara o valor 1 com a receita anual (valor 2) e retorna o indice se o valor 2 for maior
     * @param lista valor 1
     * @param indice indice
     * @return valor maior
     */
    public abstract int maxRA(double[] lista, int indice);
    /**
     * Método que compara o valor 1 com a despesa anual (valor 2) e retorna o indice se o valor 2 for menor
     * @param lista valor 1
     * @param indice indice
     * @return valor menor
     */
    public abstract int minDA(double[] lista, int indice);
    /**
     * Método que compara o valor 1 com o lucro (valor 2) e retorna o indice se o valor 2 for maior
     * @param lista valor 1
     * @param indice indice
     * @return valor maior
     */
    public abstract int maxLucro(double[] lista, int indice);
    /**
     * Método que verifica se o nMedioClientesDiario é maior que o parametro recebido
     * @param valor valor a comparar (int)
     * @return numero maior entre valor e nMedioClientesDiario (int)
     */
    public abstract int maisClientes(int valor);
}