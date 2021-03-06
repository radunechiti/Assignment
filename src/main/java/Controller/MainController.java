package Controller;

import Persistence.DAO.AdminDAO;
import Persistence.DAO.BiletDAO;
import Persistence.DAO.CasierDAO;
import Persistence.DAO.SpectacolDAO;
import Persistence.Exports.ExportFactory;
import Persistence.Model.Admin;
import Persistence.Model.Bilet;
import Persistence.Model.Casier;
import Persistence.Model.Spectacol;
import View.AdminView;
import View.CasierView;
import View.LoginView;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainController {

    private LoginView loginView;
    private AdminView adminView;
    private CasierView casierView;

    public MainController(LoginView loginView, AdminView adminView, CasierView casierView)
    {
        this.loginView=loginView;
        this.loginView.setVisible(true);

        this.adminView=adminView;
        this.casierView=casierView;

        this.loginView.ButtonSignInAdmin(new SignInAdmin_Listener());
        this.loginView.ButtonSignInCasier(new SignInCasier_Listener());

        this.adminView.ClickTableCasier(new ClickTableCasier_Listener());
        this.adminView.ClickTableSpectacol(new ClickTableSpectacol_Listener());
        this.casierView.ClickTableBilet(new ClickTableBilet_Listener());

        this.adminView.ButtonInsertCasier(new ButtonInsertCasier_Listener());
        this.adminView.ButtonUpdateCasier(new ButtonUpdateCasier_Listener());
        this.adminView.ButtonDeleteCasier(new ButtonDeleteCasier_Listener());

        this.adminView.ButtonInsertSpectacol(new ButtonInsertSpectacol_Listener());
        this.adminView.ButtonUpdateSpectacol(new ButtonUpdateSpectacol_Listener());
        this.adminView.ButtonDeleteSpectacol(new ButtonDeleteSpectacol_Listener());

        this.casierView.ButtonInsertBilet(new ButtonInsertBilet_Listener());
        this.casierView.ButtonExportJSON(new ButtonExportJSON_Listener());
        this.casierView.ButtonExportCSV(new ButtonExportCSV_Listener());
    }
    public class ButtonExportJSON_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int i = casierView.getTable1().getSelectedRow();
            TableModel model = casierView.getTable1().getModel();
            int id_spectacol = (Integer)model.getValueAt(i,0);
            BiletDAO biletDAO = new BiletDAO();
            ArrayList<Bilet> list = biletDAO.findBySpectacol(id_spectacol);
            biletDAO.export(ExportFactory.getExport("JSON"),list);
            JOptionPane.showMessageDialog(null,"JSON Succes!");
        }
    }
    public class ButtonExportCSV_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int i = casierView.getTable1().getSelectedRow();
            TableModel model = casierView.getTable1().getModel();
            int id_spectacol = (Integer)model.getValueAt(i,0);
            BiletDAO biletDAO = new BiletDAO();
            ArrayList<Bilet> list = biletDAO.findBySpectacol(id_spectacol);
            biletDAO.export(ExportFactory.getExport("CSV"),list);
            JOptionPane.showMessageDialog(null,"CSV Succes!");
        }
    }
    public class ButtonInsertBilet_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try {
                int i = casierView.getTable1().getSelectedRow();
                TableModel model = casierView.getTable1().getModel();
                int id_spectacol = (Integer)model.getValueAt(i,0);

                Integer rand = Integer.parseInt(casierView.getT2().getText());
                Integer numar = Integer.parseInt(casierView.getT3().getText());

                Bilet bilet = new Bilet(rand,numar, id_spectacol);
                BiletDAO biletDAO = new BiletDAO();
                ArrayList<Bilet> list = biletDAO.findBySpectacol(id_spectacol);
                for(Bilet b: list)
                    if(b.getNumar()==bilet.getNumar() && b.getRand()==bilet.getRand() && b.getId_spectacol()==bilet.getId_spectacol())
                        throw new Exception("Introduceti date valide");
                biletDAO.insert(bilet);
                casierView.showBilete(biletDAO.findBySpectacol(id_spectacol));
                JOptionPane.showMessageDialog(null, "Felicitari! Ati adaugat un bilet nou.");

            }catch(Exception exp){
                JOptionPane.showMessageDialog(null, "Introduceti date valide!");
            }
        }
    }
    public class ButtonInsertSpectacol_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try {
                String titlu = adminView.getT11().getText();
                String gen;
                if(adminView.getComboBox2().getSelectedItem().equals("Opera"))
                    gen = "Opera";
                else if(adminView.getComboBox2().getSelectedItem().equals("Opereta"))
                    gen = "Opereta";
                else
                    gen = "Balet";
                String distributia = adminView.getT13().getText();
                String regia = adminView.getT14().getText();
                Integer nr_bilete = Integer.parseInt(adminView.getT15().getText());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFormat.parse(adminView.getT16().getText());
                Timestamp dataPremiera  = new Timestamp(date.getTime());
                Spectacol spectacol = new Spectacol(titlu,gen, regia, distributia, dataPremiera, nr_bilete);
                SpectacolDAO spectacolDAO = new SpectacolDAO();
                spectacolDAO.insert(spectacol);
                adminView.showSpectacol(spectacolDAO.findAll());
                casierView.showSpectacol(spectacolDAO.findAll());
                JOptionPane.showMessageDialog(null, "Felicitari! Ati creat un spectacol nou.");

            }catch(Exception exp){
                JOptionPane.showMessageDialog(null, exp.getMessage());
            }
        }
    }
    public class ButtonUpdateSpectacol_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try {
                int i = adminView.getTable2().getSelectedRow();
                TableModel model = adminView.getTable2().getModel();
                int id = (Integer)model.getValueAt(i,0);
                String titlu = adminView.getT11().getText();
                String gen;
                if(adminView.getComboBox2().getSelectedItem().equals("Opera"))
                    gen = "Opera";
                else if(adminView.getComboBox2().getSelectedItem().equals("Opereta"))
                    gen = "Opereta";
                else
                    gen = "Balet";
                String distributia = adminView.getT13().getText();
                String regia = adminView.getT14().getText();
                Integer nr_bilete = Integer.parseInt(adminView.getT15().getText());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFormat.parse(adminView.getT16().getText());
                Timestamp dataPremiera  = new Timestamp(date.getTime());
                Spectacol spectacol = new Spectacol(id, titlu,gen, regia, distributia, dataPremiera, nr_bilete);
                SpectacolDAO spectacolDAO = new SpectacolDAO();
                spectacolDAO.update(spectacol);
                adminView.showSpectacol(spectacolDAO.findAll());
                casierView.showSpectacol(spectacolDAO.findAll());
                JOptionPane.showMessageDialog(null, "Felicitari! Ati facut update la un spectacol.");

            }catch(Exception exp){
                JOptionPane.showMessageDialog(null, exp.getMessage());
            }
        }
    }
    public class ButtonDeleteSpectacol_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try {
                int i = adminView.getTable2().getSelectedRow();
                TableModel model = adminView.getTable2().getModel();
                int id = (Integer)model.getValueAt(i,0);
                SpectacolDAO spectacolDAO = new SpectacolDAO();
                spectacolDAO.delete(id);
                adminView.showSpectacol(spectacolDAO.findAll());
                casierView.showSpectacol(spectacolDAO.findAll());
                JOptionPane.showMessageDialog(null, "Felicitari! Ati sters un spectacol.");

            }catch(Exception exp){
                JOptionPane.showMessageDialog(null, exp.getMessage());
            }
        }
    }
    public class ButtonInsertCasier_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try {
                String nume = adminView.getT1().getText();
                String username = adminView.getT2().getText();
                String parola = adminView.getT3().getText();
                Criptare criptare = new Criptare();
                Casier casier = new Casier(username,criptare.securePassword(parola),nume, true);
                CasierDAO casierDAO = new CasierDAO();
                casierDAO.insert(casier);
                adminView.showCasier(casierDAO.findAll());
                JOptionPane.showMessageDialog(null, "Felicitari! Ati creat un casier nou.");
                //adminView.setT1(" ");

            }catch(Exception exp){
                JOptionPane.showMessageDialog(null, exp.getMessage());
            }
        }
    }
    public class ButtonUpdateCasier_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try {
                int i = adminView.getTable1().getSelectedRow();
                TableModel model = adminView.getTable1().getModel();
                int id = (Integer)model.getValueAt(i,0);
                String nume = adminView.getT1().getText();
                String username = adminView.getT2().getText();
                String parola = adminView.getT3().getText();
                Criptare criptare = new Criptare();
                Casier casier = new Casier(id, username,criptare.securePassword(parola),nume, true);
                CasierDAO casierDAO = new CasierDAO();
                casierDAO.update(casier);
                adminView.showCasier(casierDAO.findAll());
                JOptionPane.showMessageDialog(null, "Felicitari! Ati facut update la date.");

            }catch(Exception exp){
                JOptionPane.showMessageDialog(null, exp.getMessage());
            }
        }
    }
    public class ButtonDeleteCasier_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try {
                int i = adminView.getTable1().getSelectedRow();
                TableModel model = adminView.getTable1().getModel();
                int id = (Integer)model.getValueAt(i,0);
                CasierDAO casierDAO = new CasierDAO();
                Casier casier = casierDAO.findById(id);
                casier.setActive(false);
                casierDAO.update(casier);
                adminView.showCasier(casierDAO.findAll());
                JOptionPane.showMessageDialog(null, "Felicitari! Ati sters un casier nou.");
            }catch(Exception exp){
                JOptionPane.showMessageDialog(null, exp.getMessage());
            }
        }
    }
    public class ClickTableSpectacol_Listener implements MouseListener
    {
        public void mouseClicked(java.awt.event.MouseEvent e)
        {
            adminView.showClickTableSpectacol();
        }
        public void mouseEntered(java.awt.event.MouseEvent e) {}
        public void mouseExited(java.awt.event.MouseEvent e) {}
        public void mousePressed(java.awt.event.MouseEvent e) {}
        public void mouseReleased(java.awt.event.MouseEvent e) {}
    }

    public class ClickTableCasier_Listener implements MouseListener
    {
        public void mouseClicked(java.awt.event.MouseEvent e)
        {
            adminView.showClickTableCasier();
        }
        public void mouseEntered(java.awt.event.MouseEvent e) {}
        public void mouseExited(java.awt.event.MouseEvent e) {}
        public void mousePressed(java.awt.event.MouseEvent e) {}
        public void mouseReleased(java.awt.event.MouseEvent e) {}
    }
    public class ClickTableBilet_Listener implements MouseListener
    {
        public void mouseClicked(java.awt.event.MouseEvent e)
        {
            casierView.showClickTableBilet();

            int i = casierView.getTable1().getSelectedRow();
            TableModel model = casierView.getTable1().getModel();
            int id_spectacol = (Integer)model.getValueAt(i,0);
            BiletDAO biletDAO = new BiletDAO();
            casierView.showBilete(biletDAO.findBySpectacol(id_spectacol));
        }
        public void mouseEntered(java.awt.event.MouseEvent e) {}
        public void mouseExited(java.awt.event.MouseEvent e) {}
        public void mousePressed(java.awt.event.MouseEvent e) {}
        public void mouseReleased(java.awt.event.MouseEvent e) {}
    }
    public class SignInCasier_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String username = loginView.getTextField1().getText();
            String parola = loginView.getPasswordField1().getText();
            Criptare criptare = new Criptare();
                parola=criptare.securePassword(parola);
                Casier casier = new Casier(username, parola);
            CasierDAO casierDAO = new CasierDAO();
            boolean logare = casierDAO.findCasier(casier);
            if(logare) {
                casierView.setVisible(true);
                SpectacolDAO spectacolDAO = new SpectacolDAO();
                casierView.showSpectacol(spectacolDAO.findAll());
                BiletDAO biletDAO = new BiletDAO();
                casierView.showBilete(biletDAO.findBySpectacol(1));
            }
            else
                JOptionPane.showMessageDialog(null, "Casier invalid");

        }
    }
    public class SignInAdmin_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String username = loginView.getTextField1().getText();
            String parola = loginView.getPasswordField1().getText();
            Criptare criptare = new Criptare();
                parola=criptare.securePassword(parola);
            Admin admin = new Admin(username, parola);
            AdminDAO adminDAO = new AdminDAO();
            boolean logare = adminDAO.findAdmin(admin);
            if(logare) {
                adminView.setVisible(true);
                CasierDAO casierDAO = new CasierDAO();
                adminView.showCasier(casierDAO.findAll());
                SpectacolDAO spectacolDAO = new SpectacolDAO();
                adminView.showSpectacol(spectacolDAO.findAll());
            }
            else
                JOptionPane.showMessageDialog(null, "Admin invalid");
        }
    }
}
