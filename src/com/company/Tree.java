package com.company;

import com.company.task1.List;

public class Tree {
    Node tree;

    Tree(){
        tree = null;
    }
    Tree(Node v){
        tree = v;
    }

    /**
     * check for empty tree
     * @return
     */
    public boolean isEmpty(){
        return this.tree == null;
    }

    /**
     * make the list from the whole tree
     * @return
     */
    public List toList(){
        List list = new List();
        list = makelist(this.tree, list);
        if(list.isEmpty())
            list =null;
        return list;
    }

    /**
     *
     * @param m - Node for which we make list
     * @param list - list that we form
     * @return
     */
    private List makelist(Node m, List list){
        Node tr = m;
        if(tr == null)
            return list;
        else
            list.add(tr.value);
        if(tr.child != null){
            list = makelist(tr.child, list);
        }
        if(tr.sibling != null){
            list = makelist(tr.sibling, list);
        }
        return list;
    }

    /**
     *
     * @param value - value for finding in the tree
     * @return
     */

    public Node find(Object value){
        Node cur;
        cur = tree.find(value);
        return cur;
    }
}
