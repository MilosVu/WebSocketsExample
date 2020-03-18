import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import java.io.StringWriter;

public class Player {

    private int id;
    private String name;
    private String lastname;

    public Player(int id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public static String buildJson(){
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        JsonObject jsonObject = jsonObjectBuilder.add("id",1).add("firstname","Milos").
                add("lastname","Vujic").build();

        StringWriter stringWriter = new StringWriter();

        try(JsonWriter jsonWriter = Json.createWriter(stringWriter)){
            jsonWriter.writeObject(jsonObject);
        }
        return stringWriter.toString();
    }

    public static void main(String[] args) {
        System.out.println(buildJson());
    }
}
