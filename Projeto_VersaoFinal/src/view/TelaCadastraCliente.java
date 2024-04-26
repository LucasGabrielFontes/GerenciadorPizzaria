package view;

import classes.Cliente;
import classes.PainelComImagem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static view.TelaInicial.clientes;

public class TelaCadastraCliente extends javax.swing.JFrame {

    public JFrame telaControle;
    public static String filePath;

    public TelaCadastraCliente(JFrame telaControle) {
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setResizable(false); // Desabilita o redimensionamento da janela
        this.telaControle = telaControle;
        this.filePath = "";
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        PainelComImagem painelComImagem = new PainelComImagem("src/images/logoRedimensionada25.png");
        this.setContentPane(painelComImagem);

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtfTelefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfCEP = new javax.swing.JTextField();
        txtfRua = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtfNumero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCarregarAnteriores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jButton3.setText("Tela Cliente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jLabel3.setText("Telefone:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jLabel4.setText("CEP:");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jLabel5.setText("Rua:");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jLabel6.setText("Número");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 40)); 
        jLabel1.setText("Tá chovendo pizza!");

        btnCarregarAnteriores.setFont(new java.awt.Font("Verdana", 0, 12)); 
        btnCarregarAnteriores.setText("Carregar informações anteriores");
        btnCarregarAnteriores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarAnterioresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(38, 38, 38)
                        .addComponent(txtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(181, 181, 181))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(103, 103, 103)
                        .addComponent(jButton3)
                        .addGap(222, 222, 222))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(325, 325, 325))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(btnCarregarAnteriores)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCarregarAnteriores)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(74, 74, 74))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private boolean clienteJaExiste(String telefone) {
        for (Cliente cliente: clientes) {
            if (cliente.getTelefone().equals(telefone)) {
                return true;
            }
        }
        return false;
    }
    
    private String directoryPath;
    
    // Método para criar ou atualizar o arquivo de clientes
    private void criarOuAtualizarArquivoClientes(Cliente cliente, String filePath) {
            try {
                FileWriter fw = new FileWriter(filePath, true); // O true no construtor FileWriter indica que iremos adicionar ao final do arquivo
                BufferedWriter bw = new BufferedWriter(fw);

                // Escrevendo os dados do novo cliente no arquivo
                bw.write("Nome: " + cliente.getNome() + ", Telefone: " + cliente.getTelefone() + ", CEP: " + cliente.getCep() + ", Rua: " + cliente.getRua() + ", Número: " + cliente.getNumero());
                bw.newLine(); // Adiciona uma nova linha para o novo cliente

                bw.close(); // Fecha o BufferedWriter
                fw.close(); // Fecha o FileWriter

                //Log para informar que o arquivo foi atualizado/criado com sucesso
                //System.out.println("Arquivo clientes.txt atualizado com sucesso em: " + filePath);
                
            } catch (IOException e) {
                System.err.println("Erro ao atualizar o arquivo clientes.txt: " + e.getMessage());
            }
     }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        
        String nome = txtfNome.getText();
        String telefone = txtfTelefone.getText();
        String cep = txtfCEP.getText();
        String rua = txtfRua.getText();
        String numero = txtfNumero.getText();
    

        if (!telefone.matches("\\d*")) {
            // Exibe uma mensagem de erro
            JOptionPane.showMessageDialog(null, "Por favor, insira apenas números no telefone.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!cep.matches("\\d*")) {
            JOptionPane.showMessageDialog(null, "Por favor, insira apenas números no CEP.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (clienteJaExiste(telefone)) {
            JOptionPane.showMessageDialog(this, "Este número de telefone já está cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Impede a adição do cliente
        }

        try {
            Cliente cliente = new Cliente(nome, telefone, cep, rua, numero);
            TelaInicial.adicionaCliente(cliente);

            // Se o diretório ainda não foi selecionado, solicita ao usuário que escolha o diretório para salvar o arquivo
            if (directoryPath == null || directoryPath.isEmpty()) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Salvar arquivo de clientes");
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

            // Caminho completo para o arquivo de clientes
            this.filePath = directoryPath + "/clientes.txt";

            // Adiciona o novo cliente ao arquivo
            criarOuAtualizarArquivoClientes(cliente, filePath);

            // Limpa os campos de texto
            txtfCEP.setText("");
            txtfNome.setText("");
            txtfNumero.setText("");
            txtfRua.setText("");
            txtfTelefone.setText("");

            JOptionPane.showMessageDialog(this, "Cadastro concluído!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException e) {
            switch (e.getMessage()) {
                case "nome inválido":
                    JOptionPane.showMessageDialog(this, "Nome inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                case "telefone inválido":
                    JOptionPane.showMessageDialog(this, "Telefone inválido! O telefone deve ter 11 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                case "cep inválido":
                    JOptionPane.showMessageDialog(this, "CEP inválido! O CEP deve ter 8 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                case "nome da rua inválida":
                    JOptionPane.showMessageDialog(this, "Nome da rua inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                case "número de casa inválido":
                    JOptionPane.showMessageDialog(this, "Número de casa inválido! Deve ser um número inteiro positivo.", "Erro", JOptionPane.ERROR_MESSAGE);
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
        TelaCliente telaCliente = new TelaCliente(this, clientes);
        telaCliente.setVisible(true);
        this.setVisible(false);
    }

    private void btnCarregarAnterioresActionPerformed(java.awt.event.ActionEvent evt) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Carregar arquivo de clientes");
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

        this.filePath = directoryPath + "/clientes.txt";
        
        try {
            
           BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath)); 
           String linha = bufferedReader.readLine();
           
           // Percorre o arquivo de clientes e adiciona os clientes na lista de clientes
           while (linha != null) {
               
                // Separa os dados do cliente
               String[] clienteTxt = linha.split(",");
               
               // Remove os espaços em branco no início de cada dado
               for (int i = 1; i < clienteTxt.length; i++) {
                   
                   clienteTxt[i] = clienteTxt[i].substring(1);
                   
               }
               
               // Remove as partes irrelevantes do arquivo .txt
               for (int i = 0; i < clienteTxt.length; i++) {
                   
                   clienteTxt[i] = clienteTxt[i].split(" ")[1];
                   
               }         
               
               // Cria um novo cliente com os dados do arquivo
               Cliente cliente = new Cliente(clienteTxt[0], clienteTxt[1], clienteTxt[2], clienteTxt[3], clienteTxt[4]);
               
               // Adiciona o cliente na lista de clientes
               view.TelaInicial.adicionaCliente(cliente);
               
               linha = bufferedReader.readLine();

               bufferedReader.close();
                
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
            java.util.logging.Logger.getLogger(TelaCadastraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastraCliente(null).setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtfCEP;
    private javax.swing.JTextField txtfNome;
    private javax.swing.JTextField txtfNumero;
    private javax.swing.JTextField txtfRua;
    private javax.swing.JTextField txtfTelefone;
    
}
