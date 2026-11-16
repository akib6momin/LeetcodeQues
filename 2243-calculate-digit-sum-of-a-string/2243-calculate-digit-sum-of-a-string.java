class Solution {
    public String digitSum(String s, int k) {
       Queue<Character> q = new LinkedList<>();

        if(s.length() <= k){
            return s;
        }

        int cnt = 0;
        int sum = 0;
        for(char ch : s.toCharArray()){
            if(cnt==k){
                cnt = 0;
                for(char c: String.valueOf(sum).toCharArray()){
                    q.offer(c);
                }
                sum=0;
            }

            cnt++;
            sum += (ch-'0');
        }

        if(cnt > 0) {
            for(char c : String.valueOf(sum).toCharArray()) {
                q.offer(c);
            }
        }

        while(true){
            int size = q.size();
            if(size <= k){
                break;
            }
            sum = 0;
            cnt = 0;
            for(int i=0; i<size; i++){
                if(cnt == k){
                    cnt =0;
                    for(char c: String.valueOf(sum).toCharArray()){
                        q.offer(c);
                    }
                    sum = 0;
                }

                cnt++;
                sum += q.poll() - '0';
            }

            if(cnt > 0) {
                for(char c : String.valueOf(sum).toCharArray()) {
                    q.offer(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.poll());
        }

        return sb.toString();
    }
}