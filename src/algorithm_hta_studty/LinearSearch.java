package algorithm_hta_studty;

public class LinearSearch<E> {
	
	/**
	 * int형 배열을 선형검색하는 메소드
	 * @param arr <-선형검색을 실시하는배열
	 * @param n	<-배열의 원소 수(=데이터개수)
	 * @param key <-배열 arr에서 찾으려는 값
	 * @return
	 */
	public static int seqSearch(int[] arr, int n, int key) {
		// 선형 검색을 위한 배열 인덱스 변수
		int i = 0;
		
		while(true) {
			// 선형검색을 실시하면서 찾지못한 경우
			// 즉, 배열의 0번째부터 배열의 끝자리까지 찾지 못한 경우
			// 반환값 -1을 반환
			if(i == n) {
				return -1;
			}
			// 배열 arr의 i번째 자리가 key의 값과 같은경우
			// 배열의 인덱스 i를 반환
			if(arr[i] == key) {
				return i;
			}
			i++;
		}
	}
}
