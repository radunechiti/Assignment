package View;

import Persistence.Casier;
import Persistence.Spectacol;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class AdminView  extends JFrame{
    private JTable table1;
    private JTable table2;
    private JButton createCasierButton;
    private JButton deleteCasierButton;
    private JButton updateCasierButton;
    private JButton createSpectacolButton;
    private JButton deleteSpectacolButton;
    private JButton updateSpectacolButton;
    private JTextField t1;
    private JTextField t3;
    private JTextField t2;
    private JComboBox comboBox1;
    private JTextField t11;
    private JComboBox comboBox2;
    private JTextField t16;
    private JTextField t13;
    private JTextField t15;
    private JTextField t14;
    private JPanel main;


    public AdminView()
    {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setContentPane(main);
        this.pack();

        DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
        model1.addColumn("ID");
        model1.addColumn("Nume");
        model1.addColumn("Username");
        model1.addColumn("Parola");
        model1.addColumn("Active");

        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
        model2.addColumn("ID");
        model2.addColumn("Titlu");
        model2.addColumn("Gen");
        model2.addColumn("Distributia");
        model2.addColumn("Regia");
        model2.addColumn("Nr bilete");
        model2.addColumn("Data");
    }
    public void showCasier(ArrayList<Casier> list)
    {
        DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
        model1.setRowCount(0);
        Object[] row = new Object[5];
        for(int i=0; i<list.size(); i++)
        {
            row[0]= list.get(i).getIdCasier();
            row[1]= list.get(i).getNume();
            row[2]= list.get(i).getUsername();
            row[3]= list.get(i).getParola();
            row[4]= list.get(i).isActive();
            model1.addRow(row);
        }
        table1.setModel(model1);
        model1.fireTableDataChanged();
    }
    public void showSpectacol(ArrayList<Spectacol> list)
    {
        DefaultTableModel model2 = (DefaultTableModel)table2.getModel();
        model2.setRowCount(0);
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
            model2.addRow(row);
        }
        table2.setModel(model2);
        model2.fireTableDataChanged();
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

    public void showClickTableCasier()
    {
        int i = table1.getSelectedRow();
        TableModel model1 = table1.getModel();
        t1.setText(model1.getValueAt(i, 1).toString());
        t2.setText(model1.getValueAt(i, 2).toString());
        t3.setText(model1.getValueAt(i, 3).toString());
        if ((boolean)model1.getValueAt(i,4))
            comboBox1.setSelectedItem("Active");
        else
            comboBox1.setSelectedItem("Inactive");
    }
    public void showClickTableSpectacol()
    {
        int i = table2.getSelectedRow();
        TableModel model2 = table2.getModel();
        t11.setText(model2.getValueAt(i, 1).toString());
        if (model2.getValueAt(i,2).toString().equals("Opera"))
            comboBox2.setSelectedItem("Opera");
        else if (model2.getValueAt(i,2).toString().equals("Opereta"))
            comboBox2.setSelectedItem("Opereta");
        else
            comboBox2.setSelectedItem("Balet");
        t13.setText(model2.getValueAt(i, 3).toString());
        t14.setText(model2.getValueAt(i, 4).toString());
        t15.setText(model2.getValueAt(i, 5).toString());
        t16.setText(model2.getValueAt(i, 6).toString());

    }
    public void ClickTableCasier(MouseListener e)
    {
        table1.addMouseListener(e);
    }
    public void ClickTableSpectacol(MouseListener e)
    {
        table2.addMouseListener(e);
    }
    public void ButtonInsertCasier(ActionListener e)
    {
        createCasierButton.addActionListener(e);
    }
    public void ButtonUpdateCasier(ActionListener e)
    {
        updateCasierButton.addActionListener(e);
    }
    public void ButtonDeleteCasier(ActionListener e)
    {
        deleteCasierButton.addActionListener(e);
    }
    public void ButtonInsertSpectacol(ActionListener e)
    {
        createSpectacolButton.addActionListener(e);
    }
    public void ButtonUpdateSpectacol(ActionListener e)
    {
        updateSpectacolButton.addActionListener(e);
    }
    public void ButtonDeleteSpectacol(ActionListener e)
    {
        deleteSpectacolButton.addActionListener(e);
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

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.comboBox1 = comboBox1;
    }

    public JTextField getT11() {
        return t11;
    }

    public void setT11(JTextField t11) {
        this.t11 = t11;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }

    public void setComboBox2(JComboBox comboBox2) {
        this.comboBox2 = comboBox2;
    }

    public JTextField getT16() {
        return t16;
    }

    public void setT16(JTextField t16) {
        this.t16 = t16;
    }

    public JTextField getT13() {
        return t13;
    }

    public void setT13(JTextField t13) {
        this.t13 = t13;
    }

    public JTextField getT15() {
        return t15;
    }

    public void setT15(JTextField t15) {
        this.t15 = t15;
    }

    public JTextField getT14() {
        return t14;
    }

    public void setT14(JTextField t14) {
        this.t14 = t14;
    }

}
