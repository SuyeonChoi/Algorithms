package CodingTest;

public class NumbericStringAndWord {
    public int solution(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'z') {
                result.append(0);
                i += 3;
            }else if (c == 'o') {
                result.append(1);
                i += 2;
            }else if (c == 't') {
                if (s.charAt(i+1) == 'w') {
                    result.append(2);
                    i+= 2;
                }else {
                    result.append(3);
                    i+= 4;
                }
            }else if (c == 'f') {
                if (s.charAt(i+1) == 'o') {
                    result.append(4);
                }else {
                    result.append(5);
                }
                i+= 3;
            }else if (c == 's') {
                if (s.charAt(i+1) == 'i') {
                    result.append(6);
                    i += 2;
                }else {
                    result.append(7);
                    i += 4;
                }
            }else if (c == 'e') {
                result.append(8);
                i += 4;
            }else if (c == 'n') {
                result.append(9);
                i += 3;
            }else
                result.append(c);
        }

        return Integer.parseInt(String.valueOf(result));
    }
}
