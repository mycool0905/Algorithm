#include <iostream>
#define INF 987654321

using namespace std;

/* Bubble Sort(��������)�� �����ϴ�. */
/* �ݺ��� ���鼭 �� ���� ���ϴµ� ū ���ڰ� �տ� �ִٸ� */
/* �ٷ� ���� ���ڿ� swap ���ش�. */

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

/* �ڱ� �迭�� ���ο��� ���� */
void selectionSort2(int arr[]) {
	int min;
	int index = 0;

	for (int i = 0; i < 10; i++) {
		min = INF;
		for (int j = i; j < 10; j++) {
			if (arr[j] < min) {
				min = arr[j];
				index = j;
			}
		}
		swap(arr[i], arr[index]);
	}

	printArray(arr);
}

int main() {

	int arr1[10] = { 1, 10, 5, 8, 7, 6 ,4 ,3 ,2 ,9 };
	int arr2[10] = { 1, 10, 5, 8, 7, 6 ,4 ,3 ,2 ,9 };
	selectionSort1(arr1);
	selectionSort2(arr2);

	return 0;
}