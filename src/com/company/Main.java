package com.company;

import com.company.Node;
import com.company.Tree;
import com.company.task1.List;
//todo use collections of java
public class Main {

    /* Операции
  - Добавить ребенка:                        public void addChild(Node value);   vvvvv
  - Удалить ребенка                          public boolean removeChild(Node value);    vvvvv
                                             public boolean removeChild(int index);     vvvvv
  - Получить ребенка                         public Node getChild(int index);     vvvvv
  - Получить родителя                        public Node getParent(); (если родителя нет, тогда null)    vvvvv
  - Получить путь от ребенка до родителя:    public List path();   vvvvv
  - Получить поддерево от какой-нибудь узла: public Tree subtree();   vvvvv
  - Преобразовать дерево в список:           public List toList();    vvvvv
  - Найти узел                               public Node find(Object value);    vvvvv
  - Найти общего родителя между узлами       public Node findParent(Node another);  vvvvv
  - Количество узлов:                        public int size();    vvvvv
  - Пустое дерево или нет:                   public boolean isEmpty();    vvvvv
Node - это класс узел, который используется в Tree. Его требуется сделать. API для этого класса оставляется на ваше усмотрение.
Исключения не используются. В случае неопределенности - вернуть null.
List используется тот, что был сделан как первое задание.
*/

    public static void main(String[] args) {
        Node tr = new Node(3);
        Tree tree = new Tree(tr);
        Node a1 = new Node(9);
        Node a2 = new Node(10);
        tr = tree.tree;
        int i =0;

        //Testing func addChild(Node val)

        while(i++ < 5){
            Node n = new Node(i);
            tr.addChild(n);
            if(i == 2){
                tr.child.sibling.addChild(a1);
                tr.child.sibling.addChild(a2);
                //System.out.println(tr.child.sibling.value);
                Node a3 = new Node(8);
                tr.child.sibling.child.sibling.addChild(a3);
            }
        }

        //Testing func getChild(int Index)

        if(tr.child.sibling.getChild(1) != null)
            System.out.println("For the child of key = "+ tr.child.sibling.value + " with the index = 1   is "+ tr.child.sibling.getChild(1).value);
        else
            System.out.println("For the child of key = "+ tr.child.sibling.value + " with the index = 1     doesnt exist");
        if(tr.child.sibling.getChild(2) != null)
            System.out.println("For the child of key = "+ tr.child.sibling.value + " with the index = 2  is " + tr.child.sibling.getChild(1).value);
        else
            System.out.println("For the child of key = "+ tr.child.sibling.value + " with the index = 2     doesnt exist");

        if(tr.child.sibling.child != null)
            System.out.println("For the child of key = "+ tr.child.sibling.value + " with the index = 0    is "  + tr.child.sibling.child.value);
        else
            System.out.println("For the child of key = "+ tr.child.sibling.value + " with the index = 0     doesnt exist");

        //Testing isEmpty

        System.out.println(tree.isEmpty());
        Tree trr = new Tree();
        System.out.println(trr.isEmpty());

        //Testing find(int)

        if(tr.find(5) != null)
            System.out.println("For the key 5   is "+ tr.find(5).value);
        else
            System.out.println("For the key 5 doesnt exist");
        if(tr.find(3) != null)
            System.out.println("For the child of key 3 is " + tr.find(3).value);
        else
            System.out.println("For the child of key 3  doesnt exist");
        if(tr.find(11) != null)
            System.out.println("For the child of key 11 is " + tr.find(11).value);
        else
            System.out.println("For the child of key 11  doesnt exist");
//todo JUnit for tests (Maven)
        //Test size()
        System.out.println("Size of tree is  " + tree.tree.size());

        //Test subtree()//Все-таки создавать полностью новое дерево!!
        Tree sub = tree.tree.child.sibling.subtree();
        System.out.println("Size of subtree is  " + sub.tree.size());
        System.out.print("Subtree is  ");
//        sub.toList().print();
        System.out.println(sub);
        //Test getParent()
        if(tree.tree.parent != null)
            System.out.println("Parent of " +  tree.tree.value + " is  " + tree.tree.parent.value);
        else
            System.out.println("Parent of " +  tree.tree.value + " is null");
        if(tree.tree.child.parent != null)
            System.out.println("Parent of " +  tree.tree.child.value + " is  " + tree.tree.child.parent.value);
        else
            System.out.println("null");
        if(tree.tree.child.sibling.child.parent != null)
            System.out.println("Parent of " +  tree.tree.child.sibling.child.value + " is  " + tree.tree.child.sibling.child.parent.value);
        else
            System.out.println("null");

        //Test path
        if(tree.tree.path() != null){
            System.out.print("Path for  " +  tree.tree.value + " is  ");
            tree.tree.path().print();
        }
        else
            System.out.println("Path for  " +  tree.tree.value + " is  null");
        if(tree.tree.child.path() != null){
            System.out.print("Path for  " +  tree.tree.child.value + " is  ");
            tree.tree.child.path().print();
        }
        else
            System.out.println("Path for  " +  tree.tree.child.value + " is  null");
        if(tree.tree.child.sibling.path() != null){
            System.out.print("Path for  " +  tree.tree.child.sibling.value + " is  ");
            tree.tree.child.sibling.path().print();
        }
        else
            System.out.println("Path for  " +  tree.tree.child.sibling.value + " is  null");

        //Test findParent()
        Node one = tree.tree.child.sibling;
        Node two = tree.tree.child.sibling.child.sibling.child;
        Node three =tree.tree.child.sibling.child;
        if(one.findParent(two) != null){
            System.out.println("Parent for  " +  one.value + " and  " + two.value + " is  " + one.findParent(two).value);
        }
        else
            System.out.println("Parent for  " +  one.value + " and  " + two.value + " is  null");
        if(two.findParent(three) != null){
            System.out.println("Parent for  " +  two.value + " and  " + three.value + " is  " + two.findParent(three).value);
        }
        else
            System.out.println("Parent for  " +  two.value + " and  " + three.value + " is  null");

        //Test removeChild(Node)
        /*three  = two.parent;
        System.out.println(three.removeChild(two));
        tree.toList().print();
        three.addChild(two);
        tree.toList().print();
        System.out.println(tree.tree.removeChild(one));
        tree.toList().print();*/

        //Test removeChild(Node)
        three  = two.parent;
        System.out.println(three.removeChild(0));
        tree.toList().print();
        three.addChild(two);
        tree.toList().print();
        System.out.println(tree.tree.removeChild(1));
        tree.toList().print();


        List prob = new List();
        i=0;
        while(i++ < 8){
            prob.add(i);
        }
        i=0;
        while(i++ <3){
            prob.add(i,i);
        }

        prob.print();
        System.out.println(prob.get(2).getData());
        System.out.println(prob.size());
        System.out.println(prob.contains(2));
        System.out.println(prob.contains(20));
        prob.set(10, 0);
        System.out.println(prob.indexOf(0));
        prob.print();
        prob.remove(0);
        prob.print();
        prob.remove(5);
        prob.print();
        prob.remove(12);
        prob.print();
        List list = null;
        list = tree.toList();
        list.print();
    }
}
