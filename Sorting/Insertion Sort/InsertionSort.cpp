#include <iostream>
#define INF 987654321

using namespace std;

/* Insertion Sort(삽입정렬)은 반복문 돌면서 */
/* 기존 값들을 비교하면서 적절한 위치에 삽입하는 것이다. */
/* 어떻게 적절한 위치에 삽입하느냐? */
/* 다른 배열에 맨 뒤에 넣고 앞으로 가면서 바로 직전의 값보다 작은지 비교한다. */
/* 바로 직전의 값보다 작으면 swap하고 아니면 해당 회전을 곧바로 stop한다. */

/* 이 삽입 정렬의 장점은 데이터가 이미 정렬되어있다면 어떤 알고리즘보다 빠르다. */
/* 왜냐하면, 이미 정렬되어있다면 직전의 값보다 항상 크기때문에, 곧바로 stop한다. */
/* 그래서 이미 정렬되어 있다면, O(N)의 시간으로 정렬을 끝낼 수 있다. */

/* 삽입 정렬의 시간 복잡도는 O(N^2) */

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
void insertionSort(int arr[]) {
	
	int tempArray[10];

	for (int i = 0; i < 10; i++) {
		tempArray[i] = arr[i];
		for (int j = i; j > 0 && tempArray[j-1] > tempArray[j]; j--) {
			swap(tempArray[j - 1], tempArray[j]);
		}
	}

	printArray(arr);
}

int main() {

	int arr[10] = { 1, 10, 5, 8, 7, 6 ,4 ,3 ,2 ,9 };
	insertionSort(arr);
	
	return 0;
}