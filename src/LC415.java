/**
 * 415. 字符串相加
 *
 * @author zhangzhb
 * @create 2018/4/19 12:57
 **/
public class LC415 {
    public static void main(String[] args) {
        System.out.println(addStrings("9","99"));
    }

    public static String addStrings(String num1, String num2) {
        char[] char1s = num1.toCharArray();
        char[] char2s = num2.toCharArray();

        int c1l = char1s.length;
        int c2l = char2s.length;

        int maxl = c1l>c2l?c1l:c2l;

        int[] num1s = new int[maxl+1];
        int[] num2s = new int[maxl+1];

        int[] sum = new int[maxl+1];

        boolean flag = false;
        int n = 0;
        StringBuilder stringBuilder=new StringBuilder(maxl+1);
        for(int i=1;i<=maxl+1;i++){
            if((c1l-i)>=0){
                num1s[maxl+1-i] = char1s[c1l-i]-'0';
            }else{
                num1s[maxl+1-i] = 0;
            }

            if((c2l-i)>=0){
                num2s[maxl+1-i] = char2s[c2l-i]-'0';
            }else{
                num2s[maxl+1-i] = 0;
            }

            n = num1s[maxl+1-i] + num2s[maxl+1-i];
            if(flag){
                n++;
            }
            if(n>9){
                n = n%10;
                flag = true;
            }else{
                flag = false;
            }
            sum[maxl+1-i] = n;
            stringBuilder.append(n);
        }
        if(sum[0]==0){
            stringBuilder.deleteCharAt(maxl);
        }
        stringBuilder.reverse();

        return stringBuilder.toString();

    }
}
