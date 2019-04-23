package ConnorGuidry.BinaryUtil;

public class binarymain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Binary binary = new Binary("111111");
		
		System.out.println(binary);
		
		Binary.leftShift(binary, 5);
		
		System.out.println(binary);
		
		Binary.leftShift(binary, 6);
		
		System.out.println(binary);
		
		//Binary.leftShift(binary, 7);
		
		Binary secondTest = new Binary("101011001");
		
		System.out.println(Binary.binaryToInt(secondTest));
		
		System.out.println(Binary.intToBinary(56));
	}

}
