package controller.Dao.implement;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Scanner;
import com.google.gson.Gson;
import controller.tda.list.LinkedList;

public class AdapterDao<T> implements InterfazDao<T> {
    private Class<T> clazz;
    protected Gson g;

    // Ruta absoluta en la raíz del proyecto
    public static String filePath = "C:\\Users\\patri\\Downloads\\TiendaZapatos\\jersey-service\\Bakend\\media\\";

    public AdapterDao(Class<T> clazz) {
        this.clazz = clazz;
        this.g = new Gson();
        // Si es necesario, se puede crear el directorio:
        // File dataDir = new File(filePath);
        // if (!dataDir.exists()) {
        //     dataDir.mkdirs();
        // }
    }

    public T get(Integer id) throws Exception {
        LinkedList<T> list = listAll();
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
            Method[] methods = clazz.getMethods();
            for (int i = 0; i < methods.length; i++) {
                Method m = methods[i];
                // Se incluye "getId", "getIdUser" y "getIdUsuario"
                if (m.getName().equalsIgnoreCase("getId") || 
                    m.getName().equalsIgnoreCase("getIdUser") ||
                    m.getName().equalsIgnoreCase("getIdUsuario")) {
                    method = m;
                    break;
                }
            }
            if (method == null) {
                methods = clazz.getSuperclass().getMethods();
                for (int i = 0; i < methods.length; i++) {
                    Method m = methods[i];
                    if (m.getName().equalsIgnoreCase("getId") ||
                        m.getName().equalsIgnoreCase("getIdUsuario")) {
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
        System.out.println("Persistiendo objeto: " + object);
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
        File file = new File(filePath + getFileName());
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
        File file = new File(filePath + getFileName());
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            System.out.println("Creando el archivo JSON: " + file.getAbsolutePath());
            file.createNewFile();
        }
        try (FileWriter f = new FileWriter(file)) {
            f.write(data);
            f.flush();
            System.out.println("Datos guardados exitosamente en: " + file.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public Boolean supreme(int index) throws Exception {
        LinkedList<T> list = listAll();
        list.remove(index);
        String info = g.toJson(list.toArray());
        saveFile(info);
        return true;
    }

    // Método para definir el nombre de archivo según la entidad
    private String getFileName() {
        // Si la clase es Usuario, se utiliza "usuarios.json"
        if (clazz.getSimpleName().equalsIgnoreCase("Usuario")) {
            return "usuarios.json";
        }
        // Para otras clases, se retorna el nombre en minúsculas seguido de ".json"
        return clazz.getSimpleName().toLowerCase() + ".json";
    }
}
