package view;

import classes.Cliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class TelaCliente extends javax.swing.JFrame {
    
    private TelaCadastraCliente telaCadastraCliente;
    private ArrayList<Cliente> clientes;

    private TableModelListener tableModelListener;

    /**
     * Classe interna ValidatingEditor que estende DefaultCellEditor.
     * É responsável por realizar a validação personalizada antes de parar a edição da célula.
     */
    private class ValidatingEditor extends DefaultCellEditor {
        private String columnName;

        /**
         * Construtor da classe ValidatingEditor.
         * 
         * @param textField  O campo de texto usado para editar a célula.
         * @param columnName O nome da coluna sendo editada.
         */
        public ValidatingEditor(JTextField textField, String columnName) {
            super(textField);
            this.columnName = columnName;
        }

        /**
         * Sobrescreve o método stopCellEditing para realizar a validação personalizada antes de parar a edição da célula.
         * 
         * @return true se a edição da célula puder ser interrompida, false caso contrário.
         */
        @Override
        public boolean stopCellEditing() {
            String value = (String) super.getCellEditorValue();

            // Verifica se o nome da coluna é "Nome" e o valor está vazio ou nulo
            if (columnName.equals("Nome") && (value == null || value.trim().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Erro: Nome não pode ser vazio.");
                return false;
            }

            // Verifica se o nome da coluna é "Telefone" e o valor não possui 11 dígitos
            if (columnName.equals("Telefone") && value.length() != 11) {
                JOptionPane.showMessageDialog(null, "Erro: Telefone deve ter 11 dígitos.");
                return false;
            }

            //Verifica se o telefone já existe
            for (Cliente cliente : clientes) {
                if (cliente.getTelefone().equals(value)) {
                    JOptionPane.showMessageDialog(null, "Erro: Telefone já existe.");
                    return false;
                }
            }

            // Verifica se o nome da coluna é "CEP" e o valor não possui 8 dígitos
            if (columnName.equals("CEP") && value.length() != 8) {
                JOptionPane.showMessageDialog(null, "Erro: CEP deve ter 8 dígitos.");
                return false;
            }

            // Verifica se o nome da coluna é "Rua" e o valor está vazio ou nulo
            if (columnName.equals("Rua") && (value == null || value.trim().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Erro: Rua não pode ser vazio.");
                return false;
            }

            // Verifica se o nome da coluna é "Número" e o valor está vazio ou nulo
            if (columnName.equals("Número") && (value == null || value.trim().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Erro: Número não pode ser vazio.");
                return false;
            }

            return super.stopCellEditing();
        }
    }
        
        /**
         * Construtor da classe TelaCliente que recebe a tela de cadastro de cliente e a lista de clientes.
         * Inicializa os componentes da tela, centraliza e desabilita o redimensionamento da janela.
         * Configura os editores de célula da tabela para realizar validação personalizada.
         * Adiciona um TableModelListener para capturar as alterações na tabela.
         * 
         * @param telaCadastraCliente A tela de cadastro de cliente.
         * @param clientes A lista de clientes.
         */
        public TelaCliente(TelaCadastraCliente telaCadastraCliente, ArrayList<Cliente> clientes) {
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setResizable(false); // Desabilita o redimensionamento da janela
        this.telaCadastraCliente = telaCadastraCliente;
        this.clientes = clientes;
        exibirClientes();

        // Configura os editores de célula da tabela para realizar validação personalizada
        jTableClientes.getColumnModel().getColumn(0).setCellEditor(new ValidatingEditor(new JTextField(), "Nome"));
        jTableClientes.getColumnModel().getColumn(1).setCellEditor(new ValidatingEditor(new JTextField(), "Telefone"));
        jTableClientes.getColumnModel().getColumn(2).setCellEditor(new ValidatingEditor(new JTextField(), "CEP"));
        jTableClientes.getColumnModel().getColumn(3).setCellEditor(new ValidatingEditor(new JTextField(), "Rua"));
        jTableClientes.getColumnModel().getColumn(4).setCellEditor(new ValidatingEditor(new JTextField(), "Número"));


        tableModelListener = new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();

            if (row < model.getRowCount()) {
                Object data = model.getValueAt(row, column);
                
                // Atualize o cliente na ArrayList
                Cliente cliente = clientes.get(row);
                switch(column) {
                case 0: cliente.setNome((String)data); break;
                case 1: cliente.setTelefone((String)data); break;
                case 2: cliente.setCep((String)data); break;
                case 3: cliente.setRua((String)data); break;
                case 4: cliente.setNumero((String)data); break;
                }
                
                // Atualize o arquivo clientes.txt
                try {
                criarOuAtualizarArquivoClientes();
                } catch (Exception ex) {
                System.out.println("Erro ao atualizar o arquivo clientes.txt: " + ex.getMessage());
                }
            }
            
            }
        };
        DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
        model.addTableModelListener(tableModelListener);
        }
        

        /**
         * Método responsável por criar ou atualizar o arquivo clientes.txt com os dados dos clientes.
         */
        private void criarOuAtualizarArquivoClientes() {
        try {
            FileWriter fw = new FileWriter(view.TelaCadastraCliente.filePath, false); // O false indica que iremos sobrescrever o arquivo
            BufferedWriter bw = new BufferedWriter(fw);
    
            // Escrevendo os dados dos clientes no arquivo
            for (Cliente cliente : clientes) {
                bw.write("Nome: " + cliente.getNome() + ", Telefone: " + cliente.getTelefone() + ", CEP: " + cliente.getCep() + ", Rua: " + cliente.getRua() + ", Número: " + cliente.getNumero());
                bw.newLine(); // Adiciona uma nova linha para o próximo cliente
            }
    
            bw.close(); // Fecha o BufferedWriter
            fw.close(); // Fecha o FileWriter
            
            //Log para confirmar se arquivo clientes.txt foi atualizado/criado
            //System.out.println("Arquivo clientes.txt atualizado com sucesso em: " + view.TelaCadastraCliente.filePath); 


        } catch (Exception e) {
            System.err.println("Erro ao atualizar o arquivo clientes.txt: " + e.getMessage());
        }
    }
    
    private void exibirClientes() {
        DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
        model.setRowCount(0); // Limpa a tabela antes de preenchê-la novamente
        if (!clientes.isEmpty()) { // Verifica se a lista de clientes não está vazia
            for (Cliente c : clientes) {
                model.addRow(new Object[]{c.getNome(), c.getTelefone(), c.getCep(), c.getRua(), c.getNumero()});
            }
        }
    }
    
    public TelaCliente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("CRUD CLIENTES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 40, -1, -1));

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NOME", "TELEFONE", "CEP", "RUA", "NÚMERO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jTabbedPane1.addTab("CLIENTES", jScrollPane1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 132, 471, 314));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 478, -1, -1));

        btnExcluir.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 51, 51));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lixeira20.jpeg"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 275, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoRedimensionada25.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int selectedRow = jTableClientes.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir este cliente?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
                model.removeTableModelListener(tableModelListener); // Remova o listener antes de atualizar a lista de clientes

                clientes.remove(selectedRow);
                criarOuAtualizarArquivoClientes();
                if (!clientes.isEmpty()) {
                    exibirClientes();
                } else {
                    model.setRowCount(0);
                }

                model.addTableModelListener(tableModelListener); // Adicione o listener novamente depois que a lista foi atualizada

                jTableClientes.revalidate();
                jTableClientes.repaint();
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Nenhum cliente selecionado.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Torna a TelaCliente invisível
        setVisible(false);
        // Torna a TelaCadastraCliente visível
        telaCadastraCliente.setVisible(true);
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
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableClientes;
    // End of variables declaration//GEN-END:variables
}
