#include <iostream>
#define INF 987654321

using namespace std;

/* Selction Sort(��������)���� �� ���� ����� �ִ�. */
/* ù ��°�� �ٸ� �迭�� ���������� ä�� �ִ� not in-place ���*/
/* �� ��°�� SWAP�� �̿��Ͽ� �ڽ��� �迭�� �״�� �ִ� in-place ���*/

void printArray(int arr[]) {
	for (int i = 0; i < 10; i++)
		cout << arr[i] << " ";
	cout << "\n";
}

/* �ٸ� 1���� �迭�� ä��鼭 ���� */
void selectionSort1(int arr[]) {
	int tempArr[10];
	int min;
	int index;

	for (int i = 0; i < 10; i++) {
		min = INF;
		for (int j = 0; j < 10; j++) {
			if (arr[j] < min) {
				min = arr[j];
				index = j;
			}
		}
		tempArr[i] = min;
		arr[index] = INF;
	}

	printArray(tempArr);

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
	int index=0;

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