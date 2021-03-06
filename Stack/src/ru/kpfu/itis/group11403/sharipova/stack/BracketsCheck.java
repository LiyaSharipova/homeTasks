package ru.kpfu.itis.group11403.sharipova.stack;

public class BracketsCheck {

	private static final char ROUND_OP='(';
	private static final char ROUND_CS=')';
	private static final char SQUARE_OP='[';
	private static final char SQUARE_CS=']';
	private static final char CURLY_OP='{';
	private static final char CURLY_CS='}';
	private static final char ANGLE_OP='<';
	private static final char ANGLE_CS='>';

	public static boolean isCorrect(String expr) {
		if(expr == null){
			throw new NullPointerException("String is null");
		}
		LinkedStack<Character> braketStack= new LinkedStack();
		char[] exprAr=expr.toCharArray();

		for (Character val: exprAr) {
			if ((val ==ROUND_CS|| val == SQUARE_CS || val == CURLY_CS|| val==ANGLE_CS) 
					&& braketStack.isEmpty()){
				return false;
			}
			if (val == ROUND_OP || val == SQUARE_OP || val == CURLY_OP|| val==ANGLE_OP){
				braketStack.push(val);
			}
			if ((val ==ROUND_CS|| val == SQUARE_CS || val == CURLY_CS|| val==ANGLE_CS)
					&& !braketStack.isEmpty()){
				char current = braketStack.peek();
				switch (val) {
				case ROUND_CS: 
					if (current==ROUND_OP){
						braketStack.pop();
					}else{
						return false;
					}
					break;
				
				case SQUARE_CS: 
					if (current==SQUARE_OP){
						braketStack.pop();
					}else{
						return false;
					}
					break;
				
				case CURLY_CS: 
					if (braketStack.peek()==CURLY_OP){
						braketStack.pop();
					}else{
						return false;
					}
					break;
				
				case ANGLE_CS: 
					if (braketStack.peek()==ANGLE_OP){
						braketStack.pop();
					}else{
						return false;
					}
					break;
				default:
					break;
				}
			}
			
		}
		if(braketStack.isEmpty()){
			return true;
		}else {
			return false;
		}
	}


	public static void main(String[] args) {
		System.out.println(isCorrect("(x^3-9>"));
		System.out.println(isCorrect("(x-(32+x^5))"));
	}

}
