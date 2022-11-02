import java.util.*;
 
public class PostFix {

   public int evaluateFix (String exp) {
   // Stack
   Stack<Integer> stack = new Stack<>();
   // Looks through each character
   for(int i = 0; i < exp.length(); i++)
   { 
      char op = exp.charAt(i);
      // If the character isDigit, push it to the stack
      if (Character.isDigit(op))
         stack.push(op - '0');
      // Else, pop two
      else
      {
      int first = stack.pop();
      int second = stack.pop();
      
      switch(op) {
         case'+':
            stack.push(second+first);
               break;
         case'-':
            stack.push(second*first);
               break;
         case'*':
            stack.push(second/first);
               break;
         case'/':
            stack.push(second-first);
               break;
      } //Switch end
      } //Else end 
   } //Forloop end 
      return stack.pop();
   } // evaluteFix end
  
 
   // Checks operand (+, -, *, /, ^) precedence
    public static int Weight(char op) {
      switch(op) {
         case '+':
            return 1;
         case '-':
            return 1;
         case '*':
            return 2;
         case '/':
            return 2;
         case '^':
            return 3;
         default:
            return -1; 
      }// Switch end
    } // end of class
   
   static String postFix(String exp) {
   
      Stack<Character> stack = new Stack<Character>();
      String postfix = "";
      
      for (int i = 0; i < exp.length(); i++) {
         char op = exp.charAt(i); 
         
            if(Weight(op) > 0) {
               while (stack.isEmpty() == false && 
               Weight (stack.peek()) >= Weight(op)) {
                  postfix += stack.pop();
               }
               stack.push(op);
            }
            else if(op==')') {
               char s = stack.pop();
                  while(s!='('){
                     postfix += s;
                     s = stack.pop();
                  }
            }
            else if(op=='('){
               stack.push(op);
            } else {
               postfix += op;
            }
      } // end of loop
      
      for (int i = 0; i <= stack.size(); i++) {
         postfix += stack.pop(); 
      } // end of loop
      return postfix;
   } //End postFix class
   
   //Testing 
   public static void main(String[] args) {
      // Ask user for infix expression
      System.out.println("Type your infix expression!");
         Scanner scanner = new Scanner( System. in);
         String exp = scanner.nextLine();
      // Displays infix expression
      System.out.println("Infix Expression: " + exp);
      // Displays postfix expression
      String O = postFix(exp);
      System.out.println("Postfix expression: " + O);

      //Calulate Values
      System.out.println("Postfix Value: ");

   }
} // Class end
