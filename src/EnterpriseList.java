import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class EnterpriseList implements Serializable {
    //Variable
    private ArrayList<Empresa> list;

    //Constructor
    public EnterpriseList() {
        this.list = new ArrayList<>();
    }

    //Medthods
    public void Add(Empresa enterprise) {
        list.add(enterprise);
    }

    public void Delete(String s) {
        for (Empresa enterprise : list) {
            if (enterprise.getNome().equals(s)) {
                list.remove(enterprise);
                break;
            }
        }
    }

    public String[] NomesEmp() {
        String[] nomes = new String[list.size()];
        int i = 0;

        for (Empresa enterprise : list) {
            nomes[i] = enterprise.getNome();
            i++;
        }

        return nomes;
    }

    public String[][] Info(String s) {

        for (Empresa enterprise : list) {
            if (s.equals(enterprise.getNome())) {

                return new String[][]{
                        {"|Nome: ", enterprise.getNome()},
                        {"|Tipo: ", enterprise.tipo()},
                        {"|Localização: ", String.valueOf(enterprise.getLocalizacao())},
                        {"|Distrito: ", enterprise.getDistrito()},
                        {"|Despesa anual: ", String.valueOf(enterprise.despesaAnual())},
                        {"|Receita anual: ", String.valueOf(enterprise.receitaAnual())},
                        {"|Lucro: ", enterprise.lucroSimNao()}};
            }
        }
        return new String[0][];
    }

    public String ObterCategoria(String nome) {
        String c = "";

        for (Empresa enterprise : list) {
            if (enterprise.getNome().equals(nome)) {
                c = enterprise.tipo();
                break;
            }
        }
        return c;
    }

    public String ObterDados(String nome) {
        String s = "";

        for (Empresa enterprise : list) {
            if (enterprise.getNome().equals(nome)) {
                s = enterprise.toString();
                break;
            }
        }
        return s;
    }

    public String[][] MoreInfo(String s) {
        String more = "ola:adeus,sim:nao";

        for (Empresa enterprise : list) {
            if (s.equals(enterprise.getNome()))
                more = enterprise.toString();
        }

        String[] moreInfoEmp = more.split(",");
        String[][] miEmp = new String[moreInfoEmp.length][2];

        for (int i = 0; i < moreInfoEmp.length; i++) {
            miEmp[i] = moreInfoEmp[i].split(":");
        }

        return miEmp;
    }

    public void update(EnterpriseList newStarThrive) {
        this.list = newStarThrive.list;
    }

    public void totalInfo() {
        for (Empresa enterprise : list) {
            System.out.println(enterprise.toString() + "\n");
        }
    }

    public String[][] maiorMenor(String info) {
        double[] lista = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        List<Empresa> maiorEmp = new ArrayList<>();

        maiorEmp.add(new Cafe("Não há empresas deste tipo", "Restauracao", "-", new GPS(0, 0), 0, 0, 0, 0, 0, 0));
        maiorEmp.add(new Pastelaria("Não há empresas deste tipo", "Restauracao", "-", new GPS(0, 0), 0, 0, 0, 0, 0, 0));
        maiorEmp.add(new Local("Não há empresas deste tipo", "Restauracao", "-", new GPS(0, 0), 0, 0, 0, 0, 0, 0, 0, 0, 0));
        maiorEmp.add(new FastFood("Não há empresas deste tipo", "Restauracao", "-", new GPS(0, 0), 0, 0, 0, 0, 0, 0, 0, 0, 0));
        maiorEmp.add(new Frutaria("Não há empresas deste tipo", "Mercearia", "-", new GPS(0, 0), 0, 0, 0));
        maiorEmp.add(new Mercado("Não há empresas deste tipo", "Mercearia", "-", new GPS(0, 0), 0, "-", 0, 0));

        for (Empresa enterprise : list) {
            int indice = -1;

            indice = switch (info) {
                case "RA" -> enterprise.maxRA(lista, indice);
                case "DA" -> enterprise.minDA(lista, indice);
                case "Lucro" -> enterprise.maxLucro(lista, indice);
                default -> -1;
            };

            if (indice != -1) {
                maiorEmp.set(indice, enterprise);
                switch (info) {
                    case "RA" -> lista[indice] = enterprise.getRA();
                    case "DA" -> lista[indice] = enterprise.getDA();
                    case "Lucro" -> lista[indice] = enterprise.getLucro();
                }
            }
        }

        return new String[][]{
                {"|Nome: ", maiorEmp.get(0).getNome()},
                {"|Tipo: ", maiorEmp.get(0).tipo()},
                {"|Localização: ", String.valueOf(maiorEmp.get(0).getLocalizacao())},
                {"|Distrito: ", maiorEmp.get(0).getDistrito()},
                {"|Despesa anual: ", String.valueOf(maiorEmp.get(0).despesaAnual())},
                {"|Receita anual: ", String.valueOf(maiorEmp.get(0).receitaAnual())},
                {"|Lucro: ", String.valueOf(maiorEmp.get(0).getLucro())},
                {" ", " "},
                {"|Nome: ", maiorEmp.get(1).getNome()},
                {"|Tipo: ", maiorEmp.get(1).tipo()},
                {"|Localização: ", String.valueOf(maiorEmp.get(1).getLocalizacao())},
                {"|Distrito: ", maiorEmp.get(1).getDistrito()},
                {"|Despesa anual: ", String.valueOf(maiorEmp.get(1).despesaAnual())},
                {"|Receita anual: ", String.valueOf(maiorEmp.get(1).receitaAnual())},
                {"|Lucro: ", String.valueOf(maiorEmp.get(1).getLucro())},
                {" ", " "},
                {"|Nome: ", maiorEmp.get(2).getNome()},
                {"|Tipo: ", maiorEmp.get(2).tipo()},
                {"|Localização: ", String.valueOf(maiorEmp.get(2).getLocalizacao())},
                {"|Distrito: ", maiorEmp.get(2).getDistrito()},
                {"|Despesa anual: ", String.valueOf(maiorEmp.get(2).despesaAnual())},
                {"|Receita anual: ", String.valueOf(maiorEmp.get(2).receitaAnual())},
                {"|Lucro: ", String.valueOf(maiorEmp.get(2).getLucro())},
                {" ", " "},
                {"|Nome: ", maiorEmp.get(3).getNome()},
                {"|Tipo: ", maiorEmp.get(3).tipo()},
                {"|Localização: ", String.valueOf(maiorEmp.get(3).getLocalizacao())},
                {"|Distrito: ", maiorEmp.get(3).getDistrito()},
                {"|Despesa anual: ", String.valueOf(maiorEmp.get(3).despesaAnual())},
                {"|Receita anual: ", String.valueOf(maiorEmp.get(3).receitaAnual())},
                {"|Lucro: ", String.valueOf(maiorEmp.get(3).getLucro())},
                {" ", " "},
                {"|Nome: ", maiorEmp.get(4).getNome()},
                {"|Tipo: ", maiorEmp.get(4).tipo()},
                {"|Localização: ", String.valueOf(maiorEmp.get(4).getLocalizacao())},
                {"|Distrito: ", maiorEmp.get(4).getDistrito()},
                {"|Despesa anual: ", String.valueOf(maiorEmp.get(4).despesaAnual())},
                {"|Receita anual: ", String.valueOf(maiorEmp.get(4).receitaAnual())},
                {"|Lucro: ", String.valueOf(maiorEmp.get(4).getLucro())},
                {" ", " "},
                {"|Nome: ", maiorEmp.get(5).getNome()},
                {"|Tipo: ", maiorEmp.get(5).tipo()},
                {"|Localização: ", String.valueOf(maiorEmp.get(5).getLocalizacao())},
                {"|Distrito: ", maiorEmp.get(5).getDistrito()},
                {"|Despesa anual: ", String.valueOf(maiorEmp.get(5).despesaAnual())},
                {"|Receita anual: ", String.valueOf(maiorEmp.get(5).receitaAnual())},
                {"|Lucro: ", String.valueOf(maiorEmp.get(5).getLucro())}};
    }

    public String[][] maisClientes() {
        int maior = 0, maior2 = 0;
        List<Empresa> maiorEmp = new ArrayList<>();

        maiorEmp.add(new Frutaria("StarThrive", "Mercearia", "-", new GPS(0.0, 0.0), 0, 0, 0.0));
        maiorEmp.add(new Frutaria("StarThrive", "Mercearia", "-", new GPS(0.0, 0.0), 0, 0, 0.0));

        for (Empresa enterprise : list) {
            int anterior = maior;
            if (enterprise.maisClientes(maior) != -1) {
                maior = enterprise.maisClientes(maior);
                if (maior != anterior)
                    maiorEmp.set(0, enterprise);
            }
        }

        for (Empresa enterprise : list) {
            int anterior = maior2;
            if (enterprise.maisClientes(maior2) != -1) {
                if (!enterprise.getNome().equals(maiorEmp.get(0).getNome())) {
                    maior2 = enterprise.maisClientes(maior2);
                    if (maior2 != anterior)
                        maiorEmp.set(1, enterprise);
                }
            }
        }

        Restauracao cap1 = (Restauracao) maiorEmp.get(0);
        String cap1valor = String.valueOf(cap1.getnMedioClientesDiario());

        return new String[][]{
                {"|Nome: ", maiorEmp.get(0).getNome()},
                {"|Tipo: ", maiorEmp.get(0).tipo()},
                {"|N medio clientes/dia: ", cap1valor},
                {" ", " "},
                {"|Nome: ", maiorEmp.get(1).getNome()},
                {"|Tipo: ", maiorEmp.get(1).tipo()},
                {"|N medio clientes/dia: ", cap1valor}};
    }

    public void Insert(String nomeAtual, String categoria, String[] array) {

        switch (categoria) {
            case "Cafe":

                for (Empresa enterprise : list) {
                    if (enterprise.getNome().equals(nomeAtual)) {

                        Cafe cafe = (Cafe) enterprise;
                        cafe.setNome(array[0]);
                        cafe.setDistrito(array[1]);
                        cafe.setLocalizacao(new GPS(Double.parseDouble(array[2]), Double.parseDouble(array[3])));
                        cafe.setnEmpregadosMesa(Integer.parseInt(array[4]));
                        cafe.setCustoEmpregadosMesa(Double.parseDouble(array[5]));
                        cafe.setnMedioClientesDiario(Integer.parseInt(array[6]));
                        cafe.setSalarioMedioAnual(Double.parseDouble(array[7]));
                        cafe.setnMedioCafesVendidosDia(Integer.parseInt(array[8]));
                        cafe.setFaturacaoAnualCafeDia(Double.parseDouble(array[9]));
                        break;
                    }
                }

                break;
            case "Pastelaria":
                for (Empresa enterprise : list) {
                    if (enterprise.getNome().equals(nomeAtual)) {
                        Pastelaria pastelaria = (Pastelaria) enterprise;
                        pastelaria.setNome(array[0]);
                        pastelaria.setDistrito(array[1]);
                        pastelaria.setLocalizacao(new GPS(Double.parseDouble(array[2]), Double.parseDouble(array[3])));
                        pastelaria.setnEmpregadosMesa(Integer.parseInt(array[4]));
                        pastelaria.setCustoEmpregadosMesa(Double.parseDouble(array[5]));
                        pastelaria.setnMedioClientesDiario(Integer.parseInt(array[6]));
                        pastelaria.setSalarioMedioAnual(Double.parseDouble(array[7]));
                        pastelaria.setnMedioBolosVendidosDia(Integer.parseInt(array[8]));
                        pastelaria.setFaturacaoAnualBoloDia(Double.parseDouble(array[9]));
                    }
                }
                break;
            case "Fast-Food":
                for (Empresa enterprise : list) {
                    if (enterprise.getNome().equals(nomeAtual)) {
                        FastFood fastfood = (FastFood) enterprise;
                        fastfood.setNome(array[0]);
                        fastfood.setDistrito(array[1]);
                        fastfood.setLocalizacao(new GPS(Double.parseDouble(array[2]), Double.parseDouble(array[3])));
                        fastfood.setnEmpregadosMesa(Integer.parseInt(array[4]));
                        fastfood.setCustoEmpregadosMesa(Double.parseDouble(array[5]));
                        fastfood.setnMedioClientesDiario(Integer.parseInt(array[6]));
                        fastfood.setSalarioMedioAnual(Double.parseDouble(array[7]));
                        fastfood.setnDiasFuncionamentoAno(Integer.parseInt(array[8]));
                        fastfood.setnMesasInteriores(Integer.parseInt(array[9]));
                        fastfood.setFaturacaoMediaMesaDia(Double.parseDouble(array[10]));
                        fastfood.setnMedioClientesDriveThru(Integer.parseInt(array[11]));
                        fastfood.setValorFaturacaoCliente(Double.parseDouble(array[12]));

                    }
                }
                break;
            case "Local":
                for (Empresa enterprise : list) {
                    if (enterprise.getNome().equals(nomeAtual)) {
                        Local local = (Local) enterprise;
                        local.setNome(array[0]);
                        local.setDistrito(array[1]);
                        local.setLocalizacao(new GPS(Double.parseDouble(array[2]), Double.parseDouble(array[3])));
                        local.setnEmpregadosMesa(Integer.parseInt(array[4]));
                        local.setCustoEmpregadosMesa(Double.parseDouble(array[5]));
                        local.setnMedioClientesDiario(Integer.parseInt(array[6]));
                        local.setSalarioMedioAnual(Double.parseDouble(array[7]));
                        local.setnDiasFuncionamentoAno(Integer.parseInt(array[8]));
                        local.setnMesasInteriores(Integer.parseInt(array[9]));
                        local.setFaturacaoMediaMesaDia(Double.parseDouble(array[10]));
                        local.setnMesasEsplanada(Integer.parseInt(array[11]));
                        local.setCustoAnualMesaEsplanada(Double.parseDouble(array[12]));

                    }
                }
                break;
            case "Frutaria":
                for (Empresa enterprise : list) {
                    if (enterprise.getNome().equals(nomeAtual)) {
                        Frutaria f = (Frutaria) enterprise;
                        f.setNome(array[0]);
                        f.setDistrito(array[1]);
                        f.setLocalizacao(new GPS(Double.parseDouble(array[2]), Double.parseDouble(array[3])));
                        f.setCustoLimpezaAnual(Double.parseDouble(array[4]));
                        f.setnProdutos(Integer.parseInt(array[5]));
                        f.setValorFaturacaoProduto(Double.parseDouble(array[6]));

                    }
                }
                break;
            case "Mercado":
                for (Empresa enterprise : list) {
                    if (enterprise.getNome().equals(nomeAtual)) {
                        Mercado m = (Mercado) enterprise;
                        m.setNome(array[0]);
                        m.setDistrito(array[1]);
                        m.setLocalizacao(new GPS(Double.parseDouble(array[2]), Double.parseDouble(array[3])));
                        m.setCustoLimpezaAnual(Double.parseDouble(array[4]));
                        m.setTipo(array[5]);
                        m.setAreaCorredores(Double.parseDouble(array[6]));
                        m.setValorFaturacaoMetro2(Double.parseDouble(array[7]));

                    }
                }
                break;

            //if(! array[0].equals("")) {
        }
    }
}