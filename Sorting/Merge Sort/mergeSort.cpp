#include <iostream>
#define INF 987654321

using namespace std;

/* Merge Sort(병합정렬) 대표적인 분할 정복 정렬 알고리즘이다. */
/* 병합 정렬은 일단 배열을 다 반씩으로 쪼개면서 하나씩 남을 때까지 쪼갠다.*/
/* 그리고 합치면서 배열을 정렬하는 것이다. */
/* 예를 들어 두 개의 Left 배열과 Right 배열이 있으면, */
/* Left 배열의 제일 왼쪽과 Right 배열의 제일 왼쪽을 비교한 후, 더 작은 것을 새로운 배열에 채운다. */
/* 만약 이 때, Right 배열의 제일 왼쪽이 제일 작았으면, Right 배열을 가리키는 인덱스를 하나 늘린다.  */
/* 이렇게 계속 배열의 인덱스들을 비교한다. */
/* 그리고 Left와 Right의 배열들을 다 합쳤으면, 채워놓은 배열을 Return 하면서 계속 합친다. */
/* 병렬 정렬은 어떠한 경우에도 최악의 시간을 N*logN을 보장하는 효율적인 정렬 알고리즘이다. */

/* 병합 정렬의 시간 복잡도는 O(N*logN) */

int tempArray[10];

void printArray(int arr[]) {
	for (int i = 0; i < 10; i++)
		cout << arr[i] << " ";
	cout << "\n";
}

/* 병합 단계 */
void merge(int arr[], int left, int mid, int right) {
	int i = left;
	int j = mid + 1;
	int count = left;

	while (i <= mid && j <= right) {
		if (arr[i] <= arr[j])
			tempArray[count] = arr[i++];
		else
			tempArray[count] = arr[j++];
		
		count++;
	}

	if (i <= mid)
		while (i <= mid)
			tempArray[count++] = arr[i++];
	else
		while (j <= right)
			tempArray[count++] = arr[j++];

	for (int k = left; k <= right; k++) {
		arr[k] = tempArray[k];
	}
	
}

/* 분할 단계 & 정렬 단계 */
void mergeSort(int arr[], int left, int right) {

	if (left < right) {
		int mid = (left + right) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merge(arr,left,mid,right);
	}
}

int main() {

	int arr[10] = { 1, 10, 5, 8, 7, 6 ,4 ,3 ,2 ,9 };
	
	mergeSort(arr, 0, 9);

	printArray(arr);

	return 0;
}