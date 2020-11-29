// https://www.codewars.com/kata/55cbd4ba903825f7970000f5

String getGrade(int a, int b, int c) {
  var mean = (a + b + c) / 3;
  String grade;
  if (mean >= 90)
    grade = 'A';
  else if (mean >= 80)
    grade = 'B';
  else if (mean >= 70)
    grade = 'C';
  else if (mean >= 60)
    grade = 'D';
  else
    grade = 'F';
  return grade;
}

void main() {
  print(getGrade(90, 90, 90));
}
