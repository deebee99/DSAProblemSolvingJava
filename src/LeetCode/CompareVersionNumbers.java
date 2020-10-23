package LeetCode;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if(version1.equals(version2)) return 0;
        String[] version1Set =version1.split("\\.");
        String[] version2Set =version2.split("\\.");
        int i=0,j=0;
       System.out.println(version1Set.length+ " "+version2Set.length);
        while(i<version1Set.length && j<version2Set.length){
            Integer v1=Integer.parseInt(version1Set[i++]);
            Integer v2=Integer.parseInt(version2Set[j++]);
           System.out.println(v1 + " "+v2);
            int result =v1.compareTo(v2);
            if(result<0) return -1;
            if(result>0) return 1;
        }
        System.out.println(i+" "+j);
        if(i==version1Set.length && j==version2Set.length) return 0;
        else if(i==version1Set.length){
            while(j<version2Set.length){
                int v2=Integer.parseInt(version2Set[j]);
                if(v2!=0) break;
                j++;
            }
            if(j == version2Set.length) return 0;
            else return -1;
        }
        else{
            while(i<version1Set.length){
                int v1=Integer.parseInt(version1Set[i]);
                if(v1!=0) break;
                i++;
            }
            if(i==version1Set.length) return 0;
            else return 1;
        }

    }

    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers().compareVersion("1.0.0.0.0.0.0.3","1.0.0"));
    }
}
