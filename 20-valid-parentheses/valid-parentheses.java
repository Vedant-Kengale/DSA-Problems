import java.util.*;

class Solution {
    public boolean isValid(String s) {

        ArrayList<Character> list = new ArrayList<>();
        boolean flag=false;

        if(s.length() == 0){
            return true;
        }

        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}'){
            flag = false;
        }
        else{
            for(char v: s.toCharArray()){
                if(v == '(' || v == '[' || v == '{'){
                    list.add(v);
                }

                else if(v == ']' && !list.isEmpty() && list.get(list.size()-1) == '['){
                    flag = true;
                    list.remove(list.size()-1);
                }

                else if(v == ')' && !list.isEmpty() && list.get(list.size()-1) == '('){
                    flag = true;
                    list.remove(list.size()-1);
                }

                else if(v == '}' && !list.isEmpty() && list.get(list.size()-1) == '{'){
                    flag = true;
                    list.remove(list.size()-1);
                }

                else{
                    flag = false;
                    break;
                }
            }
        }
        return flag && list.isEmpty();     
    }
}