package algorithm_hta_studty;

public class Stack {
	
	// 상수
	private final int DEFAULT_CAPACITY_SIZE = 5;	// STACK의 디폴트용량 선언
	private final int MAX_CAPACITY_SIZE = 20;		// STACK의 맥시멈용량 선언
	
	// 멤버변수
	private int top;		// 가장 최근에 Push되어진 데이터의 위치를 알려주는 변수
	private int bottom;		// 가장 먼저 Push되어진 혹은 STACK의 처음위치(0)를 알려주는 변수
	private int cursor;		// stack의 data가 push된 위치를 가리키는 변수
	private int[] capacity;	// int타입의 stack data를 저장하는 변수(또한 다른타입을 지정 할 수도 있다)
	
	// 생성자
	public Stack() {
		this.cursor = 0;
		this.capacity = new int[DEFAULT_CAPACITY_SIZE]; // 기본생성자 속의 capacity의 값은 상수로 설정해놓은 default값을 사용
	}
	
	public Stack(int capacity) {
		this.cursor = 0;
		this.capacity = new int[capacity];	// 생성자메소드에 매개변수로 입력된 용량값을 디폴트값으로 사용한다.
	}
	
	// 메서드 ***중요
	public int push(int data) {
		if(data >= 0 ) {
			if(cursor < capacity.length) {
				if(bottom == 0) {
					bottom = data;
				} 
				capacity[cursor++] = data;
				top = data;
				return 1;
			}
			/*else {	// ...형이 이 메소드에서 왜 나와?
				if(capacitySizeUp(data) == 1) {
					return 1;
				}
			}*/   
		}
		return 0;
	}
	
	public int pop() {
		if(top != 0) {	// stack이 빈 배열이 아닐때
			int data = top;	//	top의 데이터를 int data에 대입한다.
			capacity[--cursor] = 0; // 마지막 push에서 증가된 cursor의 위치를 top데이터의 자리로 이동시키고
									// 그 top데이터를 0으로 초기화시킨다.
			if(cursor != 0) {	// 커서의 위치가 0이 아닐때 -> 데이터가 하나라도 들어있을때
			data = top;			// 남아있는 데이터는 top가 된다.
			top = capacity[cursor - 1];	// top 변수에 아래위치에 있던 데이터를 대입한다.
			} else {
				top = 0;	// 커서의 위치가 0이면 그 배열은 빈 배열이다.
				bottom = 0;
			}
			return data;
		}
		return 0;
	}
	
	public int peek() {
		if(top != 0) {
			return top;
		}
		return 0;
	}
	
	public int indexOf(int data) {
		if(top != 0) {
			for(int i = cursor-1; i>=0; i--) {
				if(capacity[i] == data) {
					System.out.println(capacity[i]);
					return i;
				}
			}
		}
		return 0;
	}
	
	private int capacitySizeUp(int data) {
		if(cursor == capacity.length) {  // Stack이 가득 찼을때
			if((cursor + 1) <= MAX_CAPACITY_SIZE) {
				int[] capacityCopy = capacity;
				capacity = new int[capacity.length + 5];
				System.arraycopy(capacityCopy, 0, capacity, 0, capacity.length);
				capacity[cursor++] = data;
				top = data;
				return 1;
			} else {
				System.out.println("Stack의 사이즈가 최대용량인 20을 넘어섰습니다.");
			}
		}
		return 0;
	}
	
	public void clear() {
        for(int i = cursor -1; i >= 0; i--) {
            capacity[i] = 0;
        }
        top = 0;
        bottom = 0;
    }

    public int capacity() {
        if(top != 0) {
            return capacity.length;
        }
        return 0;
    }

    public int size() {
        if(top != 0) {
            return cursor;
        }
        return 0;
    }

    public boolean isFull() {
        if (cursor == capacity.length) {
            return true;
        }
        return false;
    }

    public void printStackData() {
        if(top != 0) {
            for (int i = cursor - 1; i >= 0; i--) {
                System.out.println(capacity[i]);
            }
        } else {
            System.out.println("스택이 비어 있습니다.");
        }
    }
	
}
