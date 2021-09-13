import com.em.utils.readerAndCalcs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainReader {
    public static void main(String[] args) throws Exception {
        readerAndCalcs  readerAndCalcs = new readerAndCalcs();
        //Inicio de los calculos llamando al método principal
        readerAndCalcs.readFromFolder();
    }
}
