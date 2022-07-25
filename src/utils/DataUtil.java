package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

    //Quando utilizamos static podemos chamar os metódos sem a necessidade de instanciar.
    //Metódos estáticos (static) servem apenas para fazer conversões e executar algo eles não armazenam valores.
    public static String converterDateParaDataEHora(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY HH:mm");
        return formatador.format(data);

        // 22/07/2022 16:46 queremos converter para essa forma.

    }

    public static String converterDateParaData(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YY");
        return formatador.format(data);
    }

    public static String converterDateParahora(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("hh:ss:mm");
        return formatador.format(data);

    }


}
