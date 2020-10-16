//package webtecass4pckg;

public class q2 {
	public static void main(String[] args) {
		int value = -1;
		byte convrt_to_byte = (byte)value;
		char convrt_to_char = (char)convrt_to_byte;
		int convrt_to_int = (int)convrt_to_char;
		System.out.println(convrt_to_int);
	}
}

/*
EXPLANATION
=> Initially value -1 is stored in "value" variable which is 32-bit integer type
   Range of Integer is -2^31 to 2^31-1 so -1 can be stored in "value" variable
   Then we cast int -> byte and stored it in "convrt_to_byte" which is 8-bit which can store -128 to 127
   So -1 can be stored in "convrt_to_byte"
   Then we cast byte to char and stored it in "convrt_to_char" which is 26-bit and can store 0 to 2^16-1 values
   As value -1 is out of range and as it is -1 so 2^16-1 is stored in "convrt_to_byte"
   And then when we cast "convrt_to_byte" -> "convrt_to_int" the value printed in 2^16-1
*/
