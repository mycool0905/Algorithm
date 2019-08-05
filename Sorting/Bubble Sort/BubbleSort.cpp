#include <iostream>

using namespace std;

/* Bubble Sort(버블정렬)은 간단하다. */
/* 반복문 돌면서 두 개씩 비교하는데 큰 숫자가 앞에 있다면 */
/* 바로 뒤의 숫자와 swap 해준다. */

/* 버블 정렬의 시간 복잡도는 O(N^2) */

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
void bubbleSort(int arr[]) {

	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 9-i; j++) {
			/* 여기서 j는 왜 9-i까지 하느냐, */
			/* Bubble Sort는 한 회전마다 제일 큰 숫자를 맨 뒤로 보내면서 진행하는 정렬이다.*/
			/* 즉, 한 회전마다 어차피 맨 뒤 숫자가 제일 크니까 앞에 것들이랑 비교할 필요가 없다.*/
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