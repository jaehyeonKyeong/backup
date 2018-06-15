package day0402;

/**
 * 일차원 배열의 사용<br>
 * 행하나에 열로만 구성된 배열<br>
 * 고정길이형 : 선언할때 정해진 방의 크기가 변경되지 않음.<br>
 * 
 * @author owner
 */
public class UseArray1 {
	
	public UseArray1() {
		//1.선언 : 데이터형[] 배열명=null;
		int[] arr1=null;
		int arr2[]=null;
		//2.생성 : 방의 갯수 설정, 모든 방의 값은 초기화
		//배열명 = new 데이터형[방의 갯수];
		arr1 = new int[6];
		arr2 = new int[3];
		System.out.println("arr1 의 방의 갯수: "+arr1.length+"\narr2 의 방의갯수: "+arr2.length);
		//3. 값할당 : 배열명[방의번호] = 값;
		arr1[0]=2018;
		arr1[1]=4;
		arr1[2]=2;
		arr1[3]=15;
		arr1[4]=17;
		//4.값사용 : 배열명[방의 번호]
		System.out.println("arr1[0] = "+arr1[0]+", "+"arr1[5] = "+arr1[5]);
		
		//모든 방의 값 출력)
		for(int i=0;i<arr1.length;i++) {
			System.out.printf("arr[%d]=%d\n",i,arr1[i]);
		}
		//향상된 for를 이용한 출력
		//for(방의 데이터형 변수명: 배열명)
		for(int value:arr2) {
			System.out.println(value);
		}
		
		//arr1의 가장 마지막번째 방부터 처음방까지 출력
		System.out.println("arr1의 가장 마지막번째 방부터 처음방까지 출력");
		for(int i=arr1.length-1;i>=0;i--) {
			System.out.printf("arr[%d]=%d\n",i,arr1[i]);
		}
		System.out.println("arr1의 가장 마지막번째 방부터 처음방까지 출력");
		//arr1배열의 짝수번째 방의 합 출력
		int sum=0;
		for(int i=0;i<arr1.length;i+=2) {
			sum+=arr1[i];
		}
		System.out.println(sum);
		
		String[] addr=new String[5];
		addr[0]="인천시 계양구";
		addr[1]="서울시 광진구";
		addr[2]="용인시 수지구";
		addr[3]="서울시 중구";
		addr[4]="서울시 관악구";
		
		String temp=null;
		for(int i=0;i<addr.length;i++) {
			if(addr[i].startsWith("서울시")) {
				temp="특별시";
			}else if(addr[i].startsWith("인천시")||addr[i].startsWith("광주시")||addr[i].startsWith("부산시")){
				temp="광역시";
			}else {
				temp="일반시";
			}
			System.out.println(temp+"\t"+addr[i]);
		}
		
	}//UseArray1
	public static void main(String[] args) {
		new UseArray1();
		
		
		
	}//main

}//class
