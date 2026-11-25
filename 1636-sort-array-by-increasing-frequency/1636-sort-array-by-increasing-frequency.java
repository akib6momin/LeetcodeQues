class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return Integer.compare(b.getKey(), a.getKey());
            }

            return Integer.compare(a.getValue(), b.getValue());
        });

        int i = 0;
        int index = 0;
        while(i<list.size()){
            for(int j=0; j<list.get(i).getValue(); j++){
                nums[index++] = list.get(i).getKey();
            }
            i++;
        }

        return nums;
    }
}