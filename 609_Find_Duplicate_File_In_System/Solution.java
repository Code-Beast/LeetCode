public class Solution {
    /**
     * @param paths: a list of string
     * @return: all the groups of duplicate files in the file system in terms of their paths
     */
    public List<List<String>> findDuplicate(String[] paths) {
        // Write your code here
        List<List<String>> res = new ArrayList<>();
        if (paths == null || paths.length == 0) return res;
        
        Map<String, List<String>> contentMap = new HashMap<>();
        
        for (String path : paths) {
            parsePathInfo(path, contentMap);
        }
        
        for (String key : contentMap.keySet()) {
            List<String> filePaths = contentMap.get(key);
            
            if (filePaths.size() > 1) {
                res.add(filePaths);
            }
        }
        
        return res;
    }
    
    private void parsePathInfo(String path, Map<String, List<String>> contentMap) {
        String[] infos = path.split(" ");
        String dir = infos[0];
        
        for (int i = 1; i < infos.length; i ++) {
            StringBuilder fileSB = new StringBuilder();
            StringBuilder contentSB = new StringBuilder();
            
            boolean contentStart = false;
            
            String info = infos[i];
            for (int j = 0; j < info.length(); j ++) {
                char ch = info.charAt(j);
                
                if (ch == '(') {
                    contentStart = true;
                } else if (contentStart) {
                    contentSB.append(ch);
                } else {
                    fileSB.append(ch);
                }
            }
            
            String content = contentSB.toString();
            String file = fileSB.toString();
            
            if (contentMap.containsKey(content)) {
                contentMap.get(content).add(dir + "/" + file);
            } else {
                List<String> filePaths = new ArrayList<>();
                filePaths.add(dir + "/" + file);
                contentMap.put(content, filePaths);
            }
        }
    }
}