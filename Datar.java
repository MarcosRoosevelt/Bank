package banco;

import java.text.DateFormat;
import java.util.Date;

public class Datar {

    protected Date datar = new Date();
    protected DateFormat formataData = DateFormat.getDateInstance(DateFormat.LONG);
    protected DateFormat hora = DateFormat.getTimeInstance();
}