package Programmers;

import java.util.*;

class Song implements Comparable<Song>{
    int idx;
    int played;

    public Song(int idx, int played) {
        this.idx = idx;
        this.played = played;
    }

    @Override
    public int compareTo(Song o) {
        if(o.played == this.played){
            return this.idx - o.idx;
        }
        return o.played - this.played;
    }
}

class Entity implements Comparable<Entity>{
    String genre;
    int plays;

    public Entity(String genre, int plays) {
        this.genre = genre;
        this.plays = plays;
    }

    @Override
    public int compareTo(Entity o) {
        return o.plays - this.plays;
    }
}

public class Best_Album {
    public static void main(String[] args) {
        String[] g= {"classic", "pop", "classic", "classic", "pop", "kpop"};
        int[] p =  {500, 600, 150, 800, 2500, 5000};

        solution(g, p);
    }
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, ArrayList<Song>> map = new HashMap<>();
        Map<String, Integer> bestGenre = new HashMap<>();
        for(int i = 0; i< genres.length; i++){
            ArrayList<Song> list;
            if(map.containsKey(genres[i])){
                list = map.get(genres[i]);
                bestGenre.put(genres[i], bestGenre.get(genres[i]) + plays[i]);
            }else{
                list = new ArrayList<>();
                bestGenre.put(genres[i], plays[i]);
            }
            list.add(new Song(i, plays[i]));
            map.put(genres[i], list);
        }


        ArrayList<Entity> tmpList = new ArrayList<>();
        for(String key: bestGenre.keySet()){
            tmpList.add(new Entity(key, bestGenre.get(key)));
        }
        Collections.sort(tmpList);
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        for(Entity entity : tmpList){
            String genre = entity.genre;
            Collections.sort(map.get(genre));
            answer.add(map.get(genre).get(0).idx);
            if(map.get(genre).size() < 2) continue;
            answer.add(map.get(genre).get(1).idx);
        }
        int[] answerArr = new int[answer.size()];
        for(int a : answer){
            answerArr[idx++] = a;
        }

        return answerArr;
    }
}
