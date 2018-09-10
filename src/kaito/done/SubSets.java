package kaito.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 求一个集合的所有子集（含自己）
 *
 * @author kaito
 * @date 2018/8/19 下午9:37
 */
public class SubSets {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4};
//        subsets(im).forEach(System.out::print);
        subsetsRecursive(test).forEach(System.out::println);
    }
    /**
     * 非递归思想
     * 假设有 1，2，3 个数字
     * 用1代表加入集合，0代表不加入集合
     * 则有 000、001、010、011、100、101、110、111 （2^3 = 8 种结果）
     * 根据 0 ~ size 根据位运算进行叠加进行遍历得到上述组合
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        //原始集合去重
        List<Integer> collect = Arrays.stream(nums).distinct().boxed().collect(Collectors.toList());
        //结果个数
        int resultCount = (int) Math.pow(2, collect.size());
        List<List<Integer>> lists = new ArrayList<>(resultCount);
        int init = 0;
        /**
         * 循环思想：
         * 假设本结果集为 1101 ，for 0 to 3
         * 应该把 0，1，2，3 分别对1、1、0、1 进行比对是否相同
         * 这里我们比对最低位：比如 1101 & 1 = 1 代表 最低位可以用于加入集合。
         * 处理后，1101 >>1 = 110 了，此时进行 110 & 1 代表比较第二位是否可以加入集合。
         */
        while (init < resultCount) {
            int order = init;
            List<Integer> list = new ArrayList<>();
            for (Integer aCollect : collect) {
                if ((order & 1) == 1) {
                    list.add(aCollect);
                }
                order >>= 1;
            }
            lists.add(list);
            init++;
        }
        return lists;
    }
    /**
     * 递归思想
     * 1，2，3，4:由 1 和 2，3，4 组成
     * 2，3，4:由 2 和 3，4 组成
     * 3，4:由 3 和 4 组成
     * 同理：
     * 1,2,3,4 :由 2 和 1，3，4 组成
     * …………………………
     * <p>
     * 目前这样迭代，会导致重复元素的出现
     * 如：1，3，4 与 2，3，4 都能拆出 3，4 的集合
     * ——————
     * 递归思路 2：
     * 1
     * 12
     * 123
     * 1234
     * 13
     * 134
     * 14
     * 2
     * 23
     * 234
     * 24
     * 3
     * 34
     * 4
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsRecursive(int[] nums) {
        //原始集合去重
        List<Integer> collect = Arrays.stream(nums).distinct().boxed().collect(Collectors.toList());
        List<List<Integer>> results = new ArrayList<>();
        int index = 0;
        subsets(collect, results, index, new ArrayList<>());
        results.add(Collections.emptyList());
        return results;
    }

    public static void subsets(List<Integer> collect, List<List<Integer>> results, int index, List<Integer> subList) {
        for (int i = index; i < collect.size(); i++) {
            subList.add(collect.get(i));
            results.add(new ArrayList<>(subList));
            if (index + 1 == i) {
                index++;
            }
            if (index + 1 < collect.size()) {
                subsets(collect, results, index + 1, subList);
            }
            subList.remove(subList.size() - 1);
        }
    }
}
