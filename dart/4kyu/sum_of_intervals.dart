// https://www.codewars.com/kata/52b7ed099cdc285c300001cd

import 'dart:math';

int sumOfIntervals(List<List<int>> intervals) {
  intervals.sort((a, b) {
    return a[0] - b[0];
  });
  List<List<int>> combined = intervals.skip(1).fold([intervals.first], (a, b) {
    if (a.last[1] >= b[0] && a.last[1] < b[1]) {
      a.last[1] = b[1];
    } else if (a.last[1] < b[0]) {
      a.add(b);
    }
    return a;
  });
  return combined.fold(0, (a, b) => a + b.last - b.first);
}

void main() {
  print(sumOfIntervals([
    [171, 396],
    [-439, 8],
    [484, 500],
    [89, 397],
    [-249, -172],
    [-419, -313],
    [189, 288],
    [-25, 102],
    [397, 465],
    [-265, 256],
    [-205, 109],
    [-328, 319],
    [427, 448]
  ])); // 920
  print(sumOfIntervals([
    [158, 278],
    [56, 326],
    [177, 489],
    [-224, 104],
    [-343, -7],
    [341, 439],
    [-267, -265],
    [-84, 242]
  ])); //832
  print(sumOfIntervals([
    [1, 5]
  ])); //, equals(4)));
  print(sumOfIntervals([
    [1, 5],
    [6, 10]
  ])); //, equals(8)));
  print(sumOfIntervals([
    [1, 5],
    [1, 5]
  ])); //, equals(4)));
  print(sumOfIntervals([
    [1, 4],
    [7, 10],
    [3, 5],
  ])); // equals(7)));
  /* print(sumOfIntervals([
    [158, 278],
    [56, 326],
    [177, 489],
    [-224, 104],
    [-343, -7],
    [341, 439],
    [-267, -265],
    [-84, 242]
  ]));*/ // 832
/*  print(sumOfIntervals([
    [307, 371],
    [176, 207],
    [312, 354],
    [-134, 100],
    [-158, 68],
    [-427, 435],
    [-29, 78],
    [-378, 448],
    [-309, -44],
    [-430, 457],
    [414, 464],
    [-401, 368],
    [-24, 174],
    [-497, 219],
    [-20, 66],
    [131, 438]
  ]));*/ // 961
}
