package com.example.alumno.parcial1;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 09/05/2019.
 */

public class ParseXml {

    public static List<Producto> parseXml(String listaItems) {
        List<Producto> ListaItem = new ArrayList<>();
        XmlPullParser xml = Xml.newPullParser();

        try {
            xml.setInput(new StringReader(listaItems));

            int event = xml.getEventType();
            Producto i = null;
            while (event != XmlPullParser.END_DOCUMENT) {

                if (event == XmlPullParser.START_TAG) {
                    if("producto".equals(xml.getName()))//obtenemos el nombre del tag sobre el cual estamos parado
                    {
                        i = new Producto();
                    }
                    if("nombre".equals(xml.getName()))
                    {
                        if(i != null) {
                            String nombre = xml.nextText();
                            i.setNombre(nombre);
                        }
                    }
                    if("cantidad".equals(xml.getName()))
                    {
                        if(i != null) {
                            String cantidad = xml.nextText();
                            i.setCantidad(Integer.parseInt(cantidad));
                        }
                    }
                    if("precio".equals(xml.getName()))
                    {
                        if(i != null) {
                            String precio = xml.nextText();
                            i.setPrecio(Float.parseFloat(precio));
                        }
                    }
                    if("id".equals(xml.getName()))
                    {
                        if(i != null) {
                            String id = xml.nextText();
                            i.setId(Integer.parseInt(id));
                        }
                    }
                } else if(event == XmlPullParser.END_TAG && "producto".equals(xml.getName())) {
                    ListaItem.add(i);
                }

                event = xml.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  ListaItem;
    }
}
