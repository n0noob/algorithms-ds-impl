package com.n0noob.structures;

public class LinkedNode<T> {
    T data;
    LinkedNode<T> left, right;

    public LinkedNode(T data) {
        this.data = data;
    }
}
