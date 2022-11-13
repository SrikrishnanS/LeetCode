/* 71. Simplify Path

Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.
 */
class Solution 
{
    public String simplifyPath(String path)
    {
        LinkedList<StringBuilder> L = new LinkedList<StringBuilder>();
        StringBuilder sb = null;
        
        for (int i = 0; i < path.length(); ++i)
        {
            char ch = path.charAt(i);
            
            if (ch == '/')
            {
                if (sb != null)
                    L.add(sb);
                sb =  null;
            }
            else if (ch == '.')
            {
                if (sb == null)
                    sb = new StringBuilder();
                int j = i;
                while (j < path.length() && path.charAt(j) != '/')
                    sb.append(path.charAt(j++));
                
                if (sb.toString().equals(".."))
                {
                    if (!L.isEmpty())
                        L.removeLast();
                    sb = null;
                }
                else if (sb.toString().equals("."))
                    sb = null;
                i = j - 1;
            }
            else
            {
                if (sb == null)
                    sb = new StringBuilder();
                sb.append(ch);
            }
        }
        if (sb != null)
            L.add(sb); // flush if any remaining
        
        // construct the new path
        if (L.isEmpty())
            return "/";
  
        path = "";
        for (StringBuilder file : L)
            path += "/" + file;
        return path;
    }
}
