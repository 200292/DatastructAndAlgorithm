package com.test.datastruct.hashtable;

public class EmployeeLinkedList {
    public Employee head;//头节点直接指向雇员，而不是指向头节点
    //添加雇员到链表中，默认是添加到链表最后
    public void add(Employee employee){
        Employee temp = head;
        //如果头节点为空
        if(head == null){
            head = employee;
        }else {
            while (temp.next !=null){
                temp = temp.next;
            }
            temp.next = employee;
        }
    }
    //遍历链表
    public void list(){
        Employee temp = head;
        if(temp == null){
            System.out.println("链表为空");
            return;
        }
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
    //根据id查询本条链表
    public Employee queryByID(int id){
        Employee temp = head;
        while (temp != null){
            if(temp.id == id){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    //根据id删除雇员，这个雇员经过hashTable的判断肯定存在
    public void delete(int id){
        Employee employee = queryByID(id);//需要删除的雇员对象
        Employee temp = head;
        //如果头节点就是需要删除的雇员
        if(temp == employee){
            head = null;
            return;
        }
        //头节点不是需要删除的节点，则链表中至少有两个节点
        while (temp.next != null){
            if(temp.next == employee){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }
}
