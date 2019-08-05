#include <iostream>
#define INF 987654321

using namespace std;

/* Insertion Sort(��������)�� �ݺ��� ���鼭 */
/* ���� ������ ���ϸ鼭 ������ ��ġ�� �����ϴ� ���̴�. */
/* ��� ������ ��ġ�� �����ϴ���? */
/* �ٸ� �迭�� �� �ڿ� �ְ� ������ ���鼭 �ٷ� ������ ������ ������ ���Ѵ�. */
/* �ٷ� ������ ������ ������ swap�ϰ� �ƴϸ� �ش� ȸ���� ��ٷ� stop�Ѵ�. */

/* �� ���� ������ ������ �����Ͱ� �̹� ���ĵǾ��ִٸ� � �˰��򺸴� ������. */
/* �ֳ��ϸ�, �̹� ���ĵǾ��ִٸ� ������ ������ �׻� ũ�⶧����, ��ٷ� stop�Ѵ�. */
/* �׷��� �̹� ���ĵǾ� �ִٸ�, O(N)�� �ð����� ������ ���� �� �ִ�. */

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