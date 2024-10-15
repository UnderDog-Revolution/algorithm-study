package programers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution30 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> infoMap = new HashMap<>();
        // info를 순회하며 각 info를 key로 하고 score리스트를 value로 하는 Map을 만든다.
        for(int i=0; i<info.length;i++){
            String[] split = info[i].split(" ");
            String key = split[0]+split[1]+split[2]+split[3];
            int score = Integer.parseInt(split[4]);
            // 이미 있는 key라면 value를 List에 추가한다.
            if(infoMap.containsKey(key)){
                infoMap.get(key).add(score);
            }
            else{ // 기존에 없는 key라면 새로운 List를 만들어 value를 추가한다.
                List<Integer> list = new ArrayList<>();
                list.add(score);
                infoMap.put(key, list);
            }
        }

        // Map의 keySet을 순회하며 value를 정렬한다.
        Set<String> keySet = infoMap.keySet();
        for(String key : keySet){
            List<Integer> list = infoMap.get(key);
            list.sort(null);
        }


        // query를 순회하며 각 query에 해당하는 사람 수를 찾는다.
        for(int i=0;i<query.length;i++){

            // query 데이터 전처리
            query[i] = query[i].replaceAll("and ", "");
            String[] split = query[i].split(" ");

            int score = Integer.parseInt(split[4]); // query의 마지막은 score이므로 기준이 되는 score를 저장한다.
            int count = 0; // X이상인 사람의 수를 저장할 변수

            // 각 항목의 모든 경우의 수를 저장할 리스트를 얻는다.
            List<String> languageList = getLanguageList(split[0]);
            List<String> jobList = getJobList(split[1]);
            List<String> careerList = getCareerList(split[2]);
            List<String> foodList = getFoodList(split[3]);

            // 각 항목의 모든 경우의 수를 저장한 리스트를 순회하며 query가 될수 있는 모든 key를 얻는다.
            List<String> keySetList = getKeySet(languageList, jobList, careerList, foodList);

            // keySetList를 순회하며 infoMap에 key가 존재한다면 X이상인 사람을 찾는다.
            for(String key : keySetList){
                if(infoMap.containsKey(key)){
                    List<Integer> scoreList = infoMap.get(key);
                    int searchIndex = binarySearch(scoreList, score);
                    count += scoreList.size()-searchIndex;
                }
            }

            // count를 answer에 저장한다.
            answer[i] = count;
        }

        return answer;
    }

    // food의 모든 경우의 수를 저장한 리스트를 반환한다.
    private static List<String> getFoodList(String foodQuery) {
        List<String> foodList = new ArrayList<>();
        if(foodQuery.equals("-")){
            foodList.add("chicken");
            foodList.add("pizza");
        }
        else{
            foodList.add(foodQuery);
        }
        return foodList;
    }

    // career의 모든 경우의 수를 저장한 리스트를 반환한다.
    private static List<String> getCareerList(String careerQuery) {
        List<String> careerList = new ArrayList<>();
        if(careerQuery.equals("-")){
            careerList.add("junior");
            careerList.add("senior");
        }
        else{
            careerList.add(careerQuery);
        }
        return careerList;
    }

    // job의 모든 경우의 수를 저장한 리스트를 반환한다.
    private static List<String> getJobList(String jobQuery) {
        List<String> jobList = new ArrayList<>();
        if(jobQuery.equals("-")){
            jobList.add("backend");
            jobList.add("frontend");
        }
        else{
            jobList.add(jobQuery);
        }
        return jobList;
    }

    // language의 모든 경우의 수를 저장한 리스트를 반환한다.
    private static List<String> getLanguageList(String languageQuery) {
        List<String> languageList = new ArrayList<>();
        if(languageQuery.equals("-")){
            languageList.add("cpp");
            languageList.add("java");
            languageList.add("python");
        }
        else{
            languageList.add(languageQuery);
        }
        return languageList;
    }

    // scoreList에서 score이상인 사람의 인덱스를 반환한다.
    private static int binarySearch(List<Integer> scoreList, int score) {
        int start = 0;
        int end = scoreList.size();
        while(start<end){
            int mid = (start+end)/2;
            if(scoreList.get(mid)< score){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }

    // language, job, career, food의 모든 경우의 수를 저장한 리스트를 반환한다.
    public List<String> getKeySet(List<String> languageList, List<String> jobList, List<String> careerList, List<String> foodList){
        List<String> keySet = new ArrayList<>();
        for(String l : languageList){
            for(String j : jobList){
                for(String c : careerList){
                    for(String f : foodList){
                        keySet.add(l+j+c+f);
                    }
                }
            }
        }
        return keySet;
    }
}

/**
 * 1. info를 순회하며 조건을 분리한다.
 * 2. 분리된 조건을 key로 하고 점수를 value 리스트로 하는 Map을 만든다. 기존에 있는 key라면 value를 List에 추가한다.
 * 3. Map을 순회하며 value를 정렬한다.
 * 4. query를 순회하며 조건을 분리한다.
 * 5. query의 조건을 key로 Map에서 찾아 value의 점수 중 X이상인 사람을 찾는다. 이때, -는 모든 조건을 만족한다.
 */