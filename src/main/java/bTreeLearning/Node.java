package bTreeLearning;

/**
 * Created by Alina on 2019/3/11.
 */
public class Node<E> {
  private E data;
  private Node leftChild;
  private Node rightChild;
  private Node parent;

  public Node(E data, Node leftChild, Node rightChild) {
    this.data = data;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  public Node(E data, Node parent) {
    this.data = data;
    this.parent = parent;
  }

  public E getData() {
    return data;
  }

  public void setData(E data) {
    this.data = data;
  }

  public Node getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(Node leftChild) {
    this.leftChild = leftChild;
  }

  public Node getRightChild() {
    return rightChild;
  }

  public void setRightChild(Node rightChild) {
    this.rightChild = rightChild;
  }

}
