package Connection;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class ObjectToJson {
    private static ObjectMapper mapper;
    static {
        mapper = new ObjectMapper();
    }
    public static String converter(Object object){
        String jsonResult = null;
        try {
            try {
                jsonResult = mapper.writeValueAsString(object);
            } catch (JsonMappingException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return jsonResult;
    }
}
