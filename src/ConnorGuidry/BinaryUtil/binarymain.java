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
		
		System.out.println(Binary.binaryToInt(secondTest));
		
		Binary thirdTest = new Binary("11101001");
		
		System.out.println(thirdTest);
		
		Binary.rightShift(thirdTest, 6);
		
		System.out.println(thirdTest);
		
		Binary hex = Binary.intToBinary(0xc5f3466a);
		
		System.out.println(hex);
	}

}
