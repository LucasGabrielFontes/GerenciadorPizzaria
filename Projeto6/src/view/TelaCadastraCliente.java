package view;

import classes.Cliente;
import java.io.BufferedWriter;
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 412, -1, -1));

        jButton2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 495, -1, -1));

        jButton3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton3.setText("Tela Cliente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 495, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 182, -1, -1));
        getContentPane().add(txtfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 331, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel3.setText("Telefone:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 226, -1, -1));
        getContentPane().add(txtfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 131, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel4.setText("CEP:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 270, -1, -1));
        getContentPane().add(txtfCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 97, -1));
        getContentPane().add(txtfRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 331, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel5.setText("Rua:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 314, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel6.setText("Número");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 358, -1, -1));
        getContentPane().add(txtfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 140, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Tá chovendo pizza!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Cadastro de clientes");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 106, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoRedimensionada25.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
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
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        telaControle.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        TelaCliente telaCliente = new TelaCliente(this, clientes);
        telaCliente.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtfCEP;
    private javax.swing.JTextField txtfNome;
    private javax.swing.JTextField txtfNumero;
    private javax.swing.JTextField txtfRua;
    private javax.swing.JTextField txtfTelefone;
    // End of variables declaration//GEN-END:variables
}
