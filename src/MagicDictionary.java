import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class MagicDictionary {
    HashSet<String> set=new HashSet<>();
    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
    for(String s : dictionary){
  set.add(s);
    }
    Iterator it=set.iterator();
    while(it.hasNext()) System.out.print(" "+it.next());
    }

    public boolean search(String searchWord) {
        if(searchWord.length()==0) return false;
        char r[]=searchWord.toCharArray();
    for(int i=0;i<searchWord.length();i++){
        for(int j=0;j<26;j++) {
            char ch=(char) ('a'+j);
            if(ch==r[i]) continue;
            r[i]= ch;
            if(set.contains(new String(r))) return true;
            r[i]=searchWord.charAt(i);
        }
    }
    return false;
    }
}
