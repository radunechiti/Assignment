package Persistence.Exports;

import Persistence.Model.Bilet;

import java.util.ArrayList;

public interface Export {

    void export(ArrayList<Bilet> list);
}
