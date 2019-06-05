import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
 *  需求：构建一个<T extends Comparable>的二叉树
 *  注意：printf打印浮点数时，指定小数位数的同时必须得指定所有位数7.2f
 */
public class GenericBinaryTree {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node<Employee> emps = new Node<>(); 
        for (int i = 1000 ; i < 1030 ; i++) {
            String name = i + "号" + "雇员" ;
            double salary = Math.random() * 30000;
             
            emps.addNode(new Employee(name, salary));
        }
         
        List<Employee> sortEmps = emps.values();
        for(Employee emp : sortEmps)
            System.out.printf("%s的薪水为%7.2f%n",emp.getName(),emp.getSalary());
    }
 
}
 
class Employee implements Comparable{
    private String name;
    private double salary;
     
    public Employee(String name, double salary) {
        super();
        this.name = name;
        this.salary = salary;
    }
 
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        Employee e = (Employee) o;
        return Double.compare(salary, e.getSalary());
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public double getSalary() {
        return salary;
    }
 
    public void setSalary(double salary) {
        this.salary = salary;
    }
     
}
class Node<T extends Comparable> {
    private T value;
    private Node<T> leftNode;
    private Node<T> rightNode;    
     
    public List<T> values() {
        List<T> lists = new ArrayList<>();
         
        if (null != leftNode)
            lists.addAll(leftNode.values());
         
        lists.add(value);
         
        if (null != rightNode)
            lists.addAll(rightNode.values());
         
        return lists;
    }
     
    public void addNode(T addValue) {
        if (null == value)
            value = addValue;
        else {
            if (addValue.compareTo(value) < 0) {
                if (null == leftNode)
                    leftNode = new Node<T>();
                leftNode.addNode(addValue);
            } else {
                if (null == rightNode)
                    rightNode = new Node<T>();
                rightNode.addNode(addValue);
            }
        }
    }
}