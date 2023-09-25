package simplifyPath;

import java.util.Stack;

/**
 *给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。
 * 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * @auther mortal
 * @date 2023/9/25 21:55
 */
public class Solution {

    public static void main(String[] args) {

    }
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (String s : split) {
            if (s.equals(".")) {

            } else if (s.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (s.equals("...")) {
                stack.push(s);
            }else if(!s.equals("")){
                stack.push(s);
            }
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("/");
        for (String s:stack) {
            buffer.append(s).append("/");
        }
        if (buffer.length() != 1) {
            return buffer.toString().substring(0, buffer.length() - 1);
        }else {
            return buffer.toString();
        }
    }
}
