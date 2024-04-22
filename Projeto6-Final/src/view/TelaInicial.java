package view;

import javax.swing.JOptionPane;
import classes.Cliente;
import classes.Pedido;
import classes.Pizza;
import java.util.ArrayList;

public class TelaInicial extends javax.swing.JFrame {
    
    String senha = "admin";
    
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    public static ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    
    public static void adicionaCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public static void adicionaPizza(Pizza pizza) {
        pizzas.add(pizza);
    }
    
    public static void adicionaPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    
    public TelaInicial() {
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setResizable(false); // Desabilita o redimensionamento da janela
        
        // Associa o botão "btnLogar" ao evento de pressionar "Enter"
        getRootPane().setDefaultButton(btnLogar);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btnLogar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Tá chovendo pizza!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 225, -1, -1));

        lblSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 295, 217, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Digite a senha para acessar o sistema: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        btnLogar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLogar.setText("Logar");
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 295, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoRedimensionada25.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void exibir () {
        this.setVisible(true);
    }
    
    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed

        if (!String.valueOf(lblSenha.getPassword()).equals(senha)) {
            JOptionPane.showMessageDialog(null, "Senha inválida! Tente novamente.");
        } else {
            this.setVisible(false);
            TelaFuncionario telaFuncionario = new TelaFuncionario();
            telaFuncionario.setVisible(true);
        }
        
    }//GEN-LAST:event_btnLogarActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField lblSenha;
    // End of variables declaration//GEN-END:variables
}
