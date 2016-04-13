import java.io.*;
import java.lang.*;
import java.util.*;

class Stack
{
    private Element top;
    private int size;

    public void setTop(Element value)
    {
        top = value;
    }

    public Element getTop()
    {
        return top;
    }

    public void setSize(int value)
    {
        size = value;
    }

    public int getSize()
    {
        return size;
    }
//pop push top get_size

    public void pop()
    {
        if (size == 0)
        {
            return ;
        }
        setSize(getSize() - 1);   //size--
        Element temp = top.getPrevios();
        top.setPrevios(null);
        top = temp;
    }

    public void push(Object value)
    {
        Element elem = new Element(top, value);
        setTop(elem);
        setSize(getSize() + 1);
    }

    public Object top()
    {
        return top.getValue1();
    }

    public boolean isEmpty()
    {
        if (size == 0)
        {
            return true;
        }
        return false;
    }

    public void clear()
    {
        for(int i = 0; i < size; i++)
        {
            pop();
        }
    }

}

class Element
{
    private Element previos;
    private Object value1;

    public void setPrevios(Element value)
    {
        previos = value;
    }

    public Element getPrevios()
    {
        return previos;
    }

    public void setValue1(Object value)
    {
        value1 = value;
    }

    public Object getValue1()
    {
        return value1;
    }

    public Element()
    {
        value1 = null;
        previos = null;
    }

    public Element(Element prev, Object value)
    {
        setValue1(value);
        setPrevios(prev);
    }

}

class lab2
{
    public static void main(String[] args)
    {
        Scanner sk = new Scanner(System.in);

        Stack st = new Stack();
        st.push(12);
        st.push("I love java");
        st.push(12);
        st.pop();
        String s = (String)st.top();
        System.out.println(s);
        st.pop();
        System.out.println(st.top());
        st.clear();
        st.isEmpty();
    }

}

