package ar.edu.unlp.info.oo2.biblioteca;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class JSONObjectAdapter implements Exporter{
    private String adapter;

    @Override
    public String exportar(List<Socio> socios) {
        JSONArray jsonArray = new JSONArray();

        for (Socio socio : socios) {
            JSONObject obj = new JSONObject();
            obj.put("nombre", socio.getNombre());
            obj.put("email", socio.getEmail());
            obj.put("legajo", socio.getLegajo());
            jsonArray.add(obj);
        }

        return jsonArray.toJSONString();
    }
}