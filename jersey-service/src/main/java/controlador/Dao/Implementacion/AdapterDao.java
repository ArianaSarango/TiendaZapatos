package controlador.Dao.Implementacion;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import com.google.gson.Gson;

import controlador.tda.List.LinkedList;

public class AdapterDao<T> implements InterfazDao<T> {
    private Class<T> clazz;
    private Gson g;
    public static String filePath = "src/main/java/Data/"; 

    public AdapterDao(Class<T> clazz) { 
        this.clazz = clazz;
        this.g = new Gson();
    }

    public T get(Integer id) throws Exception {
        LinkedList<T> list = listAll();
        if (!list.isEmpty()) {
            T [] mat = list.toArray();
            return mat[id-1];
        }
        return null;
    }

    public LinkedList<T> listAll() {  
        LinkedList<T> list = new LinkedList<>();
        try {
            String data = readFile(); 
            T[] matrix = (T[]) g.fromJson(data, java.lang.reflect.Array.newInstance(clazz, 0).getClass()); 
            list.toList(matrix); 
        } catch (Exception e) {
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
        if (list == null) {
            System.out.println("La lista es null. Asegúrate de que el archivo JSON se esté leyendo correctamente.");
            return;
        }
        list.add(object); 
        String info = g.toJson(list.toArray()); 
        System.out.println("Escribiendo datos al archivo: " + info); 
        saveFile(info); 
    }

    private String readFile() throws Exception { 
        File file = new File(filePath + clazz.getSimpleName() + ".json"); 

        if (!file.exists()) {
            System.out.println("El archivo no existe, creando uno nuevo: " + file.getAbsolutePath());
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

    private void saveFile(String data) throws Exception { 
        File file = new File(filePath + clazz.getSimpleName() + ".json");
        file.getParentFile().mkdirs(); 

        if (!file.exists()) {
            System.out.println("Creando el archivo JSON: " + file.getAbsolutePath());
            file.createNewFile();
        }
        
        try (FileWriter f = new FileWriter(file)) {  
            f.write(data); 
            f.flush(); 
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public Boolean deleteFile(int index) throws Exception{
        LinkedList<T> list = listAll();
        list.remove(index);
        String info = g.toJson(list.toArray());
        saveFile(info);
        return true;
    }
}
