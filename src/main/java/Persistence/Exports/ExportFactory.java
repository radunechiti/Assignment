package Persistence.Exports;

public class ExportFactory {

    public static Export getExport(String s)
    {
        if(s.equals("JSON"))
            return new ExportJSON();
        else
            return new ExportCSV();
    }
}
