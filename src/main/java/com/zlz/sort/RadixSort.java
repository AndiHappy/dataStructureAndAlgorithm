package com.zlz.sort;

/**
 * @author zhailz
 * 基数排序的时间复杂度是O(k·n)，其中n是排序元素个数，k是数字位数。
 * 注意这不是说这个时间复杂度一定优于O(n·log(n))，k的大小取决于数字位的选择（比如比特位数），
 * 和待排序数据所属数据类型的全集的大小；k决定了进行多少轮处理，而n是每轮处理的操作数目。
 */
public class RadixSort {

	/**
	 * 基数排序的发明可以追溯到1887年赫尔曼·何乐礼在打孔卡片制表机(Tabulation Machine)上的贡献。
	 * 它是这样实现的：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，
	 * 从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
	 * 
	 * */
	// 求取的数组中最大数的位数
	public static int maxbit(int data[], int n) //辅助函数，求数据的最大位数
	{
		int maxData = data[0]; ///< 最大数
		/// 先求出最大数，再求其位数，这样有原先依次每个数判断其位数，稍微优化点。
		for (int i = 1; i < n; ++i) {
			if (maxData < data[i])
				maxData = data[i];
		}
		int d = 1;
		int p = 10;
		while (maxData >= p) {
			maxData /= 10;
			++d;
		}
		return d;
	}

	public static void radixsort(int data[], int n) //基数排序
	{
		int d = maxbit(data, n);
		int[] tmp = new int[n];
		int[] count = new int[10]; //计数器
		int i, j, k;
		int radix = 1;
		for (i = 1; i <= d; i++) //进行d次排序
		{
			for (j = 0; j < 10; j++)
				count[j] = 0; //每次分配前清空计数器
			for (j = 0; j < n; j++) {
				k = (data[j] / radix) % 10; //统计每个桶中的记录数
				count[k]++;
			}

			for (j = 1; j < 10; j++)
				count[j] = count[j - 1] + count[j]; //将tmp中的位置依次分配给每个桶
			for (j = n - 1; j >= 0; j--) //将所有桶中记录依次收集到tmp中
			{
				k = (data[j] / radix) % 10;
				tmp[count[k] - 1] = data[j];
				count[k]--;
			}
			for (j = 0; j < n; j++) //将临时数组的内容复制到data中
				data[j] = tmp[j];
			radix = radix * 10;
		}
	}

	public static void main(String[] args) {
		int[] data = { 73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100 };
		RadixSort.radixsort(data, 3);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ,");
		}
	}
}
