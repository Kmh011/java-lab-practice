import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

        int i = input.indexOf('+');
        if (i == -1) {
            i = input.indexOf('-');
        }

        int a = Integer.parseInt(input.substring(0, i));
        char operator = input.charAt(i);
        int b = Integer.parseInt(input.substring(i + 1));

        try {
            if (a == 0 || b == 0) {
                if (operator == '+') {
                    throw new AddZeroException("AddZeroException");
                } else {
                    throw new SubtractZeroException("SubtractZeroException");
                }
            }
            if (a < 0 || b < 0 || a > 1000 || b > 1000) {
                throw new OutOfRangeException("OutOfRangeException");
            }
            
            int result;
            
            if (operator == '+') {
                result = a + b;
            } else {
                result = a - b;
            }

            if (result < 0 || result > 1000) {
                throw new OutOfRangeException("OutOfRangeException");
            }

            // 결과 출력
            System.out.println(result);
        } catch (AddZeroException e) {
            System.out.println(e.getMessage());
        } catch (SubtractZeroException e) {
            System.out.println(e.getMessage());
        } catch (OutOfRangeException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
	}
	
	static class AddZeroException extends Exception {
        public AddZeroException(String message) {
            super(message);
        }
    }

    static class SubtractZeroException extends Exception {
        public SubtractZeroException(String message) {
            super(message);
        }
    }
    
    static class OutOfRangeException extends Exception {
        public OutOfRangeException(String message) {
            super(message);
        }
    }
}
