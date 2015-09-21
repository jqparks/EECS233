// Jonathan Parks jqp

public class LLNode {

 // Fields
 public double value;
 public LLNode nextNode;

 // Constructor
 public LLNode(double value) {
  this.value = value;
  this.nextNode = null;
 }

 public LLNode(double value, LLNode nextNode) {
  this.value = value;
  this.nextNode = nextNode;
 }
}
