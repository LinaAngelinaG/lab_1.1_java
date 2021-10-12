package com.company.task1;

public class List {
    //добавить деструктор
    private Elem head;
    private Elem tail;
    int count; //будем сразу считать размер(длину)

    public class Elem {
        private Object data;
        private Elem next;
        public Elem prev;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        Elem(Object a) { //конструктор
            data = a;
        }
    }

    public List() { //конструктор
        head = null;
        tail = null;
        count = 0;
    }

    public void add(Object a) {
        Elem el = new Elem(a);
        if (isEmpty())
            head = el;
        else {
            if (tail == null)
                tail = el;
            else
                tail.next = el;
        }
        tail = el;
        count++;
    }

    public void add(Object a, int index) {
        Elem curr = head;
        int cur = 0;
        if (index == count)
            add(a);
        else if (index < count) {
            while (cur < index) {
                curr = curr.next;
                cur++;
            }
            Elem node = new Elem(a);
            node.next = curr.next;
            curr.next.prev = node;
            node.prev = curr;
            curr.next = node;
            this.tail = node;
            count++;
        } else
            System.out.println("Error! Too high index!");
    }

    public Elem get(int index) {
        Elem curr = head;
        int cur = 0;
        if (index == count)
            return tail;
        else if (index < count) {
            while (cur < index) {
                curr = curr.next;
                cur++;
            }
            return curr;
        } else
            return null;
    }

    public int indexOf(Object a) {
        Elem curr = head;
        int cur = 0;
        while (curr != null) {
            if (curr.getData() == a)
                return cur;
            curr = curr.next;
            cur++;
        }
        return -1;
    }

    public int size() {
        return count;
    }

    public boolean contains(Object a) {
        Elem curr = head;
        int cur = 0;
        while (curr != null) {
            if (curr.getData() == a)
                return true;
            curr = curr.next;
            cur++;
        }
        return false;
    }

    public void set(Object a, int index) {
        if (index >= count)
            System.out.println("Impossiple to set with such an index!");
        else {
            Elem node = head;
            int cur = 0;
            while (cur < index) {
                cur++;
                node = node.next;
            }
            node.data = a;
            System.out.println("The setting is completed!");
        }
    }

    public int remove(int index) {
        if (index >= count)
            System.out.println("Impossiple to delete with such an index!");
        else {
           /*
            elem node = head;
            int cur = 0;
            while(cur < index){
                cur++;
                node = node.next;
            }
            if(node.prev != null)
                node.prev.next = node.next;
            if(node.next != null)
                node.next.prev = node.prev;
            node = null;
            System.out.println("The deleting is completed!");
            count--;*/
            Elem del = get(index);
            System.out.println(del.data);
            if (del.prev != null)
                del.prev.next = del.next;
            if (del.next != null && del.prev != null)
                del.next.prev = del.prev;
            else if (del.next != null) {
                del.data = del.next.data;
                del.next = del.next.next;
                if (del.next.next != null)
                    del.next.next.prev = del;
            } else {
                this.head = null;
                this.tail = null;
            }
            System.out.println("The deleting is completed!");
            count--;
            return 1;
        }
        return -1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        Elem curr = head;
        while (curr != null) {
            System.out.print(curr.data + "  ");
            curr = curr.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "List{" +
                "head=" + head +
                ", tail=" + tail +
                ", count=" + count +
                '}';
    }
}


/* while(current != null){
            s++;
            if(current.child != null)
                s += current.child.size();
            current = current.sibling;
            if(current!=null && current.child != null)
                s += current.child.size();
        }
        return s;*/
