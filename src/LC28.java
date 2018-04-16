/**
 * 28. 实现strStr()
 *
 * @author zhangzhb
 * @create 2018/4/16 12:43
 **/
public class LC28 {
    public static void main(String[] args) {
        System.out.println(strStr("djalkhfdjhg","hg"));
    }
    public static int strStr(String haystack, String needle) {
        //如果是空
        if(needle==null||needle.length()==0) return 0;
        int nl = needle.length();
        int hl = haystack.length();
        //如果子串比父串长
        if(nl > hl) return -1;
        //如果子串和父串长度相等
        if(nl == hl){
            if(haystack.equals(needle)){
                return 0;
            }else{
                return -1;
            }
        }
        String tstr = "";
        int i;
        for(i=0;i<=hl-nl;i++){
            tstr = haystack.substring(i,i+nl);
            if(needle.equals(tstr)) return i;
        }
        if(i>=(hl-nl)){
            return -1;
        }
        return 0;

    }
}
