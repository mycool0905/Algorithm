#include <iostream>
#define INF 987654321

using namespace std;

/* Selction Sort(선택정렬)에는 두 가지 방법이 있다. */
/* 첫 번째는 다른 배열에 선택적으로 채워 넣는 not in-place 방식*/
/* 두 번째는 SWAP을 이용하여 자신의 배열에 그대로 넣는 in-place 방식*/

void printArray(int arr[]) {
	for (int i = 0; i < 10; i++)
		cout << arr[i] << " ";
	cout << "\n";
}

/* 다른 1차원 배열에 채우면서 소팅 */
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

/* 자기 배열의 내부에서 소팅 */
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