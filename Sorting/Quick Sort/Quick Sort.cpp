#include <iostream>
#define INF 987654321

using namespace std;

/* Quick Sort(퀵정렬) 대표적인 분할 정복 정렬 알고리즘이다. */
/* 퀵 정렬은 pivot이라는 것을 이용한다.*/
/* pivot을 설정하여 pivot 보다 큰 값을 배열의 왼쪽에서부터 찾고, */
/* pivot 보다 작은 값을 배열의 오른쪽에서부터 찾는다. */
/* 그러다가 각자 pivot보다 크고 작은것을 찾아버리면 그 두 개를 그대로 swap한다. */
/* 그런 다음에 위와 같이 계속 진행한다. 그러다가 왼쪽에서 출발한 것과 오른쪽에서 출발한 것이 교차하면, */
/* 그때, 피벗 값과 교차 지점을 swap한다.*/
/* 그리고는 그 교차지점을 중심으로 2개로 분할하여 위와 같이 분할 정복을 실시한다.*/

/* 퀵 정렬의 시간 복잡도는 O(N*logN) */

void printArray(int arr[]) {
	for (int i = 0; i < 10; i++)
		cout << arr[i] << " ";
	cout << "\n";
}

void swap(int* a, int* b) {
	int temp;

	temp = *a;
	*a = *b;
	*b = temp;
}

void quickSort(int arr[], int left, int right) {
	int i = left + 1;
	int j = right;
	int pivotPoint = left;
	int pivot = arr[pivotPoint];

	/* 중단 조건 */
	if (left >= right)
		return;

	/* i는 pivot의 값보다 큰 거, j는 pivot의 값보다 작은 거 찾는 중이다.*/
	while (i <= j) {
		while (i <= right) {
			if (pivot <= arr[i])
				break;
			i++;
		}
		while (j >= left) {
			if (pivot >= arr[j])
				break;
			j--;
		}
		
		/* 찾았는데 i와 j가 아직 교차하지 않았으면 i와 j swap*/
		if (i <= j)
			swap(arr[i], arr[j]);
		/* 찾았는데 이미 i와 j가 교차했으면 j(pivot 값보다 작은 값)와 pivot swap*/
		else
			swap(arr[pivotPoint], arr[j]);
	}

	/* pivot과 swap한 j를 중심으로 왼쪽, 오른쪽으로 분할하여 정렬 */
	quickSort(arr, left, j-1);
	quickSort(arr, j + 1, right);
}

int main() {

	int arr[10] = { 1, 10, 5, 8, 7, 6 ,4 ,3 ,2 ,9 };
	quickSort(arr,0,9);

	printArray(arr);

	return 0;
}