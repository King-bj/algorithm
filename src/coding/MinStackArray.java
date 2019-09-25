package coding;

import java.util.Arrays;

/**
 * 模拟实现栈 数组
 */
public class StackArray<T> {
    private T[] storage;//存放栈中元素的数组
    private int capacity;//栈的容量
    private int count;//栈中元素数量
    private static final int GROW_FACTOR = 2;

    
    //不带初始容量的构造方法。默认容量为8
    public StackArray() {
         this.capacity = 8;
         this.storage = (T[]) new Object[8];
         this.count = 0;
    }

    //带初始容量的构造方法
    public StackArray(int initialCapacity) {
        if(initialCapacity<1){
            throw new IllegalArgumentException("too small initialCapacity");
        }
        this.capacity = initialCapacity;
        this.storage = (T[]) new Object[initialCapacity];
        this.count = 0;
    }

    //入栈
    public void push(T value) {
        if(capacity == count){
            ensureCapacity();
        }
        storage[count++] = value;
    }

    //确保容量大小
    private void ensureCapacity() {
        int newCapcity = capacity * GROW_FACTOR;
        storage = Arrays.copyOf(storage,newCapcity);
        capacity = newCapcity;
    }

    //TODO：返回栈顶元素并出栈
    private T pop() {
        if(isEmpty()){
            throw new IllegalArgumentException("Stack is empty.");
        }
        count--;
        return storage[count];
    }

    //返回栈顶元素不出栈
    private T peek() {
        if(isEmpty()){
            throw new IllegalArgumentException("Stack is empty.");
        }
        return storage[count -1 ];
    }

    //判断栈是否为空
    private boolean isEmpty() {
        return count == 0;
    }

    //返回栈中元素的个数
    private int size() {
        return count;
    }

    public static void main(String[] args) {
        StackArray<Integer> myStack = new StackArray<Integer>(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        System.out.println(myStack.peek());//8
        System.out.println(myStack.size());//8
        for (int i = 0; i < 8; i++) {
            System.out.println(myStack.pop());
        }
        System.out.println(myStack.isEmpty());//true
        myStack.pop();//报错：java.lang.IllegalArgumentException: Stack is empty.
    }
}