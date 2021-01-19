import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1242 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            //암호문 발췌
            LinkedList<String> codeLines = new LinkedList<>();
            String previous = "";
            String zeros = "";
            for (int i = 0; i < M; i++) {
                zeros += "0";
            }
            //암호가 있는 라인 저장
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                if (str.equals(previous) || str.equals(zeros) || codeLines.contains(str)) continue;
                previous = str;
                codeLines.add(str);
            }
            //라인별 암호문 저장
            LinkedList<String> codes = new LinkedList<>();
            for (int i = 0; i < codeLines.size(); i++) {
                String[] line = codeLines.get(i).split("");
                String code = "";
                for (int j = 0; j < line.length; j++) {
                    if (!line[j].equals("0")) {
                        while (j < line.length && !line[j].equals("0")) {
                            code = code + line[j];
                            j++;
                        }
                        if (!codes.contains(code)) {
                            codes.add(code);
                            code = "";
                        }
                    }
                }
            }
            int ans = 0;
            for (int idx = 0; idx < codes.size(); idx++) {
                String code = codes.get(idx);
                //            System.out.println(code);
                //16진수 암호문을 2진수 암호문으로
                code = codeToBinary(code);
//            System.out.println(code);

                //암호문 해독
                code = decode(code);
//            System.out.println(code);
                //암호문 검증
                if(!code.equals("")){
                    ans += verifyCode(code);
                }

            }
            System.out.println("#" + t + " " + ans);

        }
    }

    private static int verifyCode(String code) {
        int odd = 0, even = 0;
        for (int i = 0; i < code.length() - 1; i++) {
            if (i % 2 == 0) {
                odd += (code.charAt(i) - '0');
            } else {
                even += (code.charAt(i) - '0');
            }
        }
        if (((odd * 3 + even + (code.charAt(code.length() - 1) - '0')) % 10) == 0) { //검증성공
            return (odd + even + (code.charAt(code.length() - 1) - '0'));
        }
        return 0;
    }

    private static String decode(String code) {
        String decode = "";
        int ratio = code.length() / 56;
        int min = Integer.MAX_VALUE; //비율 계산을 위한 변수
        //비율에 맞게
        for (int i = 0; i < code.length(); i = i + (7 * ratio)) {
            String subCode = "";
            int cnt = 1;
            //7, 14, 21.. 숫자 끊어서 확인
            for (int j = i + 1; j < i + ratio * 7; j++) {
                if (code.charAt(j) == code.charAt(j - 1)) {
                    cnt++;
                } else {
                    if (cnt < min && cnt != 1) min = cnt;
                    subCode = subCode + Integer.toString(cnt);
                    cnt = 1;
                }
                if (j == (i + ratio * 7 - 1)) subCode = subCode + Integer.toString(cnt);
            }
            //비율 계산
            boolean divided = true;
            for (int j = 0; j < subCode.length(); j++) {
                if (subCode.charAt(j) % min != 0) {
                    divided = false;
                    break;
                }
            }
            if (divided) { //비율 약분 가능시 실행
                String dividing = "";
                for (int j = 0; j < subCode.length(); j++) {
                    dividing = dividing + Integer.toString((subCode.charAt(j)-'0') / min);
                }
                subCode = dividing;
            }
            //알맞은 값 매칭
            switch (subCode) {
                case "3211":
                    decode = decode + "0";
                    break;
                case "2221":
                    decode = decode + "1";
                    break;
                case "2122":
                    decode = decode + "2";
                    break;
                case "1411":
                    decode = decode + "3";
                    break;
                case "1132":
                    decode = decode + "4";
                    break;
                case "1231":
                    decode = decode + "5";
                    break;
                case "1114":
                    decode = decode + "6";
                    break;
                case "1312":
                    decode = decode + "7";
                    break;
                case "1213":
                    decode = decode + "8";
                    break;
                case "3112":
                    decode = decode + "9";
                    break;
            }
        }
        return decode;
    }

    private static String codeToBinary(String code) {
        String newCode = "";
        for (int i = 0; i < code.length(); i++) {
            String append = hexTobin(code.charAt(i));
            while (i != 0 && append.length() < 4) append = "0" + append;
            newCode = newCode + append;
        }
        while (newCode.charAt(newCode.length() - 1) == '0') {
            newCode = newCode.substring(0, newCode.length() - 1);
        }
        while (newCode.length() % 56 != 0) {
            newCode = "0" + newCode;
        }
        return newCode;
    }

    private static String hexTobin(char c) {
        return Integer.toBinaryString(Integer.parseInt(String.valueOf(c), 16));
    }
}
