// https://www.codewars.com/kata/52f831fa9d332c6591000511


type Atom = (String, usize);
type Molecule = Vec<Atom>;

#[derive(Debug)]
pub struct ParseError {}

pub fn parse_molecule(s: &str) -> Result<Molecule, ParseError> {
  
  for c in s.chars(){
    print!("{}\n",c);
  }
  Err(ParseError{})
}




fn main(){
    print!("{:?}",parse_molecule("H"));
}
