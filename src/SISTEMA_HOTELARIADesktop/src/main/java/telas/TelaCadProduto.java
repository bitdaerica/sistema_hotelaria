
package telas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaCadProduto extends javax.swing.JInternalFrame {

   
    public TelaCadProduto() {
        initComponents();
        pnlRodapecadastro.setVisible(false);
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
        lblDatadevalidade = new javax.swing.JLabel();
        ftfDatafabricacao = new javax.swing.JFormattedTextField();
        lblQtdestoque = new javax.swing.JLabel();
        lblPrecocusto = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoriadoproduto = new javax.swing.JComboBox<>();
        spnQtdemestoque = new javax.swing.JSpinner();
        lblPrecovenda = new javax.swing.JLabel();
        ftfPrecocusto = new javax.swing.JFormattedTextField();
        ftfPrecovenda = new javax.swing.JFormattedTextField();
        ftfDatavalidade = new javax.swing.JFormattedTextField();
        lblDatafabricacao = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        lblFornecedor = new javax.swing.JLabel();
        txtFornecedor = new javax.swing.JTextField();
        lblQtdestoquemaximo = new javax.swing.JLabel();
        txtQtdestoquemaximo = new javax.swing.JTextField();
        lblQtdestoqueminimo = new javax.swing.JLabel();
        txtQtdestoqueminimo = new javax.swing.JTextField();
        lblLocalizacao = new javax.swing.JLabel();
        txtLocalizacao = new javax.swing.JTextField();
        pnlRodapecadastro = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        pnlTabela = new javax.swing.JPanel();
        pnlscrolTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
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
                .addGap(14, 14, 14)
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

        lblDatadevalidade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDatadevalidade.setText("Data de Validade:");

        try {
            ftfDatafabricacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblQtdestoque.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblQtdestoque.setText("*QTD em Estoque:");

        lblPrecocusto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrecocusto.setText("Preço Custo:");

        lblCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCategoria.setText("*Categoria:");

        cmbCategoriadoproduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione:", "Acessórios", "Alimentos", "Bebidas", "Conforto", "Eletrônicos", "Higiene", "Segurança", " ", " " }));
        cmbCategoriadoproduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblPrecovenda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrecovenda.setText("Preço Venda:");

        ftfPrecocusto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        ftfPrecovenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        try {
            ftfDatavalidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblDatafabricacao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDatafabricacao.setText("Data de Fabricação:");

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatus.setText("Status:");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione:", "Ativo", "Inativo" }));

        lblFornecedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFornecedor.setText("Fornecedor:");

        lblQtdestoquemaximo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblQtdestoquemaximo.setText("QTD Estoque Maximo:");

        lblQtdestoqueminimo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblQtdestoqueminimo.setText("QTD Estoque Minimo:");

        lblLocalizacao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblLocalizacao.setText("Localização no Hotel:");

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

        javax.swing.GroupLayout pnlRodapecadastroLayout = new javax.swing.GroupLayout(pnlRodapecadastro);
        pnlRodapecadastro.setLayout(pnlRodapecadastroLayout);
        pnlRodapecadastroLayout.setHorizontalGroup(
            pnlRodapecadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapecadastroLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(26, 26, 26)
                .addComponent(btnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRodapecadastroLayout.setVerticalGroup(
            pnlRodapecadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapecadastroLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(pnlRodapecadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap(15, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCadastrarprodutosLayout = new javax.swing.GroupLayout(pnlCadastrarprodutos);
        pnlCadastrarprodutos.setLayout(pnlCadastrarprodutosLayout);
        pnlCadastrarprodutosLayout.setHorizontalGroup(
            pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                                .addComponent(pnlRodapecadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                                .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQtdestoqueminimo)
                                    .addComponent(txtQtdestoqueminimo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQtdestoquemaximo)
                                    .addComponent(txtQtdestoquemaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblLocalizacao)))))
                    .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                        .addGap(496, 496, 496)
                        .addComponent(lblAvisocampoobrigatorio)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblQtdestoque)
                            .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFornecedor)
                                .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecocusto)
                            .addComponent(ftfPrecocusto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecovenda)
                            .addComponent(ftfPrecovenda, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatafabricacao)
                            .addComponent(ftfDatafabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatadevalidade)
                            .addComponent(ftfDatavalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCadastrarprodutosLayout.createSequentialGroup()
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomedoproduto)
                            .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(spnQtdemestoque, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNomedoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                                .addComponent(txtDescricao)
                                .addGap(19, 19, 19))
                            .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                                .addComponent(lblDescricaodoproduto)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(48, 48, 48)
                .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoriadoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria))
                .addGap(177, 177, 177))
        );
        pnlCadastrarprodutosLayout.setVerticalGroup(
            pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAvisocampoobrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomedoproduto)
                            .addComponent(lblDescricaodoproduto)
                            .addComponent(lblCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomedoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCategoriadoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecocusto)
                            .addComponent(lblPrecovenda)
                            .addComponent(lblDatadevalidade)
                            .addComponent(lblDatafabricacao)
                            .addComponent(lblStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftfPrecocusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftfPrecovenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftfDatafabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftfDatavalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                        .addComponent(lblFornecedor)
                        .addGap(5, 5, 5)
                        .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQtdestoque)
                    .addComponent(lblQtdestoquemaximo)
                    .addComponent(lblQtdestoqueminimo)
                    .addComponent(lblLocalizacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnQtdemestoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdestoquemaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdestoqueminimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlCadastrarprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadastrarprodutosLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(pnlRodapecadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastrarprodutosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        pnlTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produtos Cadastrado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        pnlscrolTabela.setToolTipText("");
        pnlscrolTabela.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "DESCRIÇÃO", "CATEGORIA", "FORNECEDOR", "PREÇO CUSTO", "PREÇO VENDA", "DATA FABRICAÇÃO", "DATA VALIDADE", "STATUS", "QTD ESTOQUE", "QTD ESTOQUE MINIMO", "QTD ESTOQUE MAXIMO", "LOCALIZAÇÃO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlscrolTabela.setViewportView(tabela);

        javax.swing.GroupLayout pnlTabelaLayout = new javax.swing.GroupLayout(pnlTabela);
        pnlTabela.setLayout(pnlTabelaLayout);
        pnlTabelaLayout.setHorizontalGroup(
            pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlscrolTabela))
        );
        pnlTabelaLayout.setVerticalGroup(
            pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlscrolTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlscrolTabela.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBuscarprodutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCadastrarprodutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(pnlBuscarprodutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlCadastrarprodutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        pnlRodapecadastro.setVisible(true);
        btnLimparselecao.setVisible(true);
        btnBuscar.setVisible(false);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparselecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparselecaoActionPerformed
        // TODO add your handling code here:
        pnlRodapecadastro.setVisible(false);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvisocampoobrigatorio;
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
    private javax.swing.JPanel pnlRodapecadastro;
    private javax.swing.JPanel pnlTabela;
    private javax.swing.JScrollPane pnlscrolTabela;
    private javax.swing.JSpinner spnQtdemestoque;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtLocalizacao;
    private javax.swing.JTextField txtNomebuscado;
    private javax.swing.JTextField txtNomedoproduto;
    private javax.swing.JTextField txtQtdestoquemaximo;
    private javax.swing.JTextField txtQtdestoqueminimo;
    // End of variables declaration//GEN-END:variables
}
