package view;

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

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePizzas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabel1)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btnExcluir)))
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Torna a TelaPizza invisível
        setVisible(false);
        // Torna a TelaCadastraCliente visível
        telaCadastroPizza.setVisible(true);
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {

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
            java.util.logging.Logger.getLogger(TelaPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPizza().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablePizzas;
   
}
