// brute force 

// class Solution {
//     public int timeRequiredToBuy(int[] tickets, int k) {
//         int ans = 0;
//         boolean isFound = false;

//         while (!isFound) {
//             for (int i = 0; i < tickets.length; i++) {
//                 if (tickets[i] > 0) {
//                     if (i == k && tickets[i] == 1) {
//                         ans += 1;
//                         isFound = true;
//                         break;
//                     }

//                     tickets[i] -= 1;
//                     ans++;
//                 }
//             }
//         }

//         return ans;
//     }
// }

// using queue
// class Solution {
//     public int timeRequiredToBuy(int[] tickets, int k) {
//         int ans = 0;
//         Queue<Integer> q = new ArrayDeque<>();
//         for(int i=0; i<tickets.length; i++){
//             q.offer(i);
//         }

//         while(!q.isEmpty()){
//             int index = q.peek();
//             if(index==k && tickets[index]==1){
//                 ans+=1;
//                 break;
//             }

//             tickets[index]-=1;
//             ans++;

//             if(tickets[index]==0){
//                 q.poll();
//             }else{
//                 q.offer(q.poll());
//             }
//         }

//         return ans;
//     }
// }

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
    
        for(int i=0; i<tickets.length; i++){
            if(i<=k){
                ans+=Math.min(tickets[i], tickets[k]);
            }else{
                ans+=Math.min(tickets[i], tickets[k]-1);
            }
        }

        return ans;
    }
}