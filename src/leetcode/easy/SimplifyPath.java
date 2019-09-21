package leetcode.easy;

import java.util.Stack;

// LC # 71
public class SimplifyPath {

    public String solution(String path) {
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (s.equals(".") || s.equals("")) {
                continue;
            } else {
                stack.push(s);
            }
        }
        if (stack.empty()) {
            return "/";
        }
        String spath = "";
        while (!stack.empty()) {
            spath = "/" + stack.pop() + spath;
        }
        return spath;
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().solution("/a/b/c/../.."));
        System.out.println(new SimplifyPath().solution("/a/b/c/./."));
        System.out.println(new SimplifyPath().solution("/a/b/c/../../d/e"));
    }
}
