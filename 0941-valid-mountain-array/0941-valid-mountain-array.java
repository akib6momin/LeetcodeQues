// class Solution {
//     public boolean validMountainArray(int[] arr) {
//         if(arr.length < 3){
//             return false;
//         }

//         int n = arr.length;
//         boolean left[] = new boolean[n];
//         boolean right[] = new boolean[n];
//         left[0] = true;
//         right[n-1] = true;

//         for(int i=1; i<arr.length; i++){
//             if(arr[i] > arr[i-1]){
//                 left[i] = true;
//             }else{
//                 break;
//             }
//         }

//         for(int i=n-2; i>=0; i--){
//             if(arr[i] > arr[i+1]){
//                 right[i] = true;
//             }else{
//                 break;
//             }
//         }

//         for(int i=1; i<n-1; i++){
//             if(arr[i-1] < arr[i] && arr[i] > arr[i+1]){
//                 if(left[i-1] && right[i+1]){
//                     return true;
//                 }
//             }
//         }

//         return false;
//     }
// }


class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3){
            return false;
        }

        int n = arr.length;
        int i=0;

        while(i<n-1 && arr[i] < arr[i+1]){
            i++;
        }

        if(i==0 || i==n-1){
            return false;
        }


        while(i<n-1 && arr[i] > arr[i+1]){
            i++;
        }

        return i==n-1;
    }
}