package Persistence.Exports;

import Persistence.Model.Bilet;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.util.ArrayList;

public class ExportJSON implements Export{
    @Override
    public void export(ArrayList<Bilet> list)
    {
        try{
            FileWriter fileWriter = new FileWriter("bilete.json");

            for(Bilet bilet: list) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id_spectacol", bilet.getId_spectacol());
                jsonObject.put("id_bilet",bilet.getIdBilet());
                jsonObject.put("Rand", bilet.getRand());
                jsonObject.put("Numar", bilet.getNumar());
                fileWriter.write(jsonObject.toJSONString());
                fileWriter.flush();
            }
        }catch(Exception e){
                e.printStackTrace();
            }
    }
}
