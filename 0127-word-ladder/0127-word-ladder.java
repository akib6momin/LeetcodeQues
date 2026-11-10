class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> s= new HashSet<>(wordList);
        if(!s.contains(endWord)){
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int ans = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String curr = q.poll();
                if(curr.equals(endWord)){
                    return ans;
                }

                char word[] = curr.toCharArray();
                for(int j=0; j<word.length; j++){
                    char original = word[j];
                    for(char ch='a'; ch<='z'; ch++){
                        word[j] = ch;
                        String next = new String(word);
                        if(s.contains(next)){
                            q.offer(next);
                            s.remove(next);
                        }
                    }

                    word[j] = original;
                }
            }

            ans++;
        }

        return 0;

    }
}