package view;

import classes.Pizza;
import java.io.BufferedWriter;
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Cadastro Pizzas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 64, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel2.setText("Código:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 181, -1, -1));
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 81, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel3.setText("Nome:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 225, -1, -1));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 186, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel4.setText("Descrição:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 274, -1, -1));
        jPanel1.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 272, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel5.setText("Valor:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 319, -1, -1));

        txtValor.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 1.0f));
        jPanel1.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 110, -1));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));

        jButton2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 436, -1, -1));

        jButton3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton3.setText("Tela Pizza");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 436, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoRedimensionada25.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 800, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        telaControle.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        TelaPizza telaPizza = new TelaPizza(this, pizzas);
        telaPizza.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroPizza(null).setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JSpinner txtValor;
    // End of variables declaration//GEN-END:variables
}
