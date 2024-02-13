import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUI extends JFrame {
    private File f;
    private ObjectFile fo;
    private EnterpriseList StarThrive;

    private String[] nomesEmp;

    private JPanel panel;
    private JLabel titulo, empresas, editar, outro;
    private JList<String> lista;
    private DefaultListModel<String> empresasLista;
    private JScrollPane scroller;
    private Botao  buttonInfo, buttonEditar, buttonCriar, buttonEliminar, buttonRA, buttonDA, buttonL, buttonC;

    public GUI() {

        //Ficheiro de Objetos
        f = new File("starthrive.dat");
        fo = new ObjectFile();

        //Ler do ficheiro
        StarThrive = Funcoes.LerFicheiro(f, fo);

        //GUI___________________________________

        //JFRAME
        this.setTitle("StarThrive");
        this.setSize(1050, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //WINDOW LISTENER
        //Guardar no ficheiro ao fechar
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

                //Guardar no ficheiro
                Funcoes.GuardarFicheiro(StarThrive, f, fo);

                System.exit(0);
            }
        });

        //JPANEL
        panel = new JPanel();

        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setBounds(0, 0, 1050, 550);

        //JLABELS
        titulo= new JLabel("StarThrive .º*");
        empresas = new JLabel("| Enterprises");
        editar = new JLabel("| Options");
        outro = new JLabel("| Thriving Enterprises");

        titulo.setFont(new Font("Monospaced", Font.BOLD, 50));
        empresas.setFont(new Font("Monospaced", Font.BOLD, 23));
        editar.setFont(new Font("Monospaced", Font.BOLD, 23));
        outro.setFont(new Font("Monospaced", Font.BOLD, 23));

        titulo.setForeground(Color.decode("#307059"));
        empresas.setForeground(Color.decode("#307059"));
        editar.setForeground(Color.decode("#307059"));
        outro.setForeground(Color.decode("#307059"));

        titulo.setBounds(50, 50, 500, 100);
        empresas.setBounds(50, 200, 200, 50);
        editar.setBounds(390, 200, 200, 50);
        outro.setBounds(660, 200, 350, 50);

        //LISTA EMPRESAS
        empresasLista = new DefaultListModel();

        nomesEmp = StarThrive.NomesEmp();

        for (String nome : nomesEmp) {
            empresasLista.addElement(nome);
        }

        //JLIST
        lista = new JList<>(empresasLista);
        lista.setSelectedIndex(0);

        lista.setFont(new Font("Monospaced", Font.BOLD, 15));
        lista.setSelectionBackground(Color.decode("#56947e"));
        lista.setSelectionForeground(Color.white);
        lista.setBackground(Color.decode("#ddf0e6"));
        UIManager.put("List.focusCellHighlightBorder", Color.white);

        //JSCROLL
        scroller = new JScrollPane(lista);

        scroller.setBackground(Color.white);
        scroller.setBounds(50, 260, 300, 300);
        scroller.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //JBUTTONS
        buttonInfo = new Botao();
        buttonEditar = new Botao();
        buttonCriar = new Botao();
        buttonEliminar = new Botao();
        buttonRA = new Botao();
        buttonDA = new Botao();
        buttonL = new Botao();
        buttonC = new Botao();

        buttonInfo.setText("- Info -");
        buttonEditar.setText("- Edit -");
        buttonCriar.setText("- Create -");
        buttonEliminar.setText("- Delete -");
        buttonRA.setText("< Highest Anual Income >");
        buttonDA.setText("< Lowest Anual Expenses >");
        buttonL.setText("< Highest Profit >");
        buttonC.setText("< Highest Client Capacity >");

        buttonInfo.setBackground(Color.decode("#56947e"));
        buttonEditar.setBackground(Color.decode("#56947e"));
        buttonCriar.setBackground(Color.decode("#56947e"));
        buttonEliminar.setBackground(Color.decode("#56947e"));
        buttonRA.setBackground(Color.decode("#56947e"));
        buttonDA.setBackground(Color.decode("#56947e"));
        buttonL.setBackground(Color.decode("#56947e"));
        buttonC.setBackground(Color.decode("#56947e"));

        buttonInfo.setForeground(Color.white);
        buttonEditar.setForeground(Color.white);
        buttonCriar.setForeground(Color.white);
        buttonEliminar.setForeground(Color.white);
        buttonRA.setForeground(Color.white);
        buttonDA.setForeground(Color.white);
        buttonL.setForeground(Color.white);
        buttonC.setForeground(Color.white);

        buttonInfo.setBorderPainted(false);
        buttonEditar.setBorderPainted(false);
        buttonCriar.setBorderPainted(false);
        buttonEliminar.setBorderPainted(false);
        buttonRA.setBorderPainted(false);
        buttonDA.setBorderPainted(false);
        buttonL.setBorderPainted(false);
        buttonC.setBorderPainted(false);

        buttonInfo.setBounds(400, 271, 190, 40);
        buttonEditar.setBounds(400, 341, 190, 40);
        buttonCriar.setBounds(400, 411, 190, 40);
        buttonEliminar.setBounds(400, 481, 190, 40);
        buttonRA.setBounds(672,271,290,40);
        buttonDA.setBounds(672,341,290,40);
        buttonL.setBounds(672,411,290,40);
        buttonC.setBounds(672,481,290,40);

        //ACTION LISTENERS
        buttonInfo.addActionListener(new Botao.Info(this));
        buttonEditar.addActionListener(new Botao.Editar(this));
        buttonCriar.addActionListener(new Botao.Criar(this));
        buttonEliminar.addActionListener(new Botao.Eliminar(this));
        buttonRA.addActionListener(new Botao.Anual(this, "Highest Anual Income", "RA"));
        buttonDA.addActionListener(new Botao.Anual(this, "Lowest Anual Expenses", "DA"));
        buttonL.addActionListener(new Botao.Anual(this, "Highest Profit", "Lucro"));
        buttonC.addActionListener(new Botao.Clientes(this));

        //ADD TO PANEL
        panel.add(titulo);
        panel.add(empresas);
        panel.add(editar);
        panel.add(outro);

        panel.add(scroller);

        panel.add(buttonInfo);
        panel.add(buttonEditar);
        panel.add(buttonCriar);
        panel.add(buttonEliminar);
        panel.add(buttonRA);
        panel.add(buttonDA);
        panel.add(buttonL);
        panel.add(buttonC);

        //ADD TO FRAME
        this.add(panel);
        this.setVisible(true);
    }

    //GETTERS
    public EnterpriseList getST() { return StarThrive; }

    public JList<String> getLista() { return lista; }

    public DefaultListModel<String> getEmpresasLista() {
        return empresasLista;
    }


}


