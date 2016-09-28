/*
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos - Seccion 31
* Juan Andrés García - 15046
* Rodrigo Barrios - 15009
* Guatemala, septiembre 27 de 2016
*/

/* Clase BinaryTree, codigo tomado del libro del curso */
public class BinaryTree<E> {
    protected E val; // value associated with node
    protected BinaryTree<E> parent; // parent of node
    protected BinaryTree<E> left, right; // children of node
    
    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right, BinaryTree<E> parent){
        val=value;
        this.left=left;
        this.right=right;
        this.parent=parent;
    }
    
    public BinaryTree<E> left()
    // post: returns reference to (possibly empty) left subtree
    // post: returns reference to (possibly empty) left subtree
    {
            return left;
    }

    public BinaryTree<E> right()
    // post: returns reference to (possibly empty) left subtree
    // post: returns reference to (possibly empty) left subtree
    {
            return right;
    }

    public BinaryTree<E> parent()
    // post: returns reference to parent node, or null
    {
        return parent;
    }
    
    public void setLeft(BinaryTree<E> newLeft){
        this.left=newLeft;
    }
    
    public void setRight(BinaryTree<E> newRight){
        this.right=newRight;
    }
    
    public void setParent(BinaryTree<E> newParent){
        this.left=newParent;
    }
    
    public E value()
	// post: returns value associated with this node
	{
		return val;
	}
	
	public void setValue(E value)
	// post: sets the value associated with this node
	{
		val = value;
	} 
}
