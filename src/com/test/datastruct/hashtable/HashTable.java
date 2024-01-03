package com.test.datastruct.hashtable;

public class HashTable {
    private EmployeeLinkedList[] array;

    public HashTable(int size) {
        //初始化哈希表中存放链表的数组，但此时数组中的每一个链表并没有初始化
        array = new EmployeeLinkedList[size];
        //初始化数组中的每一个链表
        for (int i = 0; i < array.length; i++) {
            array[i] = new EmployeeLinkedList();
        }
    }

    //散列函数
    public int hash(int key) {
        return key % array.length;
    }

    //向哈希表中添加雇员
    public void add(Employee employee) {
        int index = hash(employee.id);
        array[index].add(employee);
    }

    //遍历整个哈希表
    public void list() {
        System.out.println(" ");
        for (int i = 0; i < array.length; i++) {
            System.out.println("链表" + i + ":");
            array[i].list();
        }
        System.out.println(" ");
    }

    //查找雇员，根据id来查找雇员
    public void findEmployee(int id) {
        int index = hash(id);
        EmployeeLinkedList linkedList = array[index];
        Employee employee = linkedList.queryByID(id);
        if (employee != null) {
            System.out.println("在编号为" + index + "的链表中找到雇员:" + employee);
        } else {
            System.out.println("未找到id为" + id + "的雇员");
        }
    }
    public void deleteEmployee(int id){
        int index = hash(id);
        EmployeeLinkedList linkedList = array[index];
        Employee employee = linkedList.queryByID(id);
        if(employee == null){
            System.out.println("未找到id为" + id + "的雇员，无法删除");
        }else {
            linkedList.delete(id);
            System.out.println("成功删除id为" + id + "的雇员");
        }
    }
}
