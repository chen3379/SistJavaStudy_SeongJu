package day1027;

public class ArrayMax_05 {

	public static void main(String[] args) {
		// 배열 최대값 구하기
		int[] data= {21,35,42,58,63,71,84,93,124,146};
		System.out.println("요소의 개수: "+data.length);
		int max=data[0];
		int min=data[0];
		for(int i=1;i<data.length;i++) {
			if(data[i]>max)
				max=data[i];
			else
				min=data[i];
		}
		System.out.println("배열의 최대값: "+max);
		System.out.println("배열의 최소값: "+min);
	}
}
