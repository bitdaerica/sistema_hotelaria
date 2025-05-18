
package telas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaCadProduto extends javax.swing.JInternalFrame {

   
    public TelaCadProduto() {
        initComponents();
        pnlRodapetabela.setVisible(false);
        btnLimparselecao.setVisible(false);
        btnCadastrar.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        pnlBuscarprodutos = new javax.swing.JPanel();
        lblBuscarpornome = new javax.swing.JLabel();
        txtNomebuscado = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimparselecao = new javax.swing.JButton();
        pnlCadastrarprodutos = new javax.swing.JPanel();
        lblAvisocampoobrigatorio = new javax.swing.JLabel();
        lblNomedoproduto = new javax.swing.JLabel();
        txtNomedoproduto = new javax.swing.JTextField();
        lblDescricaodoproduto = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoriadoproduto = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        pnlTabela = new javax.swing.JPanel();
        pnlscrolTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        pnlRodapetabela = new javax.swing.JPanel();
        lblAvisoeditarouexcluir = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblPrecocusto = new javax.swing.JLabel();
        ftfPrecocusto = new javax.swing.JFormattedTextField();
        lblPrecovenda = new javax.swing.JLabel();
        ftfPrecovenda = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblQtdestoque = new javax.swing.JLabel();
        spnQtdemestoque = new javax.swing.JSpinner();
        lblQtdestoqueminimo = new javax.swing.JLabel();
        txtQtdestoqueminimo = new javax.swing.JTextField();
        lblQtdestoquemaximo = new javax.swing.JLabel();
        txtQtdestoquemaximo = new javax.swing.JTextField();
        lblLocalizacao = new javax.swing.JLabel();
        txtLocalizacao = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        lblFornecedor = new javax.swing.JLabel();
        lblDatafabricacao = new javax.swing.JLabel();
        ftfDatafabricacao = new javax.swing.JFormattedTextField();
        lblDatadevalidade = new javax.swing.JLabel();
        ftfDatavalidade = new javax.swing.JFormattedTextField();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastrar Produtos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setVisible(true);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlBuscarprodutos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        lblBuscarpornome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBuscarpornome.setText("Nome do Produto:");

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon-lupa20x20.png"))); // NOI18N
        btnBuscar.setText("Pesquisar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimparselecao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimparselecao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon-limpar20x20.png"))); // NOI18N
        btnLimparselecao.setText("Limpar Seleção");
        btnLimparselecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparselecaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBuscarprodutosLayout = new javax.swing.GroupLayout(pnlBuscarprodutos);
        pnlBuscarprodutos.setLayout(pnlBuscarprodutosLayout);
        pnlBuscarprodutosLayout.setHorizontalGroup(
            pnlBuscarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarprodutosLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(lblBuscarpornome)
                .addGap(18, 18, 18)
                .addComponent(txtNomebuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimparselecao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBuscarprodutosLayout.setVerticalGroup(
            pnlBuscarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarprodutosLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(pnlBuscarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarpornome)
                    .addComponent(txtNomebuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimparselecao))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnlCadastrarprodutos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        lblAvisocampoobrigatorio.setForeground(new java.awt.Color(153, 0, 0));
        lblAvisocampoobrigatorio.setText("(*) são campos obrigatórios para preenchimento:");

        lblNomedoproduto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNomedoproduto.setText("*Nome do Produto:");

        lblDescricaodoproduto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDescricaodoproduto.setText("Descrição:");

        lblCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCategoria.setText("*Categoria:");

        cmbCategoriadoproduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione:", "Acessórios", "Alimentos", "Bebidas", "Conforto", "Eletrônicos", "Higiene", "Segurança", " ", " " }));
        cmbCategoriadoproduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imagem do Produto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 10))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("*Marca:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Cod. Barra:");

        javax.swing.GroupLayout pnlCadastrarprodutosLayout = new javax.swing.GroupLayout(pnlCadastrarprodutos);
        pnlCadastrarprodutos.setLayout(pnlCadastrarprodutosLayout);
        pnlCadastrarprodutosLayout.setHorizontalGroup(
            pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(lblAvisocampoobrigatorio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastrarprodutosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                        .addComponent(cmbCategoriadoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomedoproduto)
                            .addComponent(txtNomedoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                                .addComponent(lblCategoria)
                                .addGap(107, 107, 107)
                                .addComponent(jLabel2)))
                        .addGap(48, 48, 48)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastrarprodutosLayout.createSequentialGroup()
                                .addComponent(lblDescricaodoproduto)
                                .addGap(211, 211, 211))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastrarprodutosLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(144, 144, 144))
                            .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        pnlCadastrarprodutosLayout.setVerticalGroup(
            pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                .addComponent(lblAvisocampoobrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescricaodoproduto)
                            .addComponent(lblNomedoproduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomedoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCategoriadoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnlTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produtos Cadastrado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        pnlscrolTabela.setToolTipText("");
        pnlscrolTabela.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "DESCRIÇÃO", "CATEGORIA", "FORNECEDOR", "PREÇO CUSTO", "PREÇO VENDA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlscrolTabela.setViewportView(tabela);

        lblAvisoeditarouexcluir.setText("Para editar ou excluir um produto, basta selecionar na tabela e clicar no botão desejado.");

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon-lapis20x20.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon-cancelar20x20.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRodapetabelaLayout = new javax.swing.GroupLayout(pnlRodapetabela);
        pnlRodapetabela.setLayout(pnlRodapetabelaLayout);
        pnlRodapetabelaLayout.setHorizontalGroup(
            pnlRodapetabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapetabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAvisoeditarouexcluir)
                .addGap(42, 42, 42)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRodapetabelaLayout.setVerticalGroup(
            pnlRodapetabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapetabelaLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlRodapetabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvisoeditarouexcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlTabelaLayout = new javax.swing.GroupLayout(pnlTabela);
        pnlTabela.setLayout(pnlTabelaLayout);
        pnlTabelaLayout.setHorizontalGroup(
            pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlscrolTabela)
                    .addComponent(pnlRodapetabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTabelaLayout.setVerticalGroup(
            pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlscrolTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(pnlRodapetabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pnlscrolTabela.getAccessibleContext().setAccessibleName("");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Financeiro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        lblPrecocusto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrecocusto.setText("Preço Custo:");

        ftfPrecocusto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        lblPrecovenda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrecovenda.setText("Preço Venda:");

        ftfPrecovenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Descontos:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Margem de Lucro:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrecocusto)
                    .addComponent(ftfPrecocusto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ftfPrecovenda, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecovenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecocusto)
                    .addComponent(lblPrecovenda)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftfPrecovenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfPrecocusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estoque", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        lblQtdestoque.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblQtdestoque.setText("*QTD em Estoque:");

        lblQtdestoqueminimo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblQtdestoqueminimo.setText("QTD Estoque Minimo:");

        lblQtdestoquemaximo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblQtdestoquemaximo.setText("QTD Estoque Maximo:");

        lblLocalizacao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblLocalizacao.setText("Localização no Estoque:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQtdestoque)
                    .addComponent(spnQtdemestoque, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQtdestoqueminimo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQtdestoqueminimo))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQtdestoquemaximo)
                    .addComponent(txtQtdestoquemaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocalizacao))
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQtdestoque)
                    .addComponent(lblQtdestoqueminimo)
                    .addComponent(lblQtdestoquemaximo)
                    .addComponent(lblLocalizacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnQtdemestoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdestoqueminimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdestoquemaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Adicionais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        lblFornecedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFornecedor.setText("Fornecedor:");

        lblDatafabricacao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDatafabricacao.setText("Data de Fabricação:");

        try {
            ftfDatafabricacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblDatadevalidade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDatadevalidade.setText("Data de Validade:");

        try {
            ftfDatavalidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatus.setText("Status:");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione:", "Ativo", "Inativo" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Garantia:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione:" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Observações:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFornecedor)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftfDatafabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDatafabricacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftfDatavalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDatadevalidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFornecedor)
                    .addComponent(lblDatafabricacao)
                    .addComponent(lblDatadevalidade)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftfDatafabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfDatavalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon-confirmar20x20.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon-cancelar20x20.png"))); // NOI18N
        jButton1.setText("Cancelar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlBuscarprodutos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTabela, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCadastrarprodutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(pnlBuscarprodutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(pnlTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(pnlCadastrarprodutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(282, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(296, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1487, 965);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        pnlRodapetabela.setVisible(true);
        btnLimparselecao.setVisible(true);
        btnBuscar.setVisible(false);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparselecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparselecaoActionPerformed
        // TODO add your handling code here:
        pnlRodapetabela.setVisible(false);
        btnLimparselecao.setVisible(false);
        btnBuscar.setVisible(true);
    }//GEN-LAST:event_btnLimparselecaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(tabela.getSelectedRow() != -1){
            
            DefaultTableModel dtmProdutos =(DefaultTableModel) tabela.getModel();
            dtmProdutos.removeRow(tabela.getSelectedRow());
        
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        JOptionPane.showMessageDialog(null, "Produto cadastrado!");
        
        DefaultTableModel dtmProdutos =(DefaultTableModel) tabela.getModel();
            Object[] dados = {
                txtNomedoproduto.getText(),
                txtDescricao.getText(),
                cmbCategoriadoproduto.getSelectedItem().toString(),
                spnQtdemestoque.getValue().toString(),
                cmbStatus.getSelectedItem().toString(),
                txtLocalizacao.getText()
            };
        dtmProdutos.addRow(dados);
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimparselecao;
    private javax.swing.JComboBox<String> cmbCategoriadoproduto;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JFormattedTextField ftfDatafabricacao;
    private javax.swing.JFormattedTextField ftfDatavalidade;
    private javax.swing.JFormattedTextField ftfPrecocusto;
    private javax.swing.JFormattedTextField ftfPrecovenda;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblAvisocampoobrigatorio;
    private javax.swing.JLabel lblAvisoeditarouexcluir;
    private javax.swing.JLabel lblBuscarpornome;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDatadevalidade;
    private javax.swing.JLabel lblDatafabricacao;
    private javax.swing.JLabel lblDescricaodoproduto;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblLocalizacao;
    private javax.swing.JLabel lblNomedoproduto;
    private javax.swing.JLabel lblPrecocusto;
    private javax.swing.JLabel lblPrecovenda;
    private javax.swing.JLabel lblQtdestoque;
    private javax.swing.JLabel lblQtdestoquemaximo;
    private javax.swing.JLabel lblQtdestoqueminimo;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlBuscarprodutos;
    private javax.swing.JPanel pnlCadastrarprodutos;
    private javax.swing.JPanel pnlRodapetabela;
    private javax.swing.JPanel pnlTabela;
    private javax.swing.JScrollPane pnlscrolTabela;
    private javax.swing.JSpinner spnQtdemestoque;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtLocalizacao;
    private javax.swing.JTextField txtNomebuscado;
    private javax.swing.JTextField txtNomedoproduto;
    private javax.swing.JTextField txtQtdestoquemaximo;
    private javax.swing.JTextField txtQtdestoqueminimo;
    // End of variables declaration//GEN-END:variables
}
