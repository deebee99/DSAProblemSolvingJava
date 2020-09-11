public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int n=secret.length();
        int bulls=0,cows=0;
        int freq[]=new int[11];
        for(char ch : secret.toCharArray()) freq[ch-'0']++;

        for(int i=0;i<n;i++){
            final char ch = guess.charAt(i);
            if(secret.charAt(i)==ch){
             bulls++;
             freq[ch-'0']--;
            }
            else{
                if(freq[ch-'0']>0){
                    freq[ch-'0']--;
                    cows++;
                }
            }
        }
        String result=Integer.toString(bulls)+'A'+Integer.toString(cows)+'B';
        return result;
    }
}
