package coding;


/**
 * 模拟实现最小栈
 * 用两个栈，A正常，B备胎，第一次进入的元素，进入A，B记录最小值，此后，每次入栈，都对数据进行校验，如果比B的出栈小，就入B栈。每次出栈时，如果出的是A的最小值 B跟着出栈
 */
public class MinStackArray<T> {
    private StackArray<Integer> mainStack = new StackArray<Integer>();
    private StackArray<Integer> minStack = new StackArray<Integer>();

    /**
     * 入栈操作
     *
     * @param element 入栈的元素
     */
    public void push(int element) {
        mainStack.push(element);
        //如果辅助栈为空，或者新元素小于或等于辅助栈栈顶，则将新元素压入辅助栈
        if (minStack.isEmpty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    /**
     * 出栈
     */
    public Integer pop() {
        //如果出栈元素和辅助栈栈顶元素值相等，辅助栈出栈
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    /**
     * 获取栈的最小元素
     */
    public int getMin() throws Exception {
        if (mainStack.isEmpty()) {
            throw new Exception("stack is empty");
        }

        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStackArray stack = new MinStackArray();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }

}