package day0402;

/**
 * ������ �迭�� ���
 * ���ϳ��� ���θ� ������ �迭
 * @author owner
 */
public class UseArray1 {
	public UseArray1() {
		// 1. ����) �������� [] �迭�� = null;
		int[] arr1 = null;
		int arr2[] = null;
		// 2. ����) ���� ���� ����, ��� ���� ���� �ʱ�ȭ
		//�迭�� = new ��������[���ǰ���];
		arr1= new int[6];
		arr2= new int[3];
		System.out.println("arr1�� ���� ���� : "+arr1.length+" ,  arr2�� ���� ���� : "+arr2.length);
		
		// 3. �� �Ҵ�) �迭��[���ǹ�ȣ]=��;
		arr1[0]=2018;
		arr1[1]=4;
		arr1[2]=2;
		arr1[3]=15;
		arr1[4]=17;
		// �� ���) �迭��[���ǹ�ȣ]
		System.out.println("arr1[0]="+arr1[0]+", arr1[5]="+arr1[5]);
		//��� ���� �� ���
		for(int i=0;i<arr1.length;i++) {
			System.out.printf("arr1[%d]=%d\n",i,arr1[i]);
		}
		//���� for : for(���� �������� ������ : �迭��)
		//�ε����� ����� �� ����.(ó�� ����� ������� ���)
		for(int value:arr2) {
			System.out.println(value);
		}
		//arr1�迭�� ���� ������ ��° ����� ó�� ����� ���
		for(int i=arr1.length-1;i>-1;i--) {
			System.out.printf("arr1[%d]=%d\n",i,arr1[i]);
		}
		// arr1�迭�� ¦�� ��° ���� �� ���\
		int sum=0;
		for(int i=0;i<arr1.length;i+=2) {
			sum+=arr1[i];
		}
		System.out.printf("arr1 ¦����° ���� ���� : %d\n",sum);
		
		String[] addr = new String[5];
		addr[0]="��õ�� ��籸";
		addr[1]="����� ������";
		addr[2]="���ν� ������";
		addr[3]="����� �߱�";
		addr[4]="����� ���Ǳ�";
		String temp="";
		for(int i=0;i<addr.length;i++) {
			if(addr[i].startsWith("�����")) {
				temp="Ư����";
			} else if(addr[i].startsWith("��õ��")||
					addr[i].startsWith("�λ��")||
					addr[i].startsWith("������")) {
				temp="������";
			} else {
				temp="�Ϲݽ�";
			}
			System.out.printf("%s\t%s\n",temp,addr[i]);
		}
					
			
			for(int i=0;i<addr.length;i++) {
				
			}//end for
		
		for(int i=0;i<addr.length;i++) {
			if(addr[i].startsWith("�����")) {
				addr[i]=addr[i].replaceAll("�����", "����Ư����");
			}else if(addr[i].startsWith("��õ��")) {
				addr[i]=addr[i].replaceAll("��õ��", "��õ������");
			}
			System.out.printf("%s\t",addr[i]);
		}//end for
		
		
		
	}//UseArray1

	public static void main(String[] args) {
		new UseArray1();
		System.out.println();
		
		

	} // class

} //class
