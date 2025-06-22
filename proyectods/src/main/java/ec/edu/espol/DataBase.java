package ec.edu.espol;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<Anfitrion> anfitriones;
    private static DataBase database;

    private DataBase() {
        anfitriones = new ArrayList<Anfitrion>();
    }
    public static DataBase getDataBase() {
        if (database == null) {
            database = new DataBase();
        }
        return database;
    }

    

    public ArrayList<Anfitrion> getAnfitriones() {
        return anfitriones;
    }
}
