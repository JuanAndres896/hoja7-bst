/*
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos - Seccion 31
* Juan Andres Garcia - 15046
* Rodrigo Barrios - 15009
* Guatemala, septiembre 27 de 2016
*/
public class Association <K,V>{
    
    protected K theKey;
    protected V theValue;

    public Association(K key, V value)
    {
        
        theKey = key;
        theValue = value;
    }

    public Association(K key)
    {
        this(key,null);
    }

    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }
    
    public int hashCode()
    {
        return getKey().hashCode();
    }
    public V getValue()
    {
        return theValue;
    }

    public K getKey()
    {
        return theKey;
    }

    public V setValue(V value)
    {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }

   
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }
    
}
