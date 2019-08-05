#include <iostream>
#define INF 987654321

using namespace std;

/* Quick Sort(������) ��ǥ���� ���� ���� ���� �˰����̴�. */
/* �� ������ pivot�̶�� ���� �̿��Ѵ�.*/
/* pivot�� �����Ͽ� pivot ���� ū ���� �迭�� ���ʿ������� ã��, */
/* pivot ���� ���� ���� �迭�� �����ʿ������� ã�´�. */
/* �׷��ٰ� ���� pivot���� ũ�� �������� ã�ƹ����� �� �� ���� �״�� swap�Ѵ�. */
/* �׷� ������ ���� ���� ��� �����Ѵ�. �׷��ٰ� ���ʿ��� ����� �Ͱ� �����ʿ��� ����� ���� �����ϸ�, */
/* �׶�, �ǹ� ���� ���� ������ swap�Ѵ�.*/
/* �׸���� �� ���������� �߽����� 2���� �����Ͽ� ���� ���� ���� ������ �ǽ��Ѵ�.*/

/* �� ������ �ð� ���⵵�� O(N*logN) */

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

	/* �ߴ� ���� */
	if (left >= right)
		return;

	/* i�� pivot�� ������ ū ��, j�� pivot�� ������ ���� �� ã�� ���̴�.*/
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
		
		/* ã�Ҵµ� i�� j�� ���� �������� �ʾ����� i�� j swap*/
		if (i <= j)
			swap(arr[i], arr[j]);
		/* ã�Ҵµ� �̹� i�� j�� ���������� j(pivot ������ ���� ��)�� pivot swap*/
		else
			swap(arr[pivotPoint], arr[j]);
	}

	/* pivot�� swap�� j�� �߽����� ����, ���������� �����Ͽ� ���� */
	quickSort(arr, left, j-1);
	quickSort(arr, j + 1, right);
}

int main() {

	int arr[10] = { 1, 10, 5, 8, 7, 6 ,4 ,3 ,2 ,9 };
	quickSort(arr,0,9);

	printArray(arr);

	return 0;
}