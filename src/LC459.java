/**
 * 459. 重复的子字符串
 *
 * @author zhangzhb
 * @create 2018/4/14 15:53
 **/
public class LC459 {
    public static void main(String[] args) {
        //System.out.println(repeatedSubstringPattern("ababab"));
        System.out.println(repeatedSubstringPattern("abaababaab"));
    }

    public static boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        for(int i = 1; i <= n / 2; i++){
            if(n % i != 0) continue;
            String refer = s.substring(0, i);
            int a = 1;
            for(int j = i; j < n; j = j + i){
                String tmp = s.substring(j, j+i);
                if(!refer.equals(tmp)){
                    a = 0;
                    break;
                }
            }
            if(a == 1) return true;
        }
        return false;
    }

    public static boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        String cstr = "";
        String tstr = "";
        //如果长度说明不行
        int i,j;
        for(i=1;i<=l/2;i++){
            //长度不整除则不行
            if(l%i!=0) continue;
            cstr = s.substring(0,i);
            for(j=i;j<l;j+=i){
                tstr = s.substring(j,j+i);
                if(!cstr.equals(tstr)){
                    break;
                }
            }
            if(j>=l){
                return true;
            }
        }
        return false;
    }
}
