package src.string;

import java.util.*;
import java.util.stream.Collectors;

public class ProgrammersRemoveAD {
    class Solution {
        public List<String> solution(String[] strArr) {
            return Arrays.asList(strArr).stream().filter(str -> !str.contains("ad")).collect(Collectors.toList());
        }
    }
}
