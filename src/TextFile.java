import java.io.*;

public class TextFile {

    //Open the file and reads info
    public void read(File file, EnterpriseList StarThrive) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while((line = br.readLine()) != null) {
            String[] linha = line.split(",");

            String nome= linha[1];
            String categoria= linha[2];
            String distrito= linha[3];
            double latitude= Double.parseDouble(linha[4]);
            double longitude= Double.parseDouble(linha[5]);

            if(linha[2].equalsIgnoreCase("Restauracao")){
                int nEmpregadosMesa= Integer.parseInt(linha[6]);
                double custoEmpregadosMesa= Double.parseDouble(linha[7]);
                int nMedioClientesDiario= Integer.parseInt(linha[8]);
                double salarioMedioAnual= Double.parseDouble(linha[9]);

                //Restaurante
                int nDiasFuncionamentoAno= Integer.parseInt(linha[10]);
                int nMesasInteriores= Integer.parseInt(linha[11]);
                double faturacaoMediaMesaDia= Double.parseDouble(linha[12]);

                if (linha[0].equalsIgnoreCase("Cafe")) {
                    int nMedioCafesVendidosDia= Integer.parseInt(linha[10]);
                    double faturacaoAnualCafeDia= Double.parseDouble(linha[11]);

                    Empresa enterprise= new Cafe(nome, categoria, distrito, new GPS(latitude, longitude), nEmpregadosMesa, custoEmpregadosMesa, nMedioClientesDiario, salarioMedioAnual, nMedioCafesVendidosDia, faturacaoAnualCafeDia);
                    StarThrive.Add(enterprise);
                }
                else if (linha[0].equalsIgnoreCase("Pastelaria")) {
                    int nMedioBolosVendidosDia= Integer.parseInt(linha[10]);
                    double faturacaoAnualBoloDia= Double.parseDouble(linha[11]);

                    Empresa enterprise= new Pastelaria(nome, categoria, distrito, new GPS(latitude, longitude), nEmpregadosMesa, custoEmpregadosMesa, nMedioClientesDiario, salarioMedioAnual, nMedioBolosVendidosDia, faturacaoAnualBoloDia);
                    StarThrive.Add(enterprise);
                }
                else if (linha[0].equalsIgnoreCase("FastFood")) {
                    int nMedioClientesDriveThru= Integer.parseInt(linha[13]);
                    double valorFaturacaoCliente= Double.parseDouble(linha[14]);

                    Empresa enterprise= new FastFood(nome, categoria, distrito, new GPS(latitude, longitude), nEmpregadosMesa, custoEmpregadosMesa, nMedioClientesDiario, salarioMedioAnual, nDiasFuncionamentoAno, nMesasInteriores, faturacaoMediaMesaDia, nMedioClientesDriveThru, valorFaturacaoCliente);
                    StarThrive.Add(enterprise);
                }
                else if (linha[0].equalsIgnoreCase("Local")) {
                    int nMesasEsplanada= Integer.parseInt(linha[13]);
                    double custoAnualMesaEsplanada= Double.parseDouble(linha[14]);

                    Empresa enterprise= new Local(nome, categoria, distrito, new GPS(latitude, longitude), nEmpregadosMesa, custoEmpregadosMesa, nMedioClientesDiario, salarioMedioAnual, nDiasFuncionamentoAno, nMesasInteriores, faturacaoMediaMesaDia, nMesasEsplanada, custoAnualMesaEsplanada);
                    StarThrive.Add(enterprise);
                }
                else{
                    System.out.println("Erro no ficheiro de texto.");
                }
            }
            else if(linha[2].equalsIgnoreCase("Mercearia")){
                double custoLimpezaAnual= Double.parseDouble(linha[6]);

                if (linha[0].equalsIgnoreCase("Frutaria")) {
                    int nProdutos= Integer.parseInt(linha[7]);
                    double valorFaturacaoProduto= Double.parseDouble(linha[8]);

                    Empresa enterprise= new Frutaria(nome, categoria, distrito, new GPS(latitude, longitude), custoLimpezaAnual, nProdutos, valorFaturacaoProduto);
                    StarThrive.Add(enterprise);
                }
                else if (linha[0].equalsIgnoreCase("Mercado")) {
                    String tipo= linha[7];
                    double areaCorredores= Double.parseDouble(linha[8]);
                    double valorFaturacaoMetro2= Double.parseDouble(linha[9]);

                    Empresa enterprise= new Mercado(nome, categoria, distrito, new GPS(latitude, longitude), custoLimpezaAnual, tipo, areaCorredores, valorFaturacaoMetro2);
                    StarThrive.Add(enterprise);
                }
                else{
                    System.out.println("Erro no ficheiro de texto.");
                }
            }
            else{
                System.out.println("Erro no ficheiro de texto.");
            }
        }

        br.close();
    }
}
