import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {

        int answer = 1;

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i =0; i<clothes.length;i++){
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        for(String key : map.keySet()){
            answer *= (map.get(key)+1); //옷을 입지 않은 경우도 체크해주기 위해서 1을 더하고 곱해줌
        }

        return answer - 1; //아무것도 입지 않은 상태를 빼주기 위해서 1을 빼준 값을 리턴
    }
}