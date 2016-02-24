//Given an integer between 0 and 999,999 print an english phrase  that describes the integer 
//{1234 --->  One Thousand, Two Hundred and Thirty Four  }

public class NumberConvertor {

    public String IntegerToString(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder result = new StringBuilder();
        String[] level = {"", " Thousand,"};
        int[] nums = new int[4];
        for (int i = 0; i < 2 && num != 0; i++) {
            nums[i] = num % 1000;
            num /= 1000;
        }
        for (int i = 1; i >= 0; i--) {
            String tmp = threeDigit(nums[i]);
            if (!tmp.equals("")) {
                result.append(tmp).append(level[i]);
            }
        }
        return result.delete(0, 1).toString();
    }

    public String threeDigit(int num) {
        if (num < 10) {
            return oneDigit(num);
        }
        if (num < 100) {
            return twoDigit(num);
        }
        return oneDigit(num / 100) + " Hundred and" + twoDigit(num % 100);
    }

    public String twoDigit(int num) {
        if (num < 10) {
            return oneDigit(num);
        }
        String[] nums = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        if (num < 20) {
            return nums[num - 10];
        }
        String[] tys = {" Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
        return tys[num / 10 - 2] + oneDigit(num % 10);
    }

    public String oneDigit(int num) {
        String[] nums = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
        return nums[num];
    }

    public static void main(String[] args) {
        NumberConvertor a = new NumberConvertor();
        System.out.println(a.IntegerToString(999999));
    }
}
