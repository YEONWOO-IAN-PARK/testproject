package algorithm_hta_studty;

public class StackQuiz {

	// 스택 최대 사이즈
    private final int MAX_STACK_SIZE = 11;

    private int leftCosor;
    private int rightCosor;

    private Object[] capacity;

    private IntegerStack integerStack;
    private StringStack stringStack;

    public StackQuiz() {
        capacity = new Object[MAX_STACK_SIZE];
        leftCosor = 0;
        rightCosor = capacity.length - 1;

        integerStack = new IntegerStack();
        stringStack = new StringStack();
    }

    // int형 스택 푸시
    public void push(int data) {
        if(data < 0) {
            return;
        }

        if(leftCosor >= capacity.length / 2) {
            System.out.println("int 스택은 꽉 찼습니다.");
            return;
        }

        if(leftCosor < capacity.length / 2) {
            if(integerStack.bottom == 0) {
                integerStack.bottom = data;
            }
            integerStack.capacity[integerStack.cosor++] = data;
            capacity[leftCosor++] = data;
            integerStack.top = data;
        }
    }

    // String 스택 푸시
    public void push(String data) {
        if(data == null) {
            return;
        }

        if(capacity.length / 2 >= rightCosor) {
            System.out.println("String 스택은 꽉 찼습니다.");
            return;
        }

        if(capacity.length / 2 < rightCosor ) {
            if(stringStack.bottom == null) {
                stringStack.bottom = data;
            }
            stringStack.capacity[stringStack.cosor++] = data;
            capacity[rightCosor--] = data;
            stringStack.top = data;
        }
    }

    public int intPop() {
        if(integerStack.cosor >= 0) {
            capacity[leftCosor--] = null;

            int topData = integerStack.capacity[--integerStack.cosor];
            integerStack.capacity[integerStack.cosor] = 0;

            if(integerStack.cosor != 0) {
                integerStack.top = integerStack.capacity[integerStack.cosor - 1];
            } else {
                integerStack.top = 0;
                integerStack.bottom = 0;
            }

            return topData;
        }

        System.out.println("IntegerStack은 이미 비어있습니다.");
        return 0;
    }

    public String stringPop() {
        if(stringStack.cosor >= 0) {
            capacity[rightCosor--] = null;

            String topData = stringStack.capacity[--stringStack.cosor];
            stringStack.capacity[stringStack.cosor] = null;

            if(stringStack.cosor != 0) {
                stringStack.top = stringStack.capacity[stringStack.cosor - 1];
            } else {
                stringStack.top = null;
                stringStack.bottom = null;
            }

            return topData;
        }

        System.out.println("StringStack은 이미 비어있습니다.");
        return null;
    }

    class IntegerStack {
        // Integer 스택 최대 사이즈
        private final int MAX_INTEGER_STACK_SIZE = MAX_STACK_SIZE / 2;

        public int top;
        public int bottom;
        public int cosor;

        public int[] capacity;

        public IntegerStack() {
            capacity = new int[MAX_INTEGER_STACK_SIZE];
            top = 0;
            bottom = 0;
            cosor = 0;
        }
    }

    class StringStack {
        // Integer 스택 최대 사이즈
        private final int MAX_STRING_STACK_SIZE = MAX_STACK_SIZE / 2;

        public String top;
        public String bottom;
        public int cosor;

        public String[] capacity;

        public StringStack() {
            capacity = new String[MAX_STRING_STACK_SIZE];
            top = null;
            bottom = null;
            cosor = 0;
        }
    }
}
