#include <iostream>
#include <algorithm>

using namespace std;

/* C++������ �̹� sort�� ���� �� �����Ǿ� �ִ�. */
/* ������ ���� �ð����� �����Ǿ� �����Ƿ�, ���� © �ʿ���� ���� sort�� �������. */
/* algorithm ����� ������, ����Ʈ�δ� �������� ������ �����Ѵ�. */

class Student {
public:
	string name;
	int score;

	Student(string name, int score) {
		this->name = name;
		this->score = score;
	}

	/* ���� ���� : '������ ���� ����' */
	bool operator <(Student student) {
		return this->score < student.score;
	}

	/* ���� ���� : '�̸��� ���� ����' */
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
	/* ���� : ���� �ּ�, �� �ּ� �Է� */
	/* �Ʒ������� �� 10���� ���ڸ� �����ϴµ�, */
	/* 0 �̻� 10 �̸��� �ε����� �����Ѵ�. */
	sort(arr1, arr1 + 10);
	printArray(arr1);

	/* ����Ʈ�� ������������ �Ǿ� �ִµ�,*/
	/* ���� bool compare ó�� ���ʿ� �� ū ���� ���� �� �ֵ��� �ϸ�,*/
	/* �������� ������ �����ϴ�. */
	sort(arr2, arr2 + 10, compare);
	printArray(arr2);

	/* ����, Ŭ������ �ִ� �Ӽ����� �ϳ��� ���� ������ �����ϴ�. */
	/* operaotr< �Լ��� �������Ͽ�, ���Ŀ� Ȱ��� ������ �������� ������ �����ϴ�. */
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