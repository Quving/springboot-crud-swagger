package helper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Creates a class which have two function getByteArrayObject and getJavaObject.
 *
 * getByteArrayObject converts a java object into byte[] and return the byte[].
 *
 * getJavaObject converts a byte[] to java object. and return SimpleExample object.
 *
 */
public class Converter {
    /**
     * Converts a given object to byte[].
     *
     * @param o
     * @return
     */
    public byte[] getByteArrayObject(Object o) {

        byte[] byteArrayObject = null;
        try {

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(o);

            oos.close();
            bos.close();
            byteArrayObject = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return byteArrayObject;
        }
        return byteArrayObject;
    }

    /**
     * Converts a given object to a json string.
     *
     * @param o
     * @return
     */
    public String getJsonStringFromObject(Object o) {
        ObjectMapper omapper = new ObjectMapper();
        String jsonstring = null;
        try {
            jsonstring = omapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonstring;
    }

    /**
     * Converts a given byte[] to an java-object.
     *
     * @param bytes
     * @return
     */
    public Object getJavaObject(byte[] bytes) {
        Object o = null;

        ByteArrayInputStream bais;
        ObjectInputStream ins;
        try {

            bais = new ByteArrayInputStream(bytes);
            ins = new ObjectInputStream(bais);
            o = (Object) ins.readObject();

            ins.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
