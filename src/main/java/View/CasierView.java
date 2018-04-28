package View;

import Persistence.Spectacol;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class CasierView extends JFrame {
    private JPanel mainPanel;
    private JTable table1;
    private JTable table2;

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
        table2.setModel(model1);
        model1.fireTableDataChanged();
    }
}