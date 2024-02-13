import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Botao extends JButton {
    private JButton botao;

    public Botao() {
        super();
        botao = new JButton();
        botao.setFont(new Font("Monospaced", Font.BOLD, 14));
        botao.setBackground(Color.decode("#56947e"));
        botao.setForeground(Color.white);
        botao.setBorderPainted(false);
    }

    //ACTION-LISTENERS//////////////////////////////////////////////////////////////////////////////////////////////////

    //INFO--------------------------------------------------------------------------------------------------------------
    protected static class Info implements ActionListener {
        private GUI frame;

        public Info(GUI frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent onClick) {
            EnterpriseList StarThrive = frame.getST();
            String empSelecionada = frame.getLista().getSelectedValue();

            //NENHUMA EMPRESA SELECIONADA
            if (empSelecionada == null) {
                JOptionPane.showMessageDialog(null, "Enterprise not selected.", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
            //APRESENTAR INFO DA EMPRESA
            else {
                //NEW JFRAME
                JFrame mostrar = new JFrame("Enterprise Info");
                mostrar.setSize(500, 500);

                //GET INFO
                String[][] infoEmpresa;
                infoEmpresa = StarThrive.Info(empSelecionada);
                String[] columnNames = {"Enterprise Info", ""};

                //JTABLE
                JTable j = new JTable(infoEmpresa, columnNames);
                j.setDefaultEditor(Object.class, null);
                j.setShowGrid(false);

                //JSCROLL
                JScrollPane sp = new JScrollPane(j);

                //ADD TO FRAME
                mostrar.add(sp);
                mostrar.setVisible(true);
            }
        }
    }

    //EDITAR------------------------------------------------------------------------------------------------------------
    protected static class Editar implements ActionListener {
        private GUI frame;

        public Editar(GUI frame) {
            this.frame = frame;
        }

        //Hinted Text Field
        public class HintTextField extends JTextField {
            public HintTextField(String hint) {
                _hint = hint;
            }


            public void paint(Graphics g) {
                this.setSize(100, 20);
                super.paint(g);
                if (getText().length() == 0) {
                    int h = getHeight();
                    ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                    Insets ins = getInsets();
                    FontMetrics fm = g.getFontMetrics();
                    int c0 = getBackground().getRGB();
                    int c1 = getForeground().getRGB();
                    int m = 0xfefefefe;
                    int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
                    g.setColor(new Color(c2, true));
                    g.drawString(_hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
                }
            }

            private final String _hint;
        }

        @Override
        public void actionPerformed(ActionEvent onClick) {
            EnterpriseList StarThrive = frame.getST();
            String empSelecionada = frame.getLista().getSelectedValue();

            //Obter dados da empresa selecionada
            String categoria = StarThrive.ObterCategoria(empSelecionada);
            String dados = StarThrive.ObterDados(empSelecionada);
            String[] dadosEmpresa = dados.split(":|,");
            for (String a : dadosEmpresa) {
                System.out.println(a);
            }
            //JFRAME
            JFrame frameEdit = new JFrame("Edit");
            frameEdit.setSize(600, 550);
            frameEdit.setResizable(false);
            frameEdit.setLocationRelativeTo(null);
            frameEdit.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            //JPANEL
            JPanel panel = new JPanel();
            panel.setLayout(null);

            //JLABEL
            JLabel titulo = new JLabel("EDIT ENTERPRISE:");
            titulo.setBounds(20, 20, 150, 25);

            //JBUTTONS
            Botao guardarEdits = new Botao();
            guardarEdits.setText("Save");
            guardarEdits.setBounds(30, 450, 100, 25);

            //JLABELS AND TEXTFIELDS
            //Atributos gerais
            JLabel nome = new JLabel("Nome:");
            nome.setBounds(20, 80, 100, 25);
            JLabel distrito = new JLabel("Distrito:");
            distrito.setBounds(20, 110, 100, 25);
            JLabel localizacao = new JLabel("Localização:");
            localizacao.setBounds(20, 140, 100, 25);
            JLabel tracinho = new JLabel("-");
            tracinho.setBounds(260, 142, 10, 20);

            panel.add(nome);
            panel.add(distrito);
            panel.add(localizacao);
            panel.add(tracinho);

            JTextField nome1 = new HintTextField(dadosEmpresa[1]);
            nome1.setBounds(150, 82, 150, 20);

            JTextField distrito1 = new HintTextField(dadosEmpresa[3]);
            distrito1.setBounds(150, 112, 150, 20);

            JTextField latitude = new HintTextField(dadosEmpresa[5]);
            latitude.setBounds(150, 142, 100, 20);

            JTextField longitude = new HintTextField(dadosEmpresa[6]);
            longitude.setBounds(280, 142, 100, 20);

            //ADD TO PANEL
            panel.add(titulo);
            panel.add(nome1);
            panel.add(distrito1);
            panel.add(latitude);
            panel.add(longitude);
            panel.add(guardarEdits);

            //JLABES AND JTEXTFIELDS
            JLabel nEmpregadosMesa = new JLabel("Nº empregados mesa:");
            nEmpregadosMesa.setBounds(20, 170, 100, 25);
            JLabel custoEmpregadosMesa = new JLabel("Custo empregados mesa:");
            custoEmpregadosMesa.setBounds(20, 200, 100, 25);
            JLabel nMedioClientesDiarios = new JLabel("Nº medio clientes diário:");
            nMedioClientesDiarios.setBounds(20, 230, 100, 25);
            JLabel salarioMedioAnual = new JLabel("Salário Médio Anual:");
            salarioMedioAnual.setBounds(20, 260, 100, 25);

            JTextField nEmpregadosMesa1 = new HintTextField(dadosEmpresa[8]);
            nEmpregadosMesa1.setBounds(150, 172, 150, 20);

            JTextField custoEmpregadosMesa1 = new HintTextField(dadosEmpresa[10]);
            custoEmpregadosMesa1.setBounds(150, 202, 150, 20);

            JTextField nMedioClientesDiarios1 = new HintTextField(dadosEmpresa[12]);
            nMedioClientesDiarios1.setBounds(150, 232, 150, 20);

            JTextField salarioMedioAnual1 = new HintTextField(dadosEmpresa[14]);
            salarioMedioAnual1.setBounds(150, 262, 150, 20);

            JLabel nDiasFuncionamentoAno = new JLabel("Nº dias de funcionamento p/ ano:");
            nDiasFuncionamentoAno.setBounds(20, 290, 100, 25);
            JLabel nMesasInteriores = new JLabel("Nº mesas interiores:");
            nMesasInteriores.setBounds(20, 320, 100, 25);
            JLabel faturacaoMediaMesaDia = new JLabel("Faturação media de mesa p/ dia:");
            faturacaoMediaMesaDia.setBounds(20, 350, 100, 25);

            JTextField nDiasFuncionamentoAno1 = new HintTextField(dadosEmpresa[16]);
            nDiasFuncionamentoAno1.setBounds(150, 292, 150, 20);
            JTextField nMesasInteriores1 = new HintTextField(dadosEmpresa[18]);
            nMesasInteriores1.setBounds(150, 322, 150, 20);
            JTextField faturacaoMediaMesaDia1 = new HintTextField(dadosEmpresa[20]);
            faturacaoMediaMesaDia1.setBounds(150, 352, 150, 20);

            switch (categoria) {

                case "Cafe":

                    panel.add(nEmpregadosMesa);
                    panel.add(custoEmpregadosMesa);
                    panel.add(nMedioClientesDiarios);
                    panel.add(salarioMedioAnual);

                    //ADD TO PANEL
                    panel.add(nEmpregadosMesa1);
                    panel.add(custoEmpregadosMesa1);
                    panel.add(nMedioClientesDiarios1);
                    panel.add(salarioMedioAnual1);

                    //JLABELS AND TEXTFIELDS
                    JLabel nCafesVendidosDia = new JLabel("Nº cafés vendidos p/dia:");
                    nCafesVendidosDia.setBounds(20, 290, 100, 25);
                    JLabel faturacaoAnualCafeDia = new JLabel("Faturação anual café/dia:");
                    faturacaoAnualCafeDia.setBounds(20, 320, 100, 25);

                    panel.add(nCafesVendidosDia);
                    panel.add(faturacaoAnualCafeDia);


                    JTextField nCafesVendidosDia1 = new HintTextField(dadosEmpresa[16]);
                    nCafesVendidosDia1.setBounds(150, 292, 150, 20);

                    JTextField faturacaoAnualCafeDia1 = new HintTextField(dadosEmpresa[18]);
                    faturacaoAnualCafeDia1.setBounds(150, 322, 150, 20);

                    //ADD TO PANEL
                    panel.add(nCafesVendidosDia1);
                    panel.add(faturacaoAnualCafeDia1);

                    //ACTION LISTENER DE GUARDAR
                    guardarEdits.addActionListener(new Botao.GuardarEdicao(frame, categoria, panel, frameEdit, empSelecionada));

                    break;

                case "Pastelaria":

                    panel.add(nEmpregadosMesa);
                    panel.add(custoEmpregadosMesa);
                    panel.add(nMedioClientesDiarios);
                    panel.add(salarioMedioAnual);

                    //ADD TO PANEL
                    panel.add(nEmpregadosMesa1);
                    panel.add(custoEmpregadosMesa1);
                    panel.add(nMedioClientesDiarios1);
                    panel.add(salarioMedioAnual1);

                    //JLABELS AND TEXTFIELDS
                    JLabel nMedioBolosVendidosDia = new JLabel("Nº bolos vendidos p/dia:");
                    nMedioBolosVendidosDia.setBounds(20, 290, 100, 25);
                    JLabel faturacaoAnualBoloDia = new JLabel("Faturação anual bolo/dia:");
                    faturacaoAnualBoloDia.setBounds(20, 320, 100, 25);

                    JTextField nMedioBolosVendidosDia1 = new HintTextField(dadosEmpresa[16]);
                    nMedioBolosVendidosDia1.setBounds(150, 292, 150, 20);

                    JTextField faturacaoAnualBoloDia1 = new HintTextField(dadosEmpresa[18]);
                    faturacaoAnualBoloDia1.setBounds(150, 322, 150, 20);

                    //ADD TO PANEL
                    panel.add(nMedioBolosVendidosDia);
                    panel.add(nMedioBolosVendidosDia1);
                    panel.add(faturacaoAnualBoloDia);
                    panel.add(faturacaoAnualBoloDia1);

                    //ACTION LISTENER DE GUARDAR
                    guardarEdits.addActionListener(new Botao.GuardarEdicao(frame, categoria, panel, frameEdit, empSelecionada));

                    break;

                case "Local":

                    panel.add(nEmpregadosMesa);
                    panel.add(custoEmpregadosMesa);
                    panel.add(nMedioClientesDiarios);
                    panel.add(salarioMedioAnual);

                    panel.add(nEmpregadosMesa1);
                    panel.add(custoEmpregadosMesa1);
                    panel.add(nMedioClientesDiarios1);
                    panel.add(salarioMedioAnual1);

                    panel.add(nDiasFuncionamentoAno);
                    panel.add(nDiasFuncionamentoAno1);
                    panel.add(nMesasInteriores);
                    panel.add(nMesasInteriores1);
                    panel.add(faturacaoMediaMesaDia);
                    panel.add(faturacaoMediaMesaDia1);

                    //JLABELS AND TEXTFIELDS
                    JLabel nMesasEsplanada = new JLabel("Nº mesas esplanada:");
                    nMesasEsplanada.setBounds(20, 380, 100, 25);
                    JLabel custoAnualMesaEsplanada = new JLabel("Custo anual p/ mesa de esplanada:");
                    custoAnualMesaEsplanada.setBounds(20, 410, 100, 25);

                    JTextField nMesasEsplanada1 = new HintTextField(dadosEmpresa[22]);
                    nMesasEsplanada1.setBounds(150, 382, 150, 20);

                    JTextField custoAnualMesaEsplanada1 = new HintTextField(dadosEmpresa[24]);
                    custoAnualMesaEsplanada1.setBounds(150, 412, 150, 20);

                    panel.add(nMesasEsplanada);
                    panel.add(nMesasEsplanada1);
                    panel.add(custoAnualMesaEsplanada);
                    panel.add(custoAnualMesaEsplanada1);

                    //ACTION LISTENER DE GUARDAR
                    guardarEdits.addActionListener(new Botao.GuardarEdicao(frame, categoria, panel, frameEdit, empSelecionada));

                    break;
                /**

                case "Local":

                    //Restauração
                    panel.add(nEmpregadosMesa);
                    panel.add(custoEmpregadosMesa);
                    panel.add(nMedioClientesDiarios);
                    panel.add(salarioMedioAnual);

                    //Restaurante
                    panel.add(nDiasFuncionamentoAno);
                    panel.add(nDiasFuncionamentoAno1);
                    panel.add(nMesasInteriores);
                    panel.add(nMesasInteriores1);
                    panel.add(faturacaoMediaMesaDia);
                    panel.add(faturacaoMediaMesaDia1);

                    //JLABELS AND TEXTFIELDS
                    JLabel nMesasEsplanada = new JLabel("Nº mesas esplanada:");
                    nMesasEsplanada.setBounds(20, 380, 100, 25);
                    JLabel custoAnualMesaEsplanada = new JLabel("Custo anual p/ mesa de esplanada:");
                    custoAnualMesaEsplanada.setBounds(20, 410, 100, 25);

                    JTextField nMesasEsplanada1 = new HintTextField(dadosEmpresa[22]);
                    nMesasEsplanada1.setBounds(150, 382, 150, 20);

                    JTextField custoAnualMesaEsplanada1 = new HintTextField(dadosEmpresa[24]);
                    custoAnualMesaEsplanada1.setBounds(150, 412, 150, 20);

                    //ADD TO PANEL
                    panel.add(nMesasEsplanada);
                    panel.add(nMesasEsplanada1);
                    panel.add(custoAnualMesaEsplanada);
                    panel.add(custoAnualMesaEsplanada1);

                    break;

                case "FastFood":

                    //Restauração
                    panel.add(nEmpregadosMesa);
                    panel.add(custoEmpregadosMesa);
                    panel.add(nMedioClientesDiarios);
                    panel.add(salarioMedioAnual);

                    //Restaurante
                    panel.add(nDiasFuncionamentoAno);
                    panel.add(nDiasFuncionamentoAno1);
                    panel.add(nMesasInteriores);
                    panel.add(nMesasInteriores1);
                    panel.add(faturacaoMediaMesaDia);
                    panel.add(faturacaoMediaMesaDia1);

                    //JLABELS AND TEXTFIELDS
                    JLabel nMedioClientesDriveThru = new JLabel("Nº medio clientes drive-thru:");
                    nMedioClientesDriveThru.setBounds(20, 380, 100, 25);
                    JLabel valorFaturacaoCliente = new JLabel("Média diária de faturação p/ cliente drive-thru:");
                    valorFaturacaoCliente.setBounds(20, 410, 100, 25);

                    JTextField nMedioClientesDriveThru1 = new HintTextField(dadosEmpresa[22]);
                    nMedioClientesDriveThru1.setBounds(150, 382, 150, 20);

                    JTextField valorFaturacaoCliente1 = new HintTextField(dadosEmpresa[24]);
                    valorFaturacaoCliente1.setBounds(150, 412, 150, 20);

                    //ADD TO PANEL
                    panel.add(nMedioClientesDriveThru);
                    panel.add(nMedioClientesDriveThru1);
                    panel.add(valorFaturacaoCliente);
                    panel.add(valorFaturacaoCliente1);

                    break;

                case "Frutaria":

                    //Mercearia
                    panel.add(custoLimpezaAnual);
                    panel.add(custoLimpezaAnual1);

                    //JLABELS AND TEXTFIELDS
                    JLabel nProdutos = new JLabel("Nº de produtos:");
                    nProdutos.setBounds(20, 200, 100, 25);
                    JLabel valorFaturacaoProduto = new JLabel("Média diária de faturação p/ produto:");
                    valorFaturacaoProduto.setBounds(20, 230, 100, 25);

                    JTextField nProdutos1 = new HintTextField(dadosEmpresa[10]);
                    nProdutos1.setBounds(150, 202, 150, 20);
                    JTextField valorFaturacaoProduto1 =  new HintTextField(dadosEmpresa[12]);
                    valorFaturacaoProduto1.setBounds(150, 232, 150, 20);

                    //ADD TO PANEL
                    panel.add(nProdutos);
                    panel.add(nProdutos1);
                    panel.add(valorFaturacaoProduto);
                    panel.add(valorFaturacaoProduto1);

                    break;

                case "Mercado":

                    //Mercearia
                    panel.add(custoLimpezaAnual);
                    panel.add(custoLimpezaAnual1);

                    //JLABELS AND TEXTFIELDS
                    JLabel tipo = new JLabel("Tipo (Minimercado, Supermercado ou Hipermercado):");
                    tipo.setBounds(20, 200, 100, 25);
                    JLabel areaCorredores = new JLabel("Área dos corredores:");
                    areaCorredores.setBounds(20, 230, 100, 25);
                    JLabel valorFaturacaoMetro2 = new JLabel("Faturação por m^2:");
                    valorFaturacaoMetro2.setBounds(20, 260, 100, 25);

                    JTextField tipo1 = new HintTextField(dadosEmpresa[10]);
                    tipo1.setBounds(150, 202, 150, 20);

                    JTextField areaCorredores1 = new HintTextField(dadosEmpresa[12]);
                    areaCorredores1.setBounds(150, 232, 150, 20);

                    JTextField valorFaturacaoMetro21 = new HintTextField(dadosEmpresa[14]);
                    valorFaturacaoMetro21.setBounds(150, 262, 150, 20);

                    //ADD TO PANEL
                    panel.add(tipo);
                    panel.add(tipo1);
                    panel.add(areaCorredores);
                    panel.add(areaCorredores1);
                    panel.add(valorFaturacaoMetro2);
                    panel.add(valorFaturacaoMetro21);

                    break;**/

            }

            //ADD TO FRAME
            frameEdit.add(panel);
            frameEdit.setVisible(true);
        }
    }

    //CRIAR-------------------------------------------------------------------------------------------------------------
    protected static class Criar implements ActionListener {
        private GUI frame;

        public Criar(GUI frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent onClick) {
            String[] tipo = {"Cafe", "Pastelaria", "Restaurante Local", "Restaurante FastFood", "Frutaria", "Mercado"};

            //JFRAME
            JFrame frameTipo = new JFrame("Create");
            frameTipo.setSize(500, 500);
            frameTipo.setResizable(false);
            frameTipo.setLocationRelativeTo(null);
            frameTipo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            //JPANEL
            JPanel panel = new JPanel();
            panel.setLayout(null);

            //JLABEL
            JLabel texto = new JLabel("Select category:");
            texto.setBounds(0, 0, 190, 35);

            //JCOMBOBOX
            JComboBox<String> escolherTipo = new JComboBox<>(tipo);
            escolherTipo.setBounds(0, 50, 190, 35);

            //JBUTTONS
            Botao selecionar = new Botao();
            selecionar.setText("Select");
            selecionar.setBounds(0, 100, 190, 35);

            selecionar.addActionListener(new Botao.Selecionar(escolherTipo, frameTipo, frame));

            //ADD TO PANEL
            panel.add(texto);
            panel.add(escolherTipo);
            panel.add(selecionar);

            //ADD TO FRAME
            frameTipo.add(panel);
            frameTipo.setVisible(true);
        }
    }

    //ELIMINAR EMPRESA--------------------------------------------------------------------------------------------------
    protected static class Eliminar implements ActionListener {
        private GUI frame;

        public Eliminar(GUI frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent onClick) {
            EnterpriseList StarThrive = frame.getST();
            String empSelecionada = frame.getLista().getSelectedValue();

            if (empSelecionada == null) {
                JOptionPane.showMessageDialog(null, "Enterprise not selected.", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this enterprise?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    StarThrive.Delete(empSelecionada);

                    frame.getEmpresasLista().removeElement(empSelecionada);
                }
            }
        }
    }

    //MAIOR RA/MENOR DA/MAIOR LUCRO-------------------------------------------------------------------------------------
    protected static class Anual implements ActionListener {
        private GUI frame;
        private String stringTitle;
        private String stringInfo;

        public Anual(GUI frame, String stringTitle, String stringInfo) {
            this.frame = frame;
            this.stringTitle = stringTitle;
            this.stringInfo = stringInfo;
        }

        @Override
        public void actionPerformed(ActionEvent onClick) {
            EnterpriseList StarThrive = frame.getST();

            //JFRAME
            JFrame mostrar = new JFrame(stringTitle);
            mostrar.setSize(500, 500);

            //GET INFO
            String[][] infoEmpresa;
            infoEmpresa = StarThrive.maiorMenor(stringInfo);
            String[] columnNames = {"Enterprise Info", ""};

            //JTABLE
            JTable j = new JTable(infoEmpresa, columnNames);
            j.setDefaultEditor(Object.class, null);

            //JSCROLL
            JScrollPane sp = new JScrollPane(j);

            //ADD TO FRAME
            mostrar.add(sp);
            mostrar.setVisible(true);
        }
    }

    //MAIOR CAPACIDADE CLIENTES-----------------------------------------------------------------------------------------
    protected static class Clientes implements ActionListener {
        private GUI frame;

        public Clientes(GUI frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent onClick) {
            EnterpriseList StarThrive = frame.getST();

            //JFRAME
            JFrame mostrar = new JFrame("Highest Client Capacity");
            mostrar.setSize(500, 500);

            //GET INFO
            String[][] infoEmpresa;
            infoEmpresa = StarThrive.maisClientes();
            String[] columnNames = {"Enterprise Info", ""};

            //JTABLE
            JTable j = new JTable(infoEmpresa, columnNames);
            j.setDefaultEditor(Object.class, null);

            //JSCROLL
            JScrollPane sp = new JScrollPane(j);

            //ADD TO FRAME
            mostrar.add(sp);
            mostrar.setVisible(true);
        }
    }

    //BOTAO SELECT------------------------------------------------------------------------------------------------------
    protected static class Selecionar implements ActionListener {
        private JComboBox<String> escolherTipo;
        private JFrame frameTipo;
        private GUI frame;


        private Selecionar(JComboBox<String> escolherTipo, JFrame frameTipo, GUI frame) {
            this.escolherTipo = escolherTipo;
            this.frameTipo = frameTipo;
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent onClick) {
            frameTipo.dispose();

            //JFRAME
            JFrame frameCriar = new JFrame("Create");
            frameCriar.setSize(600, 550);
            frameCriar.setResizable(false);
            frameCriar.setLocationRelativeTo(null);
            frameCriar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            //JPANEL
            JPanel panel = new JPanel();
            panel.setLayout(null);

            //JLABEL
            JLabel inicio = new JLabel("NEW   ENTERPRISE");
            inicio.setBounds(20, 20, 150, 25);

            //JBUTTONS
            Botao guardar = new Botao();
            guardar.setText("Save");
            guardar.setBounds(30, 450, 100, 25);



            //SELECTED CATEGORY (FROM COMBOBOX)
            String selectedItem = (String) escolherTipo.getSelectedItem();

            //JLABELS AND TEXTFIELDS
            //Atributos gerais
            JLabel nome = new JLabel("Nome:");
            nome.setBounds(20, 80, 100, 25);
            JTextField nome1 = new JTextField();
            nome1.setBounds(150, 82, 150, 20);

            JLabel distrito = new JLabel("Distrito:");
            distrito.setBounds(20, 110, 100, 25);
            JTextField distrito1 = new JTextField();
            distrito1.setBounds(150, 112, 150, 20);

            JLabel localizacao = new JLabel("Localização:");
            localizacao.setBounds(20, 140, 100, 25);
            JTextField latitude = new JTextField();
            latitude.setBounds(150, 142, 100, 20);
            JTextField longitude = new JTextField();
            longitude.setBounds(280, 142, 100, 20);
            JLabel tracinho = new JLabel("-");
            tracinho.setBounds(260, 142, 10, 20);

            //ADD TO PANEL
            panel.add(inicio);
            panel.add(nome);
            panel.add(nome1);
            panel.add(distrito);
            panel.add(distrito1);
            panel.add(localizacao);
            panel.add(latitude);
            panel.add(longitude);
            panel.add(tracinho);
            panel.add(guardar);


            //ADICIONAR DE ACORDO COM A CATEGORIA
            switch (Objects.requireNonNull(selectedItem)) {
                case "Cafe":

                    //JLABELS AND TEXTFIELDS
                    JLabel nCafesVendidosDia = new JLabel("Nº cafés vendidos p/dia:");
                    nCafesVendidosDia.setBounds(20, 290, 100, 25);
                    JTextField nCafesVendidosDia1 = new JTextField();
                    nCafesVendidosDia1.setBounds(150, 292, 150, 20);

                    JLabel faturacaoAnualCafeDia = new JLabel("Faturação anual café/dia:");
                    faturacaoAnualCafeDia.setBounds(20, 320, 100, 25);
                    JTextField faturacaoAnualCafeDia1 = new JTextField();
                    faturacaoAnualCafeDia1.setBounds(150, 322, 150, 20);

                    //ADD TO PANEL
                    addRestauracao(panel);
                    panel.add(nCafesVendidosDia);
                    panel.add(nCafesVendidosDia1);
                    panel.add(faturacaoAnualCafeDia);
                    panel.add(faturacaoAnualCafeDia1);

                    //ACTION LISTENER DE GUARDAR
                    guardar.addActionListener(new Botao.Guardar(frame, "Cafe", panel, frameCriar));

                    break;

                case "Pastelaria":

                    //JLABELS AND TEXTFIELDS
                    JLabel nMedioBolosVendidosDia = new JLabel("Nº bolos vendidos p/dia:");
                    nMedioBolosVendidosDia.setBounds(20, 290, 100, 25);
                    JTextField nMedioBolosVendidosDia1 = new JTextField();
                    nMedioBolosVendidosDia1.setBounds(150, 292, 150, 20);

                    JLabel faturacaoAnualBoloDia = new JLabel("Faturação anual bolo/dia:");
                    faturacaoAnualBoloDia.setBounds(20, 320, 100, 25);
                    JTextField faturacaoAnualBoloDia1 = new JTextField();
                    faturacaoAnualBoloDia1.setBounds(150, 322, 150, 20);

                    //ADD TO PANEL
                    addRestauracao(panel);
                    panel.add(nMedioBolosVendidosDia);
                    panel.add(nMedioBolosVendidosDia1);
                    panel.add(faturacaoAnualBoloDia);
                    panel.add(faturacaoAnualBoloDia1);

                    //ACTION LISTENER DE GUARDAR
                    guardar.addActionListener(new Botao.Guardar(frame, "Pastelaria", panel, frameCriar));

                    break;

                case "Restaurante Local":

                    //JLABELS AND TEXTFIELDS
                    JLabel nMesasEsplanada = new JLabel("Nº mesas esplanada:");
                    nMesasEsplanada.setBounds(20, 380, 100, 25);
                    JTextField nMesasEsplanada1 = new JTextField();
                    nMesasEsplanada1.setBounds(150, 382, 150, 20);

                    JLabel custoAnualMesaEsplanada = new JLabel("Custo anual p/ mesa de esplanada:");
                    custoAnualMesaEsplanada.setBounds(20, 410, 100, 25);
                    JTextField custoAnualMesaEsplanada1 = new JTextField();
                    custoAnualMesaEsplanada1.setBounds(150, 412, 150, 20);

                    //ADD TO PANEL
                    addRestauracao(panel);
                    addRestaurante(panel);
                    panel.add(nMesasEsplanada);
                    panel.add(nMesasEsplanada1);
                    panel.add(custoAnualMesaEsplanada);
                    panel.add(custoAnualMesaEsplanada1);

                    //ACTION LISTENER DE GUARDAR
                    guardar.addActionListener(new Botao.Guardar(frame, "Local", panel, frameCriar));

                    break;

                case "Restaurante FastFood":

                    //JLABELS AND TEXTFIELDS
                    JLabel nMedioClientesDriveThru = new JLabel("Nº medio clientes drive-thru:");
                    nMedioClientesDriveThru.setBounds(20, 380, 100, 25);
                    JTextField nMedioClientesDriveThru1 = new JTextField();
                    nMedioClientesDriveThru1.setBounds(150, 382, 150, 20);

                    JLabel valorFaturacaoCliente = new JLabel("Média diária de faturação p/ cliente drive-thru:");
                    valorFaturacaoCliente.setBounds(20, 410, 100, 25);
                    JTextField valorFaturacaoCliente1 = new JTextField();
                    valorFaturacaoCliente1.setBounds(150, 412, 150, 20);

                    //ADD TO PANEL
                    addRestauracao(panel);
                    addRestaurante(panel);
                    panel.add(nMedioClientesDriveThru);
                    panel.add(nMedioClientesDriveThru1);
                    panel.add(valorFaturacaoCliente);
                    panel.add(valorFaturacaoCliente1);

                    //ACTION LISTENER DE GUARDAR
                    guardar.addActionListener(new Botao.Guardar(frame, "FastFood", panel, frameCriar));

                    break;

                case "Frutaria":

                    //JLABELS AND TEXTFIELDS
                    JLabel nProdutos = new JLabel("Nº de produtos:");
                    nProdutos.setBounds(20, 200, 100, 25);
                    JTextField nProdutos1 = new JTextField();
                    nProdutos1.setBounds(150, 202, 150, 20);

                    JLabel valorFaturacaoProduto = new JLabel("Média diária de faturação p/ produto:");
                    valorFaturacaoProduto.setBounds(20, 230, 100, 25);
                    JTextField valorFaturacaoProduto1 = new JTextField();
                    valorFaturacaoProduto1.setBounds(150, 232, 150, 20);

                    //ADD TO PANEL
                    addMercearia(panel);
                    panel.add(nProdutos);
                    panel.add(nProdutos1);
                    panel.add(valorFaturacaoProduto);
                    panel.add(valorFaturacaoProduto1);

                    //ACTION LISTENER DE GUARDAR
                    guardar.addActionListener(new Botao.Guardar(frame, "Frutaria", panel, frameCriar));

                    break;

                case "Mercado":

                    //JLABELS AND TEXTFIELDS
                    JLabel tipo = new JLabel("Tipo (Minimercado, Supermercado ou Hipermercado):");
                    tipo.setBounds(20, 200, 100, 25);
                    JTextField tipo1 = new JTextField();
                    tipo1.setBounds(150, 202, 150, 20);

                    JLabel areaCorredores = new JLabel("Área dos corredores:");
                    areaCorredores.setBounds(20, 230, 100, 25);
                    JTextField areaCorredores1 = new JTextField();
                    areaCorredores1.setBounds(150, 232, 150, 20);

                    JLabel valorFaturacaoMetro2 = new JLabel("Faturação por m^2:");
                    valorFaturacaoMetro2.setBounds(20, 260, 100, 25);
                    JTextField valorFaturacaoMetro21 = new JTextField();
                    valorFaturacaoMetro21.setBounds(150, 262, 150, 20);

                    //ADD TO PANEL
                    addMercearia(panel);
                    panel.add(tipo);
                    panel.add(tipo1);
                    panel.add(areaCorredores);
                    panel.add(areaCorredores1);
                    panel.add(valorFaturacaoMetro2);
                    panel.add(valorFaturacaoMetro21);

                    //ACTION LISTENER DE GUARDAR
                    guardar.addActionListener(new Botao.Guardar(frame, "Mercado", panel, frameCriar));

                    break;
            }
            //ADD TO FRAME
            frameCriar.add(panel);
            frameCriar.setVisible(true);
        }

        void addRestauracao(JPanel panel) {

            //JLABES AND JTEXTFIELDS
            JLabel nEmpregadosMesa = new JLabel("Nº empregados mesa:");
            nEmpregadosMesa.setBounds(20, 170, 100, 25);
            JTextField nEmpregadosMesa1 = new JTextField();
            nEmpregadosMesa1.setBounds(150, 172, 150, 20);

            JLabel custoEmpregadosMesa = new JLabel("Custo empregados mesa:");
            custoEmpregadosMesa.setBounds(20, 200, 100, 25);
            JTextField custoEmpregadosMesa1 = new JTextField();
            custoEmpregadosMesa1.setBounds(150, 202, 150, 20);

            JLabel nMedioClientesDiarios = new JLabel("Nº medio clientes diário:");
            nMedioClientesDiarios.setBounds(20, 230, 100, 25);
            JTextField nMedioClientesDiarios1 = new JTextField();
            nMedioClientesDiarios1.setBounds(150, 232, 150, 20);

            JLabel salarioMedioAnual = new JLabel("Salário Médio Anual:");
            salarioMedioAnual.setBounds(20, 260, 100, 25);
            JTextField salarioMedioAnual1 = new JTextField();
            salarioMedioAnual1.setBounds(150, 262, 150, 20);

            //ADD TO PANEL
            panel.add(nEmpregadosMesa);
            panel.add(nEmpregadosMesa1);
            panel.add(custoEmpregadosMesa);
            panel.add(custoEmpregadosMesa1);
            panel.add(nMedioClientesDiarios);
            panel.add(nMedioClientesDiarios1);
            panel.add(salarioMedioAnual);
            panel.add(salarioMedioAnual1);
        }

        void addRestaurante(JPanel panel) {

            //JLABES AND JTEXTFIELDS
            JLabel nDiasFuncionamentoAno = new JLabel("Nº dias de funcionamento p/ ano:");
            nDiasFuncionamentoAno.setBounds(20, 290, 100, 25);
            JTextField nDiasFuncionamentoAno1 = new JTextField();
            nDiasFuncionamentoAno1.setBounds(150, 292, 150, 20);

            JLabel nMesasInteriores = new JLabel("Nº mesas interiores:");
            nMesasInteriores.setBounds(20, 320, 100, 25);
            JTextField nMesasInteriores1 = new JTextField();
            nMesasInteriores1.setBounds(150, 322, 150, 20);

            JLabel faturacaoMediaMesaDia = new JLabel("Faturação media de mesa p/ dia:");
            faturacaoMediaMesaDia.setBounds(20, 350, 100, 25);
            JTextField faturacaoMediaMesaDia1 = new JTextField();
            faturacaoMediaMesaDia1.setBounds(150, 352, 150, 20);

            //ADD TO PANEL
            panel.add(nDiasFuncionamentoAno);
            panel.add(nDiasFuncionamentoAno1);
            panel.add(nMesasInteriores);
            panel.add(nMesasInteriores1);
            panel.add(faturacaoMediaMesaDia);
            panel.add(faturacaoMediaMesaDia1);
        }

        void addMercearia(JPanel panel) {

            //JLABES AND JTEXTFIELDS
            JLabel custoLimpezaAnual = new JLabel("Custo de limpeza anual:");
            custoLimpezaAnual.setBounds(20, 170, 100, 25);
            JTextField custoLimpezaAnual1 = new JTextField();
            custoLimpezaAnual1.setBounds(150, 172, 150, 20);

            //ADD TO PANEL
            panel.add(custoLimpezaAnual);
            panel.add(custoLimpezaAnual1);
        }
    }

    //GUARDAR-----------------------------------------------------------------------------------------------------------
    protected static class Guardar implements ActionListener {
        GUI frame;
        String tipo;
        Object novoObjeto;
        JPanel panel;
        JFrame frameCriar;

        public Guardar(GUI frame, String tipo, JPanel panel, JFrame frameCriar) {
            this.frame = frame;
            this.tipo = tipo;
            this.panel = panel;
            this.frameCriar = frameCriar;

        }

        public void actionPerformed(ActionEvent e) {
            EnterpriseList StarThrive = frame.getST();
            int i = 0;

            //Inicializar array:
            String[] array = new String[20];

            //Guardar os valores dos TextFields
            for (Component c : panel.getComponents()) {
                if (c instanceof JTextField) {
                    //Proteção contra TextFields vazios
                    if ((((JTextField) c).getText()).equals("")) {
                        JOptionPane.showMessageDialog(null, "Preencha todas as células.", "WARNING", JOptionPane.WARNING_MESSAGE);
                        break;
                    } else {
                        array[i] = ((JTextField) c).getText();
                        System.out.println(((JTextField) c).getText());
                        i++;
                    }
                }
            }

            switch (tipo) {

                case "Cafe":

                    try {
                        Cafe c = new Cafe(array[0], "Restauracao", array[1], new GPS(Double.parseDouble(array[2]), Double.parseDouble(array[3])), Integer.parseInt(array[4]), Double.parseDouble(array[5]), Integer.parseInt(array[6]), Integer.parseInt(array[7]), Integer.parseInt(array[8]), Double.parseDouble(array[9]));
                        StarThrive.Add(c);
                        frame.getEmpresasLista().addElement(array[0]);
                        frameCriar.dispose();
                    } catch (NumberFormatException ex2) {
                        JOptionPane.showMessageDialog(null, "Escreva valores numéricos nas células correspondentes.", "WARNING", JOptionPane.WARNING_MESSAGE);
                    }

                    break;

                case "Pastelaria":

                    try {
                        Pastelaria p = new Pastelaria(array[0], "Restauracao", array[1], new GPS(Double.parseDouble(array[2]), Double.parseDouble(array[3])), Integer.parseInt(array[4]), Double.parseDouble(array[5]), Integer.parseInt(array[6]), Double.parseDouble(array[7]), Integer.parseInt(array[8]), Double.parseDouble(array[9]));
                        StarThrive.Add(p);
                        frame.getEmpresasLista().addElement(array[0]);
                        frameCriar.dispose();
                    } catch (NumberFormatException ex2) {
                        JOptionPane.showMessageDialog(null, "Escreva valores numéricos nas células correspondentes.", "WARNING", JOptionPane.WARNING_MESSAGE);
                    }

                    break;

                case "Local":

                    try {
                        Local l = new Local(array[0], "Restauracao", array[1], new GPS(Double.parseDouble(array[2]),Double.parseDouble(array[3])), Integer.parseInt(array[4]), Double.parseDouble(array[5]), Integer.parseInt(array[6]), Double.parseDouble(array[7]), Integer.parseInt(array[8]), Integer.parseInt(array[9]), Double.parseDouble(array[10]), Integer.parseInt(array[11]), Double.parseDouble(array[12]));
                        StarThrive.Add(l);
                        frame.getEmpresasLista().addElement(array[0]);
                        frameCriar.dispose();
                    } catch (NumberFormatException ex2) {
                        JOptionPane.showMessageDialog(null, "Escreva valores numéricos nas células correspondentes.", "WARNING", JOptionPane.WARNING_MESSAGE);
                    }

                    break;

                case "FastFood":

                    try {
                        FastFood f=new FastFood(array[0],"Restauracao",array[1],new GPS(Double.parseDouble(array[2]),Integer.parseInt(array[3])) , Integer.parseInt(array[4]),Double.parseDouble(array[5]),Integer.parseInt(array[6]) , Double.parseDouble(array[7]), Integer.parseInt(array[8]), Integer.parseInt(array[9]), Double.parseDouble(array[10]),Integer.parseInt(array[11]),Double.parseDouble(array[12]));
                        StarThrive.Add(f);
                        frame.getEmpresasLista().addElement(array[0]);
                        frameCriar.dispose();
                    } catch (NumberFormatException ex2) {
                        JOptionPane.showMessageDialog(null, "Escreva valores numéricos nas células correspondentes.", "WARNING", JOptionPane.WARNING_MESSAGE);
                    }

                    break;

                case "Frutaria":

                    try {
                        Frutaria f = new Frutaria(array[0], "Mercearia", array[1], new GPS(Double.parseDouble(array[2]), Integer.parseInt(array[3])), Double.parseDouble(array[4]), Integer.parseInt(array[5]), Double.parseDouble(array[6]));
                        StarThrive.Add(f);
                        frame.getEmpresasLista().addElement(array[0]);
                        frameCriar.dispose();
                    } catch (NumberFormatException ex2) {
                        JOptionPane.showMessageDialog(null, "Escreva valores numéricos nas células correspondentes.", "WARNING", JOptionPane.WARNING_MESSAGE);
                    }

                    break;

                case "Mercado":

                    try {
                        Mercado m = new Mercado(array[0], "Mercearia", array[1], new GPS(Double.parseDouble(array[2]), Double.parseDouble(array[3])), Double.parseDouble(array[4]), array[5], Double.parseDouble(array[6]), Double.parseDouble(array[7]));
                        StarThrive.Add(m);
                        frame.getEmpresasLista().addElement(array[0]);
                        frameCriar.dispose();
                    } catch (NumberFormatException ex2) {
                        JOptionPane.showMessageDialog(null, "Escreva valores numéricos nas células correspondentes.", "WARNING", JOptionPane.WARNING_MESSAGE);
                    }

                    break;
            }
        }
    }

    //GUARDAR EDICAO----------------------------------------------------------------------------------------------------

    protected static class GuardarEdicao implements ActionListener {
        GUI frame;
        String categoria;
        String nome;
        JPanel panel;
        JFrame frameEditar;

        public GuardarEdicao(GUI frame, String categoria, JPanel panel, JFrame frameEditar, String nome) {
            this.frame = frame;
            this.categoria = categoria;
            this.panel = panel;
            this.frameEditar = frameEditar;
            this.nome= nome;
        }

        public void actionPerformed(ActionEvent e) {
            EnterpriseList StarThrive = frame.getST();

            int i = 0;

            //Inicializar array:
            String[] array = new String[20];

            //Guardar os valores dos TextFields
            for (Component c : panel.getComponents()) {
                if (c instanceof JTextField) {
                    //Proteção contra TextFields vazios
                    if ((((JTextField) c).getText()).equals("")) {
                        JOptionPane.showMessageDialog(null, "Preencha todas as células.", "WARNING", JOptionPane.WARNING_MESSAGE);
                        break;
                    } else {
                        array[i] = ((JTextField) c).getText();
                        System.out.println(((JTextField) c).getText());
                        i++;
                    }
                }
            }

            //ISTO NAO FUNCIONA!!!!!!!!!!!!!!!!
            try {
                StarThrive.Insert(nome, categoria, array);
            } catch (NumberFormatException ex2) {
                JOptionPane.showMessageDialog(null, "Escreva valores numéricos nas células correspondentes.", "WARNING", JOptionPane.WARNING_MESSAGE);
            }

            if(! nome.equals(array[0])){
                frame.getEmpresasLista().removeElement(nome);
                frame.getEmpresasLista().addElement(array[0]);
            }

            frameEditar.dispose();
        }
    }
}