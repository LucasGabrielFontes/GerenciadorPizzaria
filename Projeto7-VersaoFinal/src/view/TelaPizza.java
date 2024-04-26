package view;

import classes.PainelComImagem;
import classes.Pizza;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class TelaPizza extends javax.swing.JFrame {
    
    private TelaCadastroPizza telaCadastroPizza;
    private ArrayList<Pizza> pizzas;

    private TableModelListener tableModelListener;

    private class ValidatingEditor extends DefaultCellEditor {
        
        private String columnName;

        public ValidatingEditor(JTextField textField, String columnName) {
            super(textField);
            this.columnName = columnName;
        }

        @Override
        public boolean stopCellEditing() {
            String value = (String) super.getCellEditorValue();

            // Verifica se o nome da coluna é "Código" e o valor está vazio ou nulo
            if (columnName.equals("Código") && (value == null || value.trim().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Erro: Código não pode ser vazio.");
                return false;
            }

            //Verifica se o código já existe
            for (Pizza pizza : pizzas) {
                if (pizza.getCodigo().equals(value)) {
                    JOptionPane.showMessageDialog(null, "Erro: Código/Pizza já existe.");
                    return false;
                }
            }

            // Verifica se o nome da coluna é "Nome" e o valor está vazio ou nulo
            if (columnName.equals("Nome") && (value == null || value.trim().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Erro: Nome não pode ser vazio.");
                return false;
            }

            // Verifica se o nome da coluna é "Descrição" e o valor está vazio ou nulo
            if (columnName.equals("Descrição") && (value == null || value.trim().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Erro: Descrição não pode ser vazio.");
                return false;
            }

            // Verifica se o nome da coluna é "Valor" e o valor está vazio ou nulo
            if (columnName.equals("Valor") && (value == null || value.trim().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Erro: Valor não pode ser vazio.");
                return false;
            }

            if (columnName.equals("Valor") && (value.contains(","))) {
                JOptionPane.showMessageDialog(null, "Erro: Não pode digitar vírgula. Utilize ponto.");
                return false;
            }

            // Verifica se o nome da coluna é "Valor" e o valor é negativo.
            if (columnName.equals("Valor") && Double.parseDouble(value) < 0) {
                JOptionPane.showMessageDialog(null, "Erro: Valor não pode ser negativo.");
                return false;
            }

            return super.stopCellEditing();
        }
    }
    
    public TelaPizza(TelaCadastroPizza telaCadastroPizza, ArrayList<Pizza> pizzas) {
        
        initComponents();
        setResizable(false); // Desabilita o redimensionamento da janela
        this.telaCadastroPizza = telaCadastroPizza;
        this.pizzas = pizzas;

        exibirPizzas();

        // Configura os editores de célula da tabela para realizar validação personalizada
        jTablePizzas.getColumnModel().getColumn(0).setCellEditor(new ValidatingEditor(new JTextField(), "Código"));
        jTablePizzas.getColumnModel().getColumn(1).setCellEditor(new ValidatingEditor(new JTextField(), "Nome"));
        jTablePizzas.getColumnModel().getColumn(2).setCellEditor(new ValidatingEditor(new JTextField(), "Descrição"));
        jTablePizzas.getColumnModel().getColumn(3).setCellEditor(new ValidatingEditor(new JTextField(), "Valor"));

        tableModelListener = new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            DefaultTableModel model = (DefaultTableModel) jTablePizzas.getModel();

            if (row < model.getRowCount()) {
                Object data = model.getValueAt(row, column);
                
                // Atualize a pizza na ArrayList
                Pizza pizza = pizzas.get(row);
                switch(column) {
                case 0: pizza.setCodigo((String)data); break;
                case 1: pizza.setNome((String)data); break;
                case 2: pizza.setDescricao((String)data); break;
                case 3: pizza.setValor((String)data); break;
                }
                
                // Atualize o arquivo pizzas.txt
                try {
                criarOuAtualizarArquivoPizzas();
                } catch (Exception ex) {
                System.out.println("Erro ao atualizar o arquivo pizzas.txt: " + ex.getMessage());
                }
            }
            
            }
        };
        DefaultTableModel model = (DefaultTableModel) jTablePizzas.getModel();
        model.addTableModelListener(tableModelListener);
    }
        

    /**
     * Método responsável por criar ou atualizar o arquivo pizzas.txt com os dados das Pizzas.
     */
    private void criarOuAtualizarArquivoPizzas() {
        try {
            FileWriter fw = new FileWriter(view.TelaCadastroPizza.filePath, false); // O false indica que iremos sobrescrever o arquivo
            BufferedWriter bw = new BufferedWriter(fw);

            // Escrevendo os dados das pizzas no arquivo
            for (Pizza pizza : pizzas) {
                bw.write("Código: " + pizza.getCodigo() + ", Nome: " + pizza.getNome() + ", Descricao: " + pizza.getDescricao() + ", Valor: R$" + pizza.getValor());
                bw.newLine(); // Adiciona uma nova linha para a próxima pizza
            }

            bw.close(); // Fecha o BufferedWriter
            fw.close(); // Fecha o FileWriter

            //Log para confirmar se arquivo pizzas.txt foi atualizado/criado
            //System.out.println("Arquivo pizzas.txt atualizado com sucesso em: " + view.TelaCadastroPizza.filePath); 


        } catch (Exception e) {
            System.err.println("Erro ao atualizar o arquivo pizzas.txt: " + e.getMessage());
        }
    }

    private void exibirPizzas() {
        DefaultTableModel model = (DefaultTableModel) jTablePizzas.getModel();
        model.setRowCount(0); // Limpa a tabela antes de preenchê-la novamente
        if (!pizzas.isEmpty()) { // Verifica se a lista de pizzas não está vazia
            for (Pizza p : pizzas) {
                model.addRow(new Object[]{p.getCodigo(), p.getNome(), p.getDescricao(), p.getValor()});
            }
        }
    }

    private TelaPizza() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelComImagem painelComImagem = new PainelComImagem("C:/Users/lucas/OneDrive/Documentos/MeuProjetos/ProjetoPOO/Projeto_-_FINAL/Projeto - FINAL/src/images/logoRedimensionada25.png");
        this.setContentPane(painelComImagem);

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePizzas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 40));
        jLabel1.setText("CRUD PIZZAS");

        jTablePizzas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME", "DESCRIÇÃO", "VALOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTablePizzas);
        if (jTablePizzas.getColumnModel().getColumnCount() > 0) {
            jTablePizzas.getColumnModel().getColumn(0).setResizable(false);
            jTablePizzas.getColumnModel().getColumn(1).setResizable(false);
            jTablePizzas.getColumnModel().getColumn(2).setResizable(false);
            jTablePizzas.getColumnModel().getColumn(3).setResizable(false);
        }

        jTabbedPane1.addTab("PIZZAS", jScrollPane1);

        jButton1.setFont(new java.awt.Font("Verdana", 0, 20));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Verdana", 0, 12)); 
        btnExcluir.setForeground(new java.awt.Color(255, 51, 51));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnExcluir)
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(242, 242, 242))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(348, 348, 348))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(btnExcluir)
                        .addGap(171, 171, 171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addComponent(jButton1)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Torna a TelaPizza invisível
        setVisible(false);
        // Torna a TelaCadastraCliente visível
        telaCadastroPizza.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTablePizzas.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir esta pizza?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) jTablePizzas.getModel();
                model.removeTableModelListener(tableModelListener); // Remova o listener antes de atualizar a lista de clientes

                pizzas.remove(selectedRow);
                criarOuAtualizarArquivoPizzas();
                if (!pizzas.isEmpty()) {
                    exibirPizzas();
                } else {
                    model.setRowCount(0);
                }

                model.addTableModelListener(tableModelListener); // Adicione o listener novamente depois que a lista foi atualizada

                jTablePizzas.revalidate();
                jTablePizzas.repaint();
                JOptionPane.showMessageDialog(null, "Pizza excluída com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Nenhuma pizza selecionada.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPizza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablePizzas;
    // End of variables declaration//GEN-END:variables
}
