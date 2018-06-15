package day0402;

/**
 * 일차원 배열의 사용
 * 행하나에 열로만 구성된 배열
 * @author owner
 */
public class UseArray1 {
	public UseArray1() {
		// 1. 선언) 데이터형 [] 배열명 = null;
		int[] arr1 = null;
		int arr2[] = null;
		// 2. 생성) 방의 갯수 설정, 모든 방의 값은 초기화
		//배열명 = new 데이터형[방의갯수];
		arr1= new int[6];
		arr2= new int[3];
		System.out.println("arr1의 방의 갯수 : "+arr1.length+" ,  arr2의 방의 갯수 : "+arr2.length);
		
		// 3. 값 할당) 배열명[방의번호]=값;
		arr1[0]=2018;
		arr1[1]=4;
		arr1[2]=2;
		arr1[3]=15;
		arr1[4]=17;
		// 값 사용) 배열명[방의번호]
		System.out.println("arr1[0]="+arr1[0]+", arr1[5]="+arr1[5]);
		//모든 방의 값 출력
		for(int i=0;i<arr1.length;i++) {
			System.out.printf("arr1[%d]=%d\n",i,arr1[i]);
		}
		//향상된 for : for(방의 데이터형 변수명 : 배열명)
		//인덱스를 사용할 수 없다.(처음 방부터 끝방까지 출력)
		for(int value:arr2) {
			System.out.println(value);
		}
		//arr1배열의 가장 마지막 변째 방부터 처음 방까지 출력
		for(int i=arr1.length-1;i>-1;i--) {
			System.out.printf("arr1[%d]=%d\n",i,arr1[i]);
		}
		// arr1배열의 짝수 변째 방의 합 출력\
		int sum=0;
		for(int i=0;i<arr1.length;i+=2) {
			sum+=arr1[i];
		}
		System.out.printf("arr1 짝수번째 방의 합은 : %d\n",sum);
		
		String[] addr = new String[5];
		addr[0]="인천시 계양구";
		addr[1]="서울시 광진구";
		addr[2]="용인시 수지구";
		addr[3]="서울시 중구";
		addr[4]="서울시 관악구";
		String temp="";
		for(int i=0;i<addr.length;i++) {
			if(addr[i].startsWith("서울시")) {
				temp="특별시";
			} else if(addr[i].startsWith("인천시")||
					addr[i].startsWith("부산시")||
					addr[i].startsWith("대전시")) {
				temp="광역시";
			} else {
				temp="일반시";
			}
			System.out.printf("%s\t%s\n",temp,addr[i]);
		}
					
			
			for(int i=0;i<addr.length;i++) {
				
			}//end for
		
		for(int i=0;i<addr.length;i++) {
			if(addr[i].startsWith("서울시")) {
				addr[i]=addr[i].replaceAll("서울시", "서울특별시");
			}else if(addr[i].startsWith("인천시")) {
				addr[i]=addr[i].replaceAll("인천시", "인천광역시");
			}
			System.out.printf("%s\t",addr[i]);
		}//end for
		
		
		
	}//UseArray1

	public static void main(String[] args) {
		new UseArray1();
		System.out.println();
		
		

	} // class

} //class
