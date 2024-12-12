package controller.Dao.implement;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
<<<<<<< HEAD
import java.util.Scanner;

import javax.ws.rs.core.Link;

import com.google.gson.Gson;
import controller.tda.list.LinkedList;

public class AdapterDao<T> implements InterfazDao<T> {
    private Class<T> clazz;
    protected Gson g;
    public static String filePath = "src/main/java/Data/"; // Ruta donde se guardan los archivos JSON

    public AdapterDao(Class<T> clazz) { // Constructor
        this.clazz = clazz;
        this.g = new Gson();
    }

    public T get(Integer id) throws Exception {
        LinkedList<T> list = listAll(); //Invoca el método listAll() para obtener la lista de objetos
        if(!list.isEmpty()){
            T [] matrix = list.toArray(); //Convierte la lista en un Array de objetos
            return matrix[id - 1]; //Devuelve el objeto en la posición id-1
        }
        return null; //Devuelve null si la lista está vacía
    }

    public LinkedList<T> listAll() {  //Convierte el String con formato Json en un Array de objetos
        LinkedList<T> list = new LinkedList<>();
        try {
            String data = readFile(); //Invoca el método readFile() para leer el archivo JSON y devolverlo en formato String
            T[] matrix = (T[]) g.fromJson(data, java.lang.reflect.Array.newInstance(clazz, 0).getClass()); //Deserializa el String JSON en un Array de objetos tipo T
            list.toList(matrix); //Envia matrix al método toList() de la clase LinkedList
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; //devuelve LinkedList<T> list
    }

    public void merge(T object, Integer index) throws Exception {
        LinkedList<T> list = listAll(); //Invoca el método listAll() para obtener la lista de objetos
        list.update(object, index); //Actualiza el objeto en la posición index
        String info = g.toJson(list.toArray()); //Convierte la lista en un String JSON
        saveFile(info);
    }

    public void persist(T object) throws Exception {  //Guarda un objeto en un archivo JSON
        System.out.println("Persisting object: " + object); //Imprime el objeto a guardar
        LinkedList<T> list = listAll(); //Invoca el método listAll() para obtener la lista de objetos
=======
import java.lang.reflect.Method;
import java.util.Scanner;
import com.google.gson.Gson;

import controller.tda.list.LinkedList;
public class AdapterDao<T> implements InterfazDao<T> {
    private Class<T> clazz;
    protected Gson g;

    // Cambiamos a una ruta absoluta en la raíz del proyecto
    public static String filePath = "data/"; // src/main/java/Data/

    public AdapterDao(Class<T> clazz) {
        this.clazz = clazz;
        this.g = new Gson();
        // Crear el directorio data si no existe
        File dataDir = new File(filePath);
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
    }

    public T get(Integer id) throws Exception {
        LinkedList<T> list = listAll(); // Implementar según sea necesario
        if (!list.isEmpty()) {
            T[] matriz = list.toArray();
            for (int i = 0; i < matriz.length; i++) {
                if (getIdent(matriz[i]).intValue() == id.intValue()) {
                    return matriz[i];
                }
            }
        }
        return null;
    }

    private Integer getIdent(T obj) {
        try {
            Method method = null;
            for (Method m : clazz.getMethods()) {
                if (m.getName().equalsIgnoreCase("getId")) {
                    method = m;
                    break;
                }
            }
            if (method == null) {
                for (Method m : clazz.getSuperclass().getMethods()) {
                    if (m.getName().equalsIgnoreCase("getId")) {
                        method = m;
                        break;
                    }
                }
            }
            if (method != null)
                return (Integer) method.invoke(obj);
        } catch (Exception e) {
            return -1;
        }
        return -1;
    }

    // to_list
    public LinkedList<T> listAll() {
        LinkedList<T> list = new LinkedList<>();
        try {
            String data = readFile();
            T[] matrix = g.fromJson(data, com.google.gson.reflect.TypeToken.getArray(clazz).getType());
            list.toList(matrix);
        } catch (Exception e) {
            System.out.println("Error al leer la lista: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public void merge(T object, Integer index) throws Exception {
        LinkedList<T> list = listAll();
        list.update(object, index);
        String info = g.toJson(list.toArray());
        saveFile(info);
    }

    public void persist(T object) throws Exception {
        System.out.println("Persisting object: " + object);
        LinkedList<T> list = listAll();
>>>>>>> origin/Juan
        if (list == null) {
            System.out.println("La lista es null. Asegúrate de que el archivo JSON se esté leyendo correctamente.");
            return;
        }
<<<<<<< HEAD
        list.add(object); //Agrega el objeto a la lista
        String info = g.toJson(list.toArray()); //Convierte la lista en un String JSON
        System.out.println("Escribiendo datos al archivo: " + info); //Imprime el String JSON
        saveFile(info); //Guarda el String JSON en un archivo
    }

    private String readFile() throws Exception { //Lee el archivo JSON y lo convierte en un String
        File file = new File(filePath + clazz.getSimpleName() + ".json"); //Crea una instancia de File con la ruta del archivo JSON

        if (!file.exists()) {
            System.out.println("El archivo no existe, creando uno nuevo: " + file.getAbsolutePath());
            saveFile("[]"); 
        }

        StringBuilder sb = new StringBuilder();
        try (Scanner in = new Scanner(new FileReader(file))) { //Lee el archivo JSON
            while (in.hasNextLine()) { //Mientras haya una línea que leer
                sb.append(in.nextLine()).append("\n"); //Añade la línea al StringBuilder
            }
        }
        return sb.toString().trim(); //Devuelve el contenido del archivo en formato String
    }

    public void saveFile(String data) throws Exception { //Guarda el String en un archivo JSON
        File file = new File(filePath + clazz.getSimpleName() + ".json");
        file.getParentFile().mkdirs(); //Crea los directorios necesarios para el archivo
=======
        list.add(object);
        String info = g.toJson(list.toArray());
        System.out.println("Escribiendo datos al archivo: " + info);
        saveFile(info);
    }

    private String readFile() throws Exception {
        File file = new File(filePath + clazz.getSimpleName() + ".json");

        if (!file.exists()) {
            System.out.println("El archivo no existe, creando uno nuevo: " + file.getAbsolutePath());
            file.getParentFile().mkdirs();
            saveFile("[]");
        }

        StringBuilder sb = new StringBuilder();
        try (Scanner in = new Scanner(new FileReader(file))) {
            while (in.hasNextLine()) {
                sb.append(in.nextLine()).append("\n");
            }
        }
        return sb.toString().trim();
    }

    public void saveFile(String data) throws Exception {
        File file = new File(filePath + clazz.getSimpleName() + ".json");
        file.getParentFile().mkdirs();
>>>>>>> origin/Juan

        if (!file.exists()) {
            System.out.println("Creando el archivo JSON: " + file.getAbsolutePath());
            file.createNewFile();
        }
<<<<<<< HEAD
        // Try asegura que el recurso FileWriter se cierre al finalizar el bloque
        try (FileWriter f = new FileWriter(file)) {  //Crear un objeto FileWriter asociado con el archivo file
            f.write(data); //Escribe el contenido de data en el buffer de escritura
            f.flush(); //Descarga el contenido del buffer al archivo
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
=======

        try (FileWriter f = new FileWriter(file)) {
            f.write(data);
            f.flush();
            System.out.println("Datos guardados exitosamente en: " + file.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
            e.printStackTrace();
            throw e;
>>>>>>> origin/Juan
        }
    }

    public Boolean supreme(int index) throws Exception {
<<<<<<< HEAD
        LinkedList<T> list = listAll(); //Invoca el método listAll() para obtener la lista de objetos
        list.remove(index); //Elimina el objeto en la posición index
        String info = g.toJson(list.toArray()); //Convierte la lista en un String JSON
        saveFile(info); //Guarda el String JSON en un archivo
        return true; //Retorna verdadero si se eliminó correctamente
    }

}
=======
        LinkedList<T> list = listAll(); // Invoca el método listAll() para obtener la lista de objetos
        list.remove(index); // Elimina el objeto en la posición index
        String info = g.toJson(list.toArray()); // Convierte la lista en un String JSON
        saveFile(info); // Guarda el String JSON en un archivo
        return true; // Retorna verdadero si se eliminó correctamente
    }

    
}
>>>>>>> origin/Juan
