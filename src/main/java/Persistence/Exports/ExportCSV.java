package Persistence.Exports;

import Persistence.Model.Bilet;

import java.io.FileWriter;
import java.util.ArrayList;

public class ExportCSV implements Export{

    private static final String HEADER = "BiletID,Rand, Numar";
    @Override
    public void export(ArrayList<Bilet> list)
    {
        //export csv
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("Bilete spectacol.csv");
            fileWriter.append(HEADER);
            fileWriter.append("\n");
            for(Bilet bilet: list)
            {
                fileWriter.append(String.valueOf(bilet.getIdBilet()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(bilet.getRand()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(bilet.getNumar()));
                fileWriter.append("\n");
            }
            fileWriter.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
