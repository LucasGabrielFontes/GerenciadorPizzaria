package view;

import classes.Cliente;
import classes.PainelComImagem;
import classes.Pedido;
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
import static view.TelaInicial.clientes;
import static view.TelaInicial.pedidos;

public class TelaCadastraPedido2 extends javax.swing.JFrame {

    
    public JFrame telaFuncionario;
    public static String filePath;

    public TelaCadastraPedido2(JFrame telaFuncionario) {
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setResizable(false); // Desabilita o redimensionamento da janela
        this.filePath = "";
        this.telaFuncionario = telaFuncionario;
    }


    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        PainelComImagem painelComImagem = new PainelComImagem("src/images/logoRedimensionada25.png");
        this.setContentPane(painelComImagem);

        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnVoltarInicial1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnCarregarAnteriores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 40)); 
        jLabel2.setText("Cadastro Pedido");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jLabel6.setText("Telefone do cliente:");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jLabel7.setText("Código da pizza: ");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        btnCadastrar.setFont(new java.awt.Font("Verdana", 0, 20)); 
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnVoltarInicial1.setFont(new java.awt.Font("Verdana", 0, 20)); 
        btnVoltarInicial1.setText("Voltar");
        btnVoltarInicial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarInicial1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jButton3.setText("Tela Pedido");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addGap(324, 324, 324))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(btnVoltarInicial1)
                        .addGap(131, 131, 131)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(btnCarregarAnteriores)))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCarregarAnteriores)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(btnCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltarInicial1)
                    .addComponent(jButton3))
                .addGap(116, 116, 116))
        );

        pack();
    }

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private boolean verificaClienteExistente(String telefone) {
        // Verificar se o número de telefone existe na lista de clientes cadastrados
        for (Cliente cliente: clientes) {
            if (cliente.getTelefone().equals(telefone)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean verificaPizzaExistente(String codigoPizza) {
        // Verificar se o código da pizza existe na lista de pizzas cadastradas
        for (Pizza pizza : pizzas) {
            if (pizza.getCodigo().equals(codigoPizza)) {
                return true;
            }
        }
        return false;
    }
    
    private String directoryPath;
    
    // Método para criar ou atualizar o arquivo de clientes
    private void criarOuAtualizarArquivoPedidos(Pedido pedido, String filePath) {
            try {
                FileWriter fw = new FileWriter(filePath, true); // O true no construtor FileWriter indica que iremos adicionar ao final do arquivo
                BufferedWriter bw = new BufferedWriter(fw);

                // Escrevendo os dados do novo pedido no arquivo
                bw.write("Número do pedido: " + pedido.getNumPedido() + ", Telefone do Cliente: " + pedido.getTelefone() + ", Código da Pizza: " + pedido.getCodigoPizza() + ", Estado do Pedido: " + pedido.getEstado());
                bw.newLine(); // Adiciona uma nova linha para o novo pedido

                bw.close(); // Fecha o BufferedWriter
                fw.close(); // Fecha o FileWriter

                System.out.println("Arquivo pedidos.txt atualizado com sucesso em: " + filePath);
            } catch (IOException e) {
                System.err.println("Erro ao atualizar o arquivo pedidos.txt: " + e.getMessage());
            }
     }
    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        
        String codigo = txtCodigo.getText(); // Obtenha o texto do campo txtCodigo
        String telefone = txtTelefone.getText();
        String codigoPizza = txtCodigo.getText();

        // Verificar se o número de telefone e o código da pizza existem
        boolean clienteExiste = verificaClienteExistente(telefone);
        boolean pizzaExiste = verificaPizzaExistente(codigoPizza);

        if (!clienteExiste) {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else if (!pizzaExiste) {
            JOptionPane.showMessageDialog(this, "Código de pizza não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            // Se o cliente e a pizza existirem, o pedido pode ser registrado
            // Código para registrar o pedido...

            try {
                classes.Global.numPedido++;
                Pedido pedido = new Pedido(Integer.toString(classes.Global.numPedido), telefone, codigo);
                TelaInicial.adicionaPedido(pedido);
                
                // Se o diretório ainda não foi selecionado, solicita ao usuário que escolha o diretório para salvar o arquivo
                if (directoryPath == null || directoryPath.isEmpty()) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Salvar arquivo de pedidos");
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
                
                // Caminho completo para o arquivo de pedidos
                filePath = directoryPath + "/pedidos.txt";
                
                // Adiciona a nova pizza ao arquivo
                criarOuAtualizarArquivoPedidos(pedido, filePath);
         
                // Limpar os campos após o cadastro
                txtCodigo.setText("");
                txtTelefone.setText("");

            } catch (IllegalArgumentException e) {
                switch (e.getMessage()) {
                    case "Número do pedido inválido":
                        JOptionPane.showMessageDialog(this, "Número do pedido inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                    case "Telefone inválido":
                        JOptionPane.showMessageDialog(this, "Digite um telefone válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                    case "Código inválido":
                        JOptionPane.showMessageDialog(this, "Digite um código válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        break;
                }
            }
            
            JOptionPane.showMessageDialog(this, "Pedido registrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    private void btnVoltarInicial1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        telaFuncionario.setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        TelaPedido telaPedido = new TelaPedido(this, pedidos);
        this.setVisible(false);
        telaPedido.setVisible(true);
    }

    private void btnCarregarAnterioresActionPerformed(java.awt.event.ActionEvent evt) {
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Carregar arquivo de pedidos");
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

        // Caminho completo para o arquivo de pedidos
        this.filePath = directoryPath + "/pedidos.txt";
        
        try {
            
           BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath)); 
           String linha = bufferedReader.readLine();
           
           // Lê o arquivo linha por linha
           while (linha != null) {
               
               // Separa os dados da linha em um array
               String[] pedidoTxt = linha.split(",");
               
               // Remove os espaços em branco no início de cada dado
               for (int i = 1; i < pedidoTxt.length; i++) {
                   
                   pedidoTxt[i] = pedidoTxt[i].substring(1);
                   
               }
               
               // Separa o número do pedido, o telefone do cliente e o código da pizza. Removendo as partes irrelevantes do arquivo .txt
               for (int i = 0; i < pedidoTxt.length; i++) {
                   
                   pedidoTxt[i] = pedidoTxt[i].split(" ")[3];
                   
               }         
               
               // Cria um novo pedido com os dados lidos do arquivo
               Pedido pedido = new Pedido(pedidoTxt[0], pedidoTxt[1], pedidoTxt[2]);
               
               // Adiciona o pedido à lista de pedidos
               view.TelaInicial.adicionaPedido(pedido);
               
               linha = bufferedReader.readLine();
                
           }
           
        } catch (Exception e) {
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "ERRO",JOptionPane.ERROR_MESSAGE);
            
        }
        
        for (Pedido pedido: pedidos) {
            System.out.println(pedido.toString());
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
            java.util.logging.Logger.getLogger(TelaCadastraPedido2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastraPedido2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastraPedido2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastraPedido2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastraPedido2(null).setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCarregarAnteriores;
    private javax.swing.JButton btnVoltarInicial1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtTelefone;
    
}
