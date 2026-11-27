class Solution {
    public String customSortString(String order, String s) {
      HashMap<Character, Integer>mp=new HashMap<>();
      for(Character k:s.toCharArray()){
        mp.put(k, mp.getOrDefault(k,0)+1);
      }
      StringBuilder sb=new StringBuilder();
      
      for(char k:order.toCharArray()){
        if(mp.containsKey(k)){
            int v=mp.get(k);
            while(v-->0)
                sb.append(k);
            mp.remove(k);
        }
      }
      for(Character k:mp.keySet()){
        int v=mp.get(k);
        while(v-->0)
            sb.append(k);
      }
      return sb.toString(); 
    }
}