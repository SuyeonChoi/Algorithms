import java.util.HashMap;

class PandY {
    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] lang = {"PYTHON", "C++", "SQL"};
        int[] pref = {7, 5, 5};

        System.out.println(solution(table, lang, pref));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        HashMap<String, HashMap<String, Integer>> jobTable = new HashMap<>();
        for (int i = 0; i < table.length; i++) {
            String[] info = table[i].split(" ");
            HashMap<String, Integer> languageScore = new HashMap<>();
            languageScore.put(info[1], 5);
            languageScore.put(info[2], 4);
            languageScore.put(info[3], 3);
            languageScore.put(info[4], 2);
            languageScore.put(info[5], 1);
            jobTable.put(info[0], languageScore);
        }

        int maxScore = 0;
        String answer = "";
        for (String key : jobTable.keySet()) {
            HashMap<String, Integer> languageScore = jobTable.get(key);
            int score = 0;
            for (int i = 0; i < languages.length; i++) {
                if(languageScore.containsKey(languages[i])){
                    score += (languageScore.get(languages[i]) * preference[i]);
                }
            }
            if(maxScore < score){
                maxScore = score;
                answer = key;
            }else if(maxScore == score && answer.compareTo(key) < 0){
                maxScore = score;
                answer = key;
            }
        }

        return answer;
    }
}