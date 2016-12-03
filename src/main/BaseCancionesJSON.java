package main;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BaseCancionesJSON
{
    public static void guardarInfoCanciones(ArrayList<Cancion> listaCanciones) throws JSONException
    {
        JSONObject objetoCanciones = procesarCanciones(listaCanciones);
        EscritorJSON.escribir(objetoCanciones, "BaseCanciones.json");

    }

    public static JSONObject procesarCanciones(ArrayList<Cancion> listaCanciones)
    {
        JSONObject objetoCanciones = new JSONObject();
        try
        {
            for(Cancion cancion: listaCanciones)
            {
                String id = String.valueOf(cancion.getId());
                objetoCanciones.put(id, datosCancion(cancion));
                //System.out.println("can " + id );
            }
        }
        catch(JSONException ex)
        {
            System.out.println(ex);
        }
        return objetoCanciones;
    }

    public static JSONObject datosCancion(Cancion cancion)
    {
        JSONObject datosCancion = new JSONObject();
        try
        {
            datosCancion.put("titulo",  cancion.getTitulo());
            datosCancion.put("artista", cancion.getArtista());
            datosCancion.put("letra",   cancion.getLetra());
        }
        catch(JSONException ex)
        {
            System.out.println("Error al crear objeto JSON " + ex);
        }
        return datosCancion;
    }

}
