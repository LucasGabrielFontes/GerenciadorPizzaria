package view;

import classes.Pedido;
import classes.Pizza;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static view.TelaInicial.pedidos;
import view.TelaCadastraPedido2;
import static view.TelaInicial.pizzas;
import classes.Pedido;

public class TelaVisualizaPedido extends javax.swing.JFrame {

    // Adicione um novo campo para o mapa de pedidos
    private Map<String, Pedido> mapaPedidos;

    public JFrame telaControle;
    
    public TelaVisualizaPedido(JList<String> lista, JFrame telaControle) {
        initComponents(lista, telaControle);
        setLocationRelativeTo(null);
        setResizable(false); 

        // Inicialize o mapa de pedidos
        this.mapaPedidos = new HashMap<>();

        this.telaControle = telaControle;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(JList<String> lista, JFrame telaControle) {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = lista;
        jButton1 = new javax.swing.JButton();
        btnAvancar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        jLabel1.setText("Tá chovendo pizza!");

        jScrollPane1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jScrollPane1.setViewportView(jList1);

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setText("Voltar à tela de controle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAvancar.setText("Avançar estado");
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(236, 236, 236))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAvancar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jButton1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnAvancar)))
                .addGap(72, 72, 72)
                .addComponent(jButton1)
                .addContainerGap(265, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        telaControle.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void criarOuAtualizarArquivoPedidos() {
        try {
            FileWriter fw = new FileWriter(view.TelaCadastraPedido2.filePath, false); // O false indica que iremos sobrescrever o arquivo
            BufferedWriter bw = new BufferedWriter(fw);
    
            // Escrevendo os dados dos pedidos no arquivo
            for (Pedido pedido : pedidos) {
                bw.write("Número do pedido: " + pedido.getNumPedido() + ", Telefone do Cliente: " + pedido.getTelefone() + ", Código da Pizza: " + pedido.getCodigoPizza() + ", Estado do Pedido: " + pedido.getEstado());
                bw.newLine(); // Adiciona uma nova linha para o próximo pedido
            }
    
            bw.close(); // Fecha o BufferedWriter
            fw.close(); // Fecha o FileWriter
            
            //Log para confirmar se arquivo pedidos.txt foi atualizado/criado
            //System.out.println("Arquivo pedidos.txt atualizado com sucesso em: " + view.TelaCadastraPedido2.filePath); 


        } catch (Exception e) {
            System.err.println("Erro ao atualizar o arquivo pedidos.txt: " + e.getMessage());
        }
        
    }

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed
        
        // Obter a String do pedido selecionado
        String strPedidoSelecionado = jList1.getSelectedValue();

        // Verificar se um pedido foi selecionado
        if (strPedidoSelecionado != null) {
            // Obter o Pedido correspondente do mapa
            Pedido pedidoSelecionado = mapaPedidos.get(strPedidoSelecionado);

            try {
                // Avançar o estado do pedido
                pedidoSelecionado.avancarEstado();

                criarOuAtualizarArquivoPedidos();
                
                DefaultListModel<String> modeloLista = new DefaultListModel<>();
                for (Pedido pedido : pedidos) {
                    modeloLista.addElement(pedido.toString());
                }
                
                jList1.setModel(modeloLista);

                // Atualizar a lista
                // Aqui você precisa implementar a lógica para atualizar a lista
                // Por exemplo: atualizarListaPedidos();
            } catch (Exception e) {
                // Mostrar uma mensagem de erro se o pedido já foi entregue
                JOptionPane.showMessageDialog(this, "Pedido já entregue!");
            }
            
        } else {
            // Mostrar uma mensagem de erro se nenhum pedido foi selecionado
            JOptionPane.showMessageDialog(this, "Por favor, selecione um pedido para avançar.");
        }


    }//GEN-LAST:event_btnAvancarActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(TelaVisualizaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVisualizaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVisualizaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVisualizaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVisualizaPedido(null, null).setVisible(true);
            }
        });
    }

    public Map<String, Pedido> getMapaPedidos() {
        return this.mapaPedidos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
