package myTest0403;
public class ReturnArray {
  static int[] makeArray(){    //������ �迭�� �����ϴ� �޼ҵ�
  int temp[] = new int[4];    //�迭 ����
  for(int i=0;i<temp.length;i++){
   temp[i]=i;    //�迭�� �����ҿ� �ε����� �ʱ�ȭ
  }
  return temp;    //�迭 ����
 }


 public static void main (String[] args){
  int intArray[];    //�迭 ���۷��� ���� ����
  intArray = makeArray();       //�޼ҵ带 ȣ���ϰ� �޼ҵ尡 ������ �迭�� ���޹޴´�.
  for(int i=0;i<intArray.length;i++){
   System.out.println(intArray[i]);        //�迭�� ��� ���Ҹ� ����Ѵ�.
   }
 
 }
}

