import { Node } from "../Node.js"
export class Linkedlist {
    constructor(value){
      
      this.head={value:value,next:null}
      this.tail=this.head
      this.length=1
    }
    
    append(value){
      
    const newNode=new Node(value)
      //as this.tail is nothing but a reference of this.head, modifying the this.tail.next will modify the this.head.next to the newNode value
    this.tail.next=newNode
      //now if we re-initiate the this.tail value to newNode, now it will point to newNode instead of this.head
    this.tail=newNode
    this.length+=1
  }
    prepend(value){
  
      //approach01
      // const newNode=this.head
      // this.head={value:value,next:newNode}
      // this.length+=1
  
      //approach02
      const newNode=new Node(value)
      newNode.next=this.head
      this.head=newNode
      this.length+=1
    }
    
    printList(){
      const arr=[]
      let currNode=this.head
      while(currNode!==null){
        arr.push(currNode.value)
        currNode=currNode.next
      }
      return arr
    }

    insert(index,value){
      if(index>=this.length){
        this.append(value)
      }
      const newNode=new Node(value)
      //in order to insert at specified index, this new inserted node should be pointed from the before node i.e, (index-1) node.
      const addToThisEle=this.traverseToIndex(index-1)
      const holdingPointer=addToThisEle.next
  
      //add inserted node to the previous node
      addToThisEle.next=newNode
      //change the added node next value to the holdingPointer where we stored the previous element next value
      newNode.next=holdingPointer
      this.length+=1
    }
  
    traverseToIndex(index){
      let counter=0
      let currNode=this.head
      while(counter!==index){
        currNode=currNode.next
        counter++
      }
      return currNode
    }

    remove(index){
      if(index>0&&index<this.length){
      
        const prevEle=this.traverseToIndex(index-1)
        const delNode=prevEle.next
        prevEle.next=delNode.next
        if(index===this.length-1) this.tail=prevEle
        this.length-=1  
      }
    }
  }
  // const newLinkedlist=new Linkedlist(10)
  // newLinkedlist.append(12)
  // newLinkedlist.append(13)
  // newLinkedlist.prepend(9)
  // newLinkedlist.prepend(8)
  // console.log(newLinkedlist)

  // module.exports=Linkedlist