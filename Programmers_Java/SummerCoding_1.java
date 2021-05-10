package CodingTest;

import java.util.*;

public class SummerCoding_1 {
    static class StockInfo implements Comparable<StockInfo> {
        String time;
        int price;

        public StockInfo(String time, int price) {
            this.time = time;
            this.price = price;
        }

        @Override
        public int compareTo(StockInfo o) {
            return this.time.compareTo(o.time);
        }
    }

    public int[] solution(String code, String day, String[] data) {
        Map<String, ArrayList<StockInfo>> companyStock = new HashMap<>();
        for (String datatStr : data) {
            String[] dataSplit = datatStr.split(" ");
            int price = Integer.parseInt(dataSplit[0].split("=")[1]);
            String companyCode = dataSplit[1].split("=")[1];
            String time = dataSplit[2].split("=")[1];
            StockInfo stockInfo = new StockInfo(time, price);
            ArrayList<StockInfo> list;
            if (companyStock.containsKey(companyCode)) {
                list = companyStock.get(companyCode);
            } else {
                list = new ArrayList<>();
            }
            list.add(stockInfo);
            companyStock.put(companyCode, list);
        }
        ArrayList<StockInfo> resultList = companyStock.get(code);
        ArrayList<Integer> resultPrice = new ArrayList<>();
        Collections.sort(resultList);
        for (StockInfo info: resultList) {
            String time = info.time;
            boolean rightTime = true;
            for (int i = 0; i < day.length(); i++) {
                if (time.charAt(i) != day.charAt(i)) {
                    rightTime = false;
                    break;
                }
            }
            if (rightTime) {
                resultPrice.add(info.price);
            }
        }

        int[] answer = new int[resultPrice.size()];
        for (int i = 0; i < resultPrice.size(); i++) {
            answer[i] = resultPrice.get(i);
        }
        return answer;
    }
}