/**
    public JButton buttonInfo, buttonMaisInfo, buttonEditar, buttonCriar, buttonEliminar, buttonRA, buttonDA, buttonL, buttonC;

    public EnterpriseList getStarThrive() { return StarThrive; }

    void gui(){

        //Ficheiro de Objetos
        f = new File ("starthrive.dat");
        fo = new ObjectFile();

        //Ler do ficheiro
        StarThrive = Funcoes.LerFicheiro(f, fo);

        //GUI___________________________________

        //JFRAME
        createFrame();

        //JCOMPONENTS
        createLabels();
        createList();
        createButtons();

    }

    public void createFrame(){

        //JFRAME
        this.setTitle("StarThrive");
        this.setSize (1050,650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //JPANEL
        panel = new JPanel();

        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setBounds(0, 0, 1050, 650);

        //WINDOW LISTENER
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

                //Guardar no ficheiro
                Funcoes.GuardarFicheiro(StarThrive, f, fo);

                System.exit(0);
            }
        });

        //ADD TO FRAME
        this.add(panel);
        this.setVisible(true);
    }

    public void createLabels(){

        //JLABELS
        empresas = new JLabel("| Enterprises");
        editar = new JLabel("| Options");
        outro = new JLabel("| Thriving Enterprises");

        empresas.setFont(new Font("Monospaced", Font.BOLD, 23));
        editar.setFont(new Font("Monospaced", Font.BOLD, 23));
        outro.setFont(new Font("Monospaced", Font.BOLD, 23));

        empresas.setForeground(Color.decode("#307059"));
        editar.setForeground(Color.decode("#307059"));
        outro.setForeground(Color.decode("#307059"));

        empresas.setBounds(50, 200, 200, 50);
        editar.setBounds(390, 200, 200, 50);
        outro.setBounds(660, 200, 350, 50);

        //ADD TO PANEL
        panel.add(empresas);
        panel.add(editar);
        panel.add(outro);
    }

    public void createList(){

        //LISTA EMPRESAS
        String[] ST= StarThrive.NomesEmp();

        enterprisesNames = new DefaultListModel();

        for(String name : ST){
            enterprisesNames.addElement(name);
        }

        //JLIST
        lista= new JList<>(enterprisesNames);
        lista.setSelectedIndex(0);

        lista.setFont(new Font("Monospaced", Font.BOLD, 15));
        lista.setSelectionBackground(Color.decode("#56947e"));
        lista.setSelectionForeground(Color.white);
        lista.setBackground(Color.decode("#ddf0e6"));
        UIManager.put("List.focusCellHighlightBorder", Color.white);

        //JSCROLL
        scroller = new JScrollPane(lista);

        scroller.setBackground(Color.white);
        scroller.setBounds(50,260,300,300);
        scroller.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));                       //Tira a borda feia

        //ADD TO PANEL
        panel.add(scroller);
    }

    public void createButtons(){

        //JBUTTONS
        buttonInfo = new JButton("Info");
        buttonMaisInfo = new JButton("Detailed Info");
        buttonEditar = new JButton("- Edit -");
        buttonCriar = new JButton("- Create -");
        buttonEliminar = new JButton("- Delete -");
        buttonRA = new JButton("< Highest Anual Income >");
        buttonDA = new JButton("< Lowest Anual Expenses >");
        buttonL = new JButton("< Highest Profit >");
        buttonC = new JButton("< Highest Client Capacity >");

        buttonInfo.setFont(new Font("Monospaced", Font.BOLD, 14));
        buttonMaisInfo.setFont(new Font("Monospaced", Font.BOLD, 14));
        buttonEditar.setFont(new Font("Monospaced", Font.BOLD, 14));
        buttonCriar.setFont(new Font("Monospaced", Font.BOLD, 14));
        buttonEliminar.setFont(new Font("Monospaced", Font.BOLD, 14));
        buttonRA.setFont(new Font("Monospaced", Font.BOLD, 14));
        buttonDA.setFont(new Font("Monospaced", Font.BOLD, 14));
        buttonL.setFont(new Font("Monospaced", Font.BOLD, 14));
        buttonC.setFont(new Font("Monospaced", Font.BOLD, 14));

        buttonInfo.setBackground(Color.decode("#56947e"));
        buttonMaisInfo.setBackground(Color.decode("#56947e"));
        buttonEditar.setBackground(Color.decode("#56947e"));
        buttonCriar.setBackground(Color.decode("#56947e"));
        buttonEliminar.setBackground(Color.decode("#56947e"));
        buttonRA.setBackground(Color.decode("#56947e"));
        buttonDA.setBackground(Color.decode("#56947e"));
        buttonL.setBackground(Color.decode("#56947e"));
        buttonC.setBackground(Color.decode("#56947e"));

        buttonInfo.setForeground(Color.white);
        buttonMaisInfo.setForeground(Color.white);
        buttonEditar.setForeground(Color.white);
        buttonCriar.setForeground(Color.white);
        buttonEliminar.setForeground(Color.white);
        buttonRA.setForeground(Color.white);
        buttonDA.setForeground(Color.white);
        buttonL.setForeground(Color.white);
        buttonC.setForeground(Color.white);

        buttonInfo.setBorderPainted(false);
        buttonMaisInfo.setBorderPainted(false);
        buttonEditar.setBorderPainted(false);
        buttonCriar.setBorderPainted(false);
        buttonEliminar.setBorderPainted(false);
        buttonRA.setBorderPainted(false);
        buttonDA.setBorderPainted(false);
        buttonL.setBorderPainted(false);
        buttonC.setBorderPainted(false);

        buttonInfo.setBounds(400,271,190,35);
        buttonMaisInfo.setBounds(400,331,190,35);
        buttonEditar.setBounds(400,391,190,35);
        buttonCriar.setBounds(400,451,190,35);
        buttonEliminar.setBounds(400,511,190,35);
        buttonRA.setBounds(672,271,290,40);
        buttonDA.setBounds(672,341,290,40);
        buttonL.setBounds(672,411,290,40);
        buttonC.setBounds(672,481,290,40);

        //ACTION LISTENERS
        buttonInfo.addActionListener(this);
        buttonMaisInfo.addActionListener(this);
        buttonEditar.addActionListener(this);
        buttonCriar.addActionListener(this);
        buttonEliminar.addActionListener(this);

        buttonRA.addActionListener(this);
        buttonDA.addActionListener(this);
        buttonL.addActionListener(this);
        buttonC.addActionListener(this);


        //btnSave.addActionListener(new SaveHandler());
        //buttonInfo.addActionListener(this);
        //buttonEditar.addActionListener(this);

        //ADD TO PANEL
        panel.add(buttonInfo);
        panel.add(buttonMaisInfo);
        panel.add(buttonEditar);
        panel.add(buttonCriar);
        panel.add(buttonEliminar);
        panel.add(buttonRA);
        panel.add(buttonDA);
        panel.add(buttonL);
        panel.add(buttonC);

        panel.repaint();
    }

    //PRESSIONAR BOTOES
    public void actionPerformed(ActionEvent e) {

        empresaSelecionada = (String) lista.getSelectedValue();

        //MOSTRAR INFO
        if (e.getSource() == buttonInfo) {

            //NEW JFRAME
            JFrame mostrarInfo = new JFrame("Show Info");
            mostrarInfo.setSize(500, 500);

            //GET INFO
            String[][] infoEmpresa;
            infoEmpresa = StarThrive.Info(empresaSelecionada);
            String[] columnNames = {"Enterprise Info", ""};

            //JTABLE
            JTable j = new JTable(infoEmpresa, columnNames);
            j.setDefaultEditor(Object.class, null);

            //JSCROLL
            JScrollPane sp = new JScrollPane(j);

            //ADD TO FRAME
            mostrarInfo.add(sp);
            mostrarInfo.setVisible(true);
        }
        //MOSTRAR MAIS INFO
        if (e.getSource() == buttonMaisInfo) {
            //
            //NEW JFRAME
            JFrame mostrarMaisInfo = new JFrame("Show Detailed Info");
            mostrarMaisInfo.setSize(500, 500);

            //GET INFO
            String[][] moreInfoEmpresa;
            moreInfoEmpresa = StarThrive.MoreInfo(empresaSelecionada);
            String[] columnNames = {"Enterprise Detailed Info", ""};

            //JTABLE
            JTable j = new JTable(moreInfoEmpresa, columnNames);
            j.setDefaultEditor(Object.class, null);

            //JSCROLL
            JScrollPane sp = new JScrollPane(j);

            //ADD TO FRAME
            mostrarMaisInfo.add(sp);
            mostrarMaisInfo.setVisible(true);
             //
        }
        //EDITAR INFO
        if (e.getSource() == buttonEditar) {

        }
        //CRIAR
        if (e.getSource() == buttonCriar) {

            Empresa lol = new Cafe("OLA", "Restauracao", "Coimbra", new GPS(532.12, 444.672), 4, 100, 18, 1000, 39, 30000);
            StarThrive.Add(lol);

            //CriarEmpresa nova= new CriarEmpresa();
            //nova.criar();

            //Empresa novaEmp= nova.getEmpresa();
            //StarThrive.Add(novaEmp);
        }

        //ELIMINAR
        if (e.getSource() == buttonEliminar) {

            if (JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this enterprise?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                StarThrive.Delete(empresaSelecionada);
            }

            this.enterprisesNames.removeElement(lista.getSelectedValue());

        }
    }

        /**
            //EDITAR INFO
            if (e.getSource() == buttonEditar) {

                empresaSelecionada = (String) lista.getSelectedValue();


                JFrame editarInfo = new JFrame("Editar informação da empresa");
                JPanel p = new JPanel();
                JLabel n = new JLabel("nome");
                p.add(n);
                JTextField nome = new HintTextField("Introduza o nome");
                p.add(nome);
                JLabel d = new JLabel("distrito");
                p.add(d);
                JTextField distrito = new HintTextField("Distrito");
                p.add(distrito);
                JLabel l = new JLabel("localização");
                p.add(l);
                JTextField localizacao = new HintTextField("Planeta?");
                p.add(localizacao);
                for (Empresa empresa : empresas) {
                    if (empresaSelecionada.equals(empresa.getNome())) {
                        empresa.setNome(nome.getText());
                        String[] gps = (localizacao.getText().split(" "));
                        empresa.setLocalizacao(new GPS(Double.parseDouble(gps[0]), Double.parseDouble(gps[1])));
                        empresa.setDistrito(distrito.getText());

                    }
                }

                p.setLayout(new GridLayout(3, 3));
                //p.add(novaInfo);

                editarInfo.add(p);
                editarInfo.setSize(500, 500);

                editarInfo.setVisible(true);
            }
            //CRIAR EMPRESA
            //ELIMINAR EMPRESA


        }

        public class HintTextField extends JTextField {
            public HintTextField(String hint) {
                _hint = hint;
            }

            @Override
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
    }**/