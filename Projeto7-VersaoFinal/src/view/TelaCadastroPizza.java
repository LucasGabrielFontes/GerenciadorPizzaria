package view;

import classes.PainelComImagem;
import classes.Pizza;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static view.TelaInicial.pizzas;

public class TelaCadastroPizza extends javax.swing.JFrame {

    public JFrame telaControle;
    public static String filePath;
    
    public TelaCadastroPizza(JFrame telaControle) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false); 
        this.telaControle = telaControle;
        this.filePath = "";
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        PainelComImagem painelComImagem = new PainelComImagem("src/images/logoRedimensionada25.png");
        this.setContentPane(painelComImagem);

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValor = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnCarregarAnteriores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 40)); 
        jLabel1.setText("Cadastro Pizzas");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jLabel2.setText("Código:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jLabel3.setText("Nome:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 20));
        jLabel4.setText("Descrição:");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jLabel5.setText("Valor:");

        txtValor.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 1.0f));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jButton3.setText("Tela Pizza");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnCarregarAnteriores.setFont(new java.awt.Font("Verdana", 0, 12)); 
        btnCarregarAnteriores.setText("Carregar informações anteriores");
        btnCarregarAnteriores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarAnterioresActionPerformed(evt);
            }
        });

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jButton2)))
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCodigo)
                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jButton3))))
                    .addComponent(jLabel1))
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(339, 339, 339))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCarregarAnteriores)
                        .addGap(273, 273, 273))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCarregarAnteriores)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(111, 111, 111))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private boolean codigoJaExiste (String codigo) {
        
        for (Pizza pizza: pizzas) {
            
            if (pizza.getCodigo().equals(codigo)) {
                return true;
            }
            
        }
        
        return false;
        
    }
    
    private boolean nomeJaExiste (String nome) {
        
        for (Pizza pizza: pizzas) {
            
            if (pizza.getNome().toLowerCase().equals(nome.toLowerCase())) {
                return true;
            }
            
        }
        
        return false;
        
    }
    
    private boolean descricaoJaExiste (String descricao) {
        
        for (Pizza pizza: pizzas) {
            
            if (pizza.getDescricao().toLowerCase().equals(descricao.toLowerCase())) {
                return true;
            }
            
        }
        
        return false;
        
    }
    
    private String directoryPath;
    
    // Método para criar ou atualizar o arquivo de clientes
    private void criarOuAtualizarArquivoPizzas(Pizza pizza, String filePath) {
            try {
                FileWriter fw = new FileWriter(filePath, true); // O true no construtor FileWriter indica que iremos adicionar ao final do arquivo
                BufferedWriter bw = new BufferedWriter(fw);

                // Escrevendo os dados da nova pizza no arquivo
                bw.write("Código: " + pizza.getCodigo() + ", Nome: " + pizza.getNome() + ", Descricao: " + pizza.getDescricao() + ", Valor: R$" + pizza.getValor());
                bw.newLine(); // Adiciona uma nova linha para a nova pizza

                bw.close(); // Fecha o BufferedWriter
                fw.close(); // Fecha o FileWriter

                System.out.println("Arquivo pizzas.txt atualizado com sucesso em: " + filePath);
            } catch (IOException e) {
                System.err.println("Erro ao atualizar o arquivo pizzas.txt: " + e.getMessage());
            }
     }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String codigo = txtCodigo.getText();
        String descricao = txtDescricao.getText();
        String nome = txtNome.getText();
        String valor = txtValor.getValue().toString();
        
        if (codigoJaExiste(codigo)) {
            JOptionPane.showMessageDialog(this, "Já existe uma pizza com esse código", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Impede a adição do cliente
        }
        
        if (nomeJaExiste(nome)) {
            JOptionPane.showMessageDialog(this, "Já existe uma pizza com esse nome", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (descricaoJaExiste(descricao)) {
            JOptionPane.showMessageDialog(this, "Já existe uma pizza com essa descrição", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            
            Pizza pizza = new Pizza(codigo, nome, descricao, valor);
            TelaInicial.adicionaPizza(pizza);
            
            // Se o diretório ainda não foi selecionado, solicita ao usuário que escolha o diretório para salvar o arquivo
            if (directoryPath == null || directoryPath.isEmpty()) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Salvar arquivo de pizzas");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                // Exibe o seletor de diretório
                int userSelection = fileChooser.showSaveDialog(this);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    // Obtém o diretório selecionado pelo usuário
                    directoryPath = fileChooser.getSelectedFile().getAbsolutePath();
                } else {
                    // Se o usuário cancelar a seleção do diretório, retorna sem fazer nada
                    return;
                }
            }
            
            // Caminho completo para o arquivo de pizzas
            this.filePath = directoryPath + "/pizzas.txt";
            
            // Adiciona a nova pizza ao arquivo
            criarOuAtualizarArquivoPizzas(pizza, filePath);
            
            // Limpa os campos de texto
            txtCodigo.setText("");
            txtDescricao.setText("");
            txtNome.setText("");
            txtValor.setValue(0.0);
            
            // Exibir mensagem de "cadastro concluído"
            JOptionPane.showMessageDialog(this, "Cadastro concluído!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException e) {
            switch (e.getMessage()) {
                case "código inválido":
                    JOptionPane.showMessageDialog(this, "Digite algum código!", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                case "nome inválido":
                    JOptionPane.showMessageDialog(this, "Digite algum nome!", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                case "descrição inválida":
                    JOptionPane.showMessageDialog(this, "Adicione alguma descricao!", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                case "valor inválido":
                    JOptionPane.showMessageDialog(this, "Digite um valor maior que zero, burro!", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                default:
                    break;
            }
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        telaControle.setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        TelaPizza telaPizza = new TelaPizza(this, pizzas);
        telaPizza.setVisible(true);
        this.setVisible(false);
    }

    private void btnCarregarAnterioresActionPerformed(java.awt.event.ActionEvent evt) {
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Carregar arquivo de pizzas");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // Exibe o seletor de diretório
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Obtém o diretório selecionado pelo usuário
            directoryPath = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            // Se o usuário cancelar a seleção do diretório, retorna sem fazer nada
            return;
        }

        // Caminho completo para o arquivo de pizzas
        this.filePath = directoryPath + "/pizzas.txt";
        
        try {
            
           BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath)); 
           String linha = bufferedReader.readLine();
           
           // Percorre o arquivo de pizzas e adiciona as pizzas na lista de pizzas
           while (linha != null) {
               
               // Separa os dados da pizza
               String[] pizzaTxt = linha.split(",");
               
               // Remove os espaços em branco no início de cada dado
               for (int i = 1; i < pizzaTxt.length; i++) {
                   
                   pizzaTxt[i] = pizzaTxt[i].substring(1);
                   
               }
               
               // Retira as partes irrelevantes do arquivo .txt
               for (int i = 0; i < pizzaTxt.length; i++) {
                   
                   pizzaTxt[i] = pizzaTxt[i].split(" ")[1];
                   
               }         
               
               // Retira parte irrelevante, que daria problema, do valor
               pizzaTxt[3] = pizzaTxt[3].substring(2);
               
               // Adiciona a pizza na lista de pizzas
               Pizza pizza = new Pizza(pizzaTxt[0], pizzaTxt[1], pizzaTxt[2], pizzaTxt[3]);
               
               // Adiciona a pizza na tela inicial
               view.TelaInicial.adicionaPizza(pizza);
               
               linha = bufferedReader.readLine();
                
           }
           
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "ERRO",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroPizza(null).setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnCarregarAnteriores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JSpinner txtValor;
}
