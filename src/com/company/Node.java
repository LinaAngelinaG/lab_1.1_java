package com.company;

import com.company.task1.List;

import java.util.Objects;

public class Node{
    Node parent; //родитель узла
    Node child; //непосредственный ребенок узла
    Node sibling; //"сводный узел"_ с ним есть общий родительский узел
    Object value; //информация, хранящаяся в узле
    //static int count;
    Node(int a){
        value = a;
        child= parent = sibling = null;
    }
    Node(){
        child= parent = sibling = null;
    }

    /**
     *
     * @param value - the exact Node for adding as a child
     */
    public void addChild(Node value){
        Node current = this;
        if (current.child != null) {
            current = current.child;
            while (current.sibling != null) {
                current = current.sibling;
            }
            current.sibling = value;
            current.sibling.parent = current.parent;
            current = current.sibling;
        }
        else {
            current.child = value;
            current.child.parent = current;
            current = current.child;
        }
        current.child = null;
        current.sibling = null;
    }

    /**
     *
     * @return - parent of the Node
     */
    public Node getParent(){
        return this.parent;
    }

    /**
     *
     * @return path to the parent in the list
     */
    public List path(){
        Node cur = this;
        if(cur.parent == null)
            return null;
        List path = new List();
        path.add(cur.value);
        path.add(cur.parent.value);
        return path;
    }

    /**
     *
     * @return gain the size of tree
     */
    public int size(){
        int s = 0;
        Node current = this;
        Tree tree = new Tree(this);
        List list = tree.toList();
        return list.size();
    }

    /**
     *
     * @param index - the position of child that we wanna gain
     * @return
     */

    public Node getChild(int index){
        /** итерация по листу детей
         * **/
        int i = 0;
        Node cur = this.child;
        while(i < index){
            if(cur.sibling != null){
                i++;
                cur = cur.sibling;
            }
            else
                return null;
        }
        return cur;
    }

    /**
     *
     * @return - return subtree for the Node
     */
    public Tree subtree(){
        if(this.child == null)
            return null;
        Tree tr = new Tree();
        tr.tree = this.child;
        return tr;
    }

    /**
     *
     * @param another - to which Node we have to find same parent
     * @return
     */

    public Node findParent(Node another){
        int i = 0;
        Node par = another;
        Node cur, curr;
        cur = this.parent;
        while(par != null){
            par = par.parent;
            curr = cur;
            while(curr != null){
                if(curr.equals(par)){
                    return curr;
                }
                curr = curr.parent;
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (this == obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, child, sibling, value);
    }

    /**
     *
     * @param value - the Node in the tree for deleting
     * @return
     */
    public boolean removeChild(Node value){
        Node del = value, ch = value.child, cur = value;

        if(!this.equals(cur.parent)) //проверим, что такой ребенок вообще есть
            return false;
        if(cur.sibling != null){
            System.out.println(cur.sibling.value);
            cur.child = cur.sibling.child;
            cur.value = cur.sibling.value;
            cur.sibling = cur.sibling.sibling;
            while(cur.sibling != null){
                System.out.println(cur.value);
                cur = cur.sibling;
            }
            System.out.println(cur.value);
            if(ch != null){
                ch.parent = cur.parent;
                cur.sibling = ch;
            }
        }
        else if(del.child != null){
            del.child = ch.child;
            del.value = ch.value;
            del.sibling = ch.sibling;
        }
        else
            this.child = null;
        return true;
    }

    /**
     *
     * @param index - index from which we have to delete
     * @return
     */
    public boolean removeChild(int index){
        Node f = this.getChild(index);
        if(f == null)
            return false;
        else
            return this.removeChild(f);
    }

    /**
     *
     * @param val - find this value in the tree
     * @return
     */
    public Node find(Object val){
        Node cur = this;
        Node f = null;
        //System.out.println(this.value);
        if(this.equals(null))
            return null;
        if(cur.value == val)
            return cur;
        while(cur.sibling != null){
            cur = cur.sibling;
            if(cur.value == val)
                return cur;
        }
        cur =this;
        if(cur.child != null)
            f = cur.child.find(val);
        if(f != null)
            return f;
        while(cur.sibling != null){
            cur = cur.sibling;
            if(cur.child != null)
                f = cur.child.find(val);
            if(f != null)
                return f;
        }
        return null;
    }
}
