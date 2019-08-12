#include <iostream>
#include <algorithm>

using namespace std;

/* C++������ �̹� sort�� ���� �� �����Ǿ� �ִ�. */
/* ������ ���� �ð����� �����Ǿ� �����Ƿ�, ���� © �ʿ���� ���� sort�� �������. */
/* algorithm ����� ������, ����Ʈ�δ� �������� ������ �����Ѵ�. */
/* 3���� ������ ������ �ִ�, ����ü�� �񱳸� �غ���. */
/* 1. ������ ���� ���, 2. �̸��� ���� ���� �տ� �ִ� ��� */
/* �����غ��ڸ�, 1. sort()�� 3��° ���ڷ� bool compare() �ֱ� */
/* 2. Ŭ���� ������ bool operator<() ��ġ�� */

typedef struct student {
	string name;
	int score;
	int id;
}student;

bool compare(student a, student b) {

	if (a.score == b.score)
		return a.name < b.name;
	else
		return a.score > b.score;
}

void printArray(student studentArray[]) {
	for (int i = 0; i < 10; i++)
		cout << studentArray[i].name << " " << studentArray[i].score << " " << studentArray[i].id << "\n";
}

int main() {

	student studentArray[] = {
	{"A",99,15},
	{"B",70,20},
	{"C",85,25},
	{"D",65,30},
	{"E",20,35},
	{"F",75,40},
	{"G",90,45},
	{"H",99,50},
	{"I",30,55},
	{"J",65,60}
	};

	sort(studentArray, studentArray + 10, compare);
	printArray(studentArray);

	return 0;
}