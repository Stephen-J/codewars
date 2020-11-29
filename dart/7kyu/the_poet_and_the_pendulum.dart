// https://www.codewars.com/kata/5bd776533a7e2720c40000e5

List<int> pendulum(values) {
  values.sort();
  List<int> result = List<int>(values.length);
  bool dir = false;
  int index =
      (values.length % 2 == 0 ? (values.length - 1) / 2 : values.length / 2)
          .truncate();
  result[index] = values[0];
  for (int i = 0; i < values.length; i++) {
    index = dir ? index + i * 1 : index + i * -1;
    result[index] = values[i];
    dir = !dir;
  }
  return result;
}

void main() {
  print((100 - 1) / 2);
  print((3.5).truncate());
  print(3 / 2);
  print(pendulum([4, 10, 9]));
  print(pendulum([8, 7, 10, 3]));
}
