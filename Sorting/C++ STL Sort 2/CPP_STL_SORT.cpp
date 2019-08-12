#include <iostream>
#include <algorithm>

using namespace std;

/* C++에서는 이미 sort가 아주 잘 구현되어 있다. */
/* 최적의 실행 시간으로 구현되어 있으므로, 굳이 짤 필요없을 때는 sort를 사용하자. */
/* algorithm 헤더에 있으며, 디폴트로는 오름차순 정렬을 실행한다. */
/* 3가지 변수를 가지고 있는, 구조체의 비교를 해보자. */
/* 1. 성적이 높은 사람, 2. 이름이 사전 순에 앞에 있는 사람 */
/* 정리해보자면, 1. sort()의 3번째 인자로 bool compare() 넣기 */
/* 2. 클래스 내부의 bool operator<() 고치기 */

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