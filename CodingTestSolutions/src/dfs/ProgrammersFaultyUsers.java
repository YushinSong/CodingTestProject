package src.dfs;

import java.util.*;

public class ProgrammersFaultyUsers {
    class Solution {
        public HashSet<HashSet<String>> answer = new HashSet<HashSet<String>>();
        public ArrayList<ArrayList<String>> bannedUsers = new ArrayList<ArrayList<String>>();
        public int solution(String[] user_id, String[] banned_id) {
            for(String id : banned_id){
                ArrayList<String> temp = new ArrayList<>();
                String regex = id.replace("*", ".");
                for(String user : user_id)
                    if(user.matches(regex))
                        temp.add(user);
                bannedUsers.add(temp);
            }
            DFS(new HashSet<>(), 0);

            return answer.size();
        }
        public void DFS(HashSet<String> cur, int index){
            if(index == bannedUsers.size()){
                answer.add(new HashSet<>(cur));
                return;
            }

            for(String user : bannedUsers.get(index)){
                if(!cur.contains(user)){
                    cur.add(user);
                    DFS(cur, index+1);
                    cur.remove(user);
                }
            }
        }
    }
}
