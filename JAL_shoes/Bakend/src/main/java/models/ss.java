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


///
/// 
/// 
// <!-- End Header -->
// <!-- <script>
//     $(document).ready(function(){

//         function crear_tabla(detalle){
//             //3,2,8,
//             var html = "";
//             var subtotal = 0.0;
//             var iva =0.0;
//             var total = 0.0;
//             if (detalle.length > 0){
//                 detalle = detalle.substring(0, detalle.length - 1);
//                 var res = detalle.split(":");
//                 for (var i = 0; i < res.length; i++){
//                     var aux = res[i].split(",");
//                     //
//                     //
//                     subtotal += parseInt(aux[2])+parseFloat(aux[1]);
//                     html += "<tr>";
//                     html += "<td>"+aux[1]+"</td><td>"+aux[3]+"</td><td>"+aux[2]+"</td><td>"+(parseFloat(aux[2])*parseFloat(aux[1]))+"</td>";
//                     html += "</tr>";
//                 }
//                 iva = subtotal * 0.15;
//                 total = subtotal + iva;
//             } else {
//                 html = "<tr><td>No hay productos</td></tr>";
//             }
//             $("#txtsubtotal").val("$"+subtotal.toFixed(2));
//             $("#txtiva").val("$"+iva.toFixed(2));
//             $("#txttotal").val("$"+total.toFixed(2));
//             return html;
//         }
//         function crear_input(data){
//            //
//            var detalle = $("#txtDetalle").val();
//            var resp = "";
//            if (detalle.length > 0) {
//             detalle = detalle.substring(0, detalle.length - 1);
//             var res = detalle.split(":");
//             var band = true;
//             for (var i = 0; i < res.length; i++){
//                 var aux = res[i].split(",");
//                 if (aux[0] == data.data.id){
//                     aux[1] = (aux[1]*1)+1;
//                     band = false;
//                     res += aux[0]+","+aux[1]+","+aux[2]+","+aux[3]+":";
//                     //break;  
//                 } else {
//                     resp += aux[0]+","+aux[1]+","+aux[2]+","+aux[3]+":";
//                 }
//             }
//             if (band){
//                 resp += data.data.id+",1,"+data.data.PrecioTotal+","+data.data.Nombre+":";
//             }
//            } else {
//                  resp = data.data.id+",1,"+data.data.PrecioTotal+","+data.data.Nombre+":";
//            }
//             return resp;
//         }

//         function search_producto() {
//         var texto = $("#txtcode").val();
//         var detalle = $("#detalle").val();
//         var url = "http://localhost:8086/api/producto/code/" + texto;
//         $.ajax({
//             url: url,
//             success: function (data) {
//                 //console.log(data);

//                 if (data.msg == "OK") {
//                     //var aux = data.data.id+",1"+","+data.data.Nombre;
//                     detalle = crear_input(data);
//                     $("#txtdetalle").val(detalle);
//                     $("#table tbody").html(crear_tabla(detalle));

//                     //console.log(data.data);
//                 } else {
//                     //Products.val("");
//                     //producto.val("No existe el Producto");

//                 }
//                 //console.log(data);
//             },
//             error: function (xhr, ajaxOptions, throwError){
//                 //producto.val("");
//                 //producto.val("No existe el Producto");
//                 //alert(xhr.status);
//                 //alert(throwError);
//             }
//         })
//         //btncode
//         //txtdetalle
//     }
    

//     })
    
// </script> -->
