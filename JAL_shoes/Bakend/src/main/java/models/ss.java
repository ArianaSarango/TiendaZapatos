// package models;

// import com.google.gson.Gson;
// import com.google.gson.reflect.TypeToken;
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import controller.tda.list.LinkedList;
// import java.lang.reflect.Type;
// import controller.tda.list.Node;

// public class ss {  // Renombré la clase a Main
//     public static void main(String[] args) {
//         // Crear una lista enlazada de familias
//         LinkedList<Familia> listaFamilias = new LinkedList<>();

//         // Crear objetos de la clase Familia y agregarlos a la lista
//         listaFamilias.add(new Familia(1, "Juan", "Pérez", "12345678", "987654321"));
//         listaFamilias.add(new Familia(2, "Ana", "García", "87654321", "123456789"));
//         listaFamilias.add(new Familia(3, "Luis", "Martínez", "11223344", "998877665"));

//         // Crear un objeto Gson
//         Gson gson = new Gson();

//         // Convertir la lista de familias a formato JSON
//         String listaFamiliasJson = gson.toJson(listaFamilias);

//         // Imprimir el JSON generado en la consola
//         System.out.println(listaFamiliasJson);

//         // Guardar el JSON en un archivo dentro de src/main/java/Data
//         String filePath = "src/main/java/Data/familias.json"; // Ruta del archivo
        
//         try (FileWriter writer = new FileWriter(filePath)) {
//             writer.write(listaFamiliasJson);
//             System.out.println("JSON guardado en: " + filePath);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         // Leer el archivo 
//         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//             Type listType = new TypeToken<LinkedList<Familia>>() {}.getType();
//             LinkedList<Familia> loadedList = gson.fromJson(reader, listType);

//             // Imprimir las familias 
//             Node<Familia> current = loadedList.getHeader(); // Asume que hay un método getHeader() en LinkedList
//             while (current != null) {
//                 Familia p = current.getInfo(); // Asegúrate de que getInfo() exista
//                 System.out.println("ID: " + p.getId() + ", Integrantes: " + p.getIntegrantes() + ", Apellido: " + p.getApellido() + ", apellidoPaterno: " + p.getapellidoPaterno());
//                 current = current.getNext(); // Asegúrate de que getNext() exista
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }
