#include <iostream>
#define INF 987654321

using namespace std;

/* Bubble Sort(버블정렬)은 간단하다. */
/* 반복문 돌면서 두 개씩 비교하는데 큰 숫자가 앞에 있다면 */
/* 바로 뒤의 숫자와 swap 해준다. */

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

/* 자기 배열의 내부에서 소팅 */
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