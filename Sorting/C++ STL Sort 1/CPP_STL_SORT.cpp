#include <iostream>
#include <algorithm>

using namespace std;

/* C++에서는 이미 sort가 아주 잘 구현되어 있다. */
/* 최적의 실행 시간으로 구현되어 있으므로, 굳이 짤 필요없을 때는 sort를 사용하자. */
/* algorithm 헤더에 있으며, 디폴트로는 오름차순 정렬을 실행한다. */

class Student {
public:
	string name;
	int score;

	Student(string name, int score) {
		this->name = name;
		this->score = score;
	}

	/* 정렬 기준 : '점수가 작은 순서' */
	bool operator <(Student student) {
		return this->score < student.score;
	}

	/* 정렬 기준 : '이름이 사전 역순' */
	bool operator <(Student student) {
		return this->name > student.name;
	}

};


void printArray(int arr[]) {
	for (int i = 0; i < 10; i++)
		cout << arr[i] << " ";
	cout << "\n";
}

void printStudentArray(Student student[]) {
	for (int i = 0; i < 7; i++) 
		cout << student[i].name << " : " << student[i].score << "\n";
}

bool compare(int a, int b) {
	return a > b;
}

int main() {

	int arr1[10] = { 1, 10, 5, 8, 7, 6 ,4 ,3 ,2 ,9 };
	int arr2[10] = { 1, 10, 5, 8, 7, 6 ,4 ,3 ,2 ,9 };
	/* 사용법 : 시작 주소, 끝 주소 입력 */
	/* 아래에서는 총 10개의 숫자를 정렬하는데, */
	/* 0 이상 10 미만의 인덱스를 정렬한다. */
	sort(arr1, arr1 + 10);
	printArray(arr1);

	/* 디폴트가 오름차순으로 되어 있는데,*/
	/* 위의 bool compare 처럼 왼쪽에 더 큰 것을 놓을 수 있도록 하면,*/
	/* 내림차순 정렬이 가능하다. */
	sort(arr2, arr2 + 10, compare);
	printArray(arr2);

	/* 또한, 클래스에 있는 속성들중 하나의 값도 정렬이 가능하다. */
	/* operaotr< 함수를 재정의하여, 정렬에 활용될 변수를 기준으로 정렬이 가능하다. */
	Student student[] = {
		Student("A",99),
		Student("B",70),
		Student("C",81),
		Student("D",41),
		Student("E",77),
		Student("F",11),
		Student("G",75)
	};

	sort(student, student + 7);
	printStudentArray(student);

	return 0;
}