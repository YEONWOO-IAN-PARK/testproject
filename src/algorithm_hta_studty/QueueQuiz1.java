package algorithm_hta_studty;

public class QueueQuiz1 {

	    private final int MAX_QUEUE_SIZE = 8;

	    private int[] capacity;

	    private int front;

	    private int rear;

	    public QueueQuiz1() {
	        capacity = new int[MAX_QUEUE_SIZE];
	        front = 3;
	        rear = front;
	    }

	    public void enqueue(int data) {
	        if(0 > data) {
	            System.out.println("0보다 큰 정수를 입력하시오.");
	            return;
	        }

	        if(rear == front && capacity[front] != 0) {
	            System.out.println("Queue가 가득 찼습니다.");
	            return;
	        }

	        capacity[rear++] = data;
	        if(rear >= capacity.length) {
	            rear -= capacity.length;
	        }

	    }

	    public int dequeue() {
	        if(front == 0 || rear < 0) {
	            return 0;
	        }

	        int data = capacity[front];
	        capacity[front++] = 0;

	        if(rear == front) {
	            front = 0;
	            rear = 0;
	        }

	        return data;
	    }
	}
