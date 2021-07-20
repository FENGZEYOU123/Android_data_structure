package com.yfz.data_structure.linkedList;

//节点类 Node
public class Node{
    private Node next_node; //节点Node的指针，指向下一个Node类
    private String data; //节点Node的数据，
    public Node getNext_node() {
        return next_node;
    }
    public void setNext_node(Node next_node) {
        this.next_node = next_node;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}