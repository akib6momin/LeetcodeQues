// brute force

// class Solution {
//     public int findTheWinner(int n, int k) {

//         if(n==1){
//             return n;
//         }

//         Queue<Integer> q = new ArrayDeque();
//         for(int i=1; i<=n; i++){
//             q.offer(i);
//         }

//         while(q.size() > 1){
//             for(int i=1; i<k; i++){
//                 q.offer(q.poll());
//             }

//             if(q.size() > 1){
//                 q.poll();
//             }
//         }

//         return q.peek();
//     }
// }

// optimal
class Solution {
    public int findTheWinner(int n, int k) {
        if(n==1){
            return 1;
        }

        return findAns(n, k) + 1;
    }

    public int findAns(int n, int k){
        if(n==0){
            return n;
        }

        return (findAns(n-1, k) + k) % n;
    }
}