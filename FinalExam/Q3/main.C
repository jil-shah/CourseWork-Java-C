/* Question 1
 [C Programming]
 [30 Marks]
In this question, you are required to implement a linked list in C

 
/*write structure Node that holds an integer value as well as a pointer to the next node*/
#include<stdio.h>
#include<stdlib.h>

struct Node {
  int val;
  struct Node *next;
};


/*Write structure SLL that represents the singly linked list and holds a pointer to the first node in the list.*/

struct SLL {
  struct Node *head;  
};


/*Write function searchList, that takes as input two parameters: the head of a linked list "head" and the integer value to search for "target" and 
returns:1 if the target was found in the list 0, otherwise*/

int searchList(struct Node *head, int target){
  while (head != NULL){
    if (head->val ==target){
      return 1;
    }
    head = head->next;
  }
  return 0;
}
/*Test your function in main by creating a list of 10 nodes and then call the searchList function to search for a certain value, make sure you check 
the correctness of the returned value from the function by comparing it against what you expect. */

int main(){
struct Node obj[10]; 
struct SLL pointer; 
pointer.head = obj; 
  for(int i=0;i<5;i++){
    int num = (rand() % 50);
    obj[i].val = num;
    obj[i].next = NULL;
    printf("%d\n",num);
  }
  int searchVal;
  int num1 =33;
  searchVal = searchList(pointer.head,num1);
  if (searchVal ==1){
    printf("number is in the list");
  }else{
    printf("number is not in the list");
  }
}
