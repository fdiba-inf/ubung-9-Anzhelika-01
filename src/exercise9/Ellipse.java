package exercise9;

public class Ellipse {
  private Point anfangsPunkt;
  private double a;
  private double b;

public Ellipse(){
  anfangsPunkt = new Point(0, 0);
  a = 1;
  b = 1;
}

public Ellipse(Point anfangsPunkt, double a, double b){
  this.anfangsPunkt = new Point (anfangsPunkt);
  this.a = a;
  this.b = b;
}

public Ellipse(Ellipse otherEllipse){
  anfangsPunkt = new Point(otherEllipse.anfangsPunkt);
  a = otherEllipse.a;
  b = otherEllipse.b;
}

public boolean isValid(){
  return a > 0 && b > 0;
}

public void initialize(){
  do{
    System.out.print("Start Point: ");
    anfangsPunkt.initialize();
    System.out.print("a: ");
    a = Utils.INPUT.nextDouble();
    System.out.print("b: ");
    b = Utils.INPUT.nextDouble();
  }while(!isValid());
}

public double calculatePerimeter(){
  return Math.PI * (3 * (a + b) - Math.sqrt((3* a + b) * (a + 3 * b)));
}

public double calculateArea(){
  return Math.PI * a * b;
}

public String getType(){
  if(a == b){
    return "Cycle";
  }
  else{
    return "Ellipse";
  }
}

public String toString(){
  return String.format("%s -[%s, %s], %s, P=%s, A=%s", anfangsPunkt, a , b, getType(), calculatePerimeter(), calculateArea());
}

public boolean equal(Ellipse otherEllipse) {
        boolean sameA = Utils.equals(a, otherEllipse.a);
        boolean sameB = Utils.equals(b, otherEllipse.b);
        boolean sameAReversed = Utils.equals(a, otherEllipse.b);
        boolean sameBReversed = Utils.equals(b, otherEllipse.a);

        return (sameA && sameB) || (sameAReversed && sameBReversed);
    }
}