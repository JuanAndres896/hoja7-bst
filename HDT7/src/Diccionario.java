import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
/*
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos - Seccion 31
* Juan Andrés García - 15046
* Rodrigo Barrios - 15009
* Guatemala, septiembre 27 de 2016
*/
public class Diccionario {
    
   File archivo = null;
   FileReader fr = null;
   BufferedReader br = null;
   BinaryTree<Association<String,String>> root;
   ArrayList <String> oracion = new ArrayList<String>();
   
   public Diccionario(){
       
       root = new BinaryTree<Association<String,String>>(null,null,null,null);
       fillDic();
       traducirOracion();  
   }
   
   public void fillDic(){
       ArrayList<String> palabras = new ArrayList<String>();
       ArrayList<Association<String,String>> relaciones = new ArrayList<Association<String,String>>();
       
       try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File ("C:\\Users\\JuanAndrés\\Desktop\\Segundo Año\\CICLO 2\\Estructuras de Datos\\Hoja 7\\HDT7\\src\\diccionario.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           int ind=0;
           while((linea=br.readLine())!=null){
              palabras.add(linea);
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
       
       for(int i=0; i<palabras.size()-1;i++){
           int posicion = palabras.get(i).indexOf(',');
           String eng = palabras.get(i).substring(0,posicion);
           String esp = palabras.get(i).substring(posicion+1,palabras.get(i).length());
           relaciones.add(new Association(eng,esp));
       }
       root.setValue(relaciones.get(0));
       for(int i=1; i<relaciones.size();i++){
           insertNode(root,relaciones.getClass(i));
       }
    public void insertNode(BinaryTree<Association<String,String>> parent, BinaryTree<Association<String,String>> data){
        Association<String,String>> asociacion = parent.value();
        String parentKey = asociacion.getKey();
        String dataKey = data.getKey();
        int n = parentKey.compareToIgnoreCase(dataKey);
        if(n>0 && parent.left()==null){
            parent.setLeft(new BinaryTree<Association<String,String>>(null,null,null,null));
            parent.left().setValue(data);
        }
        else if(parent.left()!=null){
            insertNode(parent.left(),data);
        }
        if (n<0 && parent.right()==null){
            parent.setRight(new BinaryTree<Association<String,String>>(null,null,null,null));
            parent.right().setValue(data);
        }
        else if(parent.right()!=null){
            insertNode(parent.right(),data);
        }
    }
    public String traducirPalabra(BinaryTree<Association<String,String>> parent, String palabra){
        String palabraTraducida = "";
        Association<String,String> asociacion = parent.value();
        String parentKey = asociacion.getKey();
        int n = parentKey.compareToIgnoreCase(palabra);
        if(n==0){
            palabraTraducida = parent.value().getValue();
        }
        if(n<0){
            if(parent.right()!=null){
                palabraTraducida = traducirPalabra(parent.right(),palabra);
            }else{
                return("*"+palabra+"*");
            }
        }
        if(n>0){
            if(parent.left()!=null){
                palabraTraducida = traducirPalabra(parent.left(),palabra);
            }else{
                return("*"+palabra+"*");
            }
        }
        return palabraTraducida;
    }
    public void traducirOracion(){
        leerOracion();
        String resultado ="";
        for(int i=0; i<oracion.size();i++){
            resultado+=traducirPalabra(root,oracion.get(i).trim())+"";
        }
        System.out.println(resultado);
    }
    public void leerOracion(){
        String palabras="";
        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine())
           archivo = new File ("\"C:\\Users\\JuanAndrés\\Desktop\\Segundo Año\\CICLO 2\\Estructuras de Datos\\Hoja 7\\HDT7\\src\\oraciones.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           int ind=0;
           while((linea=br.readLine())!=null){
              	palabras=linea;
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        while(palabras.compareTo("")!=0){
	int lugar=palabras.indexOf(' ');
            if(lugar!=-1){
                    oracion.add(palabras.substring(0,lugar));
                    palabras=palabras.substring(lugar+1);
            }else{
                    oracion.add(palabras);
                    palabras="";
            }
        }
        }
    }
   }
   
    
    
    
    
}
