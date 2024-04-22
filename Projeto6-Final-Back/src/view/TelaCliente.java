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

        public ValidatingEditor(JTextField textField, String columnName) {
            super(textField);
            this.columnName = columnName;
        }

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

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        jLabel1.setText("CRUD CLIENTES");

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

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                .addGap(259, 259, 259)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(355, 355, 355))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(btnExcluir)))
                .addGap(47, 47, 47)
                .addComponent(jButton1)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

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

    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableClientes;

}
