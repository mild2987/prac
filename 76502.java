import java.util.*;

class Solution {
    private int validate(String s, int idx) {
        var pair = Map.of(']', '[', '}', '{', ')', '(');
        var stk = new Stack<Character>();
        for (int i = idx; i < idx + s.length(); i++) {
            char c = s.charAt(i % s.length());
            if (c == '[' || c == '{' || c == '(')
                stk.push(c);
            else {
                if (!stk.empty() && stk.peek() == pair.get(c))
                    stk.pop();
                else
                    return 0;
            }
        }
        
        return stk.empty() == true ? 1 : 0;
    }
    
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++)
            answer += validate(s, i);                                           
        return answer;
    }
}
