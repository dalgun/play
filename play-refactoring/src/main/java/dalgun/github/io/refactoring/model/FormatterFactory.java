package dalgun.github.io.refactoring.model;

/**
 * Created by dalgun
 * Date: 26/10/2019
 * Time: 9:08 PM
 */
public class FormatterFactory {

    public Formatter getFormatterType(String type){
        Formatter formatter = null;
        if("A".equals(type)){
            return new Formatter.A_TYPE_FORMAT();
        }else if ("B".equals(type)){
            return new Formatter.B_TYPE_FORMAT();
        }else{
            return Formatter.DEFAULT_TYPE;
        }
    }
}
