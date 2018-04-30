package View;

        import Persistence.Model.Bilet;
        import Persistence.Model.Spectacol;

        import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import javax.swing.table.TableModel;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseListener;
        import java.util.ArrayList;

public class CasierView extends JFrame {
    private JPanel mainPanel;
    private JTable table1;
    private JTable table2;
    private JButton b2;
    private JButton b3;
    private JButton b1;
    private JTextField t1;
    private JTextField t3;
    private JTextField t2;

    public CasierView() {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
        model1.addColumn("ID");
        model1.addColumn("Titlu");
        model1.addColumn("Gen");
        model1.addColumn("Distributia");
        model1.addColumn("Regia");
        model1.addColumn("Nr bilete");
        model1.addColumn("Data");

        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
        model2.addColumn("ID");
        model2.addColumn("Rand");
        model2.addColumn("Numar");
    }

    public void showClickTableBilet()
    {
        int i = table1.getSelectedRow();
        TableModel model1 = table1.getModel();
        t1.setText(model1.getValueAt(i, 1).toString());
    }
    public void showSpectacol(ArrayList<Spectacol> list)
    {
        DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
        model1.setRowCount(0);
        Object[] row = new Object[7];
        for(int i=0; i<list.size(); i++)
        {
            row[0]= list.get(i).getIdSpectacol();
            row[1]= list.get(i).getTitlu();
            row[2]= list.get(i).getGen();
            row[3]= list.get(i).getDistributia();
            row[4]= list.get(i).getRegia();
            row[5]= list.get(i).getNrBilete();
            row[6]= list.get(i).getDataPremiera();
            model1.addRow(row);
        }
        table1.setModel(model1);
        model1.fireTableDataChanged();
    }
    public void showBilete(ArrayList<Bilet> list)
    {
        DefaultTableModel model2 = (DefaultTableModel)table2.getModel();
        model2.setRowCount(0);
        Object[] row = new Object[3];
        for(int i=0; i<list.size(); i++)
        {
            row[0]= list.get(i).getIdBilet();
            row[1]= list.get(i).getRand();
            row[2]= list.get(i).getNumar();
            model2.addRow(row);
        }
        table2.setModel(model2);
        model2.fireTableDataChanged();
    }

    public void ClickTableBilet(MouseListener e)
    {
        table1.addMouseListener(e);
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JTable getTable2() {
        return table2;
    }

    public void setTable2(JTable table2) {
        this.table2 = table2;
    }

    public JTextField getT1() {
        return t1;
    }

    public void setT1(JTextField t1) {
        this.t1 = t1;
    }

    public JTextField getT3() {
        return t3;
    }

    public void setT3(JTextField t3) {
        this.t3 = t3;
    }

    public JTextField getT2() {
        return t2;
    }

    public void setT2(JTextField t2) {
        this.t2 = t2;
    }

    public void ButtonInsertBilet(ActionListener e)
    {
        b1.addActionListener(e);

    }
    public void ButtonExportJSON(ActionListener e)
    {
        b2.addActionListener(e);
    }
    public void ButtonExportCSV(ActionListener e)
    {
        b3.addActionListener(e);
    }
}