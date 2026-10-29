
// class Solution {
//     public int minCost(String colors, int[] neededTime) {
//         ArrayList<Integer> list = new ArrayList<>();
//         int ans = 0;

//         for (int i = 0; i < colors.length(); i++) {
//             boolean skip = false;

//             while (!list.isEmpty() &&
//                    colors.charAt(list.get(list.size() - 1)) == colors.charAt(i)) {

//                 int last = list.get(list.size() - 1);

//                 if (neededTime[i] <= neededTime[last]) {
//                     ans += neededTime[i];
//                     skip = true;
//                     break;
//                 } else {
//                     ans += neededTime[last];
//                     list.remove(list.size() - 1);
//                 }
//             }

//             if (!skip) {
//                 list.add(i);
//             }
//         }

//         return ans;
//     }
// }

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int last = -1;
        int ans = 0;

        for (int i = 0; i < colors.length(); i++) {
           if(last!=-1 && colors.charAt(last)==colors.charAt(i)){
            if(neededTime[i]<=neededTime[last]){
                ans+=neededTime[i];
                continue;
            }else{
                ans+=neededTime[last];
            }
           }

           last = i;
        }

        return ans;
    }
}