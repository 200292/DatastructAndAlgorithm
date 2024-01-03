package com.test.datastruct.hashtable;

import java.util.ArrayList;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        hashTable.add(new Employee(1,"jack"));
        hashTable.add(new Employee(2,"tom"));
        hashTable.add(new Employee(3,"jerry"));
        hashTable.add(new Employee(4,"alice"));
        hashTable.add(new Employee(8,"alice"));
        hashTable.add(new Employee(7,"alice"));
        hashTable.add(new Employee(15,"a"));
        hashTable.list();
        hashTable.findEmployee(4);
        hashTable.findEmployee(9);
        hashTable.deleteEmployee(18);
        hashTable.list();
        ArrayList<Object> objects = new ArrayList<>();
    }
}
