#include <iostream>
#define INF 987654321

using namespace std;

/* Merge Sort(��������) ��ǥ���� ���� ���� ���� �˰����̴�. */
/* ���� ������ �ϴ� �迭�� �� �ݾ����� �ɰ��鼭 �ϳ��� ���� ������ �ɰ���.*/
/* �׸��� ��ġ�鼭 �迭�� �����ϴ� ���̴�. */
/* ���� ��� �� ���� Left �迭�� Right �迭�� ������, */
/* Left �迭�� ���� ���ʰ� Right �迭�� ���� ������ ���� ��, �� ���� ���� ���ο� �迭�� ä���. */
/* ���� �� ��, Right �迭�� ���� ������ ���� �۾�����, Right �迭�� ����Ű�� �ε����� �ϳ� �ø���.  */
/* �̷��� ��� �迭�� �ε������� ���Ѵ�. */
/* �׸��� Left�� Right�� �迭���� �� ��������, ä������ �迭�� Return �ϸ鼭 ��� ��ģ��. */
/* ���� ������ ��� ��쿡�� �־��� �ð��� N*logN�� �����ϴ� ȿ������ ���� �˰����̴�. */

/* ���� ������ �ð� ���⵵�� O(N*logN) */

int tempArray[10];

void printArray(int arr[]) {
	for (int i = 0; i < 10; i++)
		cout << arr[i] << " ";
	cout << "\n";
}

/* ���� �ܰ� */
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

/* ���� �ܰ� & ���� �ܰ� */
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