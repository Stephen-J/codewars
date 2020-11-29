// https://www.codewars.com/kata/525f50e3b73515a6db000b83

String createPhoneNumber(List numbers) {
  StringBuffer b = StringBuffer();
  b.write("(");
  b.write(numbers[0]);
  b.write(numbers[1]);
  b.write(numbers[2]);
  b.write(")");
  b.write(" ");
  b.write(numbers[3]);
  b.write(numbers[4]);
  b.write(numbers[5]);
  b.write("-");
  b.write(numbers[6]);
  b.write(numbers[7]);
  b.write(numbers[8]);
  b.write(numbers[9]);
  return b.toString();
}

void main() {
  print(createPhoneNumber([1, 2, 3, 4, 5, 6, 1, 1, 1, 1]));
}
