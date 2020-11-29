// https://www.codewars.com/kata/5868a68ba44cfc763e00008d/dart
//Esolang Interpreters #3 - Custom Paintf**k Interpreter

class Memory {
  final int width;
  final int height;
  List<List<bool>> _mem;
  final List<int> _dp = [0, 0];

  Memory(this.width, this.height) {
    _mem = List.generate(
        height, (index) => List.generate(width, (index) => false));
  }

  void moveSouth() => _dp[0] >= height - 1 ? _dp[0] = 0 : _dp[0]++;

  void moveNorth() => _dp[0] <= 0 ? _dp[0] = height - 1 : _dp[0]--;

  void moveEast() => _dp[1] >= width - 1 ? _dp[1] = 0 : _dp[1]++;

  void moveWest() => _dp[1] <= 0 ? _dp[1] = width - 1 : _dp[1]--;

  void flipBit() => _mem[_dp[0]][_dp[1]] = !_mem[_dp[0]][_dp[1]];

  bool read() => _mem[_dp[0]][_dp[1]];

  String toString() {
    StringBuffer buffer = StringBuffer();
    for (int i = 0; i < _mem.length; i++) {
      for (int n = 0; n < _mem[i].length; n++) {
        String val = _mem[i][n] ? '1' : '0';
        buffer.write(val);
      }
      if (i < _mem.length - 1) buffer.write('\r\n');
    }
    return buffer.toString();
  }
}

class Interpreter {
  final Memory _memory;
  final List<int> _instructions;
  final int _iterations;
  int _numIterations = 0;
  int _ip = 0;

  Interpreter(this._memory, this._instructions, this._iterations);

  void step(Memory mem) {
    switch (_instructions[_ip]) {
      case 110: // n
        mem.moveNorth();
        _numIterations++;
        break;
      case 101: // e
        mem.moveEast();
        _numIterations++;
        break;
      case 115: // s
        mem.moveSouth();
        _numIterations++;
        break;
      case 119: // w
        mem.moveWest();
        _numIterations++;
        break;
      case 42: // *
        mem.flipBit();
        _numIterations++;
        break;
      case 91: // [
        if (!_memory.read()) {
          int depth = 0;
          for (int i = _ip; i < _instructions.length; i++) {
            switch (_instructions[i]) {
              case 91: // [
                depth++;
                break;
              case 93: // ]
                depth--;
                break;
            }
            if (_instructions[i] == 93 && depth == 0) {
              _ip = i;
              break;
            }
          }
        }
        _numIterations++;
        break;
      case 93: // ]
        if (_memory.read()) {
          int depth = 0;
          for (int i = _ip; i >= 0; i--) {
            switch (_instructions[i]) {
              case 93: // ]
                depth++;
                break;
              case 91: // [
                depth--;
                break;
            }
            if (_instructions[i] == 91 && depth == 0) {
              _ip = i;
              break;
            }
          }
        }
        _numIterations++;
        break;
    }
    _ip++;
  }

  Memory run() {
    while (_ip < _instructions.length && _numIterations < _iterations) {
      step(_memory);
    }
    return _memory;
  }
}

String paintfuck(String code, int iterations, int width, int height) {
  Memory mem = Memory(width, height);
  Interpreter interpreter = Interpreter(mem, code.codeUnits, iterations);
  interpreter.run();
  return mem.toString(); // do it!
}

void main() {
  //print("n -> ${'n'.codeUnitAt(0)}");
  //print("e -> ${'e'.codeUnitAt(0)}");
  //print("s -> ${'s'.codeUnitAt(0)}");
  //print("w -> ${'w'.codeUnitAt(0)}");
  //print("* -> ${'*'.codeUnitAt(0)}");
  //print("[ -> ${'['.codeUnitAt(0)}");
  //print("] -> ${']'.codeUnitAt(0)}");
  //print(paintfuck("*eeeeeeeee*e*s*", 15, 10, 2));
  print(paintfuck("*[es*]", 9, 5, 6));
  print(paintfuck("*e*e*e*es*es*ws*ws*w*w*w*n*n*n*ssss*s*s*s*", 0, 6, 9) ==
      '000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000');
  //print(paintfuck("*e*e*e*es*es*ws*ws*w*w*w*n*n*n*ssss*s*s*s*", 7, 6, 9));
  print(paintfuck("*e*e*e*es*es*ws*ws*w*w*w*n*n*n*ssss*s*s*s*", 7, 6, 9) ==
      "111100\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000");
  //print(paintfuck("*e*e*e*es*es*ws*ws*w*w*w*n*n*n*ssss*s*s*s*", 100, 6, 9));
  print(paintfuck("*e*e*e*es*es*ws*ws*w*w*w*n*n*n*ssss*s*s*s*", 100, 6, 9) ==
      "111100\r\n100010\r\n100001\r\n100010\r\n111100\r\n100000\r\n100000\r\n100000\r\n100000");
  print(paintfuck("*e*e*e*es*es*ws*ws*w*w*w*n*n*n*ssss*s*s*s*", 42, 6, 9) ==
      "111100\r\n100010\r\n100001\r\n100010\r\n111100\r\n100000\r\n100000\r\n100000\r\n100000");
  print(paintfuck(
      "o*e*eq*reqrqp*ppooqqeaqqsr*yqaooqqqfqarppppfffpppppygesfffffffffu*wrs*agwpffffst*w*uqrw*qyaprrrrrw*nuiiiid???ii*n*ynyy??ayd*r:rq????qq::tqaq:y???ss:rqsr?s*qs:q*?qs*tr??qst?q*r",
      7,
      6,
      9));
}
