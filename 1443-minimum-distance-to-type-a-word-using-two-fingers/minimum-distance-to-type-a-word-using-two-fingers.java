class Solution {
    public int fun(String word,int i,char fig1,char fig2,List<HashMap<Character,HashMap<Character,Integer>>> dp){
        if(i==word.length()) return 0;
        if(dp.get(i).containsKey(fig1) && dp.get(i).get(fig1).containsKey(fig2)){
            return dp.get(i).get(fig1).get(fig2);
        }
        char ch = word.charAt(i);
        int x = (int)(ch-'A')/6;
        int y = (int)(ch-'A')%6;
        int dist1 = 0;
        int dist2 = 0;
        if(fig1=='\0'){
            dist1 = fun(word,i+1,ch,fig2,dp);
        }
        else{
            int x1 = (int)(fig1-'A')/6;
            int y1 = (int)(fig1-'A')%6;
            dist1 = (Math.abs(x-x1)+Math.abs(y-y1))+fun(word,i+1,ch,fig2,dp);
        }
        if(fig2=='\0'){
            dist2 = fun(word,i+1,fig1,ch,dp);
        }
        else{
            int x1 = (int)(fig2-'A')/6;
            int y1 = (int)(fig2-'A')%6;
            dist2 = (Math.abs(x-x1)+Math.abs(y-y1))+fun(word,i+1,fig1,ch,dp);
        }

        int min = Math.min(dist1,dist2);

        if(dp.get(i).containsKey(fig1)){
            dp.get(i).get(fig1).put(fig2,min);
        }
        else{
            dp.get(i).put(fig1,new HashMap<>());
            dp.get(i).get(fig1).put(fig2,min);
        }
        return min;
    }
    public int minimumDistance(String word) {
        List<HashMap<Character,HashMap<Character,Integer>>> dp = new ArrayList<>();
        for(int i=0;i<word.length();i++){
            dp.add(new HashMap<>());
        }
        return fun(word,0,'\0','\0',dp);
    }
}