// https://www.codewars.com/kata/5a58ca28e626c55ae000018a
//Calculate the area of a regular n sides polygon inside a circle of radius r
import 'dart:math';

double calcArea(double hypotenuse, double angle) {
  double rad = (angle * pi) / 180;
  double adjacent = cos(rad) * hypotenuse;
  double base = sin(rad) * hypotenuse * 2;
  return adjacent * base / 2;
}

double areaOfPolygonInsideCircle(double circleRadius, int numberOfSides) {
  double area = calcArea(circleRadius, 360 / numberOfSides / 2) * numberOfSides;
  return double.parse(area.toStringAsFixed(3));
}

void main() {
  print(areaOfPolygonInsideCircle(3.0, 3)); // 11.691
  print(areaOfPolygonInsideCircle(5.8, 7)); // 92.053
}
