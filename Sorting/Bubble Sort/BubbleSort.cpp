#include <iostream>

using namespace std;

/* Bubble Sort(��������)�� �����ϴ�. */
/* �ݺ��� ���鼭 �� ���� ���ϴµ� ū ���ڰ� �տ� �ִٸ� */
/* �ٷ� ���� ���ڿ� swap ���ش�. */

/* ���� ������ �ð� ���⵵�� O(N^2) */

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
void bubbleSort(int arr[]) {

	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 9-i; j++) {
			/* ���⼭ j�� �� 9-i���� �ϴ���, */
			/* Bubble Sort�� �� ȸ������ ���� ū ���ڸ� �� �ڷ� �����鼭 �����ϴ� �����̴�.*/
			/* ��, �� ȸ������ ������ �� �� ���ڰ� ���� ũ�ϱ� �տ� �͵��̶� ���� �ʿ䰡 ����.*/
			if (arr[j] > arr[j+1]) {
				swap(arr[j], arr[j + 1]);
			}
		}
	}

	printArray(arr);
}

int main() {

	int arr[10] = { 1, 10, 5, 8, 7, 6 ,4 ,3 ,2 ,9 };

	bubbleSort(arr);

	return 0;
}