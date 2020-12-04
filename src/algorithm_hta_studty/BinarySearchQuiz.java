package algorithm_hta_studty;

import java.util.Scanner;

public class BinarySearchQuiz {
    public static void main(String[] args) {
       
        int[] arr = {1, 3, 5, 7 , 7, 7, 7, 8, 9, 9 ,9}; 
        
        System.out.println("Please, Fill the Target Value in here");
        System.out.print("Target : ");
        
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
       
        boolean isSuccess = false;	// 검색성공: true  or not : false
        int findedIndex = -1;
       
        int low = 0;
        int mid = 0;
        int high = arr.length - 1; // 배열의 마지막 인덱스를 알려주는 변수
            
        while (low <= high){			// 검색범위가 0에 수렴할때 까지
            mid = (low + high)/2; 	// mid 위치설정 변수
            System.out.println("Index of mid: " + ((low + high)/2));
            System.out.println("Value of mid: " + arr[mid]);
            
            // mid에서 값을 찾았을 때
            if (arr[mid] == target){
            	mid--;
            	if (arr[mid] != target) {
            		isSuccess = true; 
            		findedIndex = mid+1; 
            		break; 
            	}
            }
           
            if (arr[mid] < target){
                low = mid + 1;
            }
            else {
                high = mid -1;
            }          
        }      
       
        if(isSuccess) {
            System.out.println(target+" is located at "+ (findedIndex+1) + "th");
        }else{
            System.out.println("Search Failure");
        }      
    }
}