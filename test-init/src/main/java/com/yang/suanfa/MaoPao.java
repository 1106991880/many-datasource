package com.yang.suanfa;

// 冒泡排序算法
// 基本思想: 冒泡排序，类似于水中冒泡，较大的数沉下去，
// 较小的数慢慢冒起来，假设从小到大，即为较大的数慢慢往后排，较小的数慢慢往前排。
// 直观表达，每一趟遍历，将一个最大的数移到序列末尾。】
// 时间复杂度: O(N^2)
// 空间复杂度: O(1)
// 稳定性：稳定
// 选择排序
public class MaoPao {
    public static void main(String[] args) {
        int arr[] = new int[]{5, 2, 3, 9, 8, 1};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int selectArr[] = new int[]{5, 2, 3, 9, 8, 1};
        selectSort(selectArr);
        System.out.println("====================================================");
        for (int i = 0; i < selectArr.length; i++) {
            System.out.println(selectArr[i]);
        }
    }

    // 冒泡排序算法
    private static void bubbleSort(int[] arr) {
        int length = arr.length;
        // 排除不需要排序的情况
        if (arr == null || length < 2) {
            return;
        }
        // int arr[] = new int[]{5, 2, 3, 9, 8, 1};
        // 第一次循环：将第一个和第二个比较 大的放在后面 小的放在前面 然后将第二个又和第三个比较 第三个和第四个比较 以此类推
        // 第一次循环结果 253981-235981-235891-235819
        // 第二次循环结果 235189
        // 第三次循环结果 231589
        // 第四次循环结果 213589
        // 第五次循环结果 123589
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {// 每一轮比较它一定会把最大的一个数放在最后一位
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i; // 记录最小元素位置
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j; // 更换最小元素位置
                }
            }
            if (min != i) {
                swap(arr, i, min); // 与第i个位置进行交换
            }
        }
    }

    private static void swap(int[] arr, int i, int min) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

}
